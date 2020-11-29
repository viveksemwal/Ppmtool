package com.vivek.ppmtool.repository;

import com.vivek.ppmtool.domain.Project;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    @Override
    List<Project> findAllById(Iterable<Long> iterable);

    Optional<Project> findByProjectIdentifier(String s);

    @Override
    List<Project> findAll();



}
