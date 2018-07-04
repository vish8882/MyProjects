
class Fresh{
enum FreshJuiceSize{
	Small,Medium,Size
}
FreshJuiceSize size;
}
public class EnumExample {
public static void main(String[] args) {
	Fresh.FreshJuiceSize a= Fresh.FreshJuiceSize.Medium;
	System.out.println(a);
}
}
