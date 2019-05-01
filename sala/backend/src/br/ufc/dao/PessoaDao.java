package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufc.model.Pessoa;

public class PessoaDao {
	private List<Pessoa> pessoas;
	
	public PessoaDao() {
		pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("cassio", "trinta"));
		pessoas.add(new Pessoa("ralf", "pitbull"));
	}
	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	public Pessoa buscarPessoa(String username, String password) {
		Pessoa pessoa = new Pessoa(username, password);
		if(pessoas.contains(pessoa)) {
			return pessoa;
		}
		return null;
	}
}
