package estuturadedados.listaduplamenteencadeada;

public class No<T> {
	
	private T valor;
	private No<T> proximo;
	private No<T> anterior;
	
	public No(T novoValor) {
		this.anterior = null;
		this.proximo = null;
		this.valor = novoValor;
	}

	public T getValor() {
		return valor;
	}
	
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public No<T> getProximo() {
		return proximo;
	}
	
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	
	public No<T> getAnterior() {
		return anterior;
	}
	
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	
}
