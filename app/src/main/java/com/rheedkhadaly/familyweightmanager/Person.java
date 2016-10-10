package com.rheedkhadaly.familyweightmanager;

public class Person {

    private int person_id;
    private String person_name;
    private String person_gender;
    private int person_age;
    private double person_weight;
    private double person_height;
    private double person_body_mass_index;

    public Person() {
    }

    public Person(String person_name, String person_gender, int person_age, float person_weight, float person_height, double person_body_mass_index) {
        this.person_name = person_name;
        this.person_gender = person_gender;
        this.person_age = person_age;
        this.person_weight = person_weight;
        this.person_height = person_height;
        this.person_body_mass_index = person_body_mass_index;
    }

    public int getPersonId() {
        return person_id;
    }

    public void setPersonId(int person_id) {
        this.person_id = person_id;
    }

    public String getPersonName() {
        return person_name;
    }

    public void setPersonName(String person_name) {
        this.person_name = person_name;
    }

    public String getPersonGender() {
        return person_gender;
    }

    public void setPersonGender(String person_gender) {
        this.person_gender = person_gender;
    }

    public int getPersonAge() {
        return person_age;
    }

    public void setPersonAge(int person_age) {
        this.person_age = person_age;
    }

    public double getPersonWeight() {
        return person_weight;
    }

    public void setPersonWeight(double person_weight) {
        this.person_weight = person_weight;
    }

    public double getPersonHeight() {
        return person_height;
    }

    public void setPersonHeight(double person_height) {
        this.person_height = person_height;
    }

    public double getPersonBMI() {
        return person_body_mass_index;
    }

    public void setPersonBMI(double person_body_mass_index) {
        this.person_body_mass_index = person_body_mass_index;
    }
}
