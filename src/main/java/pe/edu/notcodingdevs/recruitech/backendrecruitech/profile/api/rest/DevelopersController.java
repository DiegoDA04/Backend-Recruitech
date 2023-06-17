package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.DeveloperService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping.DeveloperMapper;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.DeveloperResource;

@RestController
@RequestMapping("/api/v1/developers")
@Tag(name = "Developers", description = "Developers information")
public class DevelopersController {
    private final DeveloperService developerService;
    private final DeveloperMapper mapper;

    public DevelopersController(DeveloperService developerService, DeveloperMapper mapper) {
        this.developerService = developerService;
        this.mapper = mapper;
    }

    @GetMapping("{developerId}")
    public ResponseEntity<DeveloperResource> getDeveloperById(@PathVariable Long developerId) {
        return new ResponseEntity<>(mapper.toResource(developerService.getById(developerId)), HttpStatus.OK);
    }

    @GetMapping("{developerId}/profile")
    public ResponseEntity<DeveloperResource> getDeveloperProfileById(@PathVariable Long developerId) {
        return new ResponseEntity<>(mapper.toResource(developerService.getById(developerId)), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<DeveloperResource>> getAllDevelopers(Pageable pageable) {
        return new ResponseEntity<>(mapper.modelListPage(developerService.getAll(), pageable), HttpStatus.OK);
    }
}
