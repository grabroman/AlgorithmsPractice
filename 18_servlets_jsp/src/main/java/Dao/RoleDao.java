package Dao;

import Domain.entity.Role;

public interface RoleDao extends Dao<Role> {
    Domain.entity.Role findByName(String name);
}
