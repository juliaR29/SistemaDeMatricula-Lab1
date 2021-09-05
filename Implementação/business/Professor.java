package business;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa implements Autenticavel {
	
	private String nome;
	private int identificadorProf;
	private List<Oferta> ofertas = new ArrayList<Oferta>();

	
	public Professor(String nome, String endereco, String telefone, int identificadorProf) {
		super(nome, endereco, telefone);
		this.identificadorProf = identificadorProf;
		this.autenticacao = new Autenticador();
	}

	public String getNome() {
		return nome;
	}

	public int getIdentificadorProf() {
		return identificadorProf;
	}
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	
	public List<Aluno> alunosDisciplina(Disciplina disciplina) {
		return disciplina.getTotalAlunos();
	}
	
	public String verificarAlunosMatriculados(Oferta o) {
		return "";
	}
	
	public void imprimeDadosProfessor() {
		System.out.println("\n");
		System.out.println("  DADOS DO PROFESSOR  ");
		super.imprimeDados();
		System.out.println("IDENTIFICADOR: " + this.getIdentificadorProf());
	}
	
	
		
}
