package br.com.alura.model;

public class Conexao {

	private String connectionParam;
	private String userName;
	private String password;
	
	public Conexao() {
		this.connectionParam = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
		this.userName = "root";
		this.password = "InsiraSuaSenhaAqui";
	}

	public String getConnectionParam() {
		return this.connectionParam;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}
	
	
	
}