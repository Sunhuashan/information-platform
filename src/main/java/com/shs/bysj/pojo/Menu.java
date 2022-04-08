package com.shs.bysj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: shs
 * @Data: 2022/3/29 15:07
 */
@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Menu {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menuPath;
    private String menuName;
    private String menuNameZh;
    private String menuIconClass;
    private String menuComponent;
    private Long menuParentId;
    //非持久化属性
    @Transient
    private List<Menu> children;

    public Menu() {
    }


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuPath='" + menuPath + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuNameZh='" + menuNameZh + '\'' +
                ", menuIconClass='" + menuIconClass + '\'' +
                ", menuComponent='" + menuComponent + '\'' +
                ", menuParentId=" + menuParentId +
                ", children=" + children +
                '}';
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuNameZh() {
        return menuNameZh;
    }

    public void setMenuNameZh(String menuNameZh) {
        this.menuNameZh = menuNameZh;
    }

    public String getMenuIconClass() {
        return menuIconClass;
    }

    public void setMenuIconClass(String menuIconClass) {
        this.menuIconClass = menuIconClass;
    }

    public String getMenuComponent() {
        return menuComponent;
    }

    public void setMenuComponent(String menuComponent) {
        this.menuComponent = menuComponent;
    }

    public Long getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Long menuParentId) {
        this.menuParentId = menuParentId;
    }
}
