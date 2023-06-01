package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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
