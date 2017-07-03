package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarea_detalle_nota_pedido database table.
 * 
 */
@Entity
@Table(name="tarea_detalle_nota_pedido")
@NamedQuery(name="TareaDetalleNotaPedido.findAll", query="SELECT t FROM TareaDetalleNotaPedido t")
public class TareaDetalleNotaPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;

	@Column(name="archivo_real")
	private String archivoReal;

	@Column(name="archivo_tarea")
	private String archivoTarea;

	@Column(name="codigo_detalle_nota_pedido")
	private Integer codigoDetalleNotaPedido;

	@Column(name="codigo_reporte")
	private Integer codigoReporte;

	@Column(name="codigo_tarea")
	private Integer codigoTarea;

	private double costo;

	private double total;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="codigo_asistente")
	private Vendedor vendedor1;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="codigo_responsable")
	private Vendedor vendedor2;

	public TareaDetalleNotaPedido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArchivoReal() {
		return this.archivoReal;
	}

	public void setArchivoReal(String archivoReal) {
		this.archivoReal = archivoReal;
	}

	public String getArchivoTarea() {
		return this.archivoTarea;
	}

	public void setArchivoTarea(String archivoTarea) {
		this.archivoTarea = archivoTarea;
	}

	public Integer getCodigoDetalleNotaPedido() {
		return this.codigoDetalleNotaPedido;
	}

	public void setCodigoDetalleNotaPedido(Integer codigoDetalleNotaPedido) {
		this.codigoDetalleNotaPedido = codigoDetalleNotaPedido;
	}

	public Integer getCodigoReporte() {
		return this.codigoReporte;
	}

	public void setCodigoReporte(Integer codigoReporte) {
		this.codigoReporte = codigoReporte;
	}

	public Integer getCodigoTarea() {
		return this.codigoTarea;
	}

	public void setCodigoTarea(Integer codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Vendedor getVendedor1() {
		return this.vendedor1;
	}

	public void setVendedor1(Vendedor vendedor1) {
		this.vendedor1 = vendedor1;
	}

	public Vendedor getVendedor2() {
		return this.vendedor2;
	}

	public void setVendedor2(Vendedor vendedor2) {
		this.vendedor2 = vendedor2;
	}

}