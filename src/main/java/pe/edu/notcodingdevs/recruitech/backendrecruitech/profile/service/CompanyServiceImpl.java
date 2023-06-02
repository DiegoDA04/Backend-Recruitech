package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.service;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.CompanyRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.DeveloperRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.CompanyService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.persistence.UserRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.exception.ResourceNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String ENTITY = "Company";

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    private final Validator validator;

    public CompanyServiceImpl(UserRepository userRepository, Validator validator,
                              CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public Company create(Company company, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        company.setUser(user);

        return companyRepository.save(company);
    }
}
