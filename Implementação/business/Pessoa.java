package business;

public abstract class Pessoa {

	private String usuario;
	private String senha;
	private String nome;
	private String endereco;
	private String telefone;
	

	public Pessoa(String nome, String endereco, String telefone) {
		this.setUsuario(usuario);
		this.setSenha(senha);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() > 0 && nome.length() <= 40)
			this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco.length() > 0 && endereco.length() <= 50)
			this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone.length() >= 9 && telefone.length() < 14)
			this.telefone = telefone;
	}


	public void imprimeDados() {
		System.out.println("Nome: " + this.getNome() + "\n" + "Endereço: " + this.getEndereco() + "\n" + "Telefone: "
				+ this.getTelefone());
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome.toString()+ "Endereço: " + this.getEndereco() + "\n" + "Telefone: "
				+ this.getTelefone();
		}
}
