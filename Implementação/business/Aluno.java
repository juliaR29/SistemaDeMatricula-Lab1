package business;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

	private int identificador;
	private Curso curso;
	private List<Oferta> obrigatoria = new ArrayList<Oferta>();
	private List<Oferta> naoObrigatoria = new ArrayList<Oferta>();
	public static final int MAX_DISC_OB = 4;
	public static final int MAX_DISC_OPT = 2;

	public Aluno(String nome, String endereco, String telefone, int identificador) {
		super(nome, endereco, telefone);
		this.identificador = identificador;
	}

	public Curso getCurso() {
		return curso;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void imprimeDadosAluno() {
		System.out.println("\n");
		System.out.println("  DADOS DO ALUNO  ");
		super.imprimeDados();
		System.out.println("Identificador: " + this.getIdentificador());
	}

	public boolean matricularObrigatoria(Oferta o) {
		boolean resultado;
		
		if (o.getDisciplina().getEhOptativa()) {
			resultado = false;
			System.out.println("Voc� n�o pode matricular em uma disciplina optativa como se fosse obrigat�ria!");
			
		} else if (obrigatoria.size() >= 4) {
			resultado = false;
			System.out.println("Voc� s� pode se matricular em 4 disciplinas obrigat�rias!");
		} else {
			resultado = o._addAluno(this);
		}

		if (resultado == true) {
			obrigatoria.add(o);
		}
		return resultado;
	}

	public boolean matricularNaoObrigatoria(Oferta o) {
		boolean resultado;

		if (!o.getDisciplina().getEhOptativa()) {
			resultado = false;
			System.out.println("Voc� n�o pode matricular em uma disciplina obrigat�ria como se fosse optativa!");

		} else if (naoObrigatoria.size() >= 2) {
			resultado = false;
			System.out.println("Voc� s� pode se matricular em 2 disciplinas optativas!");
		} else {
			resultado = o._addAluno(this);
		}
		
		if (resultado == true) {
			naoObrigatoria.add(o);
		}
		return resultado;
	}

	public boolean desmatricularObrigatoria(Oferta o) {
		boolean resultado = o._removeAluno(this);
		if (resultado == true) {
			obrigatoria.remove(o);
		}
		return resultado;

	}

	public boolean desmatricularNaoObrigatoria(Oferta o) {
		boolean resultado = o._removeAluno(this);
		if (resultado == true) {
			naoObrigatoria.remove(o);
		}
		return resultado;

	}


}
