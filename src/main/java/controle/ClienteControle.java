/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import converter.ConverterGenerico;
import entidades.Cliente;
import entidades.Cidade;
import entidades.Estado;
import facade.ClienteFacade;
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
public class ClienteControle implements Serializable {

    private Cliente cliente = new Cliente();
    @EJB
    private ClienteFacade clienteFacade;
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

    public void editar(Cliente cli) {
        cliente = cli;
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
        clienteFacade.salvar(cliente);
        cliente = new Cliente();
    }

    public void remover(Cliente obj) {
        clienteFacade.remover(obj);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return clienteFacade.listaTodos();
    }

}
