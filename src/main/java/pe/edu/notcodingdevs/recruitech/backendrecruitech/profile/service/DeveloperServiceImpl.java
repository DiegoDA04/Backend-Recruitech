package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.service;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Developer;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.DeveloperRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.LocationRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.DeveloperService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.persistence.UserRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private static final String ENTITY = "Developer";
    private final DeveloperRepository developerRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, LocationRepository locationRepository, UserRepository userRepository, Validator validator) {
        this.developerRepository = developerRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public Developer createDeveloper(Developer developer, User user, Location location) {
        developer.setUser(user);
        developer.setLocation(location);
        return developerRepository.save(developer);
    }

    @Override
    public Developer getById(Long developerId) {
        return developerRepository.findById(developerId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, developerId));
    }

    @Override
    public Developer getByUserEmail(String email) {
        return developerRepository.findByUserEmail(email);
    }

    @Override
    public Developer getByUserId(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());

        return developerRepository.findByUserId(user.getId());
    }

    @Override
    public List<Developer> getAll() {
        return developerRepository.findAll();
    }
}
