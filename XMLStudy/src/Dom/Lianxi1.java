package Dom;

import java.io.File;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class Lianxi1 {

	public void readfile(){
		try {
			File file = new File("Student.xml");
			SAXBuilder s = new SAXBuilder();
			Document doc =s.build(file);
			Element element = doc.detachRootElement();
			display(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void display(Element element){
		if(element.getAttributes().size()==0){
			System.out.println("<"+element.getName()+">");
		}else {
			List<Attribute> alist = element.getAttributes();
			String str = "";
			for (Attribute a : alist) {
				str += " "+a.getName()+"='"+a.getValue()+"' ";
			}
			System.out.println("<"+element.getName()+str+">");
		}
		List<Element> list = element.getChildren();
		for (Element e : list) {
			if(e.getChildren().size()>0){
				display(e);
			}else {
				if(e.getAttributes().size()==0){
					System.out.println("\t<"+e.getName()+">"+e.getValue()+"</"+e.getName()+">");
				}else {
					List<Attribute> alist = e.getAttributes();
					String str = "";
					for (Attribute a : alist) {
						str += " "+a.getName()+"='"+a.getValue()+"' ";
					}
					System.out.println("\t<"+e.getName()+str+">"+e.getValue()+"</"+e.getName()+">");
				}
			}
		}
		System.out.println("</"+element.getName()+">");
	}
	public static void main(String[] args) {
		new Lianxi1().readfile();
	}
}
