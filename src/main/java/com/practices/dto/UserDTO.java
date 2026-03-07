package com.practices.dto;


public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private Integer age;
    private String gender;
    private String userAddress;

    public UserDTO(Integer id, String username, String email, String phone, Integer age, String gender, String userAddress) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
        this.userAddress = userAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
