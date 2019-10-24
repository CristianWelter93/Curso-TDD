package leilao;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		if(valor <= 0){
			throw new RuntimeException("O valor do lance não pode ser igual ou inferior a zero");
		}
			this.usuario = usuario;
			this.valor = valor;

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}

}
