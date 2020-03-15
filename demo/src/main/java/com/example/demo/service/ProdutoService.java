package com.example.demo.service;

import java.util.ArrayList;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoService
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio pr;

    public Produto getProduto(int id)
    {
        return pr.getProdutosById(id); 
    }

    public ArrayList<Produto> getProdutosEmEstoque()
    {
        ArrayList<Produto> p = new ArrayList<Produto>();

        for(Produto po : pr.getProdutos())
        {
            if(po.getEstoque() > 0)
            {
                p.add(po);
            }
        }
        return p;
    }

    public ArrayList<Produto> getProdutosByValorAcima(double valor)
    {
        ArrayList<Produto> p = new ArrayList<Produto>();

        for(Produto po : pr.getProdutos())
        {
            if(po.getValor() > valor)
                p.add(po);
        }
        return p;
    }

    public ArrayList<Produto> getProdutosByValorAbaixo(double valor)
    {
        ArrayList<Produto> p = new ArrayList<Produto>();

        for(Produto po : pr.getProdutos())
        {
            if(po.getValor() < valor)
                p.add(po);
        }
        return p;
    }



}