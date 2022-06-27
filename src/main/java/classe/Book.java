package classe;

public class Book {
	private int id;
	private String titulo;
	private String autor;
	private float preco;
	private int cod;
	
	public Book(String titulo, String autor, float preco, int cod) {
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.cod = cod;
	}
	
	public Book(int id, String titulo, String autor, float preco, int cod) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.cod = cod;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
}
