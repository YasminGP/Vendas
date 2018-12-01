/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.TbVendas;
import model.TbProdutos;
import model.TbUsuarios;

/**
 *
 * @author Windows
 */
public class vendasDAO {
    public vendasDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
      
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
      public void create(TbVendas usuario) {
        
        EntityManager em = null;
        try {
            //Conecta ao banco e estabelece uma sessao
            em = getEntityManager();
            //Iniciando a transacao
            em.getTransaction().begin();
            //Inserir os dados vindos da aplicacao
            em.persist(usuario);
            //Efetiva a gravacao dos dados na tab.fisica
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
    public List<TbVendas> findTbVendasEntities() {
        return findTbVendasEntities(true, -1, -1);
    }

    public List<TbVendas> findTbVendasEntities(int maxResults, int firstResult) {
        return findTbVendasEntities(false, maxResults, firstResult);
    }

    private List<TbVendas> findTbVendasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbVendas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TbVendas findVendas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbVendas.class, id);
        } finally {
            em.close();
        }
    }
}
