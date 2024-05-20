package com.canttina.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "compras")
public class Compra {

    @Id
    private String id;

    @DBRef
    private Comanda comanda;

    @DBRef
    private Produto produto;

    private Integer quantidade;
    private Double totalPreco;
    private LocalDateTime timestamp;

    public Compra() {
        // Default constructor
    }

    public Compra(Comanda comanda, Produto produto, Integer quantidade, Double totalPreco, LocalDateTime timestamp) {
        this.comanda = comanda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.totalPreco = totalPreco;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotalPreco() {
        return totalPreco;
    }

    public void setTotalPreco(Double totalPreco) {
        this.totalPreco = totalPreco;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
