package poo.loja.Comando;

import java.util.Scanner;

import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class CadastrarProduto implements Comando{
	public void execute(Scanner ler) {
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = new Produto();
		String nome;
		
		
		double preco;
		System.out.println("insira um código");
		produto.setId(ler.nextInt());
		System.out.println("insira um nome");
		produto.setNome(ler.next());
		System.out.println("insira um preço");
		produto.setValor(ler.nextDouble());
		dao.insere(produto);
		
	}
}
