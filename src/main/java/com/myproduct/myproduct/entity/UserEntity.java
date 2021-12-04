package com.myproduct.myproduct.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long userID;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "user_role")
    private String userRole;

    public UserEntity() {
    }

    public UserEntity(Long userID, String password, String username, String userRole) {
        this.userID = userID;
        this.password = password;
        this.username = username;
        this.userRole = userRole;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
