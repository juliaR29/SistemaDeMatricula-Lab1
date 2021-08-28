package business;

import java.util.ArrayList;
import java.util.List;

public class SecretariaUniversidade implements Autenticavel {
	
	private List<Aluno> listaAlunos = new ArrayList<Aluno>(); 
	private List<Professor> listaProfessores = new ArrayList<Professor>();
	private List<Curso> listaCursos = new ArrayList<Curso>();
	private Autenticador autenticacao;
	
	public SecretariaUniversidade() {
		this.autenticacao = new Autenticador();
	}
	
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}

	public List<Curso> getListaCursos() {
		return listaCursos;
	}
	
	public void add(Aluno a) {
		listaAlunos.add(a);
	}
	
	public void remove(Aluno a) {
		listaAlunos.remove(a);
	}
	
	public void add(Professor p) {
		listaProfessores.add(p);
	}
	
	public void remove(Professor p) {
		listaProfessores.remove(p);
	}
	
	public void add(Curso c) {
		listaCursos.add(c);
	}
	
	public void remove(Curso c) {
		listaCursos.remove(c);
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
