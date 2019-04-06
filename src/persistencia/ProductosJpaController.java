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
import modelo.Proveedores;
import modelo.Detallesorden;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Productos;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Kings
 */
public class ProductosJpaController implements Serializable {

    public ProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productos productos) {
        if (productos.getDetallesordenList() == null) {
            productos.setDetallesordenList(new ArrayList<Detallesorden>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proNIT = productos.getProNIT();
            if (proNIT != null) {
                proNIT = em.getReference(proNIT.getClass(), proNIT.getProNIT());
                productos.setProNIT(proNIT);
            }
            List<Detallesorden> attachedDetallesordenList = new ArrayList<Detallesorden>();
            for (Detallesorden detallesordenListDetallesordenToAttach : productos.getDetallesordenList()) {
                detallesordenListDetallesordenToAttach = em.getReference(detallesordenListDetallesordenToAttach.getClass(), detallesordenListDetallesordenToAttach.getDetCodigo());
                attachedDetallesordenList.add(detallesordenListDetallesordenToAttach);
            }
            productos.setDetallesordenList(attachedDetallesordenList);
            em.persist(productos);
            if (proNIT != null) {
                proNIT.getProductosList().add(productos);
                proNIT = em.merge(proNIT);
            }
            for (Detallesorden detallesordenListDetallesorden : productos.getDetallesordenList()) {
                Productos oldProdCodigoOfDetallesordenListDetallesorden = detallesordenListDetallesorden.getProdCodigo();
                detallesordenListDetallesorden.setProdCodigo(productos);
                detallesordenListDetallesorden = em.merge(detallesordenListDetallesorden);
                if (oldProdCodigoOfDetallesordenListDetallesorden != null) {
                    oldProdCodigoOfDetallesordenListDetallesorden.getDetallesordenList().remove(detallesordenListDetallesorden);
                    oldProdCodigoOfDetallesordenListDetallesorden = em.merge(oldProdCodigoOfDetallesordenListDetallesorden);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productos productos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos persistentProductos = em.find(Productos.class, productos.getProdCodigo());
            Proveedores proNITOld = persistentProductos.getProNIT();
            Proveedores proNITNew = productos.getProNIT();
            List<Detallesorden> detallesordenListOld = persistentProductos.getDetallesordenList();
            List<Detallesorden> detallesordenListNew = productos.getDetallesordenList();
            if (proNITNew != null) {
                proNITNew = em.getReference(proNITNew.getClass(), proNITNew.getProNIT());
                productos.setProNIT(proNITNew);
            }
            List<Detallesorden> attachedDetallesordenListNew = new ArrayList<Detallesorden>();
            for (Detallesorden detallesordenListNewDetallesordenToAttach : detallesordenListNew) {
                detallesordenListNewDetallesordenToAttach = em.getReference(detallesordenListNewDetallesordenToAttach.getClass(), detallesordenListNewDetallesordenToAttach.getDetCodigo());
                attachedDetallesordenListNew.add(detallesordenListNewDetallesordenToAttach);
            }
            detallesordenListNew = attachedDetallesordenListNew;
            productos.setDetallesordenList(detallesordenListNew);
            productos = em.merge(productos);
            if (proNITOld != null && !proNITOld.equals(proNITNew)) {
                proNITOld.getProductosList().remove(productos);
                proNITOld = em.merge(proNITOld);
            }
            if (proNITNew != null && !proNITNew.equals(proNITOld)) {
                proNITNew.getProductosList().add(productos);
                proNITNew = em.merge(proNITNew);
            }
            for (Detallesorden detallesordenListOldDetallesorden : detallesordenListOld) {
                if (!detallesordenListNew.contains(detallesordenListOldDetallesorden)) {
                    detallesordenListOldDetallesorden.setProdCodigo(null);
                    detallesordenListOldDetallesorden = em.merge(detallesordenListOldDetallesorden);
                }
            }
            for (Detallesorden detallesordenListNewDetallesorden : detallesordenListNew) {
                if (!detallesordenListOld.contains(detallesordenListNewDetallesorden)) {
                    Productos oldProdCodigoOfDetallesordenListNewDetallesorden = detallesordenListNewDetallesorden.getProdCodigo();
                    detallesordenListNewDetallesorden.setProdCodigo(productos);
                    detallesordenListNewDetallesorden = em.merge(detallesordenListNewDetallesorden);
                    if (oldProdCodigoOfDetallesordenListNewDetallesorden != null && !oldProdCodigoOfDetallesordenListNewDetallesorden.equals(productos)) {
                        oldProdCodigoOfDetallesordenListNewDetallesorden.getDetallesordenList().remove(detallesordenListNewDetallesorden);
                        oldProdCodigoOfDetallesordenListNewDetallesorden = em.merge(oldProdCodigoOfDetallesordenListNewDetallesorden);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productos.getProdCodigo();
                if (findProductos(id) == null) {
                    throw new NonexistentEntityException("The productos with id " + id + " no longer exists.");
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
            Productos productos;
            try {
                productos = em.getReference(Productos.class, id);
                productos.getProdCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productos with id " + id + " no longer exists.", enfe);
            }
            Proveedores proNIT = productos.getProNIT();
            if (proNIT != null) {
                proNIT.getProductosList().remove(productos);
                proNIT = em.merge(proNIT);
            }
            List<Detallesorden> detallesordenList = productos.getDetallesordenList();
            for (Detallesorden detallesordenListDetallesorden : detallesordenList) {
                detallesordenListDetallesorden.setProdCodigo(null);
                detallesordenListDetallesorden = em.merge(detallesordenListDetallesorden);
            }
            em.remove(productos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productos> findProductosEntities() {
        return findProductosEntities(true, -1, -1);
    }

    public List<Productos> findProductosEntities(int maxResults, int firstResult) {
        return findProductosEntities(false, maxResults, firstResult);
    }

    private List<Productos> findProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productos.class));
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

    public Productos findProductos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productos> rt = cq.from(Productos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
