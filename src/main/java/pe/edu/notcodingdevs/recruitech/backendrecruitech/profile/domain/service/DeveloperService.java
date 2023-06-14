package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.service;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Developer;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Location;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.security.domain.model.entity.User;

import java.util.List;

public interface DeveloperService {

    Developer createDeveloper(Developer developer, User user, Location location);

    Developer getById(Long developerId);

    Developer getByUserEmail(String email);

    List<Developer> getAll();
}
