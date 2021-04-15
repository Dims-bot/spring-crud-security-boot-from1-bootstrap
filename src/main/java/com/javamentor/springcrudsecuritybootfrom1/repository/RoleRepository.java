package com.javamentor.springcrudsecuritybootfrom1.repository;

import com.javamentor.springcrudsecuritybootfrom1.Model.ERole;
import com.javamentor.springcrudsecuritybootfrom1.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(ERole name);


}
