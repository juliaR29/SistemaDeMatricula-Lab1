
//package app;
//
//import business.Aluno;
//import business.Curso;
//import business.Disciplina;
//import business.Oferta;
//import business.Pessoa;
//import business.Professor;
//import business.Universidade;
//
//import java.security.InvalidParameterException;
//import java.util.Scanner;
//
//public class Aplicacao {
//	
//	public static void main(String[] args) {
//		Universidade universidade = new Universidade();	
//		Curso curso1 = new Curso("Enhenharia de Software", 113);
//		universidade.add(curso1);
//		Professor professor1 = new Professor("Afonso", "Rua 12", "123412121", 11);
//		Professor professor2 = new Professor("Artemis", "Rua 13", "432112121", 12);
//		Professor professor3 = new Professor("Augusto", "Rua 11", "987631212", 13);
//		Professor professor4 = new Professor("Adonis", "Rua 10", "987637772", 10);
//		Aluno aluno1 = new Aluno("Aline", "Rua 14", "122992561", 112);
//		Aluno aluno2 = new Aluno("Alisteu", "Rua 15", "122992562", 113);
//		Aluno aluno3 = new Aluno("Astolfo", "Rua 16", "122992563", 114);
//		Disciplina disciplina1 = new Disciplina ("AED I", true, 11101, false);
//		Disciplina disciplina2 = new Disciplina ("AED II", true, 11102, false);
//		Disciplina disciplina3 = new Disciplina ("Programação Modular", true, 11103, false);
//		Disciplina disciplina4 = new Disciplina ("Engenharia de Requisitos", true, 11104, false);
//		Disciplina disciplina5 = new Disciplina ("Banco de Dados", true, 11105, false);
//		Disciplina disciplina6 = new Disciplina ("Desenho 3D", true, 11106, true);
//		Disciplina disciplina7 = new Disciplina ("Inteligencia Artifical", true, 11107, true);
//		Disciplina disciplina8 = new Disciplina ("Desenvolvimento de Interfaces Web", true, 11108, true);
//		
//		Oferta oferta1 = new Oferta(disciplina1, professor1, 1234);
//		Oferta oferta2 = new Oferta(disciplina2, professor2, 1235);
//		Oferta oferta3 = new Oferta(disciplina3, professor3, 1236);
//		Oferta oferta4 = new Oferta(disciplina4, professor3, 1237);
//		Oferta oferta5 = new Oferta(disciplina5, professor2, 1238);
//		Oferta oferta6 = new Oferta(disciplina6, professor1, 1239);
//		Oferta oferta7 = new Oferta(disciplina7, professor4, 1240);
//		Oferta oferta8 = new Oferta(disciplina8, professor4, 1241);
//	
//		curso1.add(disciplina1);
//		curso1.add(disciplina2);
//		curso1.add(disciplina3);
//		universidade.add(professor1);
//		universidade.add(professor2);
//		universidade.add(professor3);
//		universidade.add(aluno1);
//		universidade.add(aluno2);
//		universidade.add(aluno3);
//		aluno1.matricularObrigatoria(oferta1);
//		aluno1.matricularObrigatoria(oferta2);
//		aluno1.matricularObrigatoria(oferta3);
//		aluno1.matricularObrigatoria(oferta4);
//		System.out.println("\n iniciando tentativa matricula em 5 obrigatórias");
//		aluno1.matricularObrigatoria(oferta5);
//		aluno1.matricularNaoObrigatoria(oferta6);
//		aluno1.matricularNaoObrigatoria(oferta7);
//		System.out.println("\n iniciando tentativa matricula em 3 optativas");
//		aluno1.matricularNaoObrigatoria(oferta8);	
//	
//	}
//}

// USEI PARA TESTAR SEM O MENU

package app;

import business.Aluno;
import business.Curso;
import business.Disciplina;
import business.Pessoa;
import business.Professor;
import business.Universidade;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		System.out.println("8 - Remover alunos ");
		System.out.println("9 - Remover professores ");
		System.out.println("10 - Remover cursos");
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
				novo = new Aluno(nome+"\n", endereco, telefone, identificador);
				break;
			case 2:
				novo = new Professor(nome+"\n", endereco, telefone, identificador);
				break;
			}
		} catch (NumberFormatException ex) {
			throw new InvalidParameterException("Opção inválida.");
		}
		return novo;
	}

	public static Disciplina criaDisciplina(Scanner teclado) {
		Disciplina dis = null;
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
			System.out.println("Disciplina optativa: true/false");
			boolean disciplinaOptativa = teclado.nextBoolean();
			dis = new Disciplina(nome, disciplinaAtiva, codDisciplina, disciplinaOptativa);

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
			System.out.print("Nome: ");
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

	public static void removeAluno(Scanner teclado, Universidade u ) {
		System.out.println("\nEscolha o aluno a ser removido: ");
		
		int cont = 1;
		for (Aluno a : u.getListaAlunos()) {
			System.out.println(cont + " -> " + a.getNome());
			cont++;
		}
		
		int op = teclado.nextInt();
		cont = 1;
		
		for (Aluno a : u.getListaAlunos()) {
			if (cont == op) {
				u.remove(a);
			}
			cont++;
		}
		teclado.nextLine();
	}
	
	public static void removeProfessor(Scanner teclado, Universidade u ) {
		System.out.println("\nEscolha o professor a ser removido: ");
		
		int cont = 1;
		for (Professor p : u.getListaProfessores()) {
			System.out.println(cont + " -> " + p.getNome());
			cont++;
		}
		
		int op = teclado.nextInt();
		cont = 1;
		
		for (Professor p : u.getListaProfessores()) {
			if (cont == op) {
				u.remove(p);
			}
			cont++;
		}
		teclado.nextLine();
	}

	public static void removeCurso(Scanner teclado, Universidade u ) {
		System.out.println("\nEscolha o curso a ser removido: ");
		
		int cont = 1;
		for (Curso c : u.getListaCursos()) {
			System.out.println(cont + " -> " + c.getNome());
			cont++;
		}
		
		int op = teclado.nextInt();
		cont = 1;
		
		for (Curso c : u.getListaCursos()) {
			if (cont == op) {
				u.remove(c);
			}
			cont++;
		}
		teclado.nextLine();
	}
	

	public static void adicionarDoArquivo(Scanner teclado, Universidade sistema, String nomeArq) throws IOException {
		File arq = new File(nomeArq);
		Pessoa pessoa = null;
		try {
			arq.createNewFile();
			Scanner leitor = new Scanner(arq);
			while (leitor.hasNextLine()) {
				String[] dados = leitor.nextLine().split(";");
				String nome = dados[1];
				String end = dados[2];
				String tel = dados[3];
				int id = Integer.parseInt(dados[4]);
				int opc = Integer.parseInt(dados[0]);
				switch (opc) {
				case 1:
					pessoa = new Aluno(nome, end, tel, id);
					break;
				case 2:
					pessoa = new Professor(nome, end, tel, id);
					break;
				}
				if (pessoa != null)
					sistema.add(pessoa);
			}
			leitor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo " + nomeArq + " não foi encontrado. Dados não foram lidos");
			pausa(teclado);
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner teclado = new Scanner(System.in);
		Universidade secretaria = new Universidade();
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
			case 8:
				removeAluno(teclado, secretaria);
				break;
			case 9:
				removeProfessor(teclado, secretaria);
				break;
			case 10:
				removeCurso(teclado, secretaria);
				break;
			case 11:
				adicionarDoArquivo(teclado, secretaria, "DADOS.txt");
                break;
			}
		} while (opcao != 13);

		System.out.println("FIM");
		teclado.close();

	}
}
