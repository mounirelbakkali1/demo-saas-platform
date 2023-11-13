package ma.youcode.demosaasplatform.dto;

import jakarta.validation.constraints.NotBlank;

public record ProjectDto(@NotBlank String name ,@NotBlank String description) {
}
