package com.shs.bysj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @Author: shs
 * @Data: 2022/3/29 15:17
 */
@Entity
@Table(name = "manager_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class ManagerRole {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long managerId;
    private Long roleId;

    public ManagerRole() {
    }

    public ManagerRole(Long managerId, Long roleId) {
        this.managerId = managerId;
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "ManagerRole{" +
                "id=" + id +
                ", managerId=" + managerId +
                ", roleId=" + roleId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
