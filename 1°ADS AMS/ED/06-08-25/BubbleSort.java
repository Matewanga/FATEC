public class BubbleSort {
    public static void main(String[] args) {
        int[] array = { 15, 8, 12, 7, 10 };
        bubbleSort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }
}