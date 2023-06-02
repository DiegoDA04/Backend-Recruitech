package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.CompanyResource;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.CreateCompanyResource;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class CompanyMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public CompanyResource toResource(Company model) {
        return mapper.map(model, CompanyResource.class);
    }

    public Company toModel(CreateCompanyResource resource) {
        return mapper.map(resource, Company.class);
    }

    public Page<CompanyResource> modelListPage(List<Company> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CompanyResource.class), pageable, modelList.size());
    }
}
