package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.domain.model.AuditModel;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Table(name = "developers")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Developer extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Length(max = 40)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @NotNull
    @Length(max = 40)
    @Column(name = "last_name")
    private String lastName;

    @Length(max = 240)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
