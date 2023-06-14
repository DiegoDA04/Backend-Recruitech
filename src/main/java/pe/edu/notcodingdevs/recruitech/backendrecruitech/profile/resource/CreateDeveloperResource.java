package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.service.communication.request.RegisterRequest;

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
    private String about;

    @NotNull
    @NotBlank
    @JsonFormat(pattern="yyyy-MM-dd")
    private String birthDate;

    @NotNull
    @NotBlank
    private String gender;

    private String photoUrl;

    private Location location;

    @Email
    @NotNull
    @NotBlank
    private String email;

    @NotBlank
    @NotNull
    private String password;
}
