package Dao;

import Domain.entity.User;

public interface UserDao extends Dao<User> {
    User findByLogin(String login);

    User findByEmail(String email);
}
