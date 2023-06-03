package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.model.entity.Job;

public interface CompanyService {
    Company create(Company company);

    Company getById(Long companyId);
    Company addJobToCompany(Job job, Long companyId);
}
