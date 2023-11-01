package entidades;

import entidades.Produto;
import entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-31T19:32:07")
@StaticMetamodel(ItensVenda.class)
public class ItensVenda_ { 

    public static volatile SingularAttribute<ItensVenda, Double> preco;
    public static volatile SingularAttribute<ItensVenda, Venda> venda;
    public static volatile SingularAttribute<ItensVenda, Produto> produto;
    public static volatile SingularAttribute<ItensVenda, Long> id;
    public static volatile SingularAttribute<ItensVenda, Double> quantidade;

}