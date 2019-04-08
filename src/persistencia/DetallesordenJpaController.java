/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Detallesorden;
import modelo.Ordenes;
import modelo.Productos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Kings
 */
public class DetallesordenJpaController implements Serializable {

    public DetallesordenJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Acabados_DonJorgePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detallesorden detallesorden) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenes ordCodigo = detallesorden.getOrdCodigo();
            if (ordCodigo != null) {
                ordCodigo = em.getReference(ordCodigo.getClass(), ordCodigo.getOrdCodigo());
                detallesorden.setOrdCodigo(ordCodigo);
            }
            Productos prodCodigo = detallesorden.getProdCodigo();
            if (prodCodigo != null) {
                prodCodigo = em.getReference(prodCodigo.getClass(), prodCodigo.getProdCodigo());
                detallesorden.setProdCodigo(prodCodigo);
            }
            em.persist(detallesorden);
            if (ordCodigo != null) {
                ordCodigo.getDetallesordenList().add(detallesorden);
                ordCodigo = em.merge(ordCodigo);
            }
            if (prodCodigo != null) {
                prodCodigo.getDetallesordenList().add(detallesorden);
                prodCodigo = em.merge(prodCodigo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallesorden detallesorden) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallesorden persistentDetallesorden = em.find(Detallesorden.class, detallesorden.getDetCodigo());
            Ordenes ordCodigoOld = persistentDetallesorden.getOrdCodigo();
            Ordenes ordCodigoNew = detallesorden.getOrdCodigo();
            Productos prodCodigoOld = persistentDetallesorden.getProdCodigo();
            Productos prodCodigoNew = detallesorden.getProdCodigo();
            if (ordCodigoNew != null) {
                ordCodigoNew = em.getReference(ordCodigoNew.getClass(), ordCodigoNew.getOrdCodigo());
                detallesorden.setOrdCodigo(ordCodigoNew);
            }
            if (prodCodigoNew != null) {
                prodCodigoNew = em.getReference(prodCodigoNew.getClass(), prodCodigoNew.getProdCodigo());
                detallesorden.setProdCodigo(prodCodigoNew);
            }
            detallesorden = em.merge(detallesorden);
            if (ordCodigoOld != null && !ordCodigoOld.equals(ordCodigoNew)) {
                ordCodigoOld.getDetallesordenList().remove(detallesorden);
                ordCodigoOld = em.merge(ordCodigoOld);
            }
            if (ordCodigoNew != null && !ordCodigoNew.equals(ordCodigoOld)) {
                ordCodigoNew.getDetallesordenList().add(detallesorden);
                ordCodigoNew = em.merge(ordCodigoNew);
            }
            if (prodCodigoOld != null && !prodCodigoOld.equals(prodCodigoNew)) {
                prodCodigoOld.getDetallesordenList().remove(detallesorden);
                prodCodigoOld = em.merge(prodCodigoOld);
            }
            if (prodCodigoNew != null && !prodCodigoNew.equals(prodCodigoOld)) {
                prodCodigoNew.getDetallesordenList().add(detallesorden);
                prodCodigoNew = em.merge(prodCodigoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detallesorden.getDetCodigo();
                if (findDetallesorden(id) == null) {
                    throw new NonexistentEntityException("The detallesorden with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallesorden detallesorden;
            try {
                detallesorden = em.getReference(Detallesorden.class, id);
                detallesorden.getDetCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallesorden with id " + id + " no longer exists.", enfe);
            }
            Ordenes ordCodigo = detallesorden.getOrdCodigo();
            if (ordCodigo != null) {
                ordCodigo.getDetallesordenList().remove(detallesorden);
                ordCodigo = em.merge(ordCodigo);
            }
            Productos prodCodigo = detallesorden.getProdCodigo();
            if (prodCodigo != null) {
                prodCodigo.getDetallesordenList().remove(detallesorden);
                prodCodigo = em.merge(prodCodigo);
            }
            em.remove(detallesorden);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detallesorden> findDetallesordenEntities() {
        return findDetallesordenEntities(true, -1, -1);
    }

    public List<Detallesorden> findDetallesordenEntities(int maxResults, int firstResult) {
        return findDetallesordenEntities(false, maxResults, firstResult);
    }

    private List<Detallesorden> findDetallesordenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallesorden.class));
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

    public Detallesorden findDetallesorden(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallesorden.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallesordenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallesorden> rt = cq.from(Detallesorden.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
