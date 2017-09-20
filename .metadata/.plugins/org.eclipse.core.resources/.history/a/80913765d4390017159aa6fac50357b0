package Dom;

import java.io.File;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
public class JDOMDemo {

	public void readxml(String file1){
		SAXBuilder sb = new SAXBuilder();
		try {
			File file = new File(file1);
			Document doc = sb.build(file);
			Element element = doc.detachRootElement();
			play(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void play(Element element){
		if(element.getAttributes().size()==0){
			System.out.println("<"+element.getName()+">");
		}else {
			List<Attribute> atList = element.getAttributes();
			String str = "";
			for (Attribute attribute : atList) {
				str+=attribute.getName()+"='"+attribute.getValue()+"' ";
			}
			System.out.println("<"+element.getName()+" "+str+">");
		}
		List<Element> list = element.getChildren();
		for (Element e : list) {
			if(e.getChildren().size()>0){
				play(e);
			}else {
				if(e.getAttributes().size()==0){
					System.out.println("\t<"+e.getName()+">"+e.getValue()+"</"+e.getName()+">");
				}else {
					List<Attribute> atList = e.getAttributes();
					String str = "";
					for (Attribute attribute : atList) {
						str+=attribute.getName()+"='"+attribute.getValue()+"'";
					}
					System.out.println("\t<"+e.getName()+" "+str+">"+e.getValue()+"</"+e.getName()+">");
				}
			}
		}
		System.out.println("</"+element.getName()+">");
	}
	
	public static void main(String[] args) {
		new JDOMDemo().readxml("Student.xml");
	}
}
