package Dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public void readXMl(String file){
		Document dom = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.parse(file);
			Node node = dom.getFirstChild();
			play(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void play(Node node){
		
		if(node.getChildNodes().getLength()==0){
			System.out.println("<"+node.getNodeName()+">");
		}else {
			NamedNodeMap n = node.getAttributes();
			String str = "";
			for (int i = 0; i < n.getLength(); i++) {
				Node no = n.item(i);
				str+=no.getNodeName()+"='"+no.getTextContent()+"' ";
			}
			System.out.println("<"+node.getNodeName()+" "+str+">");
		}
		NodeList nodelist = node.getChildNodes();
		for(int i=0;i<nodelist.getLength();i++){
			Node nodechildren = nodelist.item(i); 
			String text = nodechildren.getTextContent().trim();
			if(!nodechildren.getNodeName().equals("#text")){
				if(nodechildren.getChildNodes().getLength()>1){
					play(nodechildren);
				}else {
					NamedNodeMap n = nodechildren.getAttributes();
					if(n.getLength()==0){
						System.out.println("\t<"+nodechildren.getNodeName()+">"+nodechildren.getTextContent()+"</"+nodechildren.getNodeName()+">");
					}else {
						String str = "";
						for(int j=0;j<n.getLength();j++){
							Node no = n.item(j);
							str+=no.getNodeName()+"='"+no.getTextContent()+"'\t";
						}
						System.out.println("\t<"+nodechildren.getNodeName()+"  "+str+">"+nodechildren.getNodeName()+"</"+nodechildren.getNodeName()+">");
					}
				}
			}else if(!text.equals("")){
				System.out.println("\t"+text);
			}
		}
		System.out.println("</"+node.getNodeName()+">");
	}
	public static void main(String[] args) {
		new ReadXMLFile().readXMl("Student.xml");
	}
}
