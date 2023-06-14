package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class CompanyResource {
    private Long id;
    private String name;
}
