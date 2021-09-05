package business;

import java.util.ArrayList;
import java.util.List;


public class Disciplina {

	private String nomeDisc;
	private boolean disciplinaAtiva;
	private int codDisciplina;
	private boolean ehOptativa;
	private List<Aluno> totalAlunos = new ArrayList<Aluno>();
	private List<Oferta> oferta = new ArrayList<Oferta>();

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

	public List<Aluno> getTotalAlunos() {
		return totalAlunos;
	}

	public void setTotalAlunos(List<Aluno> totalAlunos) {
		this.totalAlunos = totalAlunos;
	}
	
	public void addAluno(Aluno aluno) {
		totalAlunos.add(aluno);
	}
	
	public void removeAluno(Aluno aluno) {
		totalAlunos.remove(aluno);
	}
	
	public List<Oferta> getOferta() {
		return oferta;
	}

	public void setOferta(List<Oferta> oferta) {
		this.oferta = oferta;
	}
	
	public void addOferta(Oferta ofe) {
		oferta.add(ofe);
	}
	
	public void removeOferta(Oferta ofe) {
		oferta.remove(ofe);
	}

	@Override
	public String toString() {
		return "[ Nome Disciplina: " + this.getNomeDisc() + "CodDisciplina: " + this.getCodDisciplina() + " ]";
	}

}
