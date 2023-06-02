package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;

public interface CompanyService {
    Company create(Company company, Long userId);
}
