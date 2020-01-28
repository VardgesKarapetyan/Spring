package am.basic.web.service.impl;

import am.basic.web.model.User;
import am.basic.web.repository.UserRepository;
import am.basic.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

@Service
@Scope("singleton")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepositoryImpl;

    @PostConstruct
    public void init() {
        System.out.println("UserServiceImpl");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Hello destroy");

    }

    @Override
    public User getbyUsername(String username) {
        try {
            return userRepositoryImpl.getbyUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}

