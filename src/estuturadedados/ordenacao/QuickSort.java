package estuturadedados.ordenacao;

public class QuickSort implements Ordenacao {

	@Override
	public void ordenar(int[] vetor) {
		quickSort(vetor, 0, vetor.length - 1);
	}

	static void quickSort(int[] vetor, int esquerda, int direita) {
		if (esquerda < direita) {
			int p = particao(vetor, esquerda, direita);
			// Repete o mesmo procedimento de partição
			quickSort(vetor, esquerda, p); // p = pivô
			quickSort(vetor, p + 1, direita);
		}
	}

	// Posições: //Menor = inicio //Maior = fim
	static int particao(int[] vetor, int esquerda, int direita) {
		int meio = (int) (esquerda + direita) / 2;
		int pivot = vetor[meio];
		int i = esquerda - 1;
		int j = direita + 1;

		while (true) {
			//
			do {
				i++;
			} while (vetor[i] < pivot);
			//
			do {
				j--;
			} while (vetor[j] > pivot);
			//
			if (i >= j) { // isso só irá ocorrer no final!!!!!!!!!
				return j;
			}
			int aux = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = aux;
		}
	}
}
