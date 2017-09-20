package SQLBase;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
  

public class OpenWeb {  
	  
	//只用来打开本地的html
	public OpenWeb(String URL){
		String url ="file:///" + new File(URL).getAbsolutePath().replace("\\","/");		
		try {  
			URI uri = new URI(url);  
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
	//只用来打开网页
	public OpenWeb(String net,String URL){
		try {  
			URI uri = new URI(URL);  
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
	public static void main(String[] args) {
		String net = "";
		new OpenWeb(net,"http://api.map.baidu.com/lbsapi/creatmap/index.html");
	}
}   

