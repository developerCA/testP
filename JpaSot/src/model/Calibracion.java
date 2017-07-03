package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the calibracion database table.
 * 
 */
@Entity
@NamedQuery(name="Calibracion.findAll", query="SELECT c FROM Calibracion c")
public class Calibracion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;

	private String archivo;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_calibracion")
	private Date fechaCalibracion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String observacion;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="estado")
	private Catalogo catalogo;

	//bi-directional many-to-one association to Instrumento
	@ManyToOne
	@JoinColumn(name="codigo_instrumento")
	private Instrumento instrumento;

	public Calibracion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Date getFechaCalibracion() {
		return this.fechaCalibracion;
	}

	public void setFechaCalibracion(Date fechaCalibracion) {
		this.fechaCalibracion = fechaCalibracion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Instrumento getInstrumento() {
		return this.instrumento;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}

}