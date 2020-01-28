package am.basic.web.repository;

import am.basic.web.model.User;

import java.sql.SQLException;

public interface UserRepository {
    User getbyId(long id) throws SQLException;

    void save(User user) throws SQLException;

    void delete(long id) throws SQLException;

    void update(User user) throws SQLException;

    User getbyUsernameAndPassword(String username, String password) throws SQLException;

    void savebyUser(User user) throws SQLException;

    User getbyUsername(String username) throws SQLException;

    User getbyPassword(String password) throws SQLException;
}
