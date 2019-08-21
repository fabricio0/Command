package poo.loja.Comando;

import java.util.Scanner;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class ListarProduto implements Comando{
	
	public void execute(Scanner sc) {
		ProdutoDAO dao = new ProdutoDAO();
		System.out.println("Lista de Produto");
		for (Produto xr : dao.getProdutos()) {
			System.out.println(xr.getNome());
			System.out.println(xr.getValor());
			System.out.println(xr.getId());
		}
	}
}
