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
import modelo.Cuentas;
import modelo.Empleados;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Kings
 */
public class CuentasJpaController implements Serializable {

    public CuentasJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Acabados_DonJorgePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cuentas cuentas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empDni = cuentas.getEmpDni();
            if (empDni != null) {
                empDni = em.getReference(empDni.getClass(), empDni.getEmpDni());
                cuentas.setEmpDni(empDni);
            }
            em.persist(cuentas);
            if (empDni != null) {
                empDni.getCuentasList().add(cuentas);
                empDni = em.merge(empDni);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cuentas cuentas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuentas persistentCuentas = em.find(Cuentas.class, cuentas.getCuentaCodigo());
            Empleados empDniOld = persistentCuentas.getEmpDni();
            Empleados empDniNew = cuentas.getEmpDni();
            if (empDniNew != null) {
                empDniNew = em.getReference(empDniNew.getClass(), empDniNew.getEmpDni());
                cuentas.setEmpDni(empDniNew);
            }
            cuentas = em.merge(cuentas);
            if (empDniOld != null && !empDniOld.equals(empDniNew)) {
                empDniOld.getCuentasList().remove(cuentas);
                empDniOld = em.merge(empDniOld);
            }
            if (empDniNew != null && !empDniNew.equals(empDniOld)) {
                empDniNew.getCuentasList().add(cuentas);
                empDniNew = em.merge(empDniNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cuentas.getCuentaCodigo();
                if (findCuentas(id) == null) {
                    throw new NonexistentEntityException("The cuentas with id " + id + " no longer exists.");
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
            Cuentas cuentas;
            try {
                cuentas = em.getReference(Cuentas.class, id);
                cuentas.getCuentaCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuentas with id " + id + " no longer exists.", enfe);
            }
            Empleados empDni = cuentas.getEmpDni();
            if (empDni != null) {
                empDni.getCuentasList().remove(cuentas);
                empDni = em.merge(empDni);
            }
            em.remove(cuentas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cuentas> findCuentasEntities() {
        return findCuentasEntities(true, -1, -1);
    }

    public List<Cuentas> findCuentasEntities(int maxResults, int firstResult) {
        return findCuentasEntities(false, maxResults, firstResult);
    }

    private List<Cuentas> findCuentasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cuentas.class));
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

    public Cuentas findCuentas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cuentas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuentasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cuentas> rt = cq.from(Cuentas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
