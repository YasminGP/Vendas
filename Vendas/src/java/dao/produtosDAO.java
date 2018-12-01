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
//import model.TbUsuarios;
import model.TbProdutos;

/**
 *
 * @author Windows
 */
public class produtosDAO {
    public produtosDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
      
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
      public void create(TbProdutos produto) {
        
        EntityManager em = null;
        try {
            //Conecta ao banco e estabelece uma sessao
            em = getEntityManager();
            //Iniciando a transacao
            em.getTransaction().begin();
            //Inserir os dados vindos da aplicacao
            em.persist(produto);
            //Efetiva a gravacao dos dados na tab.fisica
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
    public List<TbProdutos> findTbProdutosEntities() {
        return findTbProdutosEntities(true, -1, -1);
    }

    public List<TbProdutos> findTbProdutosEntities(int maxResults, int firstResult) {
        return findTbProdutosEntities(false, maxResults, firstResult);
    }

    private List<TbProdutos> findTbProdutosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TbProdutos.class));
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

    public TbProdutos findProdutos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TbProdutos.class, id);
        } finally {
            em.close();
        }
    }
    
}
