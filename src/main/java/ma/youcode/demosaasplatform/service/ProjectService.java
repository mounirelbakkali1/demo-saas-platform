package ma.youcode.demosaasplatform.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.youcode.demosaasplatform.config.db.context.TenantContext;
import ma.youcode.demosaasplatform.domain.Project;
import ma.youcode.demosaasplatform.dto.ProjectDto;
import ma.youcode.demosaasplatform.maper.ProjectDtoMapper;
import ma.youcode.demosaasplatform.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDtoMapper projectDtoMapper;



    @Override
    public List<Project> getAllProjects() {
        log.info("Request to get all projects for tenant {}", TenantContext.getTenantId());
        return projectRepository.findAll();
    }

    @Override
    public void createProject(@Valid ProjectDto projectDto) {
        log.info("Request to create project {} for tenant {}", projectDto, TenantContext.getTenantId());
        Project project = projectDtoMapper.toEntity(projectDto);
        projectRepository.save(project);
        log.info("Project {} created for tenant {}", project, TenantContext.getTenantId());
    }
}
