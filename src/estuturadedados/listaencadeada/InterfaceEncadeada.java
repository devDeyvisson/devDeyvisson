package estuturadedados.listaencadeada;

public interface InterfaceEncadeada<TIPO> {

	public void remover(TIPO valorProcurado);
	public void adicionar(TIPO novoValor);
	public Elemento<TIPO> get(int posicao);
}
