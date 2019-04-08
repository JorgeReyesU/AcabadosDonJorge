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
import modelo.Ordenes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Clientes;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Kings
 */
public class ClientesJpaController implements Serializable {

    public ClientesJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Acabados_DonJorgePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes clientes) throws PreexistingEntityException, Exception {
        if (clientes.getOrdenesList() == null) {
            clientes.setOrdenesList(new ArrayList<Ordenes>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ordenes> attachedOrdenesList = new ArrayList<Ordenes>();
            for (Ordenes ordenesListOrdenesToAttach : clientes.getOrdenesList()) {
                ordenesListOrdenesToAttach = em.getReference(ordenesListOrdenesToAttach.getClass(), ordenesListOrdenesToAttach.getOrdCodigo());
                attachedOrdenesList.add(ordenesListOrdenesToAttach);
            }
            clientes.setOrdenesList(attachedOrdenesList);
            em.persist(clientes);
            for (Ordenes ordenesListOrdenes : clientes.getOrdenesList()) {
                Clientes oldCliNITOfOrdenesListOrdenes = ordenesListOrdenes.getCliNIT();
                ordenesListOrdenes.setCliNIT(clientes);
                ordenesListOrdenes = em.merge(ordenesListOrdenes);
                if (oldCliNITOfOrdenesListOrdenes != null) {
                    oldCliNITOfOrdenesListOrdenes.getOrdenesList().remove(ordenesListOrdenes);
                    oldCliNITOfOrdenesListOrdenes = em.merge(oldCliNITOfOrdenesListOrdenes);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientes(clientes.getCliNIT()) != null) {
                throw new PreexistingEntityException("Clientes " + clientes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientes clientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes persistentClientes = em.find(Clientes.class, clientes.getCliNIT());
            List<Ordenes> ordenesListOld = persistentClientes.getOrdenesList();
            List<Ordenes> ordenesListNew = clientes.getOrdenesList();
            List<Ordenes> attachedOrdenesListNew = new ArrayList<Ordenes>();
            for (Ordenes ordenesListNewOrdenesToAttach : ordenesListNew) {
                ordenesListNewOrdenesToAttach = em.getReference(ordenesListNewOrdenesToAttach.getClass(), ordenesListNewOrdenesToAttach.getOrdCodigo());
                attachedOrdenesListNew.add(ordenesListNewOrdenesToAttach);
            }
            ordenesListNew = attachedOrdenesListNew;
            clientes.setOrdenesList(ordenesListNew);
            clientes = em.merge(clientes);
            for (Ordenes ordenesListOldOrdenes : ordenesListOld) {
                if (!ordenesListNew.contains(ordenesListOldOrdenes)) {
                    ordenesListOldOrdenes.setCliNIT(null);
                    ordenesListOldOrdenes = em.merge(ordenesListOldOrdenes);
                }
            }
            for (Ordenes ordenesListNewOrdenes : ordenesListNew) {
                if (!ordenesListOld.contains(ordenesListNewOrdenes)) {
                    Clientes oldCliNITOfOrdenesListNewOrdenes = ordenesListNewOrdenes.getCliNIT();
                    ordenesListNewOrdenes.setCliNIT(clientes);
                    ordenesListNewOrdenes = em.merge(ordenesListNewOrdenes);
                    if (oldCliNITOfOrdenesListNewOrdenes != null && !oldCliNITOfOrdenesListNewOrdenes.equals(clientes)) {
                        oldCliNITOfOrdenesListNewOrdenes.getOrdenesList().remove(ordenesListNewOrdenes);
                        oldCliNITOfOrdenesListNewOrdenes = em.merge(oldCliNITOfOrdenesListNewOrdenes);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clientes.getCliNIT();
                if (findClientes(id) == null) {
                    throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes clientes;
            try {
                clientes = em.getReference(Clientes.class, id);
                clientes.getCliNIT();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.", enfe);
            }
            List<Ordenes> ordenesList = clientes.getOrdenesList();
            for (Ordenes ordenesListOrdenes : ordenesList) {
                ordenesListOrdenes.setCliNIT(null);
                ordenesListOrdenes = em.merge(ordenesListOrdenes);
            }
            em.remove(clientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clientes> findClientesEntities() {
        return findClientesEntities(true, -1, -1);
    }

    public List<Clientes> findClientesEntities(int maxResults, int firstResult) {
        return findClientesEntities(false, maxResults, firstResult);
    }

    private List<Clientes> findClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clientes.class));
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

    public Clientes findClientes(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clientes> rt = cq.from(Clientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
