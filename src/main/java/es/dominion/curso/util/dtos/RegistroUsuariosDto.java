package es.dominion.curso.util.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@SuppressWarnings("serial")
public class RegistroUsuariosDto implements Serializable {
    
    private Long codigoRegistro;
    private Date fechaEntrada;
    private Date fechaEntradaFrom;
    private Date fechaEntradaTo;
    private Date fechaSalida;
    private Date fechaSalidaFrom;
    private Date fechaSalidaTo;
	private String codigoUsuario;
	private String codigoUsuarioLk;
	private String duracion;
	private String duracionLk;
	private Short ficherosSubidos;
    private Short ficherosSubidosFrom;
    private Short ficherosSubidosTo;
    private BigDecimal informacionSubida;
    private BigDecimal informacionSubidaFrom;
    private BigDecimal informacionSubidaTo;
    
    
	public RegistroUsuariosDto() {
	}


	/**
	 * @return the codigoRegistro
	 */
	public Long getCodigoRegistro() {
		return codigoRegistro;
	}


	/**
	 * @param codigoRegistro the codigoRegistro to set
	 */
	public void setCodigoRegistro(Long codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}


	/**
	 * @return the fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	/**
	 * @param fechaEntrada the fechaEntrada to set
	 */
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	/**
	 * @return the fechaEntradaFrom
	 */
	public Date getFechaEntradaFrom() {
		return fechaEntradaFrom;
	}


	/**
	 * @param fechaEntradaFrom the fechaEntradaFrom to set
	 */
	public void setFechaEntradaFrom(Date fechaEntradaFrom) {
		this.fechaEntradaFrom = fechaEntradaFrom;
	}


	/**
	 * @return the fechaEntradaTo
	 */
	public Date getFechaEntradaTo() {
		return fechaEntradaTo;
	}


	/**
	 * @param fechaEntradaTo the fechaEntradaTo to set
	 */
	public void setFechaEntradaTo(Date fechaEntradaTo) {
		this.fechaEntradaTo = fechaEntradaTo;
	}


	/**
	 * @return the fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}


	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	/**
	 * @return the fechaSalidaFrom
	 */
	public Date getFechaSalidaFrom() {
		return fechaSalidaFrom;
	}


	/**
	 * @param fechaSalidaFrom the fechaSalidaFrom to set
	 */
	public void setFechaSalidaFrom(Date fechaSalidaFrom) {
		this.fechaSalidaFrom = fechaSalidaFrom;
	}


	/**
	 * @return the fechaSalidaTo
	 */
	public Date getFechaSalidaTo() {
		return fechaSalidaTo;
	}


	/**
	 * @param fechaSalidaTo the fechaSalidaTo to set
	 */
	public void setFechaSalidaTo(Date fechaSalidaTo) {
		this.fechaSalidaTo = fechaSalidaTo;
	}


	/**
	 * @return the codigoUsuario
	 */
	public String getCodigoUsuario() {
		return codigoUsuario;
	}


