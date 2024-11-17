package com.manage.gdpu.controller;

import com.manage.gdpu.service.ProjectService;
import com.manage.gdpu.vo.ProjectVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * 获取所有项目数据接口
     *
     * @return 返回包含所有项目数据的列表，若没有数据则返回空列表
     */
    @GetMapping("/api/project")
    public ResponseEntity<List<ProjectVO>> getProjectData() {
        List<ProjectVO> projectData = projectService.getProjectData();
        return ResponseEntity.ok(projectData);
    }

    /**
     * 根据项目ID获取特定项目数据接口
     *
     * @param projectId 项目ID
     * @return 返回特定项目的数据对象，如果不存在则返回状态码404
     */
    @GetMapping("/api/project/{projectId}")
    public ResponseEntity<ProjectVO> getProjectById(@PathVariable Long projectId) {
        ProjectVO project = projectService.getProjectById(projectId);
        if (project!= null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
}