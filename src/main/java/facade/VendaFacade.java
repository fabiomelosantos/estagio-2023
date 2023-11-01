/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entidades.ItensVenda;
import entidades.Produto;
import entidades.Venda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jaimedias
 */
@Stateless
public class VendaFacade extends AbstractFacade<Venda> {

    @PersistenceContext(unitName = "estagiopu")
    private EntityManager em;

    @Override
    public void salvar(Venda ve) {
        Produto p = null;
        for (ItensVenda it : ve.getItensVendas()) {
            p = it.getProduto();
                p.setEstoque(p.getEstoque() - it.getQuantidade());
                em.merge(p);
        }
        super.salvar(ve);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VendaFacade() {
        super(Venda.class);
    }

}
