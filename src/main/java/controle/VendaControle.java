/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import converter.ConverterGenerico;
import entidades.Cliente;
import entidades.ContasReceber;
import entidades.ItensVenda;
import entidades.Produto;
import entidades.Venda;
import facade.ClienteFacade;
import facade.ProdutoFacade;
import facade.VendaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jaimedias
 */
@ManagedBean
@SessionScoped
public class VendaControle implements Serializable {

    private Venda venda = new Venda();
    private ItensVenda itensVenda = new ItensVenda();
    @EJB
    private VendaFacade vendaFacade;
    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private ProdutoFacade produtoFacade;
    private ConverterGenerico produtoConverter;
    private ConverterGenerico clienteConverter;
    private Integer numeroParcelas;
    private ContasReceber contasReceber;

    public void novo() {
        venda = new Venda();
    }

    public void gerarParcelas() {
        venda.setContasRecebers(new ArrayList<ContasReceber>());
        Date dataVencimento = venda.getDataVenda();
        for (int i = 1; i <= numeroParcelas; i++) {
            contasReceber = new ContasReceber();
            contasReceber.setDataLancamento(venda.getDataVenda());
            contasReceber.setParcela(i);
            contasReceber.setDataVencimento(dataVencimento);
            contasReceber.setValor(venda.getValorTotal() / numeroParcelas);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataVencimento);
            cal.add(Calendar.MONTH, 1);
            dataVencimento = cal.getTime();
            venda.getContasRecebers().add(contasReceber);
        }

    }

    public ContasReceber getContasReceber() {
        return contasReceber;
    }

    public void setContasReceber(ContasReceber contasReceber) {
        this.contasReceber = contasReceber;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public ItensVenda getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ItensVenda itensVenda) {
        this.itensVenda = itensVenda;
    }

    public ConverterGenerico getProdutoConverter() {
        if (produtoConverter == null) {
            produtoConverter = new ConverterGenerico(produtoFacade);
        }
        return produtoConverter;
    }

    public void setProdutoConverter(ConverterGenerico produtoConverter) {
        this.produtoConverter = produtoConverter;
    }

    public ConverterGenerico getClienteConverter() {
        if (clienteConverter == null) {
            clienteConverter = new ConverterGenerico(clienteFacade);
        }
        return clienteConverter;
    }

    public List<Produto> getListaFiltrandoProduto(String filtro) {
        return produtoFacade.listaFiltrando(filtro, "nome");
    }

    public List<Cliente> getListaFiltrandoCliente(String filtro) {
        return clienteFacade.listaFiltrando(filtro, "nome", "cpfcnpj");
    }

    public void setClienteConverter(ConverterGenerico clienteConverter) {
        this.clienteConverter = clienteConverter;
    }

    public void salvar() {
//        venda.setDataVenda(new Date());
        vendaFacade.salvar(venda);
        venda = new Venda();
    }

    public void addItem() {
        ItensVenda itemTemp = null;
        Double estoque = itensVenda.getProduto().getEstoque();
        for (ItensVenda it : venda.getItensVendas()) {
            if (itensVenda.getProduto().getId().equals(it.getProduto().getId())) {
                estoque = estoque - it.getQuantidade();
                itemTemp = it;
            }
        }
        if (itensVenda.getQuantidade() > estoque) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Estoque insuficiente!", "Restam apenas " + estoque + " unidade!"));
        } else {
            if (itemTemp == null) {
                itensVenda.setVenda(venda);
                venda.getItensVendas().add(itensVenda);
            } else {
                itemTemp.setQuantidade(itemTemp.getQuantidade() + itensVenda.getQuantidade());
            }

            itensVenda = new ItensVenda();
        }
    }

    public void atualizaPreco() {
        itensVenda.setPreco(itensVenda.getProduto().getPreco());
    }

    public void remover(Venda ve) {
        vendaFacade.remover(ve);
    }

    public void editar(Venda ve) {
        venda = ve;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public List<Venda> getListaVendas() {
        return vendaFacade.listaTodos();
    }

}
