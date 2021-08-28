package business;

public class Disciplina {
	
	private boolean disciplinaAtiva; 
	private int codDisciplina;
	private Professor professor;
	
	public Disciplina(boolean disciplinaAtiva, int codDisciplina, Professor professor) {
		this.disciplinaAtiva = disciplinaAtiva;
		this.codDisciplina = codDisciplina;
		this.professor = professor;
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
