package tn.esprit.cour;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullCourResponse {



    private String rate;

    @Enumerated(EnumType.STRING)
    private TypeCour typeCour;

    List<Planning> plannings;
}
