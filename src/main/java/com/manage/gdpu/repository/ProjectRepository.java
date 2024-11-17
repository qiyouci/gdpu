package com.manage.gdpu.repository;

import com.manage.gdpu.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}