<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>  
<%@page import="T7.Product"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
          
        <title>My JSP 'ShowProductsJSP.jsp' starting page</title>  
  
        <meta http-equiv="pragma" content="no-cache">  
        <meta http-equiv="cache-control" content="no-cache">  
        <meta http-equiv="expires" content="0">  
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
        <meta http-equiv="description" content="This is my page">  
          
    </head>  
  
    <body bgcolor="#ffffff">  
        <%  
            Map products = new HashMap();  
            products.put("1", new Product("1", "mp3������",  
                    "Ч���ܲ����mp3���������洢�ռ��1GB", 100.00));  
            products.put("2", new Product("2", "�������", "����500��10����ѧ�佹",  
                    500.00));  
            products.put("3", new Product("3", "���������",  
                    "120�����أ�֧��ҹ�����㣬20����ѧ�佹", 200.00));  
            products.put("4", new Product("4", "����mp4",  
                    "�������ܼ�������õ�mp4������������", 300.00));  
            products.put("5", new Product("5", "�๦���ֻ�",  
                    "��mp3���š�100����������������ֻ�������һ��", 400.00));  
            products.put("6", new Product("6", "�๦���ֻ�111",  
                    "��mp3����23��100�������������111���ֻ�������һ��111",600.00));  
            products.put("7", new Product("7", "11111111111",  
                    "��mp3����23��100�������������111���ֻ�������һ��111",700.00));  
            products.put("8", new Product("8", "2222222222",  
                    "��mp3����23��100�������������111���ֻ�������һ��111",800.00));  
            products.put("9", new Product("9", "33333333333333",  
                    "��mp3����23��100�������������111���ֻ�������һ��111",900.00));  
            session.setAttribute("products", products);  
        %>  
        <H1>  
            ��Ʒ��ʾ  
        </H1>  
  
        <form name="productForm"  
            action="http://localhost:8088/JSPlearning/ShopCartJSP.jsp"  
            method="POST">  
            <input type="hidden" name="action" value="purchase">  
            <table border="1" cellspacing="0">  
                <tr bgcolor="#CCCCCC">  
                    <tr bgcolor="#CCCCCC">  
                        <td>  
                            ���  
                        </td>  
                        <td>  
                            ��Ʒ����  
                        </td>  
                        <td>  
                            ��Ʒ����  
                        </td>  
                        <td>  
                            ��Ʒ���ۣ�����  
                        </td>  
              
                        <td>  
                            ��ӵ����ﳵ  
                        </td>  
                    </tr>  
                    <%  
                        Set productIdSet = products.keySet();  
                        Iterator it = productIdSet.iterator();  
                        int number = 1;  
  
                        while (it.hasNext()) {  
                            String id = (String) it.next();  
                            Product product = (Product) products.get(id);  
                    %><tr>  
                        <td>  
                            <%=number++%>  
                        </td>  
                        <td>  
                            <%=product.getName()%>  
                        </td>  
                        <td><%=product.getDescription()%>  
                        </td>  
                        <td>  
                            <%=product.getPrice()%></td>  
                        <td>  
                            <a href="Buy.jsp?id=<%=product.getId()%>&action=add" target="cart">��Ҫ����</a>  
                        </td>  
                    </tr>  
                    <%  
                        }  
                    %>  
                  
            </table>  
            <p>  
            </p>  
        </form>  
    </body>  
</html>  
