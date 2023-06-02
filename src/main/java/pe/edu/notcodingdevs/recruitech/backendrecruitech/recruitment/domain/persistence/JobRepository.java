package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.model.entity.Job;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}