	/**
	 * @param codigoUsuario the codigoUsuario to set
	 */
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}


	/**
	 * @return the codigoUsuarioLk
	 */
	public String getCodigoUsuarioLk() {
		return codigoUsuarioLk;
	}


	/**
	 * @param codigoUsuarioLk the codigoUsuarioLk to set
	 */
	public void setCodigoUsuarioLk(String codigoUsuarioLk) {
		this.codigoUsuarioLk = codigoUsuarioLk;
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
	 * @return the ficherosSubidos
	 */
	public Short getFicherosSubidos() {
		return ficherosSubidos;
	}


	/**
	 * @param ficherosSubidos the ficherosSubidos to set
	 */
	public void setFicherosSubidos(Short ficherosSubidos) {
		this.ficherosSubidos = ficherosSubidos;
	}


	/**
	 * @return the ficherosSubidosFrom
	 */
	public Short getFicherosSubidosFrom() {
		return ficherosSubidosFrom;
	}


	/**
	 * @param ficherosSubidosFrom the ficherosSubidosFrom to set
	 */
	public void setFicherosSubidosFrom(Short ficherosSubidosFrom) {
		this.ficherosSubidosFrom = ficherosSubidosFrom;
	}


	/**
	 * @return the ficherosSubidosTo
	 */
	public Short getFicherosSubidosTo() {
		return ficherosSubidosTo;
	}


	/**
	 * @param ficherosSubidosTo the ficherosSubidosTo to set
	 */
	public void setFicherosSubidosTo(Short ficherosSubidosTo) {
		this.ficherosSubidosTo = ficherosSubidosTo;
	}


	/**
	 * @return the informacionSubida
	 */
	public BigDecimal getInformacionSubida() {
		return informacionSubida;
	}


	/**
	 * @param informacionSubida the informacionSubida to set
	 */
	public void setInformacionSubida(BigDecimal informacionSubida) {
		this.informacionSubida = informacionSubida;
	}


	/**
	 * @return the informacionSubidaFrom
	 */
	public BigDecimal getInformacionSubidaFrom() {
		return informacionSubidaFrom;
	}


	/**
	 * @param informacionSubidaFrom the informacionSubidaFrom to set
	 */
	public void setInformacionSubidaFrom(BigDecimal informacionSubidaFrom) {
		this.informacionSubidaFrom = informacionSubidaFrom;
	}


	/**
	 * @return the informacionSubidaTo
	 */
	public BigDecimal getInformacionSubidaTo() {
		return informacionSubidaTo;
	}


	/**
	 * @param informacionSubidaTo the informacionSubidaTo to set
	 */
	public void setInformacionSubidaTo(BigDecimal informacionSubidaTo) {
		this.informacionSubidaTo = informacionSubidaTo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoRegistro == null) ? 0 : codigoRegistro.hashCode());
		result = prime * result + ((codigoUsuario == null) ? 0 : codigoUsuario.hashCode());
		result = prime * result + ((codigoUsuarioLk == null) ? 0 : codigoUsuarioLk.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((duracionLk == null) ? 0 : duracionLk.hashCode());
		result = prime * result + ((fechaEntrada == null) ? 0 : fechaEntrada.hashCode());
		result = prime * result + ((fechaEntradaFrom == null) ? 0 : fechaEntradaFrom.hashCode());
		result = prime * result + ((fechaEntradaTo == null) ? 0 : fechaEntradaTo.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((fechaSalidaFrom == null) ? 0 : fechaSalidaFrom.hashCode());
		result = prime * result + ((fechaSalidaTo == null) ? 0 : fechaSalidaTo.hashCode());
		result = prime * result + ((ficherosSubidos == null) ? 0 : ficherosSubidos.hashCode());
		result = prime * result + ((ficherosSubidosFrom == null) ? 0 : ficherosSubidosFrom.hashCode());
		result = prime * result + ((ficherosSubidosTo == null) ? 0 : ficherosSubidosTo.hashCode());
		result = prime * result + ((informacionSubida == null) ? 0 : informacionSubida.hashCode());
		result = prime * result + ((informacionSubidaFrom == null) ? 0 : informacionSubidaFrom.hashCode());
		result = prime * result + ((informacionSubidaTo == null) ? 0 : informacionSubidaTo.hashCode());
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
		if (!(obj instanceof RegistroUsuariosDto)) {
			return false;
		}
		RegistroUsuariosDto other = (RegistroUsuariosDto) obj;
		if (codigoRegistro == null) {
			if (other.codigoRegistro != null) {
				return false;
			}
		} else if (!codigoRegistro.equals(other.codigoRegistro)) {
			return false;
		}
		if (codigoUsuario == null) {
			if (other.codigoUsuario != null) {
				return false;
			}
		} else if (!codigoUsuario.equals(other.codigoUsuario)) {
			return false;
		}
		if (codigoUsuarioLk == null) {
			if (other.codigoUsuarioLk != null) {
				return false;
			}
		} else if (!codigoUsuarioLk.equals(other.codigoUsuarioLk)) {
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
		if (fechaEntrada == null) {
			if (other.fechaEntrada != null) {
				return false;
			}
		} else if (!fechaEntrada.equals(other.fechaEntrada)) {
			return false;
		}
		if (fechaEntradaFrom == null) {
			if (other.fechaEntradaFrom != null) {
				return false;
			}
		} else if (!fechaEntradaFrom.equals(other.fechaEntradaFrom)) {
			return false;
		}
		if (fechaEntradaTo == null) {
			if (other.fechaEntradaTo != null) {
				return false;
			}
		} else if (!fechaEntradaTo.equals(other.fechaEntradaTo)) {
			return false;
		}
		if (fechaSalida == null) {
			if (other.fechaSalida != null) {
				return false;
			}
		} else if (!fechaSalida.equals(other.fechaSalida)) {
			return false;
		}
		if (fechaSalidaFrom == null) {
			if (other.fechaSalidaFrom != null) {
				return false;
			}
		} else if (!fechaSalidaFrom.equals(other.fechaSalidaFrom)) {
			return false;
		}
		if (fechaSalidaTo == null) {
			if (other.fechaSalidaTo != null) {
				return false;
			}
		} else if (!fechaSalidaTo.equals(other.fechaSalidaTo)) {
			return false;
		}
		if (ficherosSubidos == null) {
			if (other.ficherosSubidos != null) {
				return false;
			}
		} else if (!ficherosSubidos.equals(other.ficherosSubidos)) {
			return false;
		}
		if (ficherosSubidosFrom == null) {
			if (other.ficherosSubidosFrom != null) {
				return false;
			}
		} else if (!ficherosSubidosFrom.equals(other.ficherosSubidosFrom)) {
			return false;
		}
		if (ficherosSubidosTo == null) {
			if (other.ficherosSubidosTo != null) {
				return false;
			}
		} else if (!ficherosSubidosTo.equals(other.ficherosSubidosTo)) {
			return false;
		}
		if (informacionSubida == null) {
			if (other.informacionSubida != null) {
				return false;
			}
		} else if (!informacionSubida.equals(other.informacionSubida)) {
			return false;
		}
		if (informacionSubidaFrom == null) {
			if (other.informacionSubidaFrom != null) {
				return false;
			}
		} else if (!informacionSubidaFrom.equals(other.informacionSubidaFrom)) {
			return false;
		}
		if (informacionSubidaTo == null) {
			if (other.informacionSubidaTo != null) {
				return false;
			}
		} else if (!informacionSubidaTo.equals(other.informacionSubidaTo)) {
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
		builder.append("RegistroUsuariosDto [");
		if (codigoRegistro != null) {
			builder.append("codigoRegistro=");
			builder.append(codigoRegistro);
			builder.append(", ");
		}
		if (fechaEntrada != null) {
			builder.append("fechaEntrada=");
			builder.append(fechaEntrada);
			builder.append(", ");
		}
		if (fechaEntradaFrom != null) {
			builder.append("fechaEntradaFrom=");
			builder.append(fechaEntradaFrom);
			builder.append(", ");
		}
		if (fechaEntradaTo != null) {
			builder.append("fechaEntradaTo=");
			builder.append(fechaEntradaTo);
			builder.append(", ");
		}
		if (fechaSalida != null) {
			builder.append("fechaSalida=");
			builder.append(fechaSalida);
			builder.append(", ");
		}
		if (fechaSalidaFrom != null) {
			builder.append("fechaSalidaFrom=");
			builder.append(fechaSalidaFrom);
			builder.append(", ");
		}
		if (fechaSalidaTo != null) {
			builder.append("fechaSalidaTo=");
			builder.append(fechaSalidaTo);
			builder.append(", ");
		}
		if (codigoUsuario != null) {
			builder.append("codigoUsuario=");
			builder.append(codigoUsuario);
			builder.append(", ");
		}
		if (codigoUsuarioLk != null) {
			builder.append("codigoUsuarioLk=");
			builder.append(codigoUsuarioLk);
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
		if (ficherosSubidos != null) {
			builder.append("ficherosSubidos=");
			builder.append(ficherosSubidos);
			builder.append(", ");
		}
		if (ficherosSubidosFrom != null) {
			builder.append("ficherosSubidosFrom=");
			builder.append(ficherosSubidosFrom);
			builder.append(", ");
		}
		if (ficherosSubidosTo != null) {
			builder.append("ficherosSubidosTo=");
			builder.append(ficherosSubidosTo);
			builder.append(", ");
		}
		if (informacionSubida != null) {
			builder.append("informacionSubida=");
			builder.append(informacionSubida);
			builder.append(", ");
		}
		if (informacionSubidaFrom != null) {
			builder.append("informacionSubidaFrom=");
			builder.append(informacionSubidaFrom);
			builder.append(", ");
		}
		if (informacionSubidaTo != null) {
			builder.append("informacionSubidaTo=");
			builder.append(informacionSubidaTo);
		}
		builder.append("]");
		return builder.toString();
	}


}
