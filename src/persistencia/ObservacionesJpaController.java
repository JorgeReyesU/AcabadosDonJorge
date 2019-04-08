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
import modelo.Empleados;
import modelo.Observaciones;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Kings
 */
public class ObservacionesJpaController implements Serializable {

    public ObservacionesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Acabados_DonJorgePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Observaciones observaciones) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empDni = observaciones.getEmpDni();
            if (empDni != null) {
                empDni = em.getReference(empDni.getClass(), empDni.getEmpDni());
                observaciones.setEmpDni(empDni);
            }
            em.persist(observaciones);
            if (empDni != null) {
                empDni.getObservacionesList().add(observaciones);
                empDni = em.merge(empDni);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Observaciones observaciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Observaciones persistentObservaciones = em.find(Observaciones.class, observaciones.getObsCodigo());
            Empleados empDniOld = persistentObservaciones.getEmpDni();
            Empleados empDniNew = observaciones.getEmpDni();
            if (empDniNew != null) {
                empDniNew = em.getReference(empDniNew.getClass(), empDniNew.getEmpDni());
                observaciones.setEmpDni(empDniNew);
            }
            observaciones = em.merge(observaciones);
            if (empDniOld != null && !empDniOld.equals(empDniNew)) {
                empDniOld.getObservacionesList().remove(observaciones);
                empDniOld = em.merge(empDniOld);
            }
            if (empDniNew != null && !empDniNew.equals(empDniOld)) {
                empDniNew.getObservacionesList().add(observaciones);
                empDniNew = em.merge(empDniNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = observaciones.getObsCodigo();
                if (findObservaciones(id) == null) {
                    throw new NonexistentEntityException("The observaciones with id " + id + " no longer exists.");
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
            Observaciones observaciones;
            try {
                observaciones = em.getReference(Observaciones.class, id);
                observaciones.getObsCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The observaciones with id " + id + " no longer exists.", enfe);
            }
            Empleados empDni = observaciones.getEmpDni();
            if (empDni != null) {
                empDni.getObservacionesList().remove(observaciones);
                empDni = em.merge(empDni);
            }
            em.remove(observaciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Observaciones> findObservacionesEntities() {
        return findObservacionesEntities(true, -1, -1);
    }

    public List<Observaciones> findObservacionesEntities(int maxResults, int firstResult) {
        return findObservacionesEntities(false, maxResults, firstResult);
    }

    private List<Observaciones> findObservacionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Observaciones.class));
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

    public Observaciones findObservaciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Observaciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getObservacionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Observaciones> rt = cq.from(Observaciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
