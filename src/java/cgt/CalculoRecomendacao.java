/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cgt;

import cdp.Classificacao;
import cdp.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean
 */
public class CalculoRecomendacao {
    private final List<Classificacao> listaClassificacao;
    public CalculoRecomendacao(List<Classificacao> classificoes){
        this.listaClassificacao = classificoes;
    }
    
    public List<Item> recomendar(String userId){
        List<Item> itens = new ArrayList();
        return itens;
    }
}
