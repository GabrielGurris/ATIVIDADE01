package com.example.demo.controller;

import java.util.ArrayList;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProdutoController
 */
@Controller
public class ProdutoController {
    
    @Autowired
    private ProdutoService ps;

    @GetMapping("")
    public ModelAndView menu()
    {
        ModelAndView menu = new ModelAndView("menu");

        return menu;
    }

    @GetMapping("/produto/{codigo}")
    public ModelAndView getProduto(
        @PathVariable("codigo") int id
    ){
        ModelAndView mv = new ModelAndView("viewProduto");

        Produto p = ps.getProduto(id);

        mv.addObject("produto", p);

        return mv;
        
    }

    @GetMapping("/produtosEmEstoque")
    public ModelAndView getProdutosEmEstoque(
    ){
        ModelAndView mv = new ModelAndView("viewProdutosEmEstoque");

        ArrayList<Produto> ap = ps.getProdutosEmEstoque();

        mv.addObject("produtos", ap);

        return mv;
    }

    @GetMapping("produtosValorAcima/{valor}")
    public ModelAndView getProdutosValorAcima(
        @PathVariable("valor") double valor
    ){
        ModelAndView mv = new ModelAndView("viewProdutosValorAcima");

        ArrayList<Produto> ap = ps.getProdutosByValorAcima(valor);

        mv.addObject("produtos", ap);

        return mv;
    }

    @GetMapping("produtosValorAbaixo/{valor}")
    public ModelAndView getProdutosValorAbaixo(
        @PathVariable("valor") double valor
    ){
        ModelAndView mv = new ModelAndView("viewProdutosValorAbaixo");

        ArrayList<Produto> ap = ps.getProdutosByValorAbaixo(valor);

        mv.addObject("produtos", ap);

        return mv;
    }

    
}