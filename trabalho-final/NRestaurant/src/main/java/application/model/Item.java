package application.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Prato prato;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Pedido pedido;

	private int quantidade;

	private float valorTotalItem;
	
	public Prato getPrato() {
		return prato;
	}
	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValorTotalItem() {
		this.valorTotalItem = this.prato.getValor() * this.quantidade;
		return valorTotalItem;
				
	}
	public void setValorTotalItem(float valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", prato=" + prato + ", pedido=" + pedido + ", quantidade=" + quantidade
				+ ", valorTotalItem=" + valorTotalItem + "]";
	}
	
}
