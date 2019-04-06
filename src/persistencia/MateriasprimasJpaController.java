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
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Materiasprimas;
import modelo.Proveedores;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Kings
 */
public class MateriasprimasJpaController implements Serializable {

    public MateriasprimasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materiasprimas materiasprimas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proNIT = materiasprimas.getProNIT();
            if (proNIT != null) {
                proNIT = em.getReference(proNIT.getClass(), proNIT.getProNIT());
                materiasprimas.setProNIT(proNIT);
            }
            em.persist(materiasprimas);
            if (proNIT != null) {
                proNIT.getMateriasprimasList().add(materiasprimas);
                proNIT = em.merge(proNIT);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materiasprimas materiasprimas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materiasprimas persistentMateriasprimas = em.find(Materiasprimas.class, materiasprimas.getMatCodigo());
            Proveedores proNITOld = persistentMateriasprimas.getProNIT();
            Proveedores proNITNew = materiasprimas.getProNIT();
            if (proNITNew != null) {
                proNITNew = em.getReference(proNITNew.getClass(), proNITNew.getProNIT());
                materiasprimas.setProNIT(proNITNew);
            }
            materiasprimas = em.merge(materiasprimas);
            if (proNITOld != null && !proNITOld.equals(proNITNew)) {
                proNITOld.getMateriasprimasList().remove(materiasprimas);
                proNITOld = em.merge(proNITOld);
            }
            if (proNITNew != null && !proNITNew.equals(proNITOld)) {
                proNITNew.getMateriasprimasList().add(materiasprimas);
                proNITNew = em.merge(proNITNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = materiasprimas.getMatCodigo();
                if (findMateriasprimas(id) == null) {
                    throw new NonexistentEntityException("The materiasprimas with id " + id + " no longer exists.");
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
            Materiasprimas materiasprimas;
            try {
                materiasprimas = em.getReference(Materiasprimas.class, id);
                materiasprimas.getMatCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materiasprimas with id " + id + " no longer exists.", enfe);
            }
            Proveedores proNIT = materiasprimas.getProNIT();
            if (proNIT != null) {
                proNIT.getMateriasprimasList().remove(materiasprimas);
                proNIT = em.merge(proNIT);
            }
            em.remove(materiasprimas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materiasprimas> findMateriasprimasEntities() {
        return findMateriasprimasEntities(true, -1, -1);
    }

    public List<Materiasprimas> findMateriasprimasEntities(int maxResults, int firstResult) {
        return findMateriasprimasEntities(false, maxResults, firstResult);
    }

    private List<Materiasprimas> findMateriasprimasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materiasprimas.class));
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

    public Materiasprimas findMateriasprimas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materiasprimas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriasprimasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materiasprimas> rt = cq.from(Materiasprimas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
