package com.vivek.ppmtool.service;

import com.vivek.ppmtool.domain.Project;
import com.vivek.ppmtool.exception.ProjectIdException;
import com.vivek.ppmtool.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project save(Project project){
        try{
            return projectRepository.save(project);
        }catch (Exception e){
            throw new ProjectIdException("Project Id "+project.getProjectIdentifier()+" already persist in database so try diffrent one");
        }


    }
}
