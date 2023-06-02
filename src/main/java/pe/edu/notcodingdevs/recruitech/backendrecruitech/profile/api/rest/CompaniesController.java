package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.CompanyService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping.CompanyMapper;

@RestController
@RequestMapping("/api/v1/companies")
@Tag(name = "developers", description = "Companies information")
public class CompaniesController {

    private final CompanyService companyService;
    private final CompanyMapper mapper;

    public CompaniesController(CompanyService companyService, CompanyMapper mapper) {
        this.companyService = companyService;
        this.mapper = mapper;
    }

}
