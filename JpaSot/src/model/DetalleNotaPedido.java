package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detalle_nota_pedido database table.
 * 
 */
@Entity
@Table(name="detalle_nota_pedido")
@NamedQuery(name="DetalleNotaPedido.findAll", query="SELECT d FROM DetalleNotaPedido d")
public class DetalleNotaPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private Integer cantidad;

	@Column(name="cantidad_real")
	private Integer cantidadReal;

	@Column(name="codigo_nota_pedido")
	private Long codigoNotaPedido;

	@Column(name="costo_unitario")
	private double costoUnitario;

	private double descuento;

	@Column(name="id_catalogo")
	private Long idCatalogo;

	@Column(name="numero_accesos")
	private Integer numeroAccesos;

	@Column(name="numero_meses")
	private Integer numeroMeses;

	private double subtotal;

	private double total;

	@Column(name="valor_descuento")
	private double valorDescuento;

	@Column(name="valor_impuesto")
	private double valorImpuesto;

	@Column(name="valor_impuesto_0")
	private double valorImpuesto0;

	@Column(name="valor_real")
	private double valorReal;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	private Producto producto;

	//bi-directional many-to-one association to TareaDetalleNotaPedido
	@OneToMany(mappedBy="detalleNotaPedido")
	private List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos;

	public DetalleNotaPedido() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getCantidadReal() {
		return this.cantidadReal;
	}

	public void setCantidadReal(Integer cantidadReal) {
		this.cantidadReal = cantidadReal;
	}

	public Long getCodigoNotaPedido() {
		return this.codigoNotaPedido;
	}

	public void setCodigoNotaPedido(Long codigoNotaPedido) {
		this.codigoNotaPedido = codigoNotaPedido;
	}

	public double getCostoUnitario() {
		return this.costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Long getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(Long idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public Integer getNumeroAccesos() {
		return this.numeroAccesos;
	}

	public void setNumeroAccesos(Integer numeroAccesos) {
		this.numeroAccesos = numeroAccesos;
	}

	public Integer getNumeroMeses() {
		return this.numeroMeses;
	}

	public void setNumeroMeses(Integer numeroMeses) {
		this.numeroMeses = numeroMeses;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getValorDescuento() {
		return this.valorDescuento;
	}

	public void setValorDescuento(double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public double getValorImpuesto() {
		return this.valorImpuesto;
	}

	public void setValorImpuesto(double valorImpuesto) {
		this.valorImpuesto = valorImpuesto;
	}

	public double getValorImpuesto0() {
		return this.valorImpuesto0;
	}

	public void setValorImpuesto0(double valorImpuesto0) {
		this.valorImpuesto0 = valorImpuesto0;
	}

	public double getValorReal() {
		return this.valorReal;
	}

	public void setValorReal(double valorReal) {
		this.valorReal = valorReal;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<TareaDetalleNotaPedido> getTareaDetalleNotaPedidos() {
		return this.tareaDetalleNotaPedidos;
	}

	public void setTareaDetalleNotaPedidos(List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos) {
		this.tareaDetalleNotaPedidos = tareaDetalleNotaPedidos;
	}

	public TareaDetalleNotaPedido addTareaDetalleNotaPedido(TareaDetalleNotaPedido tareaDetalleNotaPedido) {
		getTareaDetalleNotaPedidos().add(tareaDetalleNotaPedido);
		tareaDetalleNotaPedido.setDetalleNotaPedido(this);

		return tareaDetalleNotaPedido;
	}

	public TareaDetalleNotaPedido removeTareaDetalleNotaPedido(TareaDetalleNotaPedido tareaDetalleNotaPedido) {
		getTareaDetalleNotaPedidos().remove(tareaDetalleNotaPedido);
		tareaDetalleNotaPedido.setDetalleNotaPedido(null);

		return tareaDetalleNotaPedido;
	}

}