package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class CreateCompanyResource {

    @NotNull
    @NotBlank
    @Length(max = 40)
    private String name;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "company"})
    private User user;
}
