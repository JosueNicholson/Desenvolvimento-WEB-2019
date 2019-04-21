package dao;

import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDao {
	private static PessoaDao pessoaDao;
	public static PessoaDao getInstance() {
		if(pessoaDao==null) {
			pessoaDao = new PessoaDao();
		}
		return pessoaDao;
	}
	
	private List<Pessoa> pessoas;
	
	private PessoaDao() {
		this.pessoas = new ArrayList<Pessoa>();
	}
	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	@Override
	public String toString() {
		String retorno = "";
		for (Pessoa pessoa : pessoas) {
			retorno = retorno + pessoa.toString() + "<br>";
		}
		return retorno;
	}
}
