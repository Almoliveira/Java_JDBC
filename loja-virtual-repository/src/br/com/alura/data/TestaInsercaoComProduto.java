package br.com.alura.data;

import java.sql.Connection;
import java.sql.SQLException;


import br.com.alura.model.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Fog�o","Quatro bocas");

		try(Connection connection = new ConnectionFactory().getConexao()){
			ProdutoDAO persitenciaProduto 
			= new ProdutoDAO(connection);
			persitenciaProduto.salvarProduto(comoda);
		}
		System.out.println(comoda);
	}

}
