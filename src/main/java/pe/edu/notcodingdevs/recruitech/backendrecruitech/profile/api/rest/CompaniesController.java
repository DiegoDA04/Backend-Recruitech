package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.CompanyService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping.CompanyMapper;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.CreateCompanyResource;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.service.JobService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.mapping.JobMapper;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.resource.CreateJobResource;

@RestController
@RequestMapping("/api/v1/companies")
@Tag(name = "Companies", description = "Companies information")
public class CompaniesController {

    private final CompanyService companyService;

    private final JobService jobService;
    private final JobMapper jobMapper;
    private final CompanyMapper mapper;

    public CompaniesController(CompanyService companyService, JobService jobService, JobMapper jobMapper, CompanyMapper mapper) {
        this.companyService = companyService;
        this.jobService = jobService;
        this.jobMapper = jobMapper;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody CreateCompanyResource resource) {
        return new ResponseEntity<>(companyService.create(mapper.toModel(resource)), HttpStatus.CREATED);
    }

    @PostMapping("{companyId}/job")
    public ResponseEntity<?> createJobToCompany(@PathVariable Long companyId, @RequestBody CreateJobResource resource) {
        return new ResponseEntity<>(
                companyService.addJobToCompany(
                        jobService.create(jobMapper.toModel(resource), companyService.getById(companyId)),
                        companyId
                ),
                HttpStatus.CREATED
        );
    }
}
