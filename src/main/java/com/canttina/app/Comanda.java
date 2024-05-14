package com.canttina.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private Integer saldoComanda;

    public Comanda() {
        // Default constructor
    }

    public Comanda(String name, String phoneNumber, Integer saldoComanda) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.saldoComanda = saldoComanda;
    }

    // Getters and setters for all attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getSaldoComanda() {
        return saldoComanda;
    }

    public void setSaldoComanda(Integer saldoComanda) {
        this.saldoComanda = saldoComanda;
    }
}
