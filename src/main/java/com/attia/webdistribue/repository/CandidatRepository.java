package com.attia.webdistribue.repository;

import com.attia.webdistribue.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {


}
