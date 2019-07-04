package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.model.Item;
import application.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	public void salvarItem(Item item) {
		itemRepository.save(item);
	}
	public List<Item> listarItens(Item item){
		return itemRepository.findAll();
	}
	public void deletarItem(Long id) {
		itemRepository.deleteById(id);
	}
	public Item buscarItemPorId(Long id) {
		return itemRepository.getOne(id);
	}
	public void salvarListaDeItens(List<Item> itens) {
		itemRepository.saveAll(itens);
	}
}
