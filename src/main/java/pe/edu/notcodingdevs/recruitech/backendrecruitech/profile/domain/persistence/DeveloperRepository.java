package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Developer;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    List<Developer> findAllByFirstNameContains(String name);

    Developer findByUserEmail(String email);
    Developer findByUserId(Long id);
}