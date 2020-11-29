package com.vivek.ppmtool.service;

import com.vivek.ppmtool.domain.Project;
import com.vivek.ppmtool.exception.ProjectIdException;
import com.vivek.ppmtool.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Project findByIdentifier(String s){
        return projectRepository.findByProjectIdentifier(s.toUpperCase()).orElseThrow(()-> new ProjectIdException("Not Found"));
    }

    public List<Project> findAll(){
        List<Project> projects=projectRepository.findAll();
        if(projects.isEmpty()){
            throw new ProjectIdException("No project yet stored");
        }
        return projects;
    }


    public Project delete(String s){
        Project project=projectRepository.findByProjectIdentifier(s.toUpperCase()).orElseThrow(()-> new ProjectIdException("Not Found"));
        projectRepository.delete(project);
        return project;
    }
}
