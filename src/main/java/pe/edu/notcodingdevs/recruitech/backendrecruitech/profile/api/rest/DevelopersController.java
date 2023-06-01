package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.DeveloperService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping.DeveloperMapper;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.CreateDeveloperResource;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.DeveloperResource;

@RestController
@RequestMapping("/api/v1/developers")
@Tag(name = "developers", description = "Developers information")
public class DevelopersController {
    private final DeveloperService developerService;
    private final DeveloperMapper mapper;

    public DevelopersController(DeveloperService developerService, DeveloperMapper mapper) {
        this.developerService = developerService;
        this.mapper = mapper;
    }
    @GetMapping("{userName}")
    @PreAuthorize("hasRole('USER')")
    public DeveloperResource getByUsername(@PathVariable String userName) {
        return mapper.toResource(developerService.getByUsername(userName));
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER')")
    public String test(){
        return  "Test";
    }

    @PostMapping
    public ResponseEntity<DeveloperResource> createDeveloper(@RequestBody CreateDeveloperResource resource) {
        return new ResponseEntity<>(mapper.toResource(developerService.createDeveloper(mapper.toModel(resource))),HttpStatus.CREATED);
    }
}
