package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import application.model.Prato;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Prato prato;
	private float quantidade;
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
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	public float getValorTotalItem() {
		return valorTotalItem;
	}
	public void setValorTotalItem(float valorTotalItem) {
		this.valorTotalItem = valorTotalItem;
	}
	
	
}
