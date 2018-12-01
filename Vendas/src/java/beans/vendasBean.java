/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import model.TbVendas;
import model.TbProdutos;
import model.TbUsuarios;
import dao.vendasDAO;
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
public class vendasBean {
    
    private TbVendas venda;
    private List<TbVendas> vendas;
    private vendasDAO dao;
    
    public vendasBean() {
        venda = new TbVendas();
        vendas = new ArrayList<>();
        dao = new vendasDAO(javax.persistence.Persistence.
                createEntityManagerFactory("VendasV"));
        
        
    }

    public TbVendas getVenda() {
        return venda;
    }

    public void setVenda(TbVendas venda) {
        this.venda = venda;
    }
    
    public void inserir(){
        dao.create(venda);
    }
    
    public List<TbVendas> listar(){
        vendas = dao.findTbVendasEntities();
        return vendas;
    }
}
