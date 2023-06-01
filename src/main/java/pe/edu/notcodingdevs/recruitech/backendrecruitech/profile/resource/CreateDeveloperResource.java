package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateDeveloperResource {

    @NotBlank
    @NotNull
    @Length(max = 40)
    private String firstName;

    @NotBlank
    @NotNull
    @Length(max = 40)
    private String lastName;

    @Length(max = 240)
    private String description;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "developer"})
    private User user;
}
