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
@Table(name = "tb_usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbUsuarios.findAll", query = "SELECT t FROM TbUsuarios t")
    , @NamedQuery(name = "TbUsuarios.findByIdUsuario", query = "SELECT t FROM TbUsuarios t WHERE t.idUsuario = :idUsuario")
    , @NamedQuery(name = "TbUsuarios.findByNome", query = "SELECT t FROM TbUsuarios t WHERE t.nome = :nome")
    , @NamedQuery(name = "TbUsuarios.findByRg", query = "SELECT t FROM TbUsuarios t WHERE t.rg = :rg")})
public class TbUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "rg")
    private String rg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<TbVendas> tbVendasCollection;

    public TbUsuarios() {
    }

    public TbUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbUsuarios)) {
            return false;
        }
        TbUsuarios other = (TbUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbUsuarios[ idUsuario=" + idUsuario + " ]";
    }
    
}
