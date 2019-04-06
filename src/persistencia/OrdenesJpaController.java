/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Clientes;
import modelo.Detallesorden;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Ordenes;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Kings
 */
public class OrdenesJpaController implements Serializable {

    public OrdenesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordenes ordenes) {
        if (ordenes.getDetallesordenList() == null) {
            ordenes.setDetallesordenList(new ArrayList<Detallesorden>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes cliNIT = ordenes.getCliNIT();
            if (cliNIT != null) {
                cliNIT = em.getReference(cliNIT.getClass(), cliNIT.getCliNIT());
                ordenes.setCliNIT(cliNIT);
            }
            List<Detallesorden> attachedDetallesordenList = new ArrayList<Detallesorden>();
            for (Detallesorden detallesordenListDetallesordenToAttach : ordenes.getDetallesordenList()) {
                detallesordenListDetallesordenToAttach = em.getReference(detallesordenListDetallesordenToAttach.getClass(), detallesordenListDetallesordenToAttach.getDetCodigo());
                attachedDetallesordenList.add(detallesordenListDetallesordenToAttach);
            }
            ordenes.setDetallesordenList(attachedDetallesordenList);
            em.persist(ordenes);
            if (cliNIT != null) {
                cliNIT.getOrdenesList().add(ordenes);
                cliNIT = em.merge(cliNIT);
            }
            for (Detallesorden detallesordenListDetallesorden : ordenes.getDetallesordenList()) {
                Ordenes oldOrdCodigoOfDetallesordenListDetallesorden = detallesordenListDetallesorden.getOrdCodigo();
                detallesordenListDetallesorden.setOrdCodigo(ordenes);
                detallesordenListDetallesorden = em.merge(detallesordenListDetallesorden);
                if (oldOrdCodigoOfDetallesordenListDetallesorden != null) {
                    oldOrdCodigoOfDetallesordenListDetallesorden.getDetallesordenList().remove(detallesordenListDetallesorden);
                    oldOrdCodigoOfDetallesordenListDetallesorden = em.merge(oldOrdCodigoOfDetallesordenListDetallesorden);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordenes ordenes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenes persistentOrdenes = em.find(Ordenes.class, ordenes.getOrdCodigo());
            Clientes cliNITOld = persistentOrdenes.getCliNIT();
            Clientes cliNITNew = ordenes.getCliNIT();
            List<Detallesorden> detallesordenListOld = persistentOrdenes.getDetallesordenList();
            List<Detallesorden> detallesordenListNew = ordenes.getDetallesordenList();
            if (cliNITNew != null) {
                cliNITNew = em.getReference(cliNITNew.getClass(), cliNITNew.getCliNIT());
                ordenes.setCliNIT(cliNITNew);
            }
            List<Detallesorden> attachedDetallesordenListNew = new ArrayList<Detallesorden>();
            for (Detallesorden detallesordenListNewDetallesordenToAttach : detallesordenListNew) {
                detallesordenListNewDetallesordenToAttach = em.getReference(detallesordenListNewDetallesordenToAttach.getClass(), detallesordenListNewDetallesordenToAttach.getDetCodigo());
                attachedDetallesordenListNew.add(detallesordenListNewDetallesordenToAttach);
            }
            detallesordenListNew = attachedDetallesordenListNew;
            ordenes.setDetallesordenList(detallesordenListNew);
            ordenes = em.merge(ordenes);
            if (cliNITOld != null && !cliNITOld.equals(cliNITNew)) {
                cliNITOld.getOrdenesList().remove(ordenes);
                cliNITOld = em.merge(cliNITOld);
            }
            if (cliNITNew != null && !cliNITNew.equals(cliNITOld)) {
                cliNITNew.getOrdenesList().add(ordenes);
                cliNITNew = em.merge(cliNITNew);
            }
            for (Detallesorden detallesordenListOldDetallesorden : detallesordenListOld) {
                if (!detallesordenListNew.contains(detallesordenListOldDetallesorden)) {
                    detallesordenListOldDetallesorden.setOrdCodigo(null);
                    detallesordenListOldDetallesorden = em.merge(detallesordenListOldDetallesorden);
                }
            }
            for (Detallesorden detallesordenListNewDetallesorden : detallesordenListNew) {
                if (!detallesordenListOld.contains(detallesordenListNewDetallesorden)) {
                    Ordenes oldOrdCodigoOfDetallesordenListNewDetallesorden = detallesordenListNewDetallesorden.getOrdCodigo();
                    detallesordenListNewDetallesorden.setOrdCodigo(ordenes);
                    detallesordenListNewDetallesorden = em.merge(detallesordenListNewDetallesorden);
                    if (oldOrdCodigoOfDetallesordenListNewDetallesorden != null && !oldOrdCodigoOfDetallesordenListNewDetallesorden.equals(ordenes)) {
                        oldOrdCodigoOfDetallesordenListNewDetallesorden.getDetallesordenList().remove(detallesordenListNewDetallesorden);
                        oldOrdCodigoOfDetallesordenListNewDetallesorden = em.merge(oldOrdCodigoOfDetallesordenListNewDetallesorden);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ordenes.getOrdCodigo();
                if (findOrdenes(id) == null) {
                    throw new NonexistentEntityException("The ordenes with id " + id + " no longer exists.");
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
            Ordenes ordenes;
            try {
                ordenes = em.getReference(Ordenes.class, id);
                ordenes.getOrdCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordenes with id " + id + " no longer exists.", enfe);
            }
            Clientes cliNIT = ordenes.getCliNIT();
            if (cliNIT != null) {
                cliNIT.getOrdenesList().remove(ordenes);
                cliNIT = em.merge(cliNIT);
            }
            List<Detallesorden> detallesordenList = ordenes.getDetallesordenList();
            for (Detallesorden detallesordenListDetallesorden : detallesordenList) {
                detallesordenListDetallesorden.setOrdCodigo(null);
                detallesordenListDetallesorden = em.merge(detallesordenListDetallesorden);
            }
            em.remove(ordenes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordenes> findOrdenesEntities() {
        return findOrdenesEntities(true, -1, -1);
    }

    public List<Ordenes> findOrdenesEntities(int maxResults, int firstResult) {
        return findOrdenesEntities(false, maxResults, firstResult);
    }

    private List<Ordenes> findOrdenesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordenes.class));
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

    public Ordenes findOrdenes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordenes.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordenes> rt = cq.from(Ordenes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
