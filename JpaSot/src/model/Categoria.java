package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name="codigo_empresa")
	private Integer codigoEmpresa;

	@Column(name="codigo_subcategoria")
	private Integer codigoSubcategoria;

	private Boolean estado;

	private String nombre;

	//bi-directional many-to-one association to CostoServico
	@OneToMany(mappedBy="categoria")
	private List<CostoServico> costoServicos;

	public Categoria() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoEmpresa() {
		return this.codigoEmpresa;
	}

	public void setCodigoEmpresa(Integer codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public Integer getCodigoSubcategoria() {
		return this.codigoSubcategoria;
	}

	public void setCodigoSubcategoria(Integer codigoSubcategoria) {
		this.codigoSubcategoria = codigoSubcategoria;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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
		costoServico.setCategoria(this);

		return costoServico;
	}

	public CostoServico removeCostoServico(CostoServico costoServico) {
		getCostoServicos().remove(costoServico);
		costoServico.setCategoria(null);

		return costoServico;
	}

}