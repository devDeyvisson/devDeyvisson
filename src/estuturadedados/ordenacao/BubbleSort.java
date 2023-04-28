package estuturadedados.ordenacao;

public class BubbleSort implements Ordenacao {

	@Override
	public void ordenar(int[] vetor) {

		// BUBBLE SORT O(n^2)
		int aux;
		for (int i = 0; i < vetor.length; i++) { // O(n)
			for (int j = i + 1; j < vetor.length; j++) { // O(n)
				if (vetor[i] > vetor[j]) { // TROCA A POSIÇÃO
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
	}
}
