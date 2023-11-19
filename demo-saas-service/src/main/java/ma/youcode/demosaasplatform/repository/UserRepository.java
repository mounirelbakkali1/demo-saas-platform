package ma.youcode.demosaasplatform.repository;

import ma.youcode.demosaasplatform.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
