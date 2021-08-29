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
		System.out.println("1 - Cadastro de alunos e professores");
		System.out.println("2 - Cadastro de disciplinas");
		System.out.println("3 - Cadastro de cursos");
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
		Professor p = new Professor("nome", "endereco", "123456789", 12); 
		System.out.println("__________________________________");
		System.out.println("DISCIPLINA");
		System.out.println("1 - Cadastro da disciplina");
		System.out.print("Opção: ");

		try {
			int opc = Integer.parseInt(teclado.nextLine());
			System.out.print("Nome: \n");
			String nome = teclado.nextLine();
			System.out.println("Disciplina ativa:");
			boolean disciplinaAtiva = teclado.nextBoolean();
			System.out.print("Código: \n");
			int codDisciplina = teclado.nextInt();

			switch (opc) {
			case 1:
				dis = new Disciplina(nome, disciplinaAtiva, codDisciplina, p); 
				break;
			}
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return dis;
	}

	public static Curso criaCurso(Scanner teclado) {
		Curso c = null;
		System.out.println("__________________________________");
		System.out.println("CURSO");
		System.out.println("1 - Cadastro do curso");
		//System.out.println("2 - Informações do curso");
		System.out.print("Opção: ");

		try {
			int opc = Integer.parseInt(teclado.nextLine());
			System.out.print("Nome: \n");
			String nome = teclado.nextLine();
			System.out.println("Créditos:");
			int numCreditos = teclado.nextInt();

			switch (opc) {
			case 1:
				c = new Curso(nome, numCreditos); 
				break;
			}
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return c;
	}

	public static void main(String args[]) {
		Scanner teclado = new Scanner(System.in);
		SecretariaUniversidade secretaria = new SecretariaUniversidade();
		Pessoa p1;
		Disciplina d1 = null;
		Curso c ;
		
		int opcao = 0;
		do {
			opcao = menu(teclado);
			switch (opcao) {
			case 1:
				try {
					p1 = criaPessoa(teclado);
					secretaria.addPessoa(p1);
					System.out.println(p1);
				} catch (InvalidParameterException ex) {
					System.out.println("O aluno não foi criado. " + ex.getMessage());
					pausa(teclado);
				}
				break;
			case 2:
				try {
					d1 = criaDisciplina(teclado);
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
					c.add(d1);
					System.out.println("Curso criado!");
				} catch (InvalidParameterException ex) {
					System.out.println("O curso não foi criado. " + ex.getMessage());
					pausa(teclado);
				}
			}
		} while (opcao != 9);

		System.out.println("FIM");
		teclado.close();

	}
}
