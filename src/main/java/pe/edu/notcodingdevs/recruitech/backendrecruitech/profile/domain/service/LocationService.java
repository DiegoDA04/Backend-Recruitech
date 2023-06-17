package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Developer;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;

import java.util.List;

public interface LocationService {
    void seed();
    List<Location> getAll();
    Location getByName(String name);
}
