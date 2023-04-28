package estuturadedados.ordenacao;

public class Main {

	public static void main(String[] args) {

		MergeSort merge = new MergeSort();
		BubbleSort b = new BubbleSort();
		QuickSort quick = new QuickSort();
		InsertionSort insertion = new InsertionSort();
		SelectionSort selection = new SelectionSort();

		int[] vetor = {10, 66, 9, 3, 88, 1, 5, 3, 7, 11, 15, 44};

		b.ordenar(vetor);

		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
