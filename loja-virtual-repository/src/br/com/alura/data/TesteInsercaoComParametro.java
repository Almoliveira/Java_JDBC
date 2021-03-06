package br.com.alura.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		
		try(Connection connection = factory.getConexao()){
			
		
		connection.setAutoCommit(false);
		
		try (
		PreparedStatement stm = connection.prepareStatement(
				"INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)",
				Statement.RETURN_GENERATED_KEYS)){
		
		adicionarVariavel("Smart TV", "45 Polegadas", stm);
		adicionarVariavel("Geladeira Brastremp", "120 litros", stm);
		
		connection.commit();
		

		connection.close();
		}catch (Exception er) {
			er.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		}
	}

	private static void adicionarVariavel(String nome, String descricao
			, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		
		try(ResultSet rst = stm.getGeneratedKeys()){
			while(rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}
		
	}
	
}
