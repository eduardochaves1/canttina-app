package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    public List<Comanda> getAllComandas() {
        return comandaRepository.findAll();
    }

    public Optional<Comanda> getComandaById(String id) {
        return comandaRepository.findById(id);
    }

    public Comanda createComanda(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    public Comanda updateComanda(String id, Comanda comandaDetails) {
        Comanda comanda = comandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda not found"));

        comanda.setName(comandaDetails.getName());
        comanda.setPhoneNumber(comandaDetails.getPhoneNumber());
        comanda.setSaldoComanda(comandaDetails.getSaldoComanda());

        return comandaRepository.save(comanda);
    }

    public void deleteComanda(String id) {
        Comanda comanda = comandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda not found"));
        comandaRepository.delete(comanda);
    }

    public Comanda increaseSaldoComanda(String id, int amount) {
        Comanda comanda = comandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda not found"));

        comanda.setSaldoComanda(comanda.getSaldoComanda() + amount);
        return comandaRepository.save(comanda);
    }

    public Comanda decreaseSaldoComanda(String id, int amount) {
        Comanda comanda = comandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda not found"));

        if (comanda.getSaldoComanda() < amount) {
            throw new RuntimeException("Saldo insuficiente na comanda");
        }

        comanda.setSaldoComanda(comanda.getSaldoComanda() - amount);
        return comandaRepository.save(comanda);
    }
}
