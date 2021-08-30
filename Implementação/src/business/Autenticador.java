package business;

public class Autenticador {

	private int senha;
	
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
