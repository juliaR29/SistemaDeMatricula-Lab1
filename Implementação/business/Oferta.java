package business;

import java.util.ArrayList;
import java.util.List;

public class Oferta {

	private Disciplina disciplina;
	private Professor professor;
	private int codOferta;
	private boolean matriculaAberta;
	protected List<Aluno> listaAlunos = new ArrayList<Aluno>();
	public static final int MAX_ALUNOS = 60;

	public Oferta(Disciplina disciplina, Professor professor, int codOferta) {
		this.disciplina = disciplina;
		this.professor = professor;
		this.codOferta = codOferta;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public int getCodOferta() {
		return codOferta;
	}

	public Professor getProfessor() {
		return professor;
	}

	boolean _addAluno(Aluno aluno) {
		if (listaAlunos.size() < MAX_ALUNOS) {
			listaAlunos.add(aluno);
			return true;
		} else {
			System.out.println("Limite da turma excedido!");
			return false;
		}

	}

	boolean _removeAluno(Aluno aluno) {
		return listaAlunos.remove(aluno);
	}

	public boolean isMatriculaAberta() {
		return matriculaAberta;
	}

}
