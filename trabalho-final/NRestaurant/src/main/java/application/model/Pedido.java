package application.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import application.model.Item;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private List<Item> itens;
	private float valorTotalPedido;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public float getValorTotalPedido() {
		return valorTotalPedido;
	}
	public void setValorTotalPedido(float valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	
	
}
