package com.sda;

import java.util.List;

public class Developer {

    private String name;

    private List<String> technologies;

    private int age;

    public Developer() {
    };

    public Developer(String name, List<String> technologies, int age) {
        this.name = name;
        this.technologies = technologies;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTechnologies() {
        return this.technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
