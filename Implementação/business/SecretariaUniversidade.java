package business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SecretariaUniversidade implements Autenticavel {

	private Autenticador autenticacao;
	private List<Pessoa> pessoas = new LinkedList<>();
	private List<Curso> listaCursos = new ArrayList<Curso>();
	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private List<Professor> listaProfessores = new ArrayList<Professor>();

	public void addPessoa(Pessoa novo) { // como já tem o add e remove pesso nao sei se precisaria dos add e remove de Aluno e Professor
		this.pessoas.add(novo);
	}
	
	public void removePessoas(Pessoa novo) {
		this.pessoas.remove(novo);
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}

//	public void add(Aluno a) {
//		listaAlunos.add(a);
//	}
//
//	public void remove(Aluno a) {
//		listaAlunos.remove(a);
//	}
//
//	public void add(Professor p) {
//		listaProfessores.add(p);
//	}
//
//	public void remove(Professor p) {
//		listaProfessores.remove(p);
//	}

	public void add(Curso c) {
		listaCursos.add(c);
	}

	public void remove(Curso c) {
		listaCursos.remove(c);
	}

	public SecretariaUniversidade() {
		this.autenticacao = new Autenticador();
	}

	@Override
	public void setSenha(int senha) {
		this.autenticacao.setSenha(senha);
	}

	@Override
	public boolean login(int senha) {
		return this.autenticacao.login(senha);
	}

}
