package br.com.alura.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory conexao = new ConnectionFactory();
		Connection con = conexao.getConexao();

		Statement stm = con.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String descricao = rst.getString("DESCRICAO");

			System.out.println("ID: " + id);
			System.out.println("NOME: " + nome);
			System.out.println("DESCRICAO: " + descricao);
		}
	
		con.close();
	}
	
}
