package com.dzh.javabase.jsonOperator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dongzihui on 16/6/26.
 */
public class Group {

    private Long       id;
    private String     name;
    private List<User> users = new ArrayList<User>();

    public Map<String, Map<String, Integer>> getMap() {
        return map;
    }

    private Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();

    public void setMap(Map<String, Map<String, Integer>> map) {
        this.map = map;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }
}