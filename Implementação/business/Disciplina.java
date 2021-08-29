package business;

public class Disciplina {
	
	private String nomeDisc;
	private boolean disciplinaAtiva; 
	private int codDisciplina;
	private Professor professor;
	
	public Disciplina(String nomeDisc, boolean disciplinaAtiva, int codDisciplina, Professor professor) {
		this.nomeDisc = nomeDisc;
		this.disciplinaAtiva = disciplinaAtiva;
		this.codDisciplina = codDisciplina;
		this.professor = professor;
	}
	
	public String getNomeDisc() {
		return nomeDisc;
	}

	public boolean isDisciplinaAtiva() {
		return disciplinaAtiva;
	}
	
	public int getCodDisciplina() {
		return codDisciplina;
	}

	public Professor getProfessor() {
		return professor;
	}
	

}
