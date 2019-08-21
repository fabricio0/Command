package poo.loja.teste;

import java.util.Hashtable;
import java.util.Scanner;

import poo.loja.Comando.AtualizarProduto;
import poo.loja.Comando.CadastrarProduto;
import poo.loja.Comando.Comando;
import poo.loja.Comando.ListarProduto;
import poo.loja.Comando.PesquisarNome;
import poo.loja.Comando.PesquisarPreco;
import poo.loja.Comando.Sair;
import poo.loja.dao.ProdutoDAO;
import poo.loja.modelo.Produto;

public class lojaTeste {

	public static void menu(){
		
		System.out.println("Administração da loja");	
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Atualização de um produto");
		System.out.println("3 - Pesquisa pelo nome");
		System.out.println("4 - Pesquisa pelo Preço");
		System.out.println("5. Pesquisa por todos dados");
		System.out.println("Escolha uma opção");						
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		Hashtable<Integer,Comando> comandos = 
				new Hashtable<Integer,Comando>();
		
		comandos.put(2, new AtualizarProduto());
		comandos.put(5, new ListarProduto());
		comandos.put(0, new Sair());
		comandos.put(1, new CadastrarProduto());
		comandos.put(4, new PesquisarPreco());
		comandos.put(3, new PesquisarNome());
		
		
		do{
			
		menu();
		opcao = sc.nextInt();
		comandos.get(opcao).execute(sc);
			
		}while(opcao != 0);
		sc.close();	
			
			
		
			
	
	}
}
