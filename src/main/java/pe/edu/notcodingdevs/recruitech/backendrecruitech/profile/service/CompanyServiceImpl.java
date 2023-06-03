package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.service;

import jakarta.validation.Validator;
import org.springframework.stereotype.Service;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.CompanyRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence.DeveloperRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service.CompanyService;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.model.entity.Job;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.persistence.UserRepository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.exception.ResourceNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static final String ENTITY = "Company";

    private final CompanyRepository companyRepository;

    private final Validator validator;

    public CompanyServiceImpl(Validator validator,
                              CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.validator = validator;
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
    }

    @Override
    public Company addJobToCompany(Job job, Long companyId) {

        Company company = companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, companyId));
        company.getJobs().add(job);


        return companyRepository.save(company);
    }
}
