/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "tb_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProdutos.findAll", query = "SELECT t FROM TbProdutos t")
    , @NamedQuery(name = "TbProdutos.findByIdProduto", query = "SELECT t FROM TbProdutos t WHERE t.idProduto = :idProduto")
    , @NamedQuery(name = "TbProdutos.findByDescricao", query = "SELECT t FROM TbProdutos t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "TbProdutos.findByValorUni", query = "SELECT t FROM TbProdutos t WHERE t.valorUni = :valorUni")})
public class TbProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_uni")
    private Float valorUni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<TbVendas> tbVendasCollection;

    public TbProdutos() {
    }

    public TbProdutos(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValorUni() {
        return valorUni;
    }

    public void setValorUni(Float valorUni) {
        this.valorUni = valorUni;
    }

    @XmlTransient
    public Collection<TbVendas> getTbVendasCollection() {
        return tbVendasCollection;
    }

    public void setTbVendasCollection(Collection<TbVendas> tbVendasCollection) {
        this.tbVendasCollection = tbVendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProdutos)) {
            return false;
        }
        TbProdutos other = (TbProdutos) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbProdutos[ idProduto=" + idProduto + " ]";
    }
    
}
