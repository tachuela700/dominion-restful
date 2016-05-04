package es.dominion.curso.negocio.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-03T15:50:45.615+0200")
@StaticMetamodel(Tareas.class)
public class Tareas_ {
	public static volatile SingularAttribute<Tareas, Byte> codigoTarea;
	public static volatile SingularAttribute<Tareas, String> descripcionTarea;
	public static volatile SingularAttribute<Tareas, String> vinculo;
	public static volatile SetAttribute<Tareas, Roles> roleses;
}
