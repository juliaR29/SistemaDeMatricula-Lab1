package business;

public class Aluno {
	
	private static final int DIS_OBRIGATORIAS = 4;
	private static final int DIS_OPTATIVAS = 2;
	private int identificador;
	private String nome;
	private String login;
	private String senha;
	
	public int getIdentificador() {
		return identificador;
	}
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}	

}
