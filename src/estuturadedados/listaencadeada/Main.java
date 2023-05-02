package estuturadedados.listaencadeada;

public class Main {
	
	public static void main(String[] args) {
		
		ListaLigada<Integer> lista = new ListaLigada<Integer>();
		lista.adicionar(1);
		lista.adicionar(2);
		lista.adicionar(3);
		lista.adicionar(4);
		
		System.out.println("Tamanho: " + lista.getTamanho());
		System.out.println("Primeiro: " + lista.getPrimeiro().getValor());
		System.out.println("Ultimo: " + lista.getUltimo().getValor());
		
		System.out.println("Lista: ");
		for (int i = 0; i < lista.getTamanho(); i++) {
			System.out.print(lista.get(i).getValor() + " ");
		}
		
//		System.out.println(lista.get(0).getValor());
//		System.out.println(lista.get(1).getValor());
//		System.out.println(lista.get(2).getValor());
//		System.out.println(lista.get(3).getValor());
		
		lista.remover(1);
		lista.remover(2);
		lista.remover(3);
		lista.remover(4);
		lista.adicionar(5);
		System.out.println(" ");
		System.out.println("Lista com o elemento removido: ");
		for (int i = 0; i < lista.getTamanho(); i++) {
			System.out.print(lista.get(i).getValor() + " ");
		}
		System.out.println(" ");
		System.out.println("Tamanho: " + lista.getTamanho());
	}
}
