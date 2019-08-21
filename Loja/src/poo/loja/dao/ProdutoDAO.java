package poo.loja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;
import poo.loja.modelo.Produto;
import poo.loja.util.ConnectionLojaFactory;

public class ProdutoDAO {
	
	public void insere(Produto produto) {
		Connection conn = null;
		try {			
			conn = ConnectionLojaFactory.getConnection();
			String sql ="insert into produto(codigo,nome,preco) values (?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);//
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setDouble(3, produto.getValor());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	public void excluir(Produto produto) {
		Connection conn = null;
		try {			
			conn = ConnectionLojaFactory.getConnection();
			String sql ="delete from produto where id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);//
			ps.setInt(1, produto.getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	public void atualizar(String nome, int id) {
		Connection conn = null;
		try {			
			conn = ConnectionLojaFactory.getConnection();
			String sql ="update produto set nome = ? where codigo = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);//
			ps.setString(1, nome);
			ps.setInt(2, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionLojaFactory.close(conn);
		}
	}
	
	
	public List<Produto> getProdutos() {
		Connection conn = null;
		try {
			conn =ConnectionLojaFactory.getConnection();
			String sql ="select * from produto ;";
			PreparedStatement ps = conn.prepareStatement(sql);//prepare p mim 
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<Produto>();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produtos.add(produto);
			}
			conn.close();
			return produtos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			ConnectionLojaFactory.close(conn);
		}
	}
		public List<Produto> getNome(String nm) {
			Connection conn = null;
			try {
				conn =ConnectionLojaFactory.getConnection();
				String sql ="select nome,preco from produto where nome = ?;";
				PreparedStatement ps = conn.prepareStatement(sql);//prepare p mim 
				ps.setString(1, nm);
				ResultSet rs = ps.executeQuery();
				List<Produto> produtos = new ArrayList<Produto>();
				while (rs.next()) {
					Produto produto = new Produto();
					produto.setNome(rs.getString(1));
					produto.setValor(rs.getDouble(2));
					produtos.add(produto);
				}
				conn.close();
				return produtos;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}finally {
				ConnectionLojaFactory.close(conn);
			}
	}
	
		public List<Produto> getPreco(Double x) {
			Connection conn = null;
			try {
				conn =ConnectionLojaFactory.getConnection();
				String sql ="select codigo,nome,preco from produto where preco > ?;";
				PreparedStatement ps = conn.prepareStatement(sql);//prepare p mim 
				ps.setDouble(1, x);
				ResultSet rs = ps.executeQuery();
				List<Produto> produtos = new ArrayList<Produto>();
				while (rs.next()) {
					Produto produto = new Produto();
					produto.setId(rs.getInt(1));
					produto.setNome(rs.getString(2));
					produto.setValor(rs.getDouble(3));
			
					produtos.add(produto);
				}
				conn.close();
				return produtos;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}finally {
				ConnectionLojaFactory.close(conn);
			}
		}
	
	

}
