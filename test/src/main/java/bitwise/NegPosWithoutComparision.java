package bitwise;

public class NegPosWithoutComparision {

  public static void main(String[] args) {
    String[] arr = {"negative", "positive"};
    int n = -111;
    int index = (n >> 31)+1;
    System.out.println(arr[index]);
  }
}
