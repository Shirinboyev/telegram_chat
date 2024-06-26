package backend.model.user;

import backend.model.BaseModel;

public class User extends BaseModel {
    private String name;
    private String username;
    private Integer phoneNumber;
    private String password;

    public User(String name, String username, Integer phoneNumber, String password) {
        this.name = name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String name, String phoneNumber) {

    }

    public User(String name, boolean b) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGroup() {
        return false;
    }
}