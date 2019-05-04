package org.cars.carsshop.entities;

import javax.persistence.*;

@Entity
@Table (name="accounts")
public class Account {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private double amount;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
