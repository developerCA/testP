package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@NamedQuery(name="Vendedor.findAll", query="SELECT v FROM Vendedor v")
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private String apellidos;

	private String cargo;

	private String cedula;

	private String celular;

	private String email;

	private Long estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombres;

	private String telefono;

	//bi-directional many-to-one association to TareaDetalleNotaPedido
	@OneToMany(mappedBy="vendedor1")
	private List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos1;

	//bi-directional many-to-one association to TareaDetalleNotaPedido
	@OneToMany(mappedBy="vendedor2")
	private List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos2;

	public Vendedor() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEstado() {
		return this.estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TareaDetalleNotaPedido> getTareaDetalleNotaPedidos1() {
		return this.tareaDetalleNotaPedidos1;
	}

	public void setTareaDetalleNotaPedidos1(List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos1) {
		this.tareaDetalleNotaPedidos1 = tareaDetalleNotaPedidos1;
	}

	public TareaDetalleNotaPedido addTareaDetalleNotaPedidos1(TareaDetalleNotaPedido tareaDetalleNotaPedidos1) {
		getTareaDetalleNotaPedidos1().add(tareaDetalleNotaPedidos1);
		tareaDetalleNotaPedidos1.setVendedor1(this);

		return tareaDetalleNotaPedidos1;
	}

	public TareaDetalleNotaPedido removeTareaDetalleNotaPedidos1(TareaDetalleNotaPedido tareaDetalleNotaPedidos1) {
		getTareaDetalleNotaPedidos1().remove(tareaDetalleNotaPedidos1);
		tareaDetalleNotaPedidos1.setVendedor1(null);

		return tareaDetalleNotaPedidos1;
	}

	public List<TareaDetalleNotaPedido> getTareaDetalleNotaPedidos2() {
		return this.tareaDetalleNotaPedidos2;
	}

	public void setTareaDetalleNotaPedidos2(List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos2) {
		this.tareaDetalleNotaPedidos2 = tareaDetalleNotaPedidos2;
	}

	public TareaDetalleNotaPedido addTareaDetalleNotaPedidos2(TareaDetalleNotaPedido tareaDetalleNotaPedidos2) {
		getTareaDetalleNotaPedidos2().add(tareaDetalleNotaPedidos2);
		tareaDetalleNotaPedidos2.setVendedor2(this);

		return tareaDetalleNotaPedidos2;
	}

	public TareaDetalleNotaPedido removeTareaDetalleNotaPedidos2(TareaDetalleNotaPedido tareaDetalleNotaPedidos2) {
		getTareaDetalleNotaPedidos2().remove(tareaDetalleNotaPedidos2);
		tareaDetalleNotaPedidos2.setVendedor2(null);

		return tareaDetalleNotaPedidos2;
	}

}