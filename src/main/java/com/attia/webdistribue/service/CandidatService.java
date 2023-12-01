package com.attia.webdistribue.service;

import com.attia.webdistribue.model.Candidat;
import com.attia.webdistribue.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;
    public Candidat addCandidat(Candidat candidate)
    {
        return candidatRepository.save(candidate);

    }
    public Candidat updateCandidat(int id, Candidat newCandidat)
    {
        if(candidatRepository.findById(id).isPresent())
        {
            Candidat candidatExist=candidatRepository.findById(id).get();
            candidatExist.setNom(newCandidat.getNom());
            candidatExist.setPrenom(newCandidat.getPrenom());
            candidatExist.setEmail(newCandidat.getEmail());
            return candidatRepository.save(candidatExist);
        }
        else
            return null;
    }

    public String deleteCandidat(int id) {
        if (candidatRepository.findById(id).isPresent()) {
            candidatRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }
}
