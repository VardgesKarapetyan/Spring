package am.basic.web.util;

import am.basic.web.service.UserService;
import am.basic.web.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class MAin {
    public static void main(String[] args) throws SQLException {
     //   UserRepositoryImpl us=new UserRepositoryImpl();
        /*
        User user=us.getbyId(125);
        System.out.println(user);
        us.delete(119);
        user.setName("Anahit");
        us.update(user);
        System.out.println( us.getbyUsernameAndPassword("vak","a123"));*/
       /* UserRepositoryImpl us1=new UserRepositoryImpl();*/
/*        Card card=new Card();
        card.setName("nameCard");
        card.setNumber("19879246");
        User user=new User();
        user.setName("Ani");
        user.setSurname("Aharonyan");
        user.setUsername("asnojasnf");
        user.setPassword("sd515");
        user.setCode("5559");
        user.setCard(card);


        Action action=new Action();
        Action action1=new Action();
        action.setName("dfioher");
        action.setDescription("dsngosudhfiuwehgifuwehgfiue");
        action1.setName("dfiohersdvgohaedroig");
        action1.setDescription("dsngosudhfigfiue");
        List<Action>list=new ArrayList<>();
        list.add(action);
        list.add(action1);
        user.setList(list);
        User fromDb=us.getbyId(181);
        System.out.println(fromDb);*/
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("aplication-context.xml");
        UserService userService=  applicationContext.getBean(UserService.class);
        UserService userService1=  applicationContext.getBean(UserService.class);


    }
}
