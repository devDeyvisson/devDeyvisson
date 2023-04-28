package estuturadedados.ordenacao;

public class MergeSort implements Ordenacao {

	@Override
	public void ordenar(int[] vetor) {

		int[] auxiliar = new int[vetor.length];
		mergeSort(vetor, auxiliar, 0, vetor.length - 1);
	}

	public static void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim) {

		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetor, auxiliar, inicio, meio);
			mergeSort(vetor, auxiliar, meio + 1, fim);
			intercalar(vetor, auxiliar, inicio, meio, fim);
		}
	}

	private static void intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {

		for (int i = inicio; i <= fim; i++) {
			auxiliar[i] = vetor[i];
		}

		int esquerda = inicio;
		int direita = meio + 1;

		for (int i = inicio; i <= fim; i++) {
			if (esquerda > meio) {
				vetor[i] = auxiliar[direita++];
			} else if (direita > fim) {
				vetor[i] = auxiliar[esquerda++];
			} else if (auxiliar[esquerda] < auxiliar[direita]) {
				vetor[i] = auxiliar[esquerda++];
			} else {
				vetor[i] = auxiliar[direita++];
			}
		}
	}

}
