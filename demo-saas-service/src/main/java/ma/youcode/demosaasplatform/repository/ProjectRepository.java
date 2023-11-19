package ma.youcode.demosaasplatform.repository;

import ma.youcode.demosaasplatform.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
