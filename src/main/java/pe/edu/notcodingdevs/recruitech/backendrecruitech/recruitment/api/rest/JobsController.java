package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.service.JobService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.mapping.JobMapper;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.resource.CreateJobResource;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.resource.JobResource;

@RestController
@RequestMapping("/api/v1/jobs")
@Tag(name = "Job Lists", description = "No se mano pipipi")
public class JobsController {

    private final JobService jobService;
    private final JobMapper mapper;

    public JobsController(JobService jobService, JobMapper jobMapper) {
        this.jobService = jobService;
        this.mapper = jobMapper;
    }

    @GetMapping
    public Page<JobResource> getAllJobs(Pageable pageable) {
        return mapper.modelListPage(jobService.getAll(),pageable);
    }

}
