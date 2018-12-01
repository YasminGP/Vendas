/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbVendas.findAll", query = "SELECT t FROM TbVendas t")
    , @NamedQuery(name = "TbVendas.findByIdVenda", query = "SELECT t FROM TbVendas t WHERE t.idVenda = :idVenda")
    , @NamedQuery(name = "TbVendas.findByQuantidade", query = "SELECT t FROM TbVendas t WHERE t.quantidade = :quantidade")
    , @NamedQuery(name = "TbVendas.findByVrlTotal", query = "SELECT t FROM TbVendas t WHERE t.vrlTotal = :vrlTotal")
    , @NamedQuery(name = "TbVendas.findByData", query = "SELECT t FROM TbVendas t WHERE t.data = :data")})
public class TbVendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venda")
    private Integer idVenda;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vrl_total")
    private Float vrlTotal;
    @Column(name = "data")
    private String data;
    @JoinColumn(name = "produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private TbProdutos produto;
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private TbUsuarios usuario;

    public TbVendas() {
    }

    public TbVendas(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getVrlTotal() {
        return vrlTotal;
    }

    public void setVrlTotal(Float vrlTotal) {
        this.vrlTotal = vrlTotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public TbProdutos getProduto() {
        return produto;
    }

    public void setProduto(TbProdutos produto) {
        this.produto = produto;
    }

    public TbUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUsuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbVendas)) {
            return false;
        }
        TbVendas other = (TbVendas) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbVendas[ idVenda=" + idVenda + " ]";
    }
    
}
