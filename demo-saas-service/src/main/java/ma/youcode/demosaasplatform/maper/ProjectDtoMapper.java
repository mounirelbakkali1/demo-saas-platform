package ma.youcode.demosaasplatform.maper;

import ma.youcode.demosaasplatform.domain.Project;
import ma.youcode.demosaasplatform.dto.ProjectDto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class ProjectDtoMapper {


    public ProjectDto toDto(Project project) {
        return new ProjectDto(project.getName(), project.getDescription());
    }

    public Project toEntity(ProjectDto projectDto) {
        return Project.builder()
                .name(projectDto.name())
                .description(projectDto.description())
                .build();
    }
}
