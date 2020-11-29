package com.vivek.ppmtool.repository;

import com.vivek.ppmtool.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Override
    List<Project> findAllById(Iterable<Long> iterable);

}
