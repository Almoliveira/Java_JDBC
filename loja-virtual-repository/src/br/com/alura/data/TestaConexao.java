package br.com.alura.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.alura.model.Conexao;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

		Conexao conexao = new Conexao();
		Connection con = DriverManager.
				getConnection(conexao.getConnectionParam(), conexao.getUserName(),
						conexao.getPassword());

		con.close();
	}

}