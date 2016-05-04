package es.dominion.curso.negocio.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-03T15:50:45.639+0200")
@StaticMetamodel(TareasUsuarios.class)
public class TareasUsuarios_ {
	public static volatile SingularAttribute<TareasUsuarios, Long> codigoTareausuario;
	public static volatile SingularAttribute<TareasUsuarios, String> descripcionTareausuario;
	public static volatile SingularAttribute<TareasUsuarios, String> estadoTarea;
	public static volatile SetAttribute<TareasUsuarios, TareasRealizadas> tareasRealizadases;
}
