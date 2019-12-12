package com.example.exploregreece.features.customer;

public class CustomerInput {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String telephone;
    private Integer numberOfBookings;

    public CustomerInput( String name, String surname, String email, String telephone, int numberOfBookings) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.numberOfBookings = numberOfBookings;
    }

    public CustomerInput() {
    }

    public CustomerInput(long id, String name, String surname, String email, String telephone, int numberOfBookings) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.numberOfBookings = numberOfBookings;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getNumberOfBookings() {
        return numberOfBookings;
    }

    public void setNumberOfBookings(int numberOfBookings) {
        this.numberOfBookings = numberOfBookings;
    }
}


