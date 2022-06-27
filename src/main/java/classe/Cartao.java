package classe;

public class Cartao {
	private int id;
	private int numCartao;
	private int cvc;
	private int dataVencimento;	
	
	public Cartao(int id, int numCartao, int cvc, int dataVencimento) {
		this.setId(id);
		this.setNumCartao(numCartao);
		this.setCvc(cvc);
		this.setDataVencimento(dataVencimento);
	}
	
	public Cartao(int numCartao, int cvc, int dataVencimento) {
		this.setNumCartao(numCartao);
		this.setCvc(cvc);
		this.setDataVencimento(dataVencimento);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(int numCartao) {
		this.numCartao = numCartao;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public int getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(int dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
}
