package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the seguimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Seguimiento.findAll", query="SELECT s FROM Seguimiento s")
public class Seguimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer id;

	private Integer cantidad;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String observacion;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="estado")
	private Catalogo catalogo;

	//bi-directional many-to-one association to TareaDetalleNotaPedido
	@ManyToOne
	@JoinColumn(name="codigo_tarea_detalle_nota_pedido")
	private TareaDetalleNotaPedido tareaDetalleNotaPedido;

	//bi-directional many-to-one association to TareaDetalleNotaPedido
	@OneToMany(mappedBy="seguimiento")
	private List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos;

	public Seguimiento() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public TareaDetalleNotaPedido getTareaDetalleNotaPedido() {
		return this.tareaDetalleNotaPedido;
	}

	public void setTareaDetalleNotaPedido(TareaDetalleNotaPedido tareaDetalleNotaPedido) {
		this.tareaDetalleNotaPedido = tareaDetalleNotaPedido;
	}

	public List<TareaDetalleNotaPedido> getTareaDetalleNotaPedidos() {
		return this.tareaDetalleNotaPedidos;
	}

	public void setTareaDetalleNotaPedidos(List<TareaDetalleNotaPedido> tareaDetalleNotaPedidos) {
		this.tareaDetalleNotaPedidos = tareaDetalleNotaPedidos;
	}

	public TareaDetalleNotaPedido addTareaDetalleNotaPedido(TareaDetalleNotaPedido tareaDetalleNotaPedido) {
		getTareaDetalleNotaPedidos().add(tareaDetalleNotaPedido);
		tareaDetalleNotaPedido.setSeguimiento(this);

		return tareaDetalleNotaPedido;
	}

	public TareaDetalleNotaPedido removeTareaDetalleNotaPedido(TareaDetalleNotaPedido tareaDetalleNotaPedido) {
		getTareaDetalleNotaPedidos().remove(tareaDetalleNotaPedido);
		tareaDetalleNotaPedido.setSeguimiento(null);

		return tareaDetalleNotaPedido;
	}

}