package com.manage.gdpu.service;

import com.manage.gdpu.entity.Project;
import com.manage.gdpu.repository.ProjectRepository;
import com.manage.gdpu.vo.ProjectVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * 获取所有项目数据的方法，添加将实体类转换为VO类的逻辑
     *
     * @return 返回包含所有项目数据的VO列表，若数据库中无数据则返回空列表
     */
    public List<ProjectVO> getProjectData() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectVO> projectVOList = new ArrayList<>();
        for (Project project : projectList) {
            ProjectVO projectVO = new ProjectVO();
            // 将实体类的属性值复制到VO类对应的属性中
            projectVO.setProjectId(project.getProjectId());
            projectVO.setProjectName(project.getProjectName());
            projectVO.setProjectDescription(project.getProjectDescription());
            projectVO.setStartTime(project.getStartTime());
            projectVO.setEndTime(project.getEndTime());
            // 可以根据实际情况补充更多属性的赋值，比如负责人、参与人员等信息

            projectVOList.add(projectVO);
        }
        return projectVOList;
    }

    /**
     * 根据项目ID获取特定项目数据的方法，进行类型转换
     *
     * @param projectId 项目ID
     * @return 返回特定的项目数据的VO对象，如果不存在则返回null
     */
    public ProjectVO getProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project!= null) {
            ProjectVO projectVO = new ProjectVO();
            projectVO.setProjectId(project.getProjectId());
            projectVO.setProjectName(project.getProjectName());
            projectVO.setProjectDescription(project.getProjectDescription());
            projectVO.setStartTime(project.getStartTime());
            projectVO.setEndTime(project.getEndTime());
            // 按需补充更多属性赋值
            return projectVO;
        }
        return null;
    }

    /**
     * 保存项目数据（新增或更新项目）的方法，处理VO和实体类之间的转换
     *
     * @param projectVO 要保存的项目数据的VO对象
     * @return 保存后的项目数据的VO对象
     */
    public ProjectVO saveProject(ProjectVO projectVO) {
        Project project = new Project();
        project.setProjectId(projectVO.getProjectId());
        project.setProjectName(projectVO.getProjectName());
        project.setProjectDescription(projectVO.getProjectDescription());
        project.setStartTime(projectVO.getStartTime());
        project.setEndTime(projectVO.getEndTime());
        // 处理其他相关属性赋值，将VO属性复制到实体类对象

        Project savedProject = projectRepository.save(project);

        ProjectVO savedProjectVO = new ProjectVO();
        savedProjectVO.setProjectId(savedProject.getProjectId());
        savedProjectVO.setProjectName(savedProject.getProjectName());
        savedProjectVO.setProjectDescription(savedProject.getProjectDescription());
        savedProjectVO.setStartTime(savedProject.getStartTime());
        savedProjectVO.setEndTime(savedProject.getEndTime());
        // 再将保存后的实体类对象转换回VO对象返回

        return savedProjectVO;
    }

    /**
     * 根据项目ID删除项目数据的方法
     *
     * @param projectId 项目ID
     */
    public void deleteProjectById(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}