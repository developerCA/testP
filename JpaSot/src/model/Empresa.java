package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Integer idEmpresa;

	private String color;

	@Column(name="direccion_empresa")
	private String direccionEmpresa;

	@Column(name="estado_empresa")
	private Boolean estadoEmpresa;

	@Column(name="nombre_empresa")
	private String nombreEmpresa;

	@Column(name="ruc_empresa")
	private String rucEmpresa;

	@Column(name="telefono_empresa")
	private String telefonoEmpresa;

	//bi-directional many-to-one association to SecuenciaOrden
	@OneToMany(mappedBy="empresa")
	private List<SecuenciaOrden> secuenciaOrdens;

	public Empresa() {
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDireccionEmpresa() {
		return this.direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public Boolean getEstadoEmpresa() {
		return this.estadoEmpresa;
	}

	public void setEstadoEmpresa(Boolean estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public String getNombreEmpresa() {
		return this.nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getRucEmpresa() {
		return this.rucEmpresa;
	}

	public void setRucEmpresa(String rucEmpresa) {
		this.rucEmpresa = rucEmpresa;
	}

	public String getTelefonoEmpresa() {
		return this.telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public List<SecuenciaOrden> getSecuenciaOrdens() {
		return this.secuenciaOrdens;
	}

	public void setSecuenciaOrdens(List<SecuenciaOrden> secuenciaOrdens) {
		this.secuenciaOrdens = secuenciaOrdens;
	}

	public SecuenciaOrden addSecuenciaOrden(SecuenciaOrden secuenciaOrden) {
		getSecuenciaOrdens().add(secuenciaOrden);
		secuenciaOrden.setEmpresa(this);

		return secuenciaOrden;
	}

	public SecuenciaOrden removeSecuenciaOrden(SecuenciaOrden secuenciaOrden) {
		getSecuenciaOrdens().remove(secuenciaOrden);
		secuenciaOrden.setEmpresa(null);

		return secuenciaOrden;
	}

}