package entidades;

import entidades.Fornecedor;
import entidades.ItensCompra;
import entidades.Produto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-31T19:32:07")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile ListAttribute<Compra, ItensCompra> itensCompras;
    public static volatile SingularAttribute<Compra, Produto> produto;
    public static volatile SingularAttribute<Compra, Double> valorTotal;
    public static volatile SingularAttribute<Compra, Long> id;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, Date> dataCompra;

}