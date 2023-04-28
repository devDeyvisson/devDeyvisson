package estuturadedados.ordenacao;

public class SelectionSort implements Ordenacao {

	// SELECTION SORT
	// Só faz a troca no final, diferente do bubble sort
	// que faz n^2 trocas. Por isso, ele é mais rápido.

	@Override
	public void ordenar(int[] vetor) {
		int posicaoMenor, aux;
		for (int i = 0; i < vetor.length; i++) { // O(n)
			posicaoMenor = i;
			for (int j = i + 1; j < vetor.length; j++) { // O(n)
				if (vetor[j] < vetor[posicaoMenor]) {
					posicaoMenor = j;
				}
			}
			aux = vetor[posicaoMenor];
			vetor[posicaoMenor] = vetor[i];
			vetor[i] = aux;
		}

	}
}
