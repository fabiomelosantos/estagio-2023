/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.ItensCompra;
import entidades.Produto;
import entidades.Compra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jaimedias
 */
@Stateless
public class CompraFacade extends AbstractFacade<Compra> {

    @PersistenceContext(unitName = "estagiopu")
    private EntityManager em;

    @Override
    public void salvar(Compra co) {
        Produto p = null;
        for (ItensCompra it : co.getItensCompras()) {
            p = it.getProduto();
                p.setEstoque(p.getEstoque() + it.getQuantidade());
                em.merge(p);
        }
        super.salvar(co);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompraFacade() {
        super(Compra.class);
    }

}
