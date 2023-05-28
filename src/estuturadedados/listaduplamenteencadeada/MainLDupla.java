package estuturadedados.listaduplamenteencadeada;

public class MainLDupla {

	public static void main(String[] args) throws Exception {

		ListaDupla<Integer> listadupla = new ListaDupla<>();
		listadupla.incluir(2, 0);
		listadupla.incluir(5, 1);
		listadupla.incluir(7, 2);
		listadupla.incluir(0, 3);
		
		ListaDupla<Integer> subLista = listadupla.subLista(1, 3);
		/*
		 * listadupla.adicionarInicio(5); listadupla.adicionarFim(4);
		 * listadupla.adicionarMeio(6, 1); listadupla.removerFim();
		 */
		 

		System.out.println("Primeiro elemento: " + listadupla.getPrimeiro().getValor());

		System.out.println("Lista: ");
		// listadupla.percorrerLista();
//		listadupla.removerInicio();
//
//		System.out.println(listadupla.getTamanho());
//
		listadupla.percorrerLista();
		
	    System.out.println("Valores da sublista:");
	    No<Integer> noAtual = subLista.getPrimeiro();
	    while (noAtual != null) {
	        System.out.println(noAtual.getValor());
	        noAtual = noAtual.getProximo();
	    }
	}
}
