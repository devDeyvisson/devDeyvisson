package estuturadedados.listaduplamenteencadeada;

public class ListaDupla<T> implements InterfaceListaDE<T> {

	private No<T> primeiro;
	private No<T> ultimo;
	private int tamanho;

	public ListaDupla() {
		this.primeiro = null;
		this.ultimo = null;
		this.tamanho = 0;
	}

	public No<T> getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(No<T> primeiro) {
		this.primeiro = primeiro;
	}

	public No<T> getUltimo() {
		return ultimo;
	}

	public void setUltimo(No<T> ultimo) {
		this.ultimo = ultimo;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public void incluir(T novoValor, int posicao) throws Exception {
		// Esse novoValor é o Elemento!
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição inexistente/ inválida!");
		}
		No<T> novoNo = new No<T>(novoValor);

		if (primeiro == null) {
			primeiro = novoNo;
			ultimo = novoNo;
		} else if (posicao == 0) {
			novoNo.setProximo(primeiro);
			primeiro.setAnterior(novoNo);
			primeiro = novoNo;
		} else if (posicao == tamanho) {
			ultimo.setProximo(novoNo);
			novoNo.setAnterior(ultimo);
			ultimo = novoNo;
		} else {
			No<T> noAtual = primeiro;
			for (int i = 0; i < posicao; i++) {
				noAtual = noAtual.getProximo();
			}

			No<T> noAnterior = noAtual.getAnterior();
			noAnterior.setProximo(novoNo);
			novoNo.setAnterior(noAnterior);
			novoNo.setProximo(noAtual);
			noAtual.setAnterior(novoNo);
		}
		tamanho++;
	}

	@Override
	public ListaDupla<T> subLista(int posInicio, int posFim) throws Exception {
		//Inicio e fim
		if (posInicio < 0 || posInicio >= tamanho || posFim < 0 || posFim >= tamanho || posInicio > posFim) {
			throw new Exception("Intervalo inexistente!");
		}
		ListaDupla<T> subLista = new ListaDupla<T>();
		No<T> noAtual = this.primeiro;

		int cont = 0;

		while (cont < posInicio) {
			noAtual = noAtual.getProximo();
			cont++;
		}

		for (int i = posInicio; i <= posFim; i++) {
			subLista.incluir(noAtual.getValor(), i - posInicio);
			noAtual = noAtual.getProximo();
		}
		return subLista;
	}

	@Override
	public void adicionarInicio(T novoValor) {
		No<T> novoNo = new No<>(novoValor);
		if (primeiro == null) {
			primeiro = novoNo;
			ultimo = novoNo;
		} else {
			novoNo.setProximo(primeiro);
			primeiro.setAnterior(novoNo);
			primeiro = novoNo;
		}
		tamanho++;
	}

	@Override
	public void adicionarMeio(T novoValor, int posicao) throws Exception {
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição inválida!");
		}
		if (posicao == 0) {
			adicionarInicio(novoValor);
		} else if (posicao == tamanho) {
			adicionarFim(novoValor);
		} else {
			No<T> novoNo = new No<T>(novoValor);
			No<T> noAtual = primeiro;
			for (int i = 0; i < posicao; i++) {
				noAtual = noAtual.getProximo();
			}

			No<T> noAnterior = noAtual.getAnterior();
			noAnterior.setProximo(novoNo);
			novoNo.setAnterior(noAnterior);
			novoNo.setProximo(noAtual);
			noAtual.setAnterior(novoNo);
			tamanho++;
		}
	}

	@Override
	public void adicionarFim(T novoValor) {
		No<T> novoNo = new No<>(novoValor);
		if (ultimo == null) {
			primeiro = novoNo;
			ultimo = novoNo;
		} else {
			novoNo.setAnterior(ultimo);
			ultimo.setProximo(novoNo);
			ultimo = novoNo;
		}
		tamanho++;
	}

	@Override
	public void removerInicio() throws Exception {
		if (primeiro == null) {
			throw new Exception("Lista já está vazia!");
		}
		if (primeiro == ultimo) {
			primeiro = null;
			ultimo = null;
		} else {
			primeiro = primeiro.getProximo();
			primeiro.setAnterior(null);
		}
		tamanho--;
	}

	@Override
	public void removerMeio(int posicao) throws Exception {
		if (posicao < 0 || posicao >= tamanho) {
			throw new Exception("Posição inexistente/ inválida!");
		}
		if (posicao == 0) {
			removerInicio();
		} else if (posicao == tamanho - 1) {
			removerFim();
		} else {
			No<T> noAtual = primeiro;
			for (int i = 0; i < posicao; i++) {
				noAtual = noAtual.getProximo();
			}
			No<T> noAnterior = noAtual.getAnterior();
			No<T> noPosterior = noAtual.getProximo();
			noAnterior.setProximo(noPosterior);
			noPosterior.setAnterior(noAnterior);
			tamanho--;
		}
	}

	@Override
	public void removerFim() throws Exception {
		if (this.ultimo == null) {
			throw new Exception("Lista já está vazia!");
		}
		if (this.ultimo == this.primeiro) {
			ultimo = null;
			primeiro = null;
		} else {
			ultimo = ultimo.getAnterior();
			ultimo.setProximo(null);
		}
		tamanho--;
	}

	@Override
	public int getPosicao(T valor) {
		No<T> noAtual = primeiro;
		int posicao = 0;
		while (noAtual != null) {
			if (noAtual.getValor().equals(valor)) {
				return posicao;
			}
			noAtual = noAtual.getProximo();
			posicao++;
		}
		return -1;
	}

	@Override
	public void percorrerLista() {
		No<T> noAtual = primeiro;
		while (noAtual != null) {
			System.out.print(noAtual.getValor() + " ");
			noAtual = noAtual.getProximo();
		}

	}
}
