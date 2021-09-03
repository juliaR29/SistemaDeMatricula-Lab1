package business;

public class Professor extends Pessoa implements Autenticavel {
	
	private String nome;
	private int identificadorProf;
	private Autenticador autenticacao;
	
	public Professor(String nome, String endereco, String telefone, int identificadorProf) {
		super(nome, endereco, telefone);
		this.identificadorProf = identificadorProf;
		this.autenticacao = new Autenticador();
	}

	public String getNome() {
		return nome;
	}

	public int getIdentificadorProf() {
		return identificadorProf;
	}
	
	public String verificarAlunosMatriculados(Oferta o) {
		return "";
	}
	
	public void imprimeDadosProfessor() {
		System.out.println("  DADOS PROFESSORES  ");
		super.imprimeDados();
		System.out.println("IDENTIFICADOR: " + this.getIdentificadorProf());
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
