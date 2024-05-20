package com.canttina.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comandas")
public class Comanda {
    @Id
    private String id;

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
