package ma.youcode.demosaasplatform.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
}
