package ma.youcode.demosaasplatform.service;

import jakarta.validation.Valid;
import ma.youcode.demosaasplatform.domain.Project;
import ma.youcode.demosaasplatform.dto.ProjectDto;

import java.util.List;

public interface IProjectService {
    List<Project> getAllProjects();

    void createProject(@Valid ProjectDto projectDto);
}
