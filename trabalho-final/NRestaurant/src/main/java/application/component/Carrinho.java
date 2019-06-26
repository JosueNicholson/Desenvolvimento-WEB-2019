package application.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import application.model.Item;

@Component
@SessionScope
public class Carrinho {
	private List<Item> itensDoCarrinho = new ArrayList<>();
	private float valorTotalCarrinho;
	
	public float getValorTotalCarrinho() {
		return valorTotalCarrinho;
	}
	public void setValorTotalCarrinho(float valorTotalCarrinho) {
		this.valorTotalCarrinho = valorTotalCarrinho;
	}
	public void addItemNoCarrinho(Item item) {
		itensDoCarrinho.add(item);
	}
	public void removerItemDoCarrinho(Item item) {
		itensDoCarrinho.remove(item);
	}

	public List<Item> getItensDoCarrinho() {
		return itensDoCarrinho;
	}

	public void setItensDoCarrinho(List<Item> itensDoCarrinho) {
		this.itensDoCarrinho = itensDoCarrinho;
	}
	
	
}
