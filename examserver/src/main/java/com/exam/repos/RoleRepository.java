package com.exam.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
