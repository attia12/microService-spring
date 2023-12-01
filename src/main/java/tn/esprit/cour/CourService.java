package tn.esprit.cour;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
import tn.esprit.cour.client.PlanningClient;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourService {

    private final CourRepository courRepository;

    private PlanningClient planningClient;

    public void saveCour(Cour cour){
        courRepository.save(cour);
    }

    public List<Cour> findAllCours() {
        return courRepository.findAll();
    }


    public Cour getCourById(Integer id) {
        return courRepository.findById(id).orElse(null);
    }

    public Cour updateCour(Integer id, Cour updatedCour) {
        // Vérifie si l'entité avec l'ID existe
        if (courRepository.existsById(id)) {
            // Récupère l'entité existante de la base de données
            Cour existingCour = courRepository.findById(id).orElse(null);

            if (existingCour != null) {
                // Met à jour les propriétés spécifiques
                existingCour.setRate(updatedCour.getRate());
                existingCour.setTypeCour(updatedCour.getTypeCour());

                // Enregistre l'entité mise à jour dans la base de données
                return courRepository.save(existingCour);
            }
        }
        return null; // Gérer le cas où l'entité n'est pas trouvée
    }

    public void deleteCour(Integer id) {
        courRepository.deleteById(id);
    }


    public FullCourResponse findCoursWithPlannings(Integer courId){
        var cour = courRepository.findById(courId)
                .orElse(Cour.builder()
                        .rate("Not_Found")
                        .typeCour(TypeCour.conduite)
                        .typeCour(TypeCour.parc)
                        .typeCour(TypeCour.code)
                        .build());

        var plannings = planningClient.findAllPlanningsByCours(courId);
        return FullCourResponse.builder()
                .rate(cour.getRate())
                .typeCour(cour.getTypeCour())
                .plannings(plannings)
                .build();

    }

}
