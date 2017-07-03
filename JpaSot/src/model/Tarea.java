package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarea database table.
 * 
 */
@Entity
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to CostoServico
	@OneToMany(mappedBy="tarea")
	private List<CostoServico> costoServicos;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="estado")
	private Catalogo catalogo;

	public Tarea() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CostoServico> getCostoServicos() {
		return this.costoServicos;
	}

	public void setCostoServicos(List<CostoServico> costoServicos) {
		this.costoServicos = costoServicos;
	}

	public CostoServico addCostoServico(CostoServico costoServico) {
		getCostoServicos().add(costoServico);
		costoServico.setTarea(this);

		return costoServico;
	}

	public CostoServico removeCostoServico(CostoServico costoServico) {
		getCostoServicos().remove(costoServico);
		costoServico.setTarea(null);

		return costoServico;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

}