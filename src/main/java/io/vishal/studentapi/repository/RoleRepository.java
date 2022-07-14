package io.vishal.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.vishal.studentapi.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
