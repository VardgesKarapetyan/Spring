package am.basic.web.controller;

import am.basic.web.model.User;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> test=new HashMap<>();
        test.put("username","rubo92");
        test.put("name","Vardges");
        test.put("surname","sdvisdVardges");
        test.put("age","48");
        test.put("code","dhufiwu");
        test.put("password","bihgiu65");
        String name=test.get("name");
        User user=new User();
        user.setName(test.get(name));
        Map<String,String> test1=new HashMap<>();
        //This is Dev branche
    }
}
