package es.dominion.curso.negocio.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-03T15:50:45.603+0200")
@StaticMetamodel(Roles.class)
public class Roles_ {
	public static volatile SingularAttribute<Roles, Byte> codigoRol;
	public static volatile SingularAttribute<Roles, String> descripcionRol;
	public static volatile SetAttribute<Roles, Usuarios> usuarioses;
	public static volatile SetAttribute<Roles, Tareas> tareases;
}
