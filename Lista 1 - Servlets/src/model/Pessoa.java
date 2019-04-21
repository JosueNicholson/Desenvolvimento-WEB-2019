package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
	private String nome;
	private String time;
	private List<Hobby> hobbies;
	
	public Pessoa(String nome, String time) {
		this.nome = nome;
		this.time = time;
		this.hobbies = new ArrayList<Hobby>();
	}
	public Pessoa() {
		this.hobbies = new ArrayList<Hobby>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<Hobby> getHobbies() {
		return hobbies;
	}
	public void addHobby(Hobby hobby) {
		hobbies.add(hobby);
	}
	@Override
	public String toString() {
		String retorno = "<strong>Nome:</strong> " + this.getNome() + " <strong>Time:</strong> " + this.getTime()
		+ "<br><strong>Hobbies:</strong><br> ";
		int i = 1;
		for (Hobby hobby : hobbies) {
			retorno += i +"- "+ hobby.toString() + "<br>";
			i++;
		}
		retorno += "---------------------------------------";
		return retorno;
	}
	
}
