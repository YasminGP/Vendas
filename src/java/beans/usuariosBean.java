/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.usuariosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.TbUsuarios;

/**
 *
 * @author Windows
 */
@ManagedBean
@ViewScoped
public class usuariosBean {
    
    private TbUsuarios usuario;
    private List<TbUsuarios> usuarios;
    private usuariosDAO dao;
    
    public usuariosBean() {
        usuario = new TbUsuarios();
        usuarios = new ArrayList<>();
        dao = new usuariosDAO(javax.persistence.Persistence.
                createEntityManagerFactory("VendasU"));
    }

    public TbUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(TbUsuarios usuario) {
        this.usuario = usuario;
    }
    
    public void inserir(){
        dao.create(usuario);
    }
    
    public List<TbUsuarios> listar(){
        usuarios = dao.findTbUsuariosEntities();
        return usuarios;
    }
    
}