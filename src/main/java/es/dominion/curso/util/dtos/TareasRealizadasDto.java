package es.dominion.curso.util.dtos;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

@SuppressWarnings("serial")
public class TareasRealizadasDto implements Serializable {
    
    private Long codigoTarearealizada;
    private TareasUsuariosDto tareasUsuariosDto;
    private String usuario;
	private String usuarioLk;
	private String duracion;
	private String duracionLk;
	private Date fechaRealizacion;
    private Date fechaRealizacionFrom;
    private Date fechaRealizacionTo;
    private Blob datosAñadidos;
    private Blob datosModificados;
    private Blob datosEliminados;
    
    
	public TareasRealizadasDto() {
	}


	/**
	 * @return the codigoTarearealizada
	 */
	public Long getCodigoTarearealizada() {
		return codigoTarearealizada;
	}


	/**
	 * @param codigoTarearealizada the codigoTarearealizada to set
	 */
	public void setCodigoTarearealizada(Long codigoTarearealizada) {
		this.codigoTarearealizada = codigoTarearealizada;
	}


	/**
	 * @return the tareasUsuariosDto
	 */
	public TareasUsuariosDto getTareasUsuariosDto() {
		return tareasUsuariosDto;
	}


	/**
	 * @param tareasUsuariosDto the tareasUsuariosDto to set
	 */
	public void setTareasUsuariosDto(TareasUsuariosDto tareasUsuariosDto) {
		this.tareasUsuariosDto = tareasUsuariosDto;
	}


	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return the usuarioLk
	 */
	public String getUsuarioLk() {
		return usuarioLk;
	}


	/**
	 * @param usuarioLk the usuarioLk to set
	 */
	public void setUsuarioLk(String usuarioLk) {
		this.usuarioLk = usuarioLk;
	}


	/**
	 * @return the duracion
	 */
	public String getDuracion() {
		return duracion;
	}


	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	/**
	 * @return the duracionLk
	 */
	public String getDuracionLk() {
		return duracionLk;
	}


	/**
	 * @param duracionLk the duracionLk to set
	 */
	public void setDuracionLk(String duracionLk) {
		this.duracionLk = duracionLk;
	}


