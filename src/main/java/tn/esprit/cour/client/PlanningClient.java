package tn.esprit.cour.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.cour.Planning;

import java.util.List;

@FeignClient(name="planning-service",url="${application.config.plannings-url}")
public interface PlanningClient {

    @GetMapping("/cour/{cour-id}")
    List<Planning> findAllPlanningsByCours(@PathVariable("cour-id") Integer coursId);
}
