package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.model.entity.Job;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.persistence.JobRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.service.JobService;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private static final String ENTITY = "Job";

    private final JobRepository jobRepository;

    private final Validator validator;

    public JobServiceImpl(JobRepository jobRepository, Validator validator) {
        this.jobRepository = jobRepository;
        this.validator = validator;
    }

    @Override
    public List<Job> getAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job create(Job job) {
        return jobRepository.save(job);
    }
}
