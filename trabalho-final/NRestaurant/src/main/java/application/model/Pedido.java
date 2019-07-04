package application.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> itens = new ArrayList<>();
	private float valorTotalPedido;
	
	@ManyToOne
	private Cliente cliente;
	
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
			System.out.println(" item: " + item.getId() + " valor: " + item.getValorTotalItem());
			somatorio += item.getValorTotalItem();
		}
		System.out.println(" total: "+somatorio);
		this.valorTotalPedido = somatorio;
		return this.valorTotalPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setValorTotalPedido(float valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	
	
}
