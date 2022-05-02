package question;

public class CatalanNumber {

  /**
   * (2n)! / (n+1)! n!
   *
   * @param args
   */
  public static void main(String[] args) {
    int n = 5;
    catalanByDP(n);
    catalanNumberByFormula(n);
  }

  public static void catalanByDP(int n) {
    int a[] = new int[n + 1];
    a[0] = 1;
    a[1] = 1;
    a[2] = 2;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        a[i] += a[i - j] * a[j - 1];
      }
    }
    System.out.println("Catalan by DP: " + a[n]);
  }

  public static void catalanNumberByFormula(int n) {
    int twoN = n * 2;
    int numerator = 1;
    int denominator = 1;
    for (int i = twoN; i >= 1; i--) {
      numerator = i * numerator;
      if (i <= n) {
        denominator = denominator * i;
      }
    }
    denominator = denominator * denominator * (n + 1);
    int catalan = numerator / denominator;
    System.out.println("Catalan by formula: " + catalan);
  }

}
