package com.attia.webdistribue;

import com.attia.webdistribue.model.Candidat;
import com.attia.webdistribue.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class WebdistribueApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebdistribueApplication.class, args);
	}
	@Autowired
	private CandidatRepository repository;
	@Bean
	ApplicationRunner init()
	{
		return (args)->{
			repository.save(new Candidat("mariam","ch","ma@esprit.tn"));
			repository.save(new Candidat("sara","ab","sa@esprit.tn"));
			repository.save(new Candidat("mohamed","ba","mo@esprit.tn"));
			repository.findAll().forEach(System.out::println);

		};
	}

}
