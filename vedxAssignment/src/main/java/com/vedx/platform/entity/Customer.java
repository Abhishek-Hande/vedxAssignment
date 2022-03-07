package com.vedx.platform.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    @Column(name = "user_Name")
    private String userName;

    private String password;

    @Column(name = "contact_No")
    private String contactNo;

    private String address;
    private String status;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    List<Order>orders;

    public Customer() {
    }

    public Customer(String id, String name, String userName, String password, String contactNo, String address,
            String status) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.contactNo = contactNo;
        this.address = address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Cstomer [address=" + address + ", contactNo=" + contactNo + ", id=" + id + ", name=" + name
                + ", password=" + password + ", status=" + status + ", userName=" + userName + "]";
    }

    
    
    
}