	/**
	 * @return the fechaRealizacion
	 */
	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}


	/**
	 * @param fechaRealizacion the fechaRealizacion to set
	 */
	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}


	/**
	 * @return the fechaRealizacionFrom
	 */
	public Date getFechaRealizacionFrom() {
		return fechaRealizacionFrom;
	}


	/**
	 * @param fechaRealizacionFrom the fechaRealizacionFrom to set
	 */
	public void setFechaRealizacionFrom(Date fechaRealizacionFrom) {
		this.fechaRealizacionFrom = fechaRealizacionFrom;
	}


	/**
	 * @return the fechaRealizacionTo
	 */
	public Date getFechaRealizacionTo() {
		return fechaRealizacionTo;
	}


	/**
	 * @param fechaRealizacionTo the fechaRealizacionTo to set
	 */
	public void setFechaRealizacionTo(Date fechaRealizacionTo) {
		this.fechaRealizacionTo = fechaRealizacionTo;
	}


	/**
	 * @return the datosAñadidos
	 */
	public Blob getDatosAñadidos() {
		return datosAñadidos;
	}


	/**
	 * @param datosAñadidos the datosAñadidos to set
	 */
	public void setDatosAñadidos(Blob datosAñadidos) {
		this.datosAñadidos = datosAñadidos;
	}


	/**
	 * @return the datosModificados
	 */
	public Blob getDatosModificados() {
		return datosModificados;
	}


	/**
	 * @param datosModificados the datosModificados to set
	 */
	public void setDatosModificados(Blob datosModificados) {
		this.datosModificados = datosModificados;
	}


	/**
	 * @return the datosEliminados
	 */
	public Blob getDatosEliminados() {
		return datosEliminados;
	}


	/**
	 * @param datosEliminados the datosEliminados to set
	 */
	public void setDatosEliminados(Blob datosEliminados) {
		this.datosEliminados = datosEliminados;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTarearealizada == null) ? 0 : codigoTarearealizada.hashCode());
		result = prime * result + ((datosAñadidos == null) ? 0 : datosAñadidos.hashCode());
		result = prime * result + ((datosEliminados == null) ? 0 : datosEliminados.hashCode());
		result = prime * result + ((datosModificados == null) ? 0 : datosModificados.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((duracionLk == null) ? 0 : duracionLk.hashCode());
		result = prime * result + ((fechaRealizacion == null) ? 0 : fechaRealizacion.hashCode());
		result = prime * result + ((fechaRealizacionFrom == null) ? 0 : fechaRealizacionFrom.hashCode());
		result = prime * result + ((fechaRealizacionTo == null) ? 0 : fechaRealizacionTo.hashCode());
		result = prime * result + ((tareasUsuariosDto == null) ? 0 : tareasUsuariosDto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((usuarioLk == null) ? 0 : usuarioLk.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TareasRealizadasDto)) {
			return false;
		}
		TareasRealizadasDto other = (TareasRealizadasDto) obj;
		if (codigoTarearealizada == null) {
			if (other.codigoTarearealizada != null) {
				return false;
			}
		} else if (!codigoTarearealizada.equals(other.codigoTarearealizada)) {
			return false;
		}
		if (datosAñadidos == null) {
			if (other.datosAñadidos != null) {
				return false;
			}
		} else if (!datosAñadidos.equals(other.datosAñadidos)) {
			return false;
		}
		if (datosEliminados == null) {
			if (other.datosEliminados != null) {
				return false;
			}
		} else if (!datosEliminados.equals(other.datosEliminados)) {
			return false;
		}
		if (datosModificados == null) {
			if (other.datosModificados != null) {
				return false;
			}
		} else if (!datosModificados.equals(other.datosModificados)) {
			return false;
		}
		if (duracion == null) {
			if (other.duracion != null) {
				return false;
			}
		} else if (!duracion.equals(other.duracion)) {
			return false;
		}
		if (duracionLk == null) {
			if (other.duracionLk != null) {
				return false;
			}
		} else if (!duracionLk.equals(other.duracionLk)) {
			return false;
		}
		if (fechaRealizacion == null) {
			if (other.fechaRealizacion != null) {
				return false;
			}
		} else if (!fechaRealizacion.equals(other.fechaRealizacion)) {
			return false;
		}
		if (fechaRealizacionFrom == null) {
			if (other.fechaRealizacionFrom != null) {
				return false;
			}
		} else if (!fechaRealizacionFrom.equals(other.fechaRealizacionFrom)) {
			return false;
		}
		if (fechaRealizacionTo == null) {
			if (other.fechaRealizacionTo != null) {
				return false;
			}
		} else if (!fechaRealizacionTo.equals(other.fechaRealizacionTo)) {
			return false;
		}
		if (tareasUsuariosDto == null) {
			if (other.tareasUsuariosDto != null) {
				return false;
			}
		} else if (!tareasUsuariosDto.equals(other.tareasUsuariosDto)) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		if (usuarioLk == null) {
			if (other.usuarioLk != null) {
				return false;
			}
		} else if (!usuarioLk.equals(other.usuarioLk)) {
			return false;
		}
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TareasRealizadasDto [");
		if (codigoTarearealizada != null) {
			builder.append("codigoTarearealizada=");
			builder.append(codigoTarearealizada);
			builder.append(", ");
		}
		if (tareasUsuariosDto != null) {
			builder.append("tareasUsuariosDto=");
			builder.append(tareasUsuariosDto);
			builder.append(", ");
		}
		if (usuario != null) {
			builder.append("usuario=");
			builder.append(usuario);
			builder.append(", ");
		}
		if (usuarioLk != null) {
			builder.append("usuarioLk=");
			builder.append(usuarioLk);
			builder.append(", ");
		}
		if (duracion != null) {
			builder.append("duracion=");
			builder.append(duracion);
			builder.append(", ");
		}
		if (duracionLk != null) {
			builder.append("duracionLk=");
			builder.append(duracionLk);
			builder.append(", ");
		}
		if (fechaRealizacion != null) {
			builder.append("fechaRealizacion=");
			builder.append(fechaRealizacion);
			builder.append(", ");
		}
		if (fechaRealizacionFrom != null) {
			builder.append("fechaRealizacionFrom=");
			builder.append(fechaRealizacionFrom);
			builder.append(", ");
		}
		if (fechaRealizacionTo != null) {
			builder.append("fechaRealizacionTo=");
			builder.append(fechaRealizacionTo);
			builder.append(", ");
		}
		if (datosAñadidos != null) {
			builder.append("datosAñadidos=");
			builder.append(datosAñadidos);
			builder.append(", ");
		}
		if (datosModificados != null) {
			builder.append("datosModificados=");
			builder.append(datosModificados);
			builder.append(", ");
		}
		if (datosEliminados != null) {
			builder.append("datosEliminados=");
			builder.append(datosEliminados);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
