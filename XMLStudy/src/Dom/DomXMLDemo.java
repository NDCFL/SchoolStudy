package Dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXMLDemo {

	public void readXMLFile(){
		Document doc=null;
		//创建工厂实例
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		//是否检验XML文件内容的有效性
		dbf.setValidating(false);
		try {
			//创建文档对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			File file = new File("Student.xml");
			//解析xml文档
			doc = db.parse(file);
			//读取根节点
			Node root = doc.getFirstChild();
			display(root);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void display(Node root){
		System.out.println(root.getNodeName());
		//读取根节点的子节点列表
		NodeList nodeArr = root.getChildNodes();
		for(int i=0;i<nodeArr.getLength();i++){
			Node child = nodeArr.item(i);
			String val = child.getTextContent().trim(); 
			//处理元素节点
			if(!child.getNodeName().equals("#text")){
				//含有子元素的元素
				if(child.getChildNodes().getLength()>1){
					display(child); //递归调用
				}else{//叶子节点
					System.out.println(child.getNodeName()+"="+child.getTextContent());
				}
				//读取节点的属性列表
				 NamedNodeMap attrs = child.getAttributes();
				 if(attrs==null || attrs.getLength()==0){
					 continue;
				 }
				 System.out.print(child.getNodeName()+"的属性：");
				 for(int j=0;j<attrs.getLength();j++){
					 Node atrr = attrs.item(j);
					 System.out.print(atrr.getNodeName()+"="+atrr.getTextContent());
				 }
				 System.out.println();
			}else if(!val.equals("")){//文本节点的名称是#text，如果内容不为空就显示内容
				System.out.println("#text="+val);
			}
			
			
		}
	}
	public static void main(String[] args) {
		new DomXMLDemo().readXMLFile();
	}
}
