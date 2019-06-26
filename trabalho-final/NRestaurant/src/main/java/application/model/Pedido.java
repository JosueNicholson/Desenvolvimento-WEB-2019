package application.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens;
	private float valorTotalPedido;
	
	private String endereco;
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
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
		float somatorio = 0;
		for (Item item : itens) {
			somatorio += item.getValorTotalItem();
		}
		this.valorTotalPedido = somatorio;
		return this.valorTotalPedido;
	}
	public void setValorTotalPedido(float valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	
	
}
