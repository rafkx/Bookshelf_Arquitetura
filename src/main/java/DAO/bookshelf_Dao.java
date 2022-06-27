package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import classe.Book;
import classe.Cartao;
import classe.Pedido;

public class bookshelf_Dao {
	
	public static String cadastrarBook(Book book) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(book);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return "Livro cadastrado";
		}
	
	public static Book listarBook() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Book estoque=null;
		try {
			estoque= em.find(Book.class,1);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return estoque;
		}
	
	public static String removerBook(int idBook) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Book remover = em.find(Book.class, idBook);
			em.remove(remover);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return "Livro removido";
		}
	
	public static String atualizarBook(Book book) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(book);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return "Livro atualizado";
		}

	
	public static String cadastrarCartao(Cartao cartao) {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				em.persist(cartao);
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
			
			em.close();
			em.getTransaction().commit();
			return "Cadastro concluido";
			}
		
		public static Cartao listarCartao() {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Cartao carteira=null;
			try {
				carteira= em.find(Cartao.class,1);
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
			
			em.close();
			em.getTransaction().commit();
			return carteira;
			}
		
		public static String removerCartao(int idCartao) {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				Cartao remover = em.find(Cartao.class, idCartao);
				em.remove(remover);
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
			
			em.close();
			em.getTransaction().commit();
			return "Cartão removido";
			}
		
		public static String atualizarCartao(Cartao cartao) {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			try {
				em.merge(cartao);
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}
			
			em.close();
			em.getTransaction().commit();
			return "Cartão atualizado";
			}
	
		public static String cadastrarPedido(Pedido pedido) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(pedido);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return "Cadastro concluido";
		}
	
	public static Pedido listarPedido() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pedido ordem=null;
		try {
			ordem= em.find(Pedido.class,1);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return ordem;
		}
	
	public static String removerPedido(int idPedido) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Pedido remover = em.find(Pedido.class, idPedido);
			em.remove(remover);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return "Pedido removido";
		}
	
	public static String atualizarPedido(Pedido pedido) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Connect");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(pedido);
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		
		em.close();
		em.getTransaction().commit();
		return "Pedido atualizado";
		}
}
