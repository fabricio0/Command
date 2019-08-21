package poo.loja.Comando;

import java.util.Scanner;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class PesquisarNome implements Comando{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		ProdutoDAO dao = new ProdutoDAO();
		System.out.println("insira um nome");
		String nome = sc.next();
		for (Produto xr : dao.getNome(nome)) {
			System.out.println(xr.getNome());
			System.out.println(xr.getValor());
		}
	}

}
