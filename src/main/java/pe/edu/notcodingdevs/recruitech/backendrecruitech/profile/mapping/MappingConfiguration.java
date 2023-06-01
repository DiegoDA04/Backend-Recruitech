package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profileMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DeveloperMapper developerMapper(){
        return new DeveloperMapper();
    }
}
