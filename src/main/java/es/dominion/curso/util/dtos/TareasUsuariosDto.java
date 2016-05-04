package es.dominion.curso.util.dtos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TareasUsuariosDto implements Serializable {
    
    private Long codigoTareausuario;
    private String descripcionTareausuario;
	private String descripcionTareausuarioLk;
	private String estadoTarea;
	private String estadoTareaLk;
    
    
	public TareasUsuariosDto() {
	}


	/**
	 * @return the codigoTareausuario
	 */
	public Long getCodigoTareausuario() {
		return codigoTareausuario;
	}


	/**
	 * @param codigoTareausuario the codigoTareausuario to set
	 */
	public void setCodigoTareausuario(Long codigoTareausuario) {
		this.codigoTareausuario = codigoTareausuario;
	}


	/**
	 * @return the descripcionTareausuario
	 */
	public String getDescripcionTareausuario() {
		return descripcionTareausuario;
	}


	/**
	 * @param descripcionTareausuario the descripcionTareausuario to set
	 */
	public void setDescripcionTareausuario(String descripcionTareausuario) {
		this.descripcionTareausuario = descripcionTareausuario;
	}


	/**
	 * @return the descripcionTareausuarioLk
	 */
	public String getDescripcionTareausuarioLk() {
		return descripcionTareausuarioLk;
	}


	/**
	 * @param descripcionTareausuarioLk the descripcionTareausuarioLk to set
	 */
	public void setDescripcionTareausuarioLk(String descripcionTareausuarioLk) {
		this.descripcionTareausuarioLk = descripcionTareausuarioLk;
	}


	/**
	 * @return the estadoTarea
	 */
	public String getEstadoTarea() {
		return estadoTarea;
	}


	/**
	 * @param estadoTarea the estadoTarea to set
	 */
	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}


	/**
	 * @return the estadoTareaLk
	 */
	public String getEstadoTareaLk() {
		return estadoTareaLk;
	}


	/**
	 * @param estadoTareaLk the estadoTareaLk to set
	 */
	public void setEstadoTareaLk(String estadoTareaLk) {
		this.estadoTareaLk = estadoTareaLk;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTareausuario == null) ? 0 : codigoTareausuario.hashCode());
		result = prime * result + ((descripcionTareausuario == null) ? 0 : descripcionTareausuario.hashCode());
		result = prime * result + ((descripcionTareausuarioLk == null) ? 0 : descripcionTareausuarioLk.hashCode());
		result = prime * result + ((estadoTarea == null) ? 0 : estadoTarea.hashCode());
		result = prime * result + ((estadoTareaLk == null) ? 0 : estadoTareaLk.hashCode());
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
		if (!(obj instanceof TareasUsuariosDto)) {
			return false;
		}
		TareasUsuariosDto other = (TareasUsuariosDto) obj;
		if (codigoTareausuario == null) {
			if (other.codigoTareausuario != null) {
				return false;
			}
		} else if (!codigoTareausuario.equals(other.codigoTareausuario)) {
			return false;
		}
		if (descripcionTareausuario == null) {
			if (other.descripcionTareausuario != null) {
				return false;
			}
		} else if (!descripcionTareausuario.equals(other.descripcionTareausuario)) {
			return false;
		}
		if (descripcionTareausuarioLk == null) {
			if (other.descripcionTareausuarioLk != null) {
				return false;
			}
		} else if (!descripcionTareausuarioLk.equals(other.descripcionTareausuarioLk)) {
			return false;
		}
		if (estadoTarea == null) {
			if (other.estadoTarea != null) {
				return false;
			}
		} else if (!estadoTarea.equals(other.estadoTarea)) {
			return false;
		}
		if (estadoTareaLk == null) {
			if (other.estadoTareaLk != null) {
				return false;
			}
		} else if (!estadoTareaLk.equals(other.estadoTareaLk)) {
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
		builder.append("TareasUsuariosDto [");
		if (codigoTareausuario != null) {
			builder.append("codigoTareausuario=");
			builder.append(codigoTareausuario);
			builder.append(", ");
		}
		if (descripcionTareausuario != null) {
			builder.append("descripcionTareausuario=");
			builder.append(descripcionTareausuario);
			builder.append(", ");
		}
		if (descripcionTareausuarioLk != null) {
			builder.append("descripcionTareausuarioLk=");
			builder.append(descripcionTareausuarioLk);
			builder.append(", ");
		}
		if (estadoTarea != null) {
			builder.append("estadoTarea=");
			builder.append(estadoTarea);
			builder.append(", ");
		}
		if (estadoTareaLk != null) {
			builder.append("estadoTareaLk=");
			builder.append(estadoTareaLk);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
