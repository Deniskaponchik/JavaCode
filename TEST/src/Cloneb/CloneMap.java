//package com.javarush.task.task21.task2107;
package Cloneb;

import java.util.LinkedHashMap;
import java.util.Map;

public class CloneMap implements Cloneable {

    public static void main(String[] args) {
        CloneMap solution = new CloneMap();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        CloneMap clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public CloneMap clone() throws CloneNotSupportedException {
        CloneMap o = (CloneMap) super.clone();

        //clone users
        Map<String, CloneMap.User> newUsers = new LinkedHashMap<>();
        for (String key : o.users.keySet()) {
            CloneMap.User user = o.users.get(key);
            newUsers.put(key, (CloneMap.User) user.clone());
        }
        o.users = newUsers;

        return o;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CloneMap.User user = (CloneMap.User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

    }
}
