package com.example.testabc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class Userdetail {
    @Id
    @Column(name = "usernmae", nullable = false, length = 50)
    private String usernmae;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "lname", length = 50)
    private String lname;

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}