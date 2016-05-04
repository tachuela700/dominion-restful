package es.dominion.curso.util.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
public class PaisDto implements Serializable {
    
    private Long codigoPais;
    private Integer paisIsonum;
    private Integer paisIsonumFrom;
    private Integer paisIsonumTo;
	private String paisIso2;
	private String paisIso2Lk;
	private String paisIso3;
	private String paisIso3Lk;
	private String paisNombre;
	private String paisNombreLk;
	
    
	public PaisDto() {
	}


	/**
	 * @return the codigoPais
	 */
	public Long getCodigoPais() {
		return codigoPais;
	}


	/**
	 * @param codigoPais the codigoPais to set
	 */
	public void setCodigoPais(Long codigoPais) {
		this.codigoPais = codigoPais;
	}


	/**
	 * @return the paisIsonum
	 */
	public Integer getPaisIsonum() {
		return paisIsonum;
	}


	/**
	 * @param paisIsonum the paisIsonum to set
	 */
	public void setPaisIsonum(Integer paisIsonum) {
		this.paisIsonum = paisIsonum;
	}


	/**
	 * @return the paisIsonumFrom
	 */
	public Integer getPaisIsonumFrom() {
		return paisIsonumFrom;
	}


	/**
	 * @param paisIsonumFrom the paisIsonumFrom to set
	 */
	public void setPaisIsonumFrom(Integer paisIsonumFrom) {
		this.paisIsonumFrom = paisIsonumFrom;
	}


	/**
	 * @return the paisIsonumTo
	 */
	public Integer getPaisIsonumTo() {
		return paisIsonumTo;
	}


	/**
	 * @param paisIsonumTo the paisIsonumTo to set
	 */
	public void setPaisIsonumTo(Integer paisIsonumTo) {
		this.paisIsonumTo = paisIsonumTo;
	}


	/**
	 * @return the paisIso2
	 */
	public String getPaisIso2() {
		return paisIso2;
	}


	/**
	 * @param paisIso2 the paisIso2 to set
	 */
	public void setPaisIso2(String paisIso2) {
		this.paisIso2 = paisIso2;
	}


	/**
	 * @return the paisIso2Lk
	 */
	public String getPaisIso2Lk() {
		return paisIso2Lk;
	}


	/**
	 * @param paisIso2Lk the paisIso2Lk to set
	 */
	public void setPaisIso2Lk(String paisIso2Lk) {
		this.paisIso2Lk = paisIso2Lk;
	}


	/**
	 * @return the paisIso3
	 */
	public String getPaisIso3() {
		return paisIso3;
	}


	/**
	 * @param paisIso3 the paisIso3 to set
	 */
	public void setPaisIso3(String paisIso3) {
		this.paisIso3 = paisIso3;
	}


	/**
	 * @return the paisIso3Lk
	 */
	public String getPaisIso3Lk() {
		return paisIso3Lk;
	}


	/**
	 * @param paisIso3Lk the paisIso3Lk to set
	 */
	public void setPaisIso3Lk(String paisIso3Lk) {
		this.paisIso3Lk = paisIso3Lk;
	}


	/**
	 * @return the paisNombre
	 */
	public String getPaisNombre() {
		return paisNombre;
	}


