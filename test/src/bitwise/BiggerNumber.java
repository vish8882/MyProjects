package bitwise;

public class BiggerNumber {

  public static void main(String[] args) {
    int a = 876098;
    int b = 987978;

    int diff = b - a;

    int [] arr = {a,b};

    int index = (diff >> 31) + 1;

    System.out.println(arr[index] + " is greater than " + (b+a- arr[index]));

  }
}
