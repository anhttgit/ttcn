package vn.edu.vnua.dse.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.edu.vnua.dse.calendar.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String roleName);
}
