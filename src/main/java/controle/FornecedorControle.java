/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import converter.ConverterGenerico;
import entidades.Fornecedor;
import entidades.Cidade;
import entidades.Estado;
import facade.FornecedorFacade;
import facade.CidadeFacade;
import facade.EstadoFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jaimedias
 */
@ManagedBean
@SessionScoped
public class FornecedorControle implements Serializable {

    private Fornecedor fornecedor = new Fornecedor();
    @EJB
    private FornecedorFacade fornecedorFacade;
    @EJB
    private CidadeFacade cidadeFacade;
    private ConverterGenerico cidadeConverter;

    public ConverterGenerico getCidadeConverter() {
        if (cidadeConverter == null) {
            cidadeConverter = new ConverterGenerico(cidadeFacade);
        }
        return cidadeConverter;
    }
    @EJB
    private EstadoFacade estadoFacade;
    private ConverterGenerico estadoConverter;

    public ConverterGenerico getEstadoConverter() {
        if (estadoConverter == null) {
            estadoConverter = new ConverterGenerico(estadoFacade);
        }
        return estadoConverter;
    }

    public void editar(Fornecedor forn) {
        fornecedor = forn;
    }

    public void setCidadeConverter(ConverterGenerico cidadeConverter) {
        this.cidadeConverter = cidadeConverter;
    }

    public List<Cidade> listaCidadesFiltrando(String filtro) {
        return cidadeFacade.listaFiltrando(filtro, "nome");
    }

    public void setEstadoConverter(ConverterGenerico estadoConverter) {
        this.estadoConverter = estadoConverter;
    }

    public List<Estado> listaEstadosFiltrando(String filtro) {
        return estadoFacade.listaFiltrando(filtro, "nome", "uf");
    }

    public void salvar() {
        fornecedorFacade.salvar(fornecedor);
        fornecedor = new Fornecedor();
    }

    public void remover(Fornecedor obj) {
        fornecedorFacade.remover(obj);
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getListaFornecedors() {
        return fornecedorFacade.listaTodos();
    }

}
