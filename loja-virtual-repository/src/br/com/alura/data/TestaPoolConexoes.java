package br.com.alura.data;

import java.sql.SQLException;

public abstract class TestaPoolConexoes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory conexao = new ConnectionFactory();
		
		for (int i = 0 ; i < 20; i++) {
			conexao.getConexao();
			System.out.println("Conex�o de numero:" +i);
		}
	}

}
