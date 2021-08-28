package business;

public class Professor implements Autenticavel {
	
	private String nome;
	private int identificadorProf;
	private Autenticador autenticacao;
	
	public Professor(String nome, int identificadorProf) {
		this.nome = nome;
		this.identificadorProf = identificadorProf;
		this.autenticacao = new Autenticador();
	}

	public String getNome() {
		return nome;
	}

	public int getIdentificadorProf() {
		return identificadorProf;
	}
	
	public void verificarAlunosMatriculados() {
		
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
