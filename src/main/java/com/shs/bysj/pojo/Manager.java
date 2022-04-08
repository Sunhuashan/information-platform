package com.shs.bysj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manager")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Manager {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String managerUsername;

    @Column
    private String managerPassword;

    @Column
    private String managerEmail;

    @Column
    private String managerPhone;

    @Column
    private String managerSalt;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Transient
    private List<Role> roleList;

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", managerUsername='" + managerUsername + '\'' +
                ", managerPassword='" + managerPassword + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", managerSalt='" + managerSalt + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    public Manager() {
    }

    public Manager(String managerUsername, String managerPassword, String managerEmail, String managerPhone) {
        this.managerUsername = managerUsername;
        this.managerPassword = managerPassword;
        this.managerEmail = managerEmail;
        this.managerPhone = managerPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManagerUsername() {
        return managerUsername;
    }

    public void setManagerUsername(String managerUsername) {
        this.managerUsername = managerUsername;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerSalt() {
        return managerSalt;
    }

    public void setManagerSalt(String managerSalt) {
        this.managerSalt = managerSalt;
    }

}
