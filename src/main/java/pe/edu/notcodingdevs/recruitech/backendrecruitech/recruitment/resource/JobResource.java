package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.resource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
public class JobResource {
    private Long id;
    private String title;
    private String description;
}
