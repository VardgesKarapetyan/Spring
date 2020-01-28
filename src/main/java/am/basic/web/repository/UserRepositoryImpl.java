package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.SQLException;


@Repository
@Scope("singleton")
@Transactional(isolation = Isolation.REPEATABLE_READ,rollbackFor = Throwable.class,noRollbackFor=ThreadDeath.class)

public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;
    @PostConstruct
    public void init() {
        System.out.println("UserRepositoryImpl");
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional(readOnly = true)
    public User getbyId(long id) throws SQLException {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);

    }

    @Transactional
    public void save(User user) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

    }

    @Transactional
    public void delete(long id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();

        NativeQuery<User> query = session.createNativeQuery("DELETE from user where id=?", User.class);
        query.setParameter(1, id);
        query.executeUpdate();


    }

    @Transactional
    public void update(User user) throws SQLException {
        // Session session = sessionFactory.openSession();
        // session.beginTransaction();
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        //  session.getTransaction().commit();
    }
    @Transactional(readOnly = true)
    public User getbyUsernameAndPassword(String username, String password) throws SQLException {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("Select * from user where username=? AND password=?", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);
        return query.uniqueResult();


    }

    public void savebyUser(User user) throws SQLException {

    }

    public User getbyUsername(String username) {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("Select * from user where username=?", User.class);
        query.setParameter(1, username);
        return query.uniqueResult();


    }

    @Override
    public User getbyPassword(String password) throws SQLException {
        return null;
    }

   /* public User getbyPassword(String password) throws SQLException {

        return user;


    }*/
}
