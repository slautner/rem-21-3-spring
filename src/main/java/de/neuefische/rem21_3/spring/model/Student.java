package de.neuefische.rem21_3.spring.model;

public class Student {

    private String name;
    private String matNumber;

    public Student(String name, String matNumber) {
        this.name = name;
        this.matNumber = matNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatNumber() {
        return matNumber;
    }

    public void setMatNumber(String matNumber) {
        this.matNumber = matNumber;
    }
}
