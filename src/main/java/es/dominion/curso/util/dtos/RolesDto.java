package es.dominion.curso.util.dtos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RolesDto implements Serializable {
    
    private Byte codigoRol;
    private String descripcionRol;
	private String descripcionRolLk;
    
    
	public RolesDto() {
	}


	/**
	 * @return the codigoRol
	 */
	public Byte getCodigoRol() {
		return codigoRol;
	}


	/**
	 * @param codigoRol the codigoRol to set
	 */
	public void setCodigoRol(Byte codigoRol) {
		this.codigoRol = codigoRol;
	}


	/**
	 * @return the descripcionRol
	 */
	public String getDescripcionRol() {
		return descripcionRol;
	}


	/**
	 * @param descripcionRol the descripcionRol to set
	 */
	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}


	/**
	 * @return the descripcionRolLk
	 */
	public String getDescripcionRolLk() {
		return descripcionRolLk;
	}


	/**
	 * @param descripcionRolLk the descripcionRolLk to set
	 */
	public void setDescripcionRolLk(String descripcionRolLk) {
		this.descripcionRolLk = descripcionRolLk;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoRol == null) ? 0 : codigoRol.hashCode());
		result = prime * result + ((descripcionRol == null) ? 0 : descripcionRol.hashCode());
		result = prime * result + ((descripcionRolLk == null) ? 0 : descripcionRolLk.hashCode());
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
		if (!(obj instanceof RolesDto)) {
			return false;
		}
		RolesDto other = (RolesDto) obj;
		if (codigoRol == null) {
			if (other.codigoRol != null) {
				return false;
			}
		} else if (!codigoRol.equals(other.codigoRol)) {
			return false;
		}
		if (descripcionRol == null) {
			if (other.descripcionRol != null) {
				return false;
			}
		} else if (!descripcionRol.equals(other.descripcionRol)) {
			return false;
		}
		if (descripcionRolLk == null) {
			if (other.descripcionRolLk != null) {
				return false;
			}
		} else if (!descripcionRolLk.equals(other.descripcionRolLk)) {
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
		builder.append("RolesDto [");
		if (codigoRol != null) {
			builder.append("codigoRol=");
			builder.append(codigoRol);
			builder.append(", ");
		}
		if (descripcionRol != null) {
			builder.append("descripcionRol=");
			builder.append(descripcionRol);
			builder.append(", ");
		}
		if (descripcionRolLk != null) {
			builder.append("descripcionRolLk=");
			builder.append(descripcionRolLk);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
