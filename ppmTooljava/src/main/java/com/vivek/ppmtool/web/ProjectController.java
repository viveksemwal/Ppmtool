package com.vivek.ppmtool.web;

import com.vivek.ppmtool.domain.Project;
import com.vivek.ppmtool.service.MapValiErrorService;
import com.vivek.ppmtool.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final MapValiErrorService mapValiErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        if(result.hasErrors()){
           return mapValiErrorService.mapValidateService(result);
        }
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        return new ResponseEntity<Project>(projectService.save(project), HttpStatus.CREATED);

    }
}
