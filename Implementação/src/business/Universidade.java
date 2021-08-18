package src;

import java.util.ArrayList;
import java.util.List;

public class Universidade {

	private String loginAdm;
	private String senhaAdm; 
	private List<Aluno> listaAlunos = new ArrayList<Aluno>(); 
	private List<Professor> listaProfessores = new ArrayList<Professor>();
	private List<Curso> listaCursos = new ArrayList<Curso>();
	
	public String getLoginAdm() {
		return loginAdm;
	}
	public String getSenhaAdm() {
		return senhaAdm;
	}
	
}
