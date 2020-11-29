package com.vivek.ppmtool.service;

import com.vivek.ppmtool.domain.Project;
import com.vivek.ppmtool.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project save(Project project){
        return projectRepository.save(project);
    }
}
