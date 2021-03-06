package br.com.alura.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.getConexao();
		
		PreparedStatement stm = 
				connection.prepareStatement("DELETE FROM PRODUTO WHERE ID >= 2");
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de Linhas que foram modificadas: " 
		+ linhasModificadas);
	}
}
