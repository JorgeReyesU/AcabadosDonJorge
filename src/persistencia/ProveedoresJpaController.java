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
import modelo.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Materiasprimas;
import modelo.Proveedores;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Kings
 */
public class ProveedoresJpaController implements Serializable {

    public ProveedoresJpaController() {
        this.emf = this.emf = Persistence.createEntityManagerFactory("Acabados_DonJorgePU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedores proveedores) throws PreexistingEntityException, Exception {
        if (proveedores.getProductosList() == null) {
            proveedores.setProductosList(new ArrayList<Productos>());
        }
        if (proveedores.getMateriasprimasList() == null) {
            proveedores.setMateriasprimasList(new ArrayList<Materiasprimas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Productos> attachedProductosList = new ArrayList<Productos>();
            for (Productos productosListProductosToAttach : proveedores.getProductosList()) {
                productosListProductosToAttach = em.getReference(productosListProductosToAttach.getClass(), productosListProductosToAttach.getProdCodigo());
                attachedProductosList.add(productosListProductosToAttach);
            }
            proveedores.setProductosList(attachedProductosList);
            List<Materiasprimas> attachedMateriasprimasList = new ArrayList<Materiasprimas>();
            for (Materiasprimas materiasprimasListMateriasprimasToAttach : proveedores.getMateriasprimasList()) {
                materiasprimasListMateriasprimasToAttach = em.getReference(materiasprimasListMateriasprimasToAttach.getClass(), materiasprimasListMateriasprimasToAttach.getMatCodigo());
                attachedMateriasprimasList.add(materiasprimasListMateriasprimasToAttach);
            }
            proveedores.setMateriasprimasList(attachedMateriasprimasList);
            em.persist(proveedores);
            for (Productos productosListProductos : proveedores.getProductosList()) {
                Proveedores oldProNITOfProductosListProductos = productosListProductos.getProNIT();
                productosListProductos.setProNIT(proveedores);
                productosListProductos = em.merge(productosListProductos);
                if (oldProNITOfProductosListProductos != null) {
                    oldProNITOfProductosListProductos.getProductosList().remove(productosListProductos);
                    oldProNITOfProductosListProductos = em.merge(oldProNITOfProductosListProductos);
                }
            }
            for (Materiasprimas materiasprimasListMateriasprimas : proveedores.getMateriasprimasList()) {
                Proveedores oldProNITOfMateriasprimasListMateriasprimas = materiasprimasListMateriasprimas.getProNIT();
                materiasprimasListMateriasprimas.setProNIT(proveedores);
                materiasprimasListMateriasprimas = em.merge(materiasprimasListMateriasprimas);
                if (oldProNITOfMateriasprimasListMateriasprimas != null) {
                    oldProNITOfMateriasprimasListMateriasprimas.getMateriasprimasList().remove(materiasprimasListMateriasprimas);
                    oldProNITOfMateriasprimasListMateriasprimas = em.merge(oldProNITOfMateriasprimasListMateriasprimas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProveedores(proveedores.getProNIT()) != null) {
                throw new PreexistingEntityException("Proveedores " + proveedores + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedores proveedores) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores persistentProveedores = em.find(Proveedores.class, proveedores.getProNIT());
            List<Productos> productosListOld = persistentProveedores.getProductosList();
            List<Productos> productosListNew = proveedores.getProductosList();
            List<Materiasprimas> materiasprimasListOld = persistentProveedores.getMateriasprimasList();
            List<Materiasprimas> materiasprimasListNew = proveedores.getMateriasprimasList();
            List<Productos> attachedProductosListNew = new ArrayList<Productos>();
            for (Productos productosListNewProductosToAttach : productosListNew) {
                productosListNewProductosToAttach = em.getReference(productosListNewProductosToAttach.getClass(), productosListNewProductosToAttach.getProdCodigo());
                attachedProductosListNew.add(productosListNewProductosToAttach);
            }
            productosListNew = attachedProductosListNew;
            proveedores.setProductosList(productosListNew);
            List<Materiasprimas> attachedMateriasprimasListNew = new ArrayList<Materiasprimas>();
            for (Materiasprimas materiasprimasListNewMateriasprimasToAttach : materiasprimasListNew) {
                materiasprimasListNewMateriasprimasToAttach = em.getReference(materiasprimasListNewMateriasprimasToAttach.getClass(), materiasprimasListNewMateriasprimasToAttach.getMatCodigo());
                attachedMateriasprimasListNew.add(materiasprimasListNewMateriasprimasToAttach);
            }
            materiasprimasListNew = attachedMateriasprimasListNew;
            proveedores.setMateriasprimasList(materiasprimasListNew);
            proveedores = em.merge(proveedores);
            for (Productos productosListOldProductos : productosListOld) {
                if (!productosListNew.contains(productosListOldProductos)) {
                    productosListOldProductos.setProNIT(null);
                    productosListOldProductos = em.merge(productosListOldProductos);
                }
            }
            for (Productos productosListNewProductos : productosListNew) {
                if (!productosListOld.contains(productosListNewProductos)) {
                    Proveedores oldProNITOfProductosListNewProductos = productosListNewProductos.getProNIT();
                    productosListNewProductos.setProNIT(proveedores);
                    productosListNewProductos = em.merge(productosListNewProductos);
                    if (oldProNITOfProductosListNewProductos != null && !oldProNITOfProductosListNewProductos.equals(proveedores)) {
                        oldProNITOfProductosListNewProductos.getProductosList().remove(productosListNewProductos);
                        oldProNITOfProductosListNewProductos = em.merge(oldProNITOfProductosListNewProductos);
                    }
                }
            }
            for (Materiasprimas materiasprimasListOldMateriasprimas : materiasprimasListOld) {
                if (!materiasprimasListNew.contains(materiasprimasListOldMateriasprimas)) {
                    materiasprimasListOldMateriasprimas.setProNIT(null);
                    materiasprimasListOldMateriasprimas = em.merge(materiasprimasListOldMateriasprimas);
                }
            }
            for (Materiasprimas materiasprimasListNewMateriasprimas : materiasprimasListNew) {
                if (!materiasprimasListOld.contains(materiasprimasListNewMateriasprimas)) {
                    Proveedores oldProNITOfMateriasprimasListNewMateriasprimas = materiasprimasListNewMateriasprimas.getProNIT();
                    materiasprimasListNewMateriasprimas.setProNIT(proveedores);
                    materiasprimasListNewMateriasprimas = em.merge(materiasprimasListNewMateriasprimas);
                    if (oldProNITOfMateriasprimasListNewMateriasprimas != null && !oldProNITOfMateriasprimasListNewMateriasprimas.equals(proveedores)) {
                        oldProNITOfMateriasprimasListNewMateriasprimas.getMateriasprimasList().remove(materiasprimasListNewMateriasprimas);
                        oldProNITOfMateriasprimasListNewMateriasprimas = em.merge(oldProNITOfMateriasprimasListNewMateriasprimas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = proveedores.getProNIT();
                if (findProveedores(id) == null) {
                    throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.");
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
            Proveedores proveedores;
            try {
                proveedores = em.getReference(Proveedores.class, id);
                proveedores.getProNIT();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.", enfe);
            }
            List<Productos> productosList = proveedores.getProductosList();
            for (Productos productosListProductos : productosList) {
                productosListProductos.setProNIT(null);
                productosListProductos = em.merge(productosListProductos);
            }
            List<Materiasprimas> materiasprimasList = proveedores.getMateriasprimasList();
            for (Materiasprimas materiasprimasListMateriasprimas : materiasprimasList) {
                materiasprimasListMateriasprimas.setProNIT(null);
                materiasprimasListMateriasprimas = em.merge(materiasprimasListMateriasprimas);
            }
            em.remove(proveedores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedores> findProveedoresEntities() {
        return findProveedoresEntities(true, -1, -1);
    }

    public List<Proveedores> findProveedoresEntities(int maxResults, int firstResult) {
        return findProveedoresEntities(false, maxResults, firstResult);
    }

    private List<Proveedores> findProveedoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedores.class));
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

    public Proveedores findProveedores(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedores.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedores> rt = cq.from(Proveedores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
