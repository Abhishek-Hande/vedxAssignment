package com.vedx.platform.entity;

import java.sql.Date;
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
public class Order{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String customerId;

    private String country;

    @Column(name = "delivery_Address")
    private String address;;

    @Column(name = "order_Date")
    private Date date;

    @Column(name = "order_status")
    private String status;

    @OneToMany(mappedBy = "id",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    List<Product> products;

    public Order() {
    }

    public Order(String id, String cutomerId, String country, String address, Date date, String status) {
        this.id = id;
        this.customerId = cutomerId;
        this.country = country;
        this.address = address;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCutomerId() {
        return customerId;
    }

    public void setCutomerId(String cutomerId) {
        this.customerId = cutomerId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order [address=" + address + ", country=" + country + ", customerId=" + customerId + ", date=" + date
                + ", id=" + id + ", status=" + status + "]";
    }

    
}
