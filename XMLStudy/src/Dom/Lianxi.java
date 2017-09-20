package Dom;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Lianxi {

	public Lianxi() {
		try {
			Document doc = null;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File("Student.xml");
			doc = db.parse(file);
			Node node = doc.getFirstChild();
			play(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void play(Node node){
		if(node.getAttributes().getLength()==0){
			System.out.println("<"+node.getNodeName()+">");
		}else {
			NamedNodeMap nn = node.getAttributes();
			String str = "";
			for(int j=0;j<nn.getLength();j++){
				Node n = nn.item(j);
				str += " "+n.getNodeName()+"='"+n.getTextContent()+"' ";
			}
			System.out.println("<"+node.getNodeName()+str+">");
		}
		NodeList list = node.getChildNodes();
		for(int i=0;i<list.getLength();i++){
			Node no = list.item(i);
			if(!no.getNodeName().equals("#text")){
				if(no.getChildNodes().getLength()>1){
					play(no);
				}else {
					NamedNodeMap nn = no.getAttributes();
					if(nn.getLength()==0){
						System.out.println("\t<"+no.getNodeName()+">"+no.getTextContent()+"</"+no.getNodeName()+">");
					}else {
						String str = "";
						for(int j=0;j<nn.getLength();j++){
							Node n = nn.item(j);
							str += " "+n.getNodeName()+"='"+n.getTextContent()+"' ";
						}
						System.out.println("\t<"+no.getNodeName()+str+">"+no.getTextContent()+"</"+no.getNodeName()+">");
					}
				}
			}
		}
		System.out.println("</"+node.getNodeName()+">");
	}
	public static void main(String[] args) {
		new Lianxi();
	}
}
