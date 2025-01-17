package question;

import java.util.regex.Pattern;

public class StringReverseWithSpecialChars {
	public static void main(String[] args) {
    	
    	String a = "Ra,m_is_a__boy. He_is_a_go,od_guy...w";
    	int j=a.length()-1;
    	String s1="";
    	int i=0;
    	Pattern p = Pattern.compile("['()@_.,!]");
    	while(j>=0){
    		if(!a.substring(j,j+1).matches("['()@_.,!]")){
    			if(!a.substring(i,i+1).matches("['()@_.,!]")){
    				s1=s1 + a.charAt(j);
    				i++;
    				j--;
    			}
    			else{
    				s1=s1 + a.charAt(i);
    				i++;
    			}
    		}
    		else {
    			j--;
    		}
    	}
    	while(i<a.length()){
    		s1=s1+a.charAt(i++);
    	}
    System.out.println(s1);
    
	}

}