	/**
	 * @param paisNombre the paisNombre to set
	 */
	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}


	/**
	 * @return the paisNombreLk
	 */
	public String getPaisNombreLk() {
		return paisNombreLk;
	}


	/**
	 * @param paisNombreLk the paisNombreLk to set
	 */
	public void setPaisNombreLk(String paisNombreLk) {
		this.paisNombreLk = paisNombreLk;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoPais == null) ? 0 : codigoPais.hashCode());
		result = prime * result + ((paisIso2 == null) ? 0 : paisIso2.hashCode());
		result = prime * result + ((paisIso2Lk == null) ? 0 : paisIso2Lk.hashCode());
		result = prime * result + ((paisIso3 == null) ? 0 : paisIso3.hashCode());
		result = prime * result + ((paisIso3Lk == null) ? 0 : paisIso3Lk.hashCode());
		result = prime * result + ((paisIsonum == null) ? 0 : paisIsonum.hashCode());
		result = prime * result + ((paisIsonumFrom == null) ? 0 : paisIsonumFrom.hashCode());
		result = prime * result + ((paisIsonumTo == null) ? 0 : paisIsonumTo.hashCode());
		result = prime * result + ((paisNombre == null) ? 0 : paisNombre.hashCode());
		result = prime * result + ((paisNombreLk == null) ? 0 : paisNombreLk.hashCode());
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
		if (!(obj instanceof PaisDto)) {
			return false;
		}
		PaisDto other = (PaisDto) obj;
		if (codigoPais == null) {
			if (other.codigoPais != null) {
				return false;
			}
		} else if (!codigoPais.equals(other.codigoPais)) {
			return false;
		}
		if (paisIso2 == null) {
			if (other.paisIso2 != null) {
				return false;
			}
		} else if (!paisIso2.equals(other.paisIso2)) {
			return false;
		}
		if (paisIso2Lk == null) {
			if (other.paisIso2Lk != null) {
				return false;
			}
		} else if (!paisIso2Lk.equals(other.paisIso2Lk)) {
			return false;
		}
		if (paisIso3 == null) {
			if (other.paisIso3 != null) {
				return false;
			}
		} else if (!paisIso3.equals(other.paisIso3)) {
			return false;
		}
		if (paisIso3Lk == null) {
			if (other.paisIso3Lk != null) {
				return false;
			}
		} else if (!paisIso3Lk.equals(other.paisIso3Lk)) {
			return false;
		}
		if (paisIsonum == null) {
			if (other.paisIsonum != null) {
				return false;
			}
		} else if (!paisIsonum.equals(other.paisIsonum)) {
			return false;
		}
		if (paisIsonumFrom == null) {
			if (other.paisIsonumFrom != null) {
				return false;
			}
		} else if (!paisIsonumFrom.equals(other.paisIsonumFrom)) {
			return false;
		}
		if (paisIsonumTo == null) {
			if (other.paisIsonumTo != null) {
				return false;
			}
		} else if (!paisIsonumTo.equals(other.paisIsonumTo)) {
			return false;
		}
		if (paisNombre == null) {
			if (other.paisNombre != null) {
				return false;
			}
		} else if (!paisNombre.equals(other.paisNombre)) {
			return false;
		}
		if (paisNombreLk == null) {
			if (other.paisNombreLk != null) {
				return false;
			}
		} else if (!paisNombreLk.equals(other.paisNombreLk)) {
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
		builder.append("PaisDto [");
		if (codigoPais != null) {
			builder.append("codigoPais=");
			builder.append(codigoPais);
			builder.append(", ");
		}
		if (paisIsonum != null) {
			builder.append("paisIsonum=");
			builder.append(paisIsonum);
			builder.append(", ");
		}
		if (paisIsonumFrom != null) {
			builder.append("paisIsonumFrom=");
			builder.append(paisIsonumFrom);
			builder.append(", ");
		}
		if (paisIsonumTo != null) {
			builder.append("paisIsonumTo=");
			builder.append(paisIsonumTo);
			builder.append(", ");
		}
		if (paisIso2 != null) {
			builder.append("paisIso2=");
			builder.append(paisIso2);
			builder.append(", ");
		}
		if (paisIso2Lk != null) {
			builder.append("paisIso2Lk=");
			builder.append(paisIso2Lk);
			builder.append(", ");
		}
		if (paisIso3 != null) {
			builder.append("paisIso3=");
			builder.append(paisIso3);
			builder.append(", ");
		}
		if (paisIso3Lk != null) {
			builder.append("paisIso3Lk=");
			builder.append(paisIso3Lk);
			builder.append(", ");
		}
		if (paisNombre != null) {
			builder.append("paisNombre=");
			builder.append(paisNombre);
			builder.append(", ");
		}
		if (paisNombreLk != null) {
			builder.append("paisNombreLk=");
			builder.append(paisNombreLk);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
