package business;

import java.util.ArrayList;
import java.util.List;

public class Aluno implements Autenticavel {

	private String nome;
	private int identificador;
	private Autenticador autenticacao;
	private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>() ;; 
	

	public Aluno(int identificador, String nome) {
		this.identificador = identificador;
		this.nome = nome;
		this.autenticacao = new Autenticador();
	}
	
	public int getIdentificador() {
		return identificador;
	}
	public String getNome() {
		return nome;
	}
	
	
	//a lista é só das disciplinas que ele está matriculado, tem que dar um jeito de relacionar com matrícula
	public void add(Disciplina d) {
		listaDisciplinas.add(d);
	}
	
	public void remove(Disciplina d) {
		listaDisciplinas.remove(d);
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
