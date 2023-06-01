package pe.edu.notcodingdevs.recruitech.backendrecruitech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackendRecruitechApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendRecruitechApplication.class, args);
    }

}
