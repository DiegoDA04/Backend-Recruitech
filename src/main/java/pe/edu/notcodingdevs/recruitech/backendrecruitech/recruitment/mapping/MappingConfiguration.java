package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("recruitmentMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public JobMapper jobMapper(){ return new JobMapper(); }
}
