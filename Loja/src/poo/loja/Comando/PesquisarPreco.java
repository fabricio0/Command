package poo.loja.Comando;

import java.util.Scanner;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class PesquisarPreco implements Comando{

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		ProdutoDAO dao = new ProdutoDAO();
		System.out.println("Buscar por valores maiores que ... ");
		double prec = sc.nextDouble();
		dao.getPreco(prec);
		for (Produto xr : dao.getPreco(prec)) {
			System.out.println(xr.getNome());
			System.out.println(xr.getValor());
			System.out.println(xr.getId());
		
	}

	}
}
