package estuturadedados.listaencadeada;

public class ListaLigada<TIPO> implements InterfaceEncadeada<TIPO> {
//agora ela é generica
//serve para definir o tipo da lista que 
//nesse caso é a classe
// é um tipo que eu vou definir na hora de utilizar a lista
	private Elemento<TIPO> primeiro;
	private Elemento<TIPO> ultimo;
	private int tamanho;

	public ListaLigada() {
		this.tamanho = 0;
	}

	public Elemento<TIPO> getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Elemento<TIPO> primeiro) {
		this.primeiro = primeiro;
	}

	public Elemento<TIPO> getUltimo() {
		return ultimo;
	}

	public void setUltimo(Elemento<TIPO> ultimo) {
		this.ultimo = ultimo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public void adicionar(TIPO novoValor) {
		Elemento<TIPO> novoElemento = new Elemento<TIPO>(novoValor);
		if (this.primeiro == null && this.ultimo == null) {
			this.primeiro = novoElemento;
			this.ultimo = novoElemento;
		} else {
			this.ultimo.setProximo(novoElemento);
			this.ultimo = novoElemento;
		}
		this.tamanho++;
	}

	@Override
	public void remover(TIPO valorProcurado) {
		Elemento<TIPO> anterior = null;
		Elemento<TIPO> atual = this.primeiro;
		for (int i = 0; i < this.getTamanho(); i++) {

			if (atual.getValor().equals(valorProcurado)) {
				if (this.tamanho == 1) {
					this.primeiro = null;
					this.ultimo = null;
				} else if (atual == primeiro) {
					this.primeiro = atual.getProximo();
					atual.setProximo(null);
				} else if (atual == ultimo) {
					this.ultimo = anterior;
					anterior.setProximo(null);
				} else {
					anterior.setProximo(atual.getProximo());
					atual = null;
				}
				this.tamanho--;
				break;
			}
			anterior = atual;
			atual = atual.getProximo();

		}
	}

	// Busca o elemento de acordo com a posição que
	// eu informar
	@Override
	public Elemento<TIPO> get(int posicao) /* throws Exception */ {
		Elemento<TIPO> atual = this.primeiro;
		for (int i = 0; i < posicao; i++) {
			if (atual.getProximo() != null) {
				atual = atual.getProximo();
			}
			/*
			 * if (atual.getProximo() == null) { throw new Exception("lista nula"); }
			 */
		}
		return atual;
	}

}
