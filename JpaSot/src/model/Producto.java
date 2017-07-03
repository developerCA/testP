package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private Boolean actualizable;

	@Column(name="aplica_accesos")
	private Boolean aplicaAccesos;

	@Column(name="aplica_impuesto")
	private Boolean aplicaImpuesto;

	@Column(name="aplica_suscripcion")
	private Boolean aplicaSuscripcion;

	@Column(name="codigo_categoria")
	private Long codigoCategoria;

	@Column(name="codigo_tipo_producto")
	private Long codigoTipoProducto;

	private double costo;

	private String descripcion;

	@Column(name="estado_catalogo")
	private Long estadoCatalogo;

	@Column(name="maximo_accesos")
	private Integer maximoAccesos;

	@Column(name="meses_vigencia")
	private Integer mesesVigencia;

	@Column(name="minimo_accesos")
	private Integer minimoAccesos;

	private String nemonico;

	private String nombre;

	@Column(name="numero_actualizacion")
	private Integer numeroActualizacion;

	private Boolean renovable;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="codigo_producto_renovacion")
	private Producto producto;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="producto")
	private List<Producto> productos;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="producto")
	private List<Tarea> tareas;

	//bi-directional many-to-one association to DetalleNotaPedido
	@OneToMany(mappedBy="producto")
	private List<DetalleNotaPedido> detalleNotaPedidos;

	public Producto() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Boolean getActualizable() {
		return this.actualizable;
	}

	public void setActualizable(Boolean actualizable) {
		this.actualizable = actualizable;
	}

	public Boolean getAplicaAccesos() {
		return this.aplicaAccesos;
	}

	public void setAplicaAccesos(Boolean aplicaAccesos) {
		this.aplicaAccesos = aplicaAccesos;
	}

	public Boolean getAplicaImpuesto() {
		return this.aplicaImpuesto;
	}

	public void setAplicaImpuesto(Boolean aplicaImpuesto) {
		this.aplicaImpuesto = aplicaImpuesto;
	}

	public Boolean getAplicaSuscripcion() {
		return this.aplicaSuscripcion;
	}

	public void setAplicaSuscripcion(Boolean aplicaSuscripcion) {
		this.aplicaSuscripcion = aplicaSuscripcion;
	}

	public Long getCodigoCategoria() {
		return this.codigoCategoria;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Long getCodigoTipoProducto() {
		return this.codigoTipoProducto;
	}

	public void setCodigoTipoProducto(Long codigoTipoProducto) {
		this.codigoTipoProducto = codigoTipoProducto;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getEstadoCatalogo() {
		return this.estadoCatalogo;
	}

	public void setEstadoCatalogo(Long estadoCatalogo) {
		this.estadoCatalogo = estadoCatalogo;
	}

	public Integer getMaximoAccesos() {
		return this.maximoAccesos;
	}

	public void setMaximoAccesos(Integer maximoAccesos) {
		this.maximoAccesos = maximoAccesos;
	}

	public Integer getMesesVigencia() {
		return this.mesesVigencia;
	}

	public void setMesesVigencia(Integer mesesVigencia) {
		this.mesesVigencia = mesesVigencia;
	}

	public Integer getMinimoAccesos() {
		return this.minimoAccesos;
	}

	public void setMinimoAccesos(Integer minimoAccesos) {
		this.minimoAccesos = minimoAccesos;
	}

	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroActualizacion() {
		return this.numeroActualizacion;
	}

	public void setNumeroActualizacion(Integer numeroActualizacion) {
		this.numeroActualizacion = numeroActualizacion;
	}

	public Boolean getRenovable() {
		return this.renovable;
	}

	public void setRenovable(Boolean renovable) {
		this.renovable = renovable;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setProducto(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setProducto(null);

		return producto;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea addTarea(Tarea tarea) {
		getTareas().add(tarea);
		tarea.setProducto(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setProducto(null);

		return tarea;
	}

	public List<DetalleNotaPedido> getDetalleNotaPedidos() {
		return this.detalleNotaPedidos;
	}

	public void setDetalleNotaPedidos(List<DetalleNotaPedido> detalleNotaPedidos) {
		this.detalleNotaPedidos = detalleNotaPedidos;
	}

	public DetalleNotaPedido addDetalleNotaPedido(DetalleNotaPedido detalleNotaPedido) {
		getDetalleNotaPedidos().add(detalleNotaPedido);
		detalleNotaPedido.setProducto(this);

		return detalleNotaPedido;
	}

	public DetalleNotaPedido removeDetalleNotaPedido(DetalleNotaPedido detalleNotaPedido) {
		getDetalleNotaPedidos().remove(detalleNotaPedido);
		detalleNotaPedido.setProducto(null);

		return detalleNotaPedido;
	}

}