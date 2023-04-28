package estuturadedados.ordenacao;

public class InsertionSort implements Ordenacao {

	@Override
	public void ordenar(int[] vetor) {

		// INSERTION SORT
		int aux, j;
		for (int i = 1; i < vetor.length; i++) {
			aux = vetor[i];
			j = i - 1;
			while (j >= 0 && vetor[j] > aux) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			vetor[j + 1] = aux;
		}
	}
}
