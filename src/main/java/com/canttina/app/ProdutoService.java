package com.canttina.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(String id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(String id, Produto produtoDetails) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto not found"));

        produto.setNome(produtoDetails.getNome());
        produto.setPreco(produtoDetails.getPreco());
        produto.setQuantidadeDisponivel(produtoDetails.getQuantidadeDisponivel());
        produto.setUrlImagem(produtoDetails.getUrlImagem());

        return produtoRepository.save(produto);
    }

    public void deleteProduto(String id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto not found"));
        produtoRepository.delete(produto);
    }
}
