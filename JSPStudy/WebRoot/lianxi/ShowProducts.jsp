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
            products.put("1", new Product("1", "mp3播放器",  
                    "效果很不错的mp3播放器，存储空间达1GB", 100.00));  
            products.put("2", new Product("2", "数码相机", "象素500万，10倍光学变焦",  
                    500.00));  
            products.put("3", new Product("3", "数码摄像机",  
                    "120万象素，支持夜景拍摄，20倍光学变焦", 200.00));  
            products.put("4", new Product("4", "迷你mp4",  
                    "市面所能见到的最好的mp4播放器，国产", 300.00));  
            products.put("5", new Product("5", "多功能手机",  
                    "集mp3播放、100万象素数码相机，手机功能于一体", 400.00));  
            products.put("6", new Product("6", "多功能手机111",  
                    "集mp3播放23、100万象素数码相机111，手机功能于一体111",600.00));  
            products.put("7", new Product("7", "11111111111",  
                    "集mp3播放23、100万象素数码相机111，手机功能于一体111",700.00));  
            products.put("8", new Product("8", "2222222222",  
                    "集mp3播放23、100万象素数码相机111，手机功能于一体111",800.00));  
            products.put("9", new Product("9", "33333333333333",  
                    "集mp3播放23、100万象素数码相机111，手机功能于一体111",900.00));  
            session.setAttribute("products", products);  
        %>  
        <H1>  
            产品显示  
        </H1>  
  
        <form name="productForm"  
            action="http://localhost:8088/JSPlearning/ShopCartJSP.jsp"  
            method="POST">  
            <input type="hidden" name="action" value="purchase">  
            <table border="1" cellspacing="0">  
                <tr bgcolor="#CCCCCC">  
                    <tr bgcolor="#CCCCCC">  
                        <td>  
                            序号  
                        </td>  
                        <td>  
                            产品名称  
                        </td>  
                        <td>  
                            产品描述  
                        </td>  
                        <td>  
                            产品单价（￥）  
                        </td>  
              
                        <td>  
                            添加到购物车  
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
                            <a href="Buy.jsp?id=<%=product.getId()%>&action=add" target="cart">我要购买</a>  
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
