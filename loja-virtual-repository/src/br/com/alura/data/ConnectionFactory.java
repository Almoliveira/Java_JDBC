package br.com.alura.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	
	//SEMPRE ALTERAR O NOME DA SENHA AO REALIZAR COMMIT!

	private String connectionParam;
	private String userName;
	private String password;
	private Connection conexao;
	
	public DataSource datasource;
	
	public ConnectionFactory() {
		this.connectionParam = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
		this.userName = "root";
		this.password = "";
		
		
		ComboPooledDataSource combo = new ComboPooledDataSource();
		combo.setJdbcUrl(this.connectionParam);
		combo.setUser(this.userName);
		combo.setPassword(this.password);
		
		combo.setMaxPoolSize(15);
		
		this.datasource = combo;
	}
	
	public Connection getConexao() throws SQLException {
//		return DriverManager.
//				getConnection(this.connectionParam, this.userName,
//						this.password);
		return this.datasource.getConnection();
	}
	

//	public String getConnectionParam() {
//		return this.connectionParam;
//	}
//
//	public String getUserName() {
//		return this.userName;
//	}
//
//	public String getPassword() {
//		return this.password;
//	}
	
	
	
}
