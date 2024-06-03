package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    public Optional<Compra> getCompraById(String id) {
        return compraRepository.findById(id);
    }

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

    public Compra updateCompra(String id, Compra compraDetails) {
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra not found"));

        compra.setComanda(compraDetails.getComanda());
        compra.setProduto(compraDetails.getProduto());
        compra.setQuantidade(compraDetails.getQuantidade());
        compra.setTotalPreco(compraDetails.getTotalPreco());
        compra.setTimestamp(compraDetails.getTimestamp());

        return compraRepository.save(compra);
    }

    public void deleteCompra(String id) {
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra not found"));
        compraRepository.delete(compra);
    }
}
