package edu.ht.openexe;
import java.awt.Desktop;  
import java.io.IOException;  
import java.net.URI;  
import java.net.URISyntaxException;  
  
public class TestBrowse {  
 public static void main(String[] a) {  
  try {  
   URI uri = new URI("http://ke.qq.com/");  
   Desktop desktop = null;  
   if (Desktop.isDesktopSupported()) {  
    desktop = Desktop.getDesktop();  
   }  
   if (desktop != null)  
    desktop.browse(uri);  
  } catch (IOException ioe) {  
   ioe.printStackTrace();  
  } catch (URISyntaxException e) {  
   e.printStackTrace();  
  }  
 }  
} 