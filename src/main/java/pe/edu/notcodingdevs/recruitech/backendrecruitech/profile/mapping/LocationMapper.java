package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.resource.LocationResource;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class LocationMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public Page<LocationResource> modelListPage(List<Location> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, LocationResource.class), pageable, modelList.size());
    }
}
