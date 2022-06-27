package teste;

import classe.Book;
import classe.Cartao;
import classe.Pedido;

import java.sql.SQLException;

import DAO.bookshelfDAO;

public class teste {
	public static void main(String[] args) throws SQLException {
		bookshelfDAO  dao = new bookshelfDAO ();
		
		Book livro = new Book("amor","joão", 45,12);
		Cartao cartao = new Cartao(123456,333,7777);
		Pedido pedido = new Pedido("maria", "rua augusta","amor", 1);
		Book livroAtu = new Book(1,"jogo", "jose",15, 11);
		Cartao cartaoAtu = new Cartao(1,5555555,333,7777);
		Pedido pedidoAtu = new Pedido(1,"carla", "rua augusto","jogo", 5);
		
		//Cadastrar
		dao.cadastrarCartao(cartao);
		dao.cadastrarBook(livro);
		dao.cadastrarPedido(pedido);
		
		//Listar
		dao.getPagamento();
		dao.getAcervo();
		dao.getPedidos();
		
		//Editar
		dao.atuBook(livroAtu);
		dao.atuCartao(cartaoAtu);
		dao.atuPedido(pedidoAtu);
		
		//Listar
		dao.getPagamento();
		dao.getAcervo();
		dao.getPedidos();
		
		//Remover
		dao.removeBookPorId(livro.getId(),false);
		dao.removeCartaoPorId(cartao.getId(),false);
		dao.removePedidoPorId(pedido.getId(),false);
		
		//Listar
		dao.getPagamento();
		dao.getAcervo();
		dao.getPedidos();

	}

}
