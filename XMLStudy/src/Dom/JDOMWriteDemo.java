package Dom;

import java.io.File;
import java.io.FileWriter;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDOMWriteDemo {

	public void writexml(){
		try {
			File file = new File("Student.xml");
			//子元素
			Element element = new Element("姓名");
			element.setText("张三");
			//添加属性
			Attribute att = new Attribute("编号","P1001");
			element.setAttribute(att);
			Element element1 = new Element("年龄");
			element1.setText("20");
			Element element2 = new Element("民族");
			element2.setText("汉族");
			Element element3 = new Element("学历");
			element3.setText("本科");
			Element element4 = new Element("性别");
			element4.setText("男");
			Element element5 = new Element("配偶信息");
			Attribute att1 = new Attribute("配偶编号","P1002");
			Attribute att2 = new Attribute("出生日期","1997-02-02");
			element5.setAttribute(att1);
			element5.setAttribute(att2);
			Element element6 = new Element("姓名");
			element6.setText("小丽");
			Element element7 = new Element("性别");
			element7.setText("女");
			element5.addContent(element6);
			element5.addContent(element7);
			//父元素
			Element person = new Element("张三简介");
			person.addContent(element);
			person.addContent(element1);
			person.addContent(element2);
			person.addContent(element3);
			person.addContent(element4);
			person.addContent(element5);
			//创建根元素
			Element root = new Element("个人信息");
			root.addContent(person);
			//创建文档
			Document doc = new Document(root); 
			//格式化文件
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat().setEncoding("gbk"));
			//写入文件
			FileWriter fw = new FileWriter(new File("people.xml"));
			out.output(doc, fw);
			//文件的读取
			out.output(doc, System.out);
			System.out.println("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JDOMWriteDemo().writexml();
	}
}
