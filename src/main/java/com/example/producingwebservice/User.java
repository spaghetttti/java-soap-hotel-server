package com.example.producingwebservice;

public class User {
    private String firstName;
    private String lastName;
    private String creditCard;

    public User(String firstName, String lastName, String creditCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCard = creditCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creditCard='" + creditCard + '\'' +
                "}";
    }
}
