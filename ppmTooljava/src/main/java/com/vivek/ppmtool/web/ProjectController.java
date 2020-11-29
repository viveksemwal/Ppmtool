package com.vivek.ppmtool.web;

import com.vivek.ppmtool.domain.Project;
import com.vivek.ppmtool.service.MapValiErrorService;
import com.vivek.ppmtool.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final MapValiErrorService mapValiErrorService;

    @PostMapping("")
    public ResponseEntity<?> createAndUpdate(@Valid @RequestBody Project project, BindingResult result){

        //to Update you just need to give the ID in Json Payload
        if(result.hasErrors()){
           return mapValiErrorService.mapValidateService(result);
        }
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        return new ResponseEntity<Project>(projectService.save(project), HttpStatus.CREATED);

    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getprojectByIdentifier(@PathVariable String projectId){
        return new ResponseEntity<Project>(projectService.findByIdentifier(projectId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findALl(){
        return new ResponseEntity<List<Project>>(projectService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteByIdentifier(@PathVariable String projectId){
        return new ResponseEntity<Project>(projectService.delete(projectId), HttpStatus.OK);
    }

}
