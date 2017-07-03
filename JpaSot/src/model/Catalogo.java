package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the catalogo database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name="codigo_grupo_catalogo")
	private Long codigoGrupoCatalogo;

	private String descripcion;

	private String icono;

	private String nombre;

	private String sigla;

	//bi-directional many-to-one association to Seguimiento
	@OneToMany(mappedBy="catalogo")
	private List<Seguimiento> seguimientos;

	public Catalogo() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Long getCodigoGrupoCatalogo() {
		return this.codigoGrupoCatalogo;
	}

	public void setCodigoGrupoCatalogo(Long codigoGrupoCatalogo) {
		this.codigoGrupoCatalogo = codigoGrupoCatalogo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Seguimiento> getSeguimientos() {
		return this.seguimientos;
	}

	public void setSeguimientos(List<Seguimiento> seguimientos) {
		this.seguimientos = seguimientos;
	}

	public Seguimiento addSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().add(seguimiento);
		seguimiento.setCatalogo(this);

		return seguimiento;
	}

	public Seguimiento removeSeguimiento(Seguimiento seguimiento) {
		getSeguimientos().remove(seguimiento);
		seguimiento.setCatalogo(null);

		return seguimiento;
	}

}