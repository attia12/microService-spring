package tn.esprit.cour;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cour {


    @Id
    @GeneratedValue
    private Integer id;

    private String rate;

    @Enumerated(EnumType.STRING)
    private TypeCour typeCour;
}
