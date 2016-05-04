package es.dominion.curso.negocio.entidades;

import java.sql.Blob;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-03T15:50:45.627+0200")
@StaticMetamodel(TareasRealizadas.class)
public class TareasRealizadas_ {
	public static volatile SingularAttribute<TareasRealizadas, Long> codigoTarearealizada;
	public static volatile SingularAttribute<TareasRealizadas, TareasUsuarios> tareasUsuarios;
	public static volatile SingularAttribute<TareasRealizadas, String> usuario;
	public static volatile SingularAttribute<TareasRealizadas, Date> fechaRealizacion;
	public static volatile SingularAttribute<TareasRealizadas, Blob> datosAñadidos;
	public static volatile SingularAttribute<TareasRealizadas, Blob> datosModificados;
	public static volatile SingularAttribute<TareasRealizadas, Blob> datosEliminados;
}
