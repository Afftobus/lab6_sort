public class Sorter {
  private static int size;

  public static void sort(int[] a) {
    buildPiramid(a);
    while (size > 1) {
      swap(a, 0, size - 1);
      size--;
      toPiramid(a, 0);
    }
  }

  private static void buildPiramid(int[] a) {
    size = a.length;
    for (int i = a.length / 2; i >= 0; i--) {
      toPiramid(a, i);
    }
  }

  private static void toPiramid(int[] a, int i) {
    int l = 2 * i + 2;
    int r = 2 * i + 1;
    int largest = i;

    if (l < size && a[i] < a[l]) {
      largest = l;
    }

    if (r < size && a[largest] < a[r]) {
      largest = r;
    }

    if (i != largest) {
      swap(a, i, largest);
      toPiramid(a, largest);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }


}
