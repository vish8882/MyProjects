package test;

public class Palindrome {

public static void main(String[] args) {
	
	String p="MALAYAALAM";
	int end =p.length();
	System.out.println(findPalindrome(p, 0, end-1));
}	

public static String findPalindrome(String p, int start, int end){
		
	if(start<=end)
	{
	if(p.charAt(start)==p.charAt(end)){
		return findPalindrome(p, start+1, end-1);
	}
	else{
		return "String Not a palindrome";
	}
	}
	return "Palindrome";
}
	
}
