package business;

public class OfertaDisciplina {
	
	private Disciplina disciplina;
	public static final int MAX_Alunos = 60;
	private int codOferta;
	


	public OfertaDisciplina(Disciplina disciplina, int codOferta) {
		this.disciplina = disciplina;
		this.codOferta = codOferta;
	}



	public Disciplina getDisciplina() {
		return disciplina;
	}



	public int getCodOferta() {
		return codOferta;
	}

	

}
