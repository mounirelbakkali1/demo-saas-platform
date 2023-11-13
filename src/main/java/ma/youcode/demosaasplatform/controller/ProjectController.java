package ma.youcode.demosaasplatform.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.demosaasplatform.dto.ProjectDto;
import ma.youcode.demosaasplatform.service.IProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final IProjectService projectService;

    @GetMapping
    public ResponseEntity<?> getProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody @Valid ProjectDto projectDto) {
        projectService.createProject(projectDto);
        return ResponseEntity
                .created(URI.create("/projects"))
                .build();
    }
}
