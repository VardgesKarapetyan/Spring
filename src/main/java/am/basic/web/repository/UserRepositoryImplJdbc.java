package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.DataSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Scope("singleton")
public class UserRepositoryImplJdbc implements UserRepository {
    public void init(){
        System.out.println("UserRepositoryImplJdbc");
    }
    @Override
    public User getbyId(long id) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        //con.setReadOnly(t);
       // con.setTransactionIsolation();
        con.setAutoCommit(false);
        con.commit();
        con.rollback();
        PreparedStatement pr = con.prepareStatement("Select * from user where id=?");
        pr.setLong(1, id);

        ResultSet rs = pr.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setSurname(rs.getString(3));
            user.setAge(rs.getInt(4));
            user.setPassword(rs.getString(5));
            user.setUsername(rs.getString("username"));
            user.setCode(rs.getString("code"));
        }
        return user;


    }

    @Override
    public void save(User user) throws SQLException {
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
        pr.setInt(1, 0);
        pr.setString(2, user.getName());
        pr.setString(3, user.getSurname());
        pr.setInt(4, user.getAge());
        pr.setString(5, user.getPassword());
        pr.setString(6, user.getUsername());
        pr.setString(7, user.getCode());
        pr.execute();
    }

    @Override
    public void delete(long id) throws SQLException {
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("DELETE from user where id=?");
        pr.setLong(1, id);
        pr.execute();

    }

    @Override
    public void update(User user) throws SQLException {
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("UPDATE user SET name=?,surname=?,age=?,password=?,username=?,code=?  where id = ?");
        pr.setString(1, "Vrej");
        pr.setString(2, "Xachatryan");
        pr.setInt(3, 20);
        pr.setString(4, "");
        pr.setString(5, "");
        pr.setInt(6, 45);
        pr.setLong(7, user.getId());
        pr.execute();
    }

    @Override
    public User getbyUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("Select * from user where username=? AND password=?");
        pr.setString(1, username);
        pr.setString(2, password);

        ResultSet rs = pr.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setSurname(rs.getString(3));
            user.setAge(rs.getInt(4));
            user.setPassword(rs.getString(5));
            user.setUsername(rs.getString("username"));
            user.setCode(rs.getString("code"));
        }
        return user;


    }
    @Override
    public void savebyUser(User user) throws SQLException {
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
        pr.setInt(1, 0);
        pr.setString(2, user.getName());
        pr.setString(3, user.getSurname());
        pr.setInt(4, user.getAge());
        pr.setString(5, user.getPassword());
        pr.setString(6, user.getUsername());
        pr.setString(7, user.getCode());
        pr.execute();
    }

    @Override
    public User getbyUsername(String username) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("Select * from user where username=?");
        pr.setString(1, username);

        ResultSet rs = pr.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setSurname(rs.getString(3));
            user.setAge(rs.getInt(4));
            user.setPassword(rs.getString(5));
            user.setUsername(rs.getString("username"));
            user.setCode(rs.getString("code"));
        }
        return user;


    }
    @Override
    public User getbyPassword(String password) throws SQLException {
        User user = null;
        Connection con = DataSource.getConnection();
        PreparedStatement pr = con.prepareStatement("Select * from user where  password=?");
        pr.setString(1, password);

        ResultSet rs = pr.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(rs.getLong(1));
            user.setName(rs.getString(2));
            user.setSurname(rs.getString(3));
            user.setAge(rs.getInt(4));
            user.setPassword(rs.getString(5));
            user.setUsername(rs.getString("username"));
            user.setCode(rs.getString("code"));
        }
        return user;


    }

}
