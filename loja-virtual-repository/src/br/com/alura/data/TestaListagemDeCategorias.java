package br.com.alura.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.model.Categoria;
import br.com.alura.model.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().getConexao()){
			
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategoria =  categoriaDAO.listar();

			listaDeCategoria.stream().forEach(ct -> {
					System.out.println(ct.getNome());
					
					try {
						for(Produto produto : new ProdutoDAO(connection)
								.buscar(ct)) {
							System.out.println(ct.getNome() + " - " 
						+ produto.getNome());
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
			});
		}
		
		
	}

}
