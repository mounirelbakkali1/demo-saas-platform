package ma.youcode.demosaasplatform.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    String name ;
}
