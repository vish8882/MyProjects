import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
 


import javax.net.ssl.HttpsURLConnection;
 
 
 
public class RefreshURL {
 
       public static void main(String[] args) {
             
              refresh();
       }
      
       public static void refresh(){
 
             
              URL url;
              try {
                     url = new URL("https://in.bookmyshow.com/buytickets/baahubali-2-the-conclusion-hindi-hyderabad/movie-hyd-ET00050679-MT/20170505");
      
              HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
              int responseCode = con.getResponseCode();
              System.out.println(responseCode);
              boolean result=false;
              int count = 0;
              BufferedReader buff = new BufferedReader( new InputStreamReader(con.getInputStream()));
             
              String response= null;
             
              while((response = buff.readLine()) != null)
              {
                     result=response.contains("PVR Forum Sujana Mall");
                     if(result)
                    	 break;
                     count++;
              }
              System.out.println(count);
              System.out.println(result);
              if(!result){
                     Thread.sleep(600000);
                     refresh();
              }
              else{
            	  File file = new File("D:/Series/The flash/The.Flash.2014.S02E14.HDTV.x264-LOL[ettv]/the.flash.2014.214.hdtv-lol[ettv].mp4");
            	  Desktop desktop = Desktop.getDesktop();
            	  if(file.exists())
            		  desktop.open(file);
              }
             
             
              }
              catch (Exception e) {
                     // TODO Auto-generated catch block
                     System.out.println(e.getMessage());
                     e.printStackTrace();
              }
              // TODO Auto-generated method stub
 
      
       }
 
}