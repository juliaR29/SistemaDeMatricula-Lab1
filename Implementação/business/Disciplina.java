package business;

public class Disciplina {
	
	private String nomeDisc;
	private boolean disciplinaAtiva; 
	private int codDisciplina;
	private double valorDisciplina;
	private boolean ehOptativa; 
	
	public boolean getEhOptativa() {
		return ehOptativa;
	}


	public Disciplina(String nomeDisc, boolean disciplinaAtiva, int codDisciplina, boolean ehOptativa) {
		this.nomeDisc = nomeDisc;
		this.disciplinaAtiva = disciplinaAtiva;
		this.codDisciplina = codDisciplina;
		this.ehOptativa = ehOptativa;

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


	
	@Override
	public String toString() {
		return "[ Nome Disciplina: " + this.getNomeDisc() + "CodDisciplina: " + this.getCodDisciplina() + " ]";
	}
	

}
