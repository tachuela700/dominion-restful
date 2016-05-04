package es.dominion.curso.util.dtos;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class UsuariosDto implements Serializable {
    
    private String nombreUsuario;
	private String nombreUsuarioLk;
	private RolesDto rolesDto;
	private String password;
	private String passwordLk;
	private Date fechaAlta;
    private Date fechaAltaFrom;
    private Date fechaAltaTo;
    private Date fechaBaja;
    private Date fechaBajaFrom;
    private Date fechaBajaTo;
	private String carpetaDocumentacion;
	private String carpetaDocumentacionLk;
	private String idioma;
	private String idiomaLk;
    
    
	public UsuariosDto() {
	}


	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	/**
	 * @return the nombreUsuarioLk
	 */
	public String getNombreUsuarioLk() {
		return nombreUsuarioLk;
	}


	/**
	 * @param nombreUsuarioLk the nombreUsuarioLk to set
	 */
	public void setNombreUsuarioLk(String nombreUsuarioLk) {
		this.nombreUsuarioLk = nombreUsuarioLk;
	}


	/**
	 * @return the rolesDto
	 */
	public RolesDto getRolesDto() {
		return rolesDto;
	}


	/**
	 * @param rolesDto the rolesDto to set
	 */
	public void setRolesDto(RolesDto rolesDto) {
		this.rolesDto = rolesDto;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the passwordLk
	 */
	public String getPasswordLk() {
		return passwordLk;
	}


	/**
	 * @param passwordLk the passwordLk to set
	 */
	public void setPasswordLk(String passwordLk) {
		this.passwordLk = passwordLk;
	}


	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}


	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}


	/**
	 * @return the fechaAltaFrom
	 */
	public Date getFechaAltaFrom() {
		return fechaAltaFrom;
	}


	/**
	 * @param fechaAltaFrom the fechaAltaFrom to set
	 */
	public void setFechaAltaFrom(Date fechaAltaFrom) {
		this.fechaAltaFrom = fechaAltaFrom;
	}


	/**
	 * @return the fechaAltaTo
	 */
	public Date getFechaAltaTo() {
		return fechaAltaTo;
	}


	/**
	 * @param fechaAltaTo the fechaAltaTo to set
	 */
	public void setFechaAltaTo(Date fechaAltaTo) {
		this.fechaAltaTo = fechaAltaTo;
	}


	/**
	 * @return the fechaBaja
	 */
	public Date getFechaBaja() {
		return fechaBaja;
	}


	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}


	/**
	 * @return the fechaBajaFrom
	 */
	public Date getFechaBajaFrom() {
		return fechaBajaFrom;
	}


	/**
	 * @param fechaBajaFrom the fechaBajaFrom to set
	 */
	public void setFechaBajaFrom(Date fechaBajaFrom) {
		this.fechaBajaFrom = fechaBajaFrom;
	}


	/**
	 * @return the fechaBajaTo
	 */
	public Date getFechaBajaTo() {
		return fechaBajaTo;
	}


	/**
	 * @param fechaBajaTo the fechaBajaTo to set
	 */
	public void setFechaBajaTo(Date fechaBajaTo) {
		this.fechaBajaTo = fechaBajaTo;
	}


	/**
	 * @return the carpetaDocumentacion
	 */
	public String getCarpetaDocumentacion() {
		return carpetaDocumentacion;
	}


	/**
	 * @param carpetaDocumentacion the carpetaDocumentacion to set
	 */
	public void setCarpetaDocumentacion(String carpetaDocumentacion) {
		this.carpetaDocumentacion = carpetaDocumentacion;
	}


	/**
	 * @return the carpetaDocumentacionLk
	 */
	public String getCarpetaDocumentacionLk() {
		return carpetaDocumentacionLk;
	}


	/**
	 * @param carpetaDocumentacionLk the carpetaDocumentacionLk to set
	 */
	public void setCarpetaDocumentacionLk(String carpetaDocumentacionLk) {
		this.carpetaDocumentacionLk = carpetaDocumentacionLk;
	}


	/**
	 * @return the idioma
	 */
	public String getIdioma() {
		return idioma;
	}


	/**
	 * @param idioma the idioma to set
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}


	/**
	 * @return the idiomaLk
	 */
	public String getIdiomaLk() {
		return idiomaLk;
	}


	/**
	 * @param idiomaLk the idiomaLk to set
	 */
	public void setIdiomaLk(String idiomaLk) {
		this.idiomaLk = idiomaLk;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carpetaDocumentacion == null) ? 0 : carpetaDocumentacion.hashCode());
		result = prime * result + ((carpetaDocumentacionLk == null) ? 0 : carpetaDocumentacionLk.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaAltaFrom == null) ? 0 : fechaAltaFrom.hashCode());
		result = prime * result + ((fechaAltaTo == null) ? 0 : fechaAltaTo.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((fechaBajaFrom == null) ? 0 : fechaBajaFrom.hashCode());
		result = prime * result + ((fechaBajaTo == null) ? 0 : fechaBajaTo.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((idiomaLk == null) ? 0 : idiomaLk.hashCode());
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
		result = prime * result + ((nombreUsuarioLk == null) ? 0 : nombreUsuarioLk.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((passwordLk == null) ? 0 : passwordLk.hashCode());
		result = prime * result + ((rolesDto == null) ? 0 : rolesDto.hashCode());
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
		if (!(obj instanceof UsuariosDto)) {
			return false;
		}
		UsuariosDto other = (UsuariosDto) obj;
		if (carpetaDocumentacion == null) {
			if (other.carpetaDocumentacion != null) {
				return false;
			}
		} else if (!carpetaDocumentacion.equals(other.carpetaDocumentacion)) {
			return false;
		}
		if (carpetaDocumentacionLk == null) {
			if (other.carpetaDocumentacionLk != null) {
				return false;
			}
		} else if (!carpetaDocumentacionLk.equals(other.carpetaDocumentacionLk)) {
			return false;
		}
		if (fechaAlta == null) {
			if (other.fechaAlta != null) {
				return false;
			}
		} else if (!fechaAlta.equals(other.fechaAlta)) {
			return false;
		}
		if (fechaAltaFrom == null) {
			if (other.fechaAltaFrom != null) {
				return false;
			}
		} else if (!fechaAltaFrom.equals(other.fechaAltaFrom)) {
			return false;
		}
		if (fechaAltaTo == null) {
			if (other.fechaAltaTo != null) {
				return false;
			}
		} else if (!fechaAltaTo.equals(other.fechaAltaTo)) {
			return false;
		}
		if (fechaBaja == null) {
			if (other.fechaBaja != null) {
				return false;
			}
		} else if (!fechaBaja.equals(other.fechaBaja)) {
			return false;
		}
		if (fechaBajaFrom == null) {
			if (other.fechaBajaFrom != null) {
				return false;
			}
		} else if (!fechaBajaFrom.equals(other.fechaBajaFrom)) {
			return false;
		}
		if (fechaBajaTo == null) {
			if (other.fechaBajaTo != null) {
				return false;
			}
		} else if (!fechaBajaTo.equals(other.fechaBajaTo)) {
			return false;
		}
		if (idioma == null) {
			if (other.idioma != null) {
				return false;
			}
		} else if (!idioma.equals(other.idioma)) {
			return false;
		}
		if (idiomaLk == null) {
			if (other.idiomaLk != null) {
				return false;
			}
		} else if (!idiomaLk.equals(other.idiomaLk)) {
			return false;
		}
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null) {
				return false;
			}
		} else if (!nombreUsuario.equals(other.nombreUsuario)) {
			return false;
		}
		if (nombreUsuarioLk == null) {
			if (other.nombreUsuarioLk != null) {
				return false;
			}
		} else if (!nombreUsuarioLk.equals(other.nombreUsuarioLk)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (passwordLk == null) {
			if (other.passwordLk != null) {
				return false;
			}
		} else if (!passwordLk.equals(other.passwordLk)) {
			return false;
		}
		if (rolesDto == null) {
			if (other.rolesDto != null) {
				return false;
			}
		} else if (!rolesDto.equals(other.rolesDto)) {
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
		builder.append("UsuariosDto [");
		if (nombreUsuario != null) {
			builder.append("nombreUsuario=");
			builder.append(nombreUsuario);
			builder.append(", ");
		}
		if (nombreUsuarioLk != null) {
			builder.append("nombreUsuarioLk=");
			builder.append(nombreUsuarioLk);
			builder.append(", ");
		}
		if (rolesDto != null) {
			builder.append("rolesDto=");
			builder.append(rolesDto);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (passwordLk != null) {
			builder.append("passwordLk=");
			builder.append(passwordLk);
			builder.append(", ");
		}
		if (fechaAlta != null) {
			builder.append("fechaAlta=");
			builder.append(fechaAlta);
			builder.append(", ");
		}
		if (fechaAltaFrom != null) {
			builder.append("fechaAltaFrom=");
			builder.append(fechaAltaFrom);
			builder.append(", ");
		}
		if (fechaAltaTo != null) {
			builder.append("fechaAltaTo=");
			builder.append(fechaAltaTo);
			builder.append(", ");
		}
		if (fechaBaja != null) {
			builder.append("fechaBaja=");
			builder.append(fechaBaja);
			builder.append(", ");
		}
		if (fechaBajaFrom != null) {
			builder.append("fechaBajaFrom=");
			builder.append(fechaBajaFrom);
			builder.append(", ");
		}
		if (fechaBajaTo != null) {
			builder.append("fechaBajaTo=");
			builder.append(fechaBajaTo);
			builder.append(", ");
		}
		if (carpetaDocumentacion != null) {
			builder.append("carpetaDocumentacion=");
			builder.append(carpetaDocumentacion);
			builder.append(", ");
		}
		if (carpetaDocumentacionLk != null) {
			builder.append("carpetaDocumentacionLk=");
			builder.append(carpetaDocumentacionLk);
			builder.append(", ");
		}
		if (idioma != null) {
			builder.append("idioma=");
			builder.append(idioma);
			builder.append(", ");
		}
		if (idiomaLk != null) {
			builder.append("idiomaLk=");
			builder.append(idiomaLk);
		}
		builder.append("]");
		return builder.toString();
	}

	
}
