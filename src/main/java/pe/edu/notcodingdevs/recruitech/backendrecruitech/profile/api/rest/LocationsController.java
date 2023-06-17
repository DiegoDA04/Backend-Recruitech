package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.api.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.LocationService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping.LocationMapper;



@RestController
@RequestMapping("/api/v1/locations")
@Tag(name = "Locations", description = "Location data")
public class LocationsController {

    private final LocationService locationService;

    private final LocationMapper mapper;

    public LocationsController(LocationService locationService, LocationMapper mapper) {
        this.locationService = locationService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllLocations(Pageable pageable){

        return new ResponseEntity<>(mapper.modelListPage(locationService.getAll(), pageable), HttpStatus.OK);
    }
}
