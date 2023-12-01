package tn.esprit.cour;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Planning {

    private Date dateD;

    private Date dateF;

    private String etat;
}
