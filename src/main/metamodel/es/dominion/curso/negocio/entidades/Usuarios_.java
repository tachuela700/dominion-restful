package es.dominion.curso.negocio.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-03T15:50:45.652+0200")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ {
	public static volatile SingularAttribute<Usuarios, String> nombreUsuario;
	public static volatile SingularAttribute<Usuarios, Roles> roles;
	public static volatile SingularAttribute<Usuarios, String> password;
	public static volatile SingularAttribute<Usuarios, Date> fechaAlta;
	public static volatile SingularAttribute<Usuarios, Date> fechaBaja;
	public static volatile SingularAttribute<Usuarios, String> carpetaDocumentacion;
	public static volatile SingularAttribute<Usuarios, String> idioma;
}
