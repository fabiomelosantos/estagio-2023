package entidades;

import entidades.Compra;
import entidades.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-31T19:32:07")
@StaticMetamodel(ItensCompra.class)
public class ItensCompra_ { 

    public static volatile SingularAttribute<ItensCompra, Double> preco;
    public static volatile SingularAttribute<ItensCompra, Compra> compra;
    public static volatile SingularAttribute<ItensCompra, Produto> produto;
    public static volatile SingularAttribute<ItensCompra, Long> id;
    public static volatile SingularAttribute<ItensCompra, Double> quantidade;

}