package pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.profile.domain.model.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}