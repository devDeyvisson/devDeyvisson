package estuturadedados.listaduplamenteencadeada;

public interface InterfaceListaDE<T> {
	
	public void incluir(T valor, int posicao) throws Exception;
	public ListaDupla<T> subLista(int inicio, int fim) throws Exception;
	public void adicionarInicio(T valor);
	public void adicionarMeio(T valor, int posicao) throws Exception;
	public void adicionarFim(T valor);
	public void removerInicio() throws Exception;
	public void removerMeio(int posicao) throws Exception;
	public void removerFim() throws Exception;
	public void percorrerLista();
	int getPosicao(T valor);
}
