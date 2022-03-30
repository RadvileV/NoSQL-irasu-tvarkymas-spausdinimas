package com.company;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    private int charId;
    private String name;
    private String type;
    private String address;
    private String work;
    private double salary;

    public Character(){}

    public Character(int charId, String name, String type, String address, String work, double salary){
        this.charId = charId;
        this.name = name;
        this.type = type;
        this.address = address;
        this.work = work;
        this.salary = salary;
    }

    public int getCharId() {
        return charId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getWork() {
        return work;
    }

    public double getSalary() {
        return salary;
    }


    public void setCharId(int charId) {
        this.charId = charId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Char{" +
                ", id=" + charId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", work='" + work + '\'' +
                ", salary=" + salary +
                '}';
    }

}
