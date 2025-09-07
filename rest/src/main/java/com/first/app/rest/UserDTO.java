package com.first.app.rest;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age; 
    private String occupation;
    
    // No-args constructor (required for serialization)
    public UserDTO() {}

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

   public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

}

