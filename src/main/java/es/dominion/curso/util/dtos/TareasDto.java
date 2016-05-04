package es.dominion.curso.util.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
public class TareasDto implements Serializable {
    
    private Byte codigoTarea;
    private String descripcionTarea;
	private String descripcionTareaLk;
	private String vinculo;
	private String vinculoLk;
    
    
	public TareasDto() {
	}


	/**
	 * @return the codigoTarea
	 */
	public Byte getCodigoTarea() {
		return codigoTarea;
	}


	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(Byte codigoTarea) {
		this.codigoTarea = codigoTarea;
	}


	/**
	 * @return the descripcionTarea
	 */
	public String getDescripcionTarea() {
		return descripcionTarea;
	}


	/**
	 * @param descripcionTarea the descripcionTarea to set
	 */
	public void setDescripcionTarea(String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;
	}


	/**
	 * @return the descripcionTareaLk
	 */
	public String getDescripcionTareaLk() {
		return descripcionTareaLk;
	}


	/**
	 * @param descripcionTareaLk the descripcionTareaLk to set
	 */
	public void setDescripcionTareaLk(String descripcionTareaLk) {
		this.descripcionTareaLk = descripcionTareaLk;
	}


	/**
	 * @return the vinculo
	 */
	public String getVinculo() {
		return vinculo;
	}


	/**
	 * @param vinculo the vinculo to set
	 */
	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}


	/**
	 * @return the vinculoLk
	 */
	public String getVinculoLk() {
		return vinculoLk;
	}


	/**
	 * @param vinculoLk the vinculoLk to set
	 */
	public void setVinculoLk(String vinculoLk) {
		this.vinculoLk = vinculoLk;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoTarea == null) ? 0 : codigoTarea.hashCode());
		result = prime * result + ((descripcionTarea == null) ? 0 : descripcionTarea.hashCode());
		result = prime * result + ((descripcionTareaLk == null) ? 0 : descripcionTareaLk.hashCode());
		result = prime * result + ((vinculo == null) ? 0 : vinculo.hashCode());
		result = prime * result + ((vinculoLk == null) ? 0 : vinculoLk.hashCode());
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
		if (!(obj instanceof TareasDto)) {
			return false;
		}
		TareasDto other = (TareasDto) obj;
		if (codigoTarea == null) {
			if (other.codigoTarea != null) {
				return false;
			}
		} else if (!codigoTarea.equals(other.codigoTarea)) {
			return false;
		}
		if (descripcionTarea == null) {
			if (other.descripcionTarea != null) {
				return false;
			}
		} else if (!descripcionTarea.equals(other.descripcionTarea)) {
			return false;
		}
		if (descripcionTareaLk == null) {
			if (other.descripcionTareaLk != null) {
				return false;
			}
		} else if (!descripcionTareaLk.equals(other.descripcionTareaLk)) {
			return false;
		}
		if (vinculo == null) {
			if (other.vinculo != null) {
				return false;
			}
		} else if (!vinculo.equals(other.vinculo)) {
			return false;
		}
		if (vinculoLk == null) {
			if (other.vinculoLk != null) {
				return false;
			}
		} else if (!vinculoLk.equals(other.vinculoLk)) {
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
		builder.append("TareasDto [");
		if (codigoTarea != null) {
			builder.append("codigoTarea=");
			builder.append(codigoTarea);
			builder.append(", ");
		}
		if (descripcionTarea != null) {
			builder.append("descripcionTarea=");
			builder.append(descripcionTarea);
			builder.append(", ");
		}
		if (descripcionTareaLk != null) {
			builder.append("descripcionTareaLk=");
			builder.append(descripcionTareaLk);
			builder.append(", ");
		}
		if (vinculo != null) {
			builder.append("vinculo=");
			builder.append(vinculo);
			builder.append(", ");
		}
		if (vinculoLk != null) {
			builder.append("vinculoLk=");
			builder.append(vinculoLk);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
