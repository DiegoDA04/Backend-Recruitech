package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class DeveloperResource {

    private Long id;
    private String firstName;
    private String lastName;
    private String description;
}
