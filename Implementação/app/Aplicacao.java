package app;

import business.Aluno;
import business.Curso;
import business.Disciplina;
import business.Pessoa;
import business.Professor;
import business.SecretariaUniversidade;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Aplicacao {

	public static void limparTela() {
		System.out.flush();
	}

	public static int menu(Scanner teclado) {
		limparTela();
		System.out.println("__________________________________");
		System.out.println("Sistema de Matricula");
		System.out.println("Bem vinda Secretaria!");
		System.out.println("1 - Cadastro de alunos e professores");
		System.out.println("2 - Cadastro de disciplinas");
		System.out.println("3 - Cadastro de cursos");
		System.out.println("4 - Exibir Professores cadastrados");
		System.out.println("5 - Exibir Alunos cadastrados");
		System.out.println("6 - Exibir Cursos cadastrados");
		System.out.println("7 - Exibir Disciplinas por curso");
		System.out.println("0 - Sair");

		int opcao = teclado.nextInt();
		teclado.nextLine();
		return opcao;
	}

	static void pausa(Scanner teclado) {
		System.out.println("Enter para continuar.");
		teclado.nextLine();
	}

	public static Pessoa criaPessoa(Scanner teclado) {
		Pessoa novo = null;
		System.out.println("__________________________________");
		System.out.println("Criar novo cadastro");
		System.out.println("1 - Aluno");
		System.out.println("2 - Professor");
		System.out.print("Opção: ");

		try {
			int opc = Integer.parseInt(teclado.nextLine());
			System.out.print("Nome: \n");
			String nome = teclado.nextLine();
			System.out.print("Endereço: \n");
			String endereco = teclado.nextLine();
			System.out.print("Telefone: \n");
			String telefone = teclado.nextLine();
			System.out.print("Identificador: \n");
			int identificador = teclado.nextInt();
			teclado.nextLine();

			switch (opc) {
			case 1:
				novo = new Aluno(nome + "\n", endereco, telefone, identificador);
				break;
			case 2:
				novo = new Professor(nome + "\n", endereco, telefone, identificador);
				break;
			}
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return novo;
	}

	public static Disciplina criaDisciplina(Scanner teclado) {
		Disciplina dis = null;
		Professor p = new Professor("nome", "endereco", "123456789", 12); //professor temporário
		System.out.println("__________________________________");
		System.out.println("DISCIPLINA");

		try {
			System.out.print("Nome: \n");
			String nome = teclado.nextLine();
			System.out.println("Disciplina ativa:");
			boolean disciplinaAtiva = teclado.nextBoolean();
			System.out.print("Código: \n");
			int codDisciplina = teclado.nextInt();
			teclado.nextLine();
			dis = new Disciplina(nome, disciplinaAtiva, codDisciplina, p);

		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return dis;
	}

	public static Curso criaCurso(Scanner teclado) {
		Curso c = null;
		System.out.println("__________________________________");
		System.out.println("CURSO");

		try {
			System.out.print("Nome: \n");
			String nome = teclado.nextLine();
			System.out.println("Código:");
			int codigoCurso = teclado.nextInt();
			teclado.nextLine();
			c = new Curso(nome, codigoCurso);
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return c;
	}

	public static int lerCodCurso(Scanner teclado) {
		int codigoCurso;
		System.out.println("__________________________________");
		System.out.println("INSIRA O CÓDIGO DO CURSO");

		try {
			System.out.println("Código:");
			codigoCurso = teclado.nextInt();
			teclado.nextLine();

		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return codigoCurso;
	}

	public static void main(String args[]) {
		Scanner teclado = new Scanner(System.in);
		SecretariaUniversidade secretaria = new SecretariaUniversidade();
		Pessoa p1;
		Disciplina d1 = null;
		Curso c;

		int opcao = 0;
		int codCurso;
		do {
			opcao = menu(teclado);
			switch (opcao) {
			case 1:
				try {
					p1 = criaPessoa(teclado);
					secretaria.add(p1);
					System.out.println(p1);
				} catch (InvalidParameterException ex) {
					System.out.println("O aluno não foi criado. " + ex.getMessage());
					pausa(teclado);
				}
				break;
			case 2:
				try {
					secretaria.printCursosCadastrados();
					codCurso = lerCodCurso(teclado);
					d1 = criaDisciplina(teclado);
					secretaria.addDisciplinaNoCurso(codCurso, d1);
					System.out.println("Disciplina criada!");
				} catch (InvalidParameterException ex) {
					System.out.println("A disciplina não foi criada. " + ex.getMessage());
					pausa(teclado);
				}
				break;
			case 3:
				try {
					c = criaCurso(teclado);
					secretaria.add(c);
					System.out.println("Curso criado!");
				} catch (InvalidParameterException ex) {
					System.out.println("O curso não foi criado. " + ex.getMessage());
					pausa(teclado);
				}
				break;
			case 4:
				secretaria.printProfessoresCadastrados();
				pausa(teclado);
				break;
			case 5:
				secretaria.printAlunosCadastrados();
				pausa(teclado);
				break;
			case 6:
				secretaria.printCursosCadastrados();
				pausa(teclado);
				break;
			case 7:
				secretaria.printCursosCadastrados();
				codCurso = lerCodCurso(teclado);
				secretaria.printDisciplinasPorCurso(codCurso);
				break;
			}
		} while (opcao != 9);

		System.out.println("FIM");
		teclado.close();

	}
}
