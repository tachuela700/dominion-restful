package es.dominion.curso.negocio.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-03T15:50:45.591+0200")
@StaticMetamodel(RegistroUsuarios.class)
public class RegistroUsuarios_ {
	public static volatile SingularAttribute<RegistroUsuarios, Long> codigoRegistro;
	public static volatile SingularAttribute<RegistroUsuarios, String> codigoUsuario;
	public static volatile SingularAttribute<RegistroUsuarios, Date> fechaEntrada;
	public static volatile SingularAttribute<RegistroUsuarios, Date> fechaSalida;
	public static volatile SingularAttribute<RegistroUsuarios, String> duracion;
	public static volatile SingularAttribute<RegistroUsuarios, Short> ficherosSubidos;
	public static volatile SingularAttribute<RegistroUsuarios, BigDecimal> informacionSubida;
}
