package entidades;

import entidades.Cliente;
import entidades.Venda;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-31T19:32:07")
@StaticMetamodel(ContasReceber.class)
public class ContasReceber_ { 

    public static volatile SingularAttribute<ContasReceber, Cliente> cliente;
    public static volatile SingularAttribute<ContasReceber, Venda> venda;
    public static volatile SingularAttribute<ContasReceber, Double> desconto;
    public static volatile SingularAttribute<ContasReceber, Date> dataVencimento;
    public static volatile SingularAttribute<ContasReceber, Double> juros;
    public static volatile SingularAttribute<ContasReceber, Double> valor;
    public static volatile SingularAttribute<ContasReceber, Long> id;
    public static volatile SingularAttribute<ContasReceber, Date> dataCompetencia;
    public static volatile SingularAttribute<ContasReceber, Integer> parcela;
    public static volatile SingularAttribute<ContasReceber, Date> dataLancamento;
    public static volatile SingularAttribute<ContasReceber, Date> dataRecebimento;

}