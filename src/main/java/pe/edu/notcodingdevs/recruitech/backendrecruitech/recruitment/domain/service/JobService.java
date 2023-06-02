package pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.service;

import pe.edu.notcodingdevs.recruitech.backendrecruitech.recruitment.domain.model.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAll();
    Job create(Job job);
}
