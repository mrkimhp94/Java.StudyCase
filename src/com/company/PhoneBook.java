package com.company;

public class PhoneBook {
    private int number;
    private String group;
    private String name;
    private String sex;
    private String address;
    private String bornDay;
    private String email;

    public PhoneBook(int number, String group, String name, String sex, String address,String bornDay,String email) {
        this.number = number;
        this.group = group;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.bornDay = bornDay;
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBornDay() {
        return bornDay;
    }

    public void setBornDay(String bornDay) {
        this.bornDay = bornDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
