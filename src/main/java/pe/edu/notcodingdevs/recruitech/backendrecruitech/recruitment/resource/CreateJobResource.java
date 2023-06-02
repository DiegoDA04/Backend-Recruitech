package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class CreateJobResource {

    @NotNull
    @NotBlank
    @Length(max = 40)
    private String title;

    @NotNull
    @NotBlank
    private String description;
}
