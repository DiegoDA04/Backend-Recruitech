package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import lombok.*;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With

public class DeveloperResource {
    private Long id;
    private String firstName;
    private String lastName;
    private String about;
    private String gender;
    private String photoUrl;
    private Location location;
    private String birthDate;
}
