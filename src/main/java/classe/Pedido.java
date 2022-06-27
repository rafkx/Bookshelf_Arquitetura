package classe;

public class Pedido {
	private int id;
	private String nomeCliente;
	private String end;
	private String book;
	private float pagamento;
	
	public Pedido(int id, String nomeCliente, String end, String book, float pagamento) {
		this.setId(id);
		this.setNomeCliente(nomeCliente);
		this.setEnd(end);
		this.setBook(book);
		this.setPagamento(pagamento);
	}
	
	public Pedido(String nomeCliente, String end, String book, float pagamento) {
		this.setId(id);
		this.setNomeCliente(nomeCliente);
		this.setEnd(end);
		this.setBook(book);
		this.setPagamento(pagamento);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public float getPagamento() {
		return pagamento;
	}

	public void setPagamento(float pagamento) {
		this.pagamento = pagamento;
	}

}
