package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "12306", catalog = "12306")
public class UserEntity {
    private String username;
    private String password;
    private Integer permission;
    private String phonenum;
    private String contact;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "permission")
    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    @Basic
    @Column(name = "phonenum")
    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    @Basic
    @Column(name = "contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(permission, that.permission)&&
                Objects.equals(phonenum, that.phonenum)&&
                Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, permission,phonenum,contact);
    }
}
