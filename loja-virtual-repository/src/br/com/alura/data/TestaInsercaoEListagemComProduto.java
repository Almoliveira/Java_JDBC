package br.com.alura.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.model.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Fog?o","Quatro bocas");

		try(Connection connection = new ConnectionFactory().getConexao()){
			ProdutoDAO produtoDao 
			= new ProdutoDAO(connection);
			produtoDao.salvarProduto(comoda);
			
			List<Produto> lista = produtoDao.lista();
			lista.stream().forEach(lp -> System.out.println(lp));
		}
	//	System.out.println(comoda);
	}

}
