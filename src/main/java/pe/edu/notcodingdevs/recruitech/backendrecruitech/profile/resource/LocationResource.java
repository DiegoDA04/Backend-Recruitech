package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import lombok.*;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Country;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class LocationResource {
    private int id;
    private String name;
    private Country country;
}
