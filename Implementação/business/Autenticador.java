package business;

public class Autenticador {

	private String usuario;
	private String nome;
	private int senha;
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public boolean login(int senha) {
		boolean logado;
		if (this.senha == senha) {
			logado = true;
		}
		else{
			logado = false;
		}
		return logado;
	}

}
