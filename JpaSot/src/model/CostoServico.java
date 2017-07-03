package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the costo_servico database table.
 * 
 */
@Entity
@Table(name="costo_servico")
@NamedQuery(name="CostoServico.findAll", query="SELECT c FROM CostoServico c")
public class CostoServico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;

	private BigDecimal costo;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="estado")
	private Catalogo catalogo;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="codigo_categoria")
	private Categoria categoria;

	//bi-directional many-to-one association to Tarea
	@ManyToOne
	@JoinColumn(name="codigo_tarea")
	private Tarea tarea;

	public CostoServico() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

}