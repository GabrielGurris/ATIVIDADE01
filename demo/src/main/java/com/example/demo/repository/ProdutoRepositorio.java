package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;

import com.example.demo.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * ProdutoRepositorio
 */
@Repository
public class ProdutoRepositorio {

    public HashMap <Integer, Produto> produtos = new HashMap <Integer, Produto>();

    public ProdutoRepositorio()
    {
        produtos.put(1, new Produto(1, "CALABRESA", 10, 50));
        produtos.put(2, new Produto(2, "BACON", 8, 20));
        produtos.put(3, new Produto(3, "FRANGO", 5, 30));
        produtos.put(4, new Produto(4, "QUEIJO", 10, 50));
        produtos.put(5, new Produto(5, "PRESUNTO", 12, 60));
        produtos.put(6, new Produto(6, "PAO", 4, 20));
        produtos.put(7, new Produto(7, "SALAME", 15, 75));
        produtos.put(8, new Produto(8, "GORGONZOLA", 20, 20));
        produtos.put(9, new Produto(9, "AMENDOIM", 10, 80));
        produtos.put(10, new Produto(10, "PEITO DE PERU", 20, 10));
    }

    public Collection <Produto> getProdutos() {
        return produtos.values();
    }

    public Produto getProdutosById(int Codigo) {
        Produto p = new Produto();
        for (int i=1; i <= produtos.size(); i++)
        {
            if (produtos.get(i).getCodigo() == Codigo){
                p = produtos.get(i);
                return p;
            }
        }
        return null;
    }
}