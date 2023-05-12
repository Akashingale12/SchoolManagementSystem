package com.schoolmanagementsystem.repository;

import com.schoolmanagementsystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query(value = "select * from role where role_name=:roleName",nativeQuery = true)
    List<Role> findRoleByName(@RequestParam("roleName") String roleName);

    @Query(value = "select * from role where role_id=:roleId",nativeQuery = true)
    Role findById(@RequestParam("roleId") long roleId);


}
