/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import model.TbProdutos;
import dao.produtosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;



/**
 *
 * @author Windows
 */
@ManagedBean
@ViewScoped
public class produtosBean {
    
    private TbProdutos produto;
    private List<TbProdutos> produtos;
    private produtosDAO dao;
    
    public produtosBean() {
        produto = new TbProdutos();
        produtos = new ArrayList<>();
        dao = new produtosDAO(javax.persistence.Persistence.
                createEntityManagerFactory("VendasP"));
    }

    public TbProdutos getProduto() {
        return produto;
    }

    public void setProduto(TbProdutos produto) {
        this.produto = produto;
    }
     
    public void inserir(){
        dao.create(produto);
    }
    
    public List<TbProdutos> listar(){
        produtos = dao.findTbProdutosEntities();
        return produtos;
    }
    
}
