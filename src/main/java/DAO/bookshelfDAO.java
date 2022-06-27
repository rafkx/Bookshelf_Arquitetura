package DAO;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import classe.Book;
import classe.Cartao;
import classe.Pedido;
import factory.Connect;

@SuppressWarnings("unused")
public class bookshelfDAO {
	public void cadastrarCartao(Cartao cartao) throws SQLException{
		String comandSQL = "INSERT INTO cartao (numCartao, cvc, dataVencimento) VALUES (?,?,?);";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(comandSQL);
			ps.setInt(1, cartao.getNumCartao());
			ps.setInt(2, cartao.getCvc());
			ps.setInt(3, cartao.getDataVencimento());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				} if (rede != null) {
					rede.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeCartaoPorId (int id, boolean zerar) {
		String comandSQL = "DELETE FROM cartao WHERE id = ?;";
		String comandSQL2 = "truncate table cartao;";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			if (zerar) {
				ps = rede.prepareStatement(comandSQL2);
			} else {
				ps = rede.prepareStatement(comandSQL);
				ps.setInt(1, id);
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				} if (rede != null) {
					rede.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atuCartao (Cartao cartao) {
		String comandSQL = "UPDATE cartao SET numCartao = ?, cvc = ?, dataVencimento = ? WHERE id = ?;";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(comandSQL);
			ps.setInt(1, cartao.getNumCartao());
			ps.setInt(2, cartao.getCvc());
			ps.setInt(3, cartao.getDataVencimento());
			ps.setInt(4, cartao.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public List<Cartao> getPagamento() {
		String comandSQL = "SELECT * FROM cartao;";
		List <Cartao> pagamento = new ArrayList<Cartao>();
		Connection rede = null;
		PreparedStatement ps = null;
		ResultSet metodoPagamento = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(comandSQL);
			metodoPagamento = ps.executeQuery();
			
			while (metodoPagamento.next()) {
				Cartao cartoes = new Cartao(0,0,0);
				cartoes.setId(metodoPagamento.getInt("id"));
				cartoes.setNumCartao(metodoPagamento.getInt("numCartao"));
				cartoes.setCvc(metodoPagamento.getInt("cvc"));
				cartoes.setDataVencimento(metodoPagamento.getInt("dataVencimento"));
				pagamento.add(cartoes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return pagamento;
	}
	
	public Cartao seleCartoes (int id) {
		String commandSQL = "SELECT numCartao, cvc, dataVencimento FROM CARTAO WHERE ID = ?";
		Cartao cartao = null;
		Connection rede = null;
		PreparedStatement ps = null;
		ResultSet searchCartao = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			ps.setInt(1, id);
			searchCartao = ps.executeQuery();
			
			while (searchCartao.next()) {
				int numCartao = searchCartao.getInt("numCartao");
				int cvc = searchCartao.getInt("cvc");
				int dataVencimento = searchCartao.getInt("dataVencimento");
				cartao = new Cartao (id, numCartao, cvc, dataVencimento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return cartao;
	}
	
	public void cadastrarBook (Book book) {
		String commandSQL = "INSERT INTO book (titulo, autor, preco, cod) VALUES (?,?,?,?);";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			ps.setString(1, book.getTitulo());
			ps.setString(2, book.getAutor());
			ps.setFloat(3, book.getPreco());
			ps.setInt(4, book.getCod());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public void removeBookPorId (int id, boolean zerar) {
		String commandSQL = "DELETE FROM book WHERE id = ?;";
		String commandSQL2 = "truncate table book;";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			if (zerar) {
				ps = rede.prepareStatement(commandSQL2);
			} else {
				ps = rede.prepareStatement(commandSQL);
				ps.setInt(1, id);
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public void atuBook (Book book) {
		String commandSQL = "UPDATE book SET titulo = ?, autor = ?, preco = ?, cod = ? WHERE id = ?;";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			ps.setString(1, book.getTitulo());
			ps.setString(2, book.getAutor());
			ps.setFloat(3, book.getPreco());
			ps.setInt(4, book.getCod());
			ps.setInt(5, book.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public List<Book> getAcervo() {
		String commandSQL = "SELECT * FROM book;";
		List<Book> acervo = new ArrayList<Book>();
		Connection rede = null;
		PreparedStatement ps = null;
		ResultSet confAcervo = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			confAcervo = ps.executeQuery();
			
			while (confAcervo.next()) {
				Book books = new Book(null,null,0,0);
				books.setId(confAcervo.getInt("id"));
				books.setTitulo(confAcervo.getString("titulo"));
				books.setAutor(confAcervo.getString("autor"));
				books.setPreco(confAcervo.getFloat("preco"));
				books.setCod(confAcervo.getInt("cod"));
				acervo.add(books);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try{
					 if(ps != null){
						 ps.close();
					 }
					 if(rede != null){
						 rede.close();
					 }
				 }catch(Exception e){
					 e.printStackTrace();
				}
			}
		return acervo;
	}
	
	public Book seleBooks (int id) {
		String commandSQL = "SELECT titulo, autor, preco, cod FROM BOOK WHERE ID = ?;";
		Connection rede = null;
		PreparedStatement ps = null;
		Book book = null;
		ResultSet searchBook = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			searchBook = ps.executeQuery();
			
			while (searchBook.next()) {
				String titulo = searchBook.getString("titulo");
				String autor = searchBook.getString("autor");
				Float preco = searchBook.getFloat("preco");
				int cod = searchBook.getInt("cod");
				book = new Book (id, titulo, autor, preco, cod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return book;
	}
	
	public void cadastrarPedido (Pedido pedido) {
		String commandSQL = "INSERT INTO pedido (nomeCliente, end, book, pagamento) VALUES (?,?,?,?);";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			ps.setString(1, pedido.getNomeCliente());
			ps.setString(2, pedido.getEnd());
			ps.setString(3, pedido.getBook());
			ps.setFloat(4, pedido.getPagamento());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public void removePedidoPorId (int id, boolean zerar) {
		String commandSQL = "DELETE FROM pedido WHERE ID = ?;";
		String commandSQL2 = "truncate table pedido;";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			rede = Connect.criaConexao();
			if (zerar) {
				ps = rede.prepareStatement(commandSQL2);
			} else {
				ps = rede.prepareStatement(commandSQL);
				ps.setInt(1, id);
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public void atuPedido (Pedido pedido) {
		String comandoSQL = "UPDATE pedido SET nomeCliente = ?, end = ?, book = ?, pagamento = ? WHERE id = ?;";
		Connection rede = null;
		PreparedStatement ps = null;
		
		try {
			 rede= Connect.criaConexao();
			 ps = rede.prepareStatement(comandoSQL);
			 ps.setString(1, pedido.getNomeCliente());
			 ps.setString(2, pedido.getEnd());
			 ps.setString(3, pedido.getBook());
			 ps.setFloat(4, pedido.getPagamento());
			 ps.setInt(5, pedido.getId());
			 ps.execute();
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
	}
	
	public List<Pedido> getPedidos() {
		String commandSQL = "SELECT * FROM pedido;";
		List <Pedido> pedidos = new ArrayList<Pedido>();
		Connection rede = null;
		PreparedStatement ps = null;
		ResultSet pedido = null;
		
		try {
			rede = Connect.criaConexao();
			ps = rede.prepareStatement(commandSQL);
			pedido = ps.executeQuery();
			
			while (pedido.next()) {
				Pedido ped = new Pedido(null, null, null,0);
				 ped.setId(pedido.getInt("id"));
				 ped.setNomeCliente(pedido.getString("nomeCliente"));
				 ped.setEnd(pedido.getString("end"));
				 ped.setBook(pedido.getString("book"));
				 ped.setPagamento(pedido.getFloat("pagamento"));
				 pedidos.add(ped);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{
				 if(ps != null){
					 ps.close();
				 }
				 if(rede != null){
					 rede.close();
				 }
			 }catch(Exception e){
				 e.printStackTrace();
			}
		}
		return pedidos;
	}
}
