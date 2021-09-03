package business;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SecretariaUniversidade implements Autenticavel {

	private Autenticador autenticacao;
	private List<Curso> listaCursos = new ArrayList<Curso>();
	private List<Aluno> listaAlunos = new ArrayList<Aluno>();
	private List<Professor> listaProfessores = new ArrayList<Professor>();

	public List<Curso> getListaCursos() {
		return listaCursos;
	}

	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}

	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}
	
	public void add(Pessoa p) {
		if (p instanceof Aluno) {
			listaAlunos.add((Aluno)p);	
		}else {
			listaProfessores.add((Professor)p);
		}
		
	}

	public void remove(Pessoa p) {
		if (p instanceof Aluno) {
			listaAlunos.remove((Aluno)p);	
		}else {
			listaProfessores.remove((Professor)p);
		}
		
	}
	
	public void add(Curso c) {
		listaCursos.add(c);
	}

	public void remove(Curso c) {
		listaCursos.remove(c);
	}

	public SecretariaUniversidade() {
		this.autenticacao = new Autenticador();
	}
	
	public void printCursosCadastrados() {
		for (Curso curso : listaCursos) {
			System.out.println(curso.toString());
		}
	}
	
	public void printAlunosCadastrados() {
		for (Aluno aluno : listaAlunos) {
			aluno.imprimeDadosAluno();
		}
	}
	
	public void printProfessoresCadastrados() {
		for (Professor professor : listaProfessores) {
			professor.imprimeDadosProfessor();	
		}	
	}
	
	public void printDisciplinasPorCurso(int codCurso) {
		for (Curso curso : listaCursos) {
			if(curso.getCodigoCurso() == codCurso) {
				curso.printDisciplinasCurso();
			}
		}
	}
	
	public void addDisciplinaNoCurso(int codCurso, Disciplina disciplina) {
		for (Curso curso : listaCursos) {
			if(curso.getCodigoCurso() == codCurso) {
				curso.add(disciplina);
			}
		}
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
