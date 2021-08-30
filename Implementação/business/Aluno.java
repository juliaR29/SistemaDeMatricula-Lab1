package business;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa implements Autenticavel {

	private int identificador;
	private Autenticador autenticacao;
	private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>();
	

	public Aluno(String nome, String endereco, String telefone, int identificador) {
		super(nome, endereco, telefone);
		this.identificador = identificador;
		this.autenticacao = new Autenticador();
	}
	
	public int getIdentificador() {
		return identificador;
	}
	
	
	//a lista é só das disciplinas que ele está matriculado, tem que dar um jeito de relacionar com matrícula
	public void add(Disciplina d) {
		listaDisciplinas.add(d);
	}
	
	public void remove(Disciplina d) {
		listaDisciplinas.remove(d);
	}
	
	public void imprimeDadosAluno() {
		System.out.println("  DADOS ALUNOS  ");
		super.imprimeDados();
		System.out.println("IDENTIFICADOR: " + this.getIdentificador());
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
