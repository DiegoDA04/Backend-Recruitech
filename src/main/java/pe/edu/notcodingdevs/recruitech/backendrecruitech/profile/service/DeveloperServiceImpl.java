package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.service;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Developer;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.DeveloperRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.DeveloperService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.persistence.UserRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private static final String ENTITY = "Developer";
    private final DeveloperRepository developerRepository;
    private final UserRepository userRepository;
    private final Validator validator;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, UserRepository userRepository, Validator validator) {
        this.developerRepository = developerRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }


    @Override
    public Developer getByUsername(String username) {
        return developerRepository.findByUserUsername(username).orElseThrow(() -> new ResourceNotFoundException(ENTITY));
    }

    @Override
    public List<Developer> getAllDevelopersByFirstNameWithContains(String name) {
        return developerRepository.findAllByFirstNameContains(name);
    }

    @Override
    public Developer createDeveloper(Developer developer) {
        User user = userRepository.findByUsername(developer.getUser().getUsername()).orElseThrow(() -> new ResourceNotFoundException("User"));

        developer.setUser(user);

        return developerRepository.save(developer);
    }
}
