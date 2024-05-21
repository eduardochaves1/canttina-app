package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Compra realizarCompra(String comandaId, String produtoId, Integer quantidade) {
        Comanda comanda = comandaRepository.findById(comandaId).orElseThrow(() -> new RuntimeException("Comanda not found"));
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto not found"));

        Double preco = produto.getPreco();
        Double totalPreco = preco * quantidade;
        if (comanda.getSaldoComanda() < totalPreco) {
            throw new RuntimeException("Saldo insuficiente na comanda");
        }

        comanda.setSaldoComanda((int) (comanda.getSaldoComanda() - totalPreco));
        comandaRepository.save(comanda);

        Compra compra = new Compra(comanda, produto, quantidade, totalPreco);
        return compraRepository.save(compra);
    }
}
