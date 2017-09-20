<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/5
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String  path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>SpringMVC入门</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/hui.css" />
</head>
<body>
<header class="hui-header">
    <div id="hui-back"></div>
    <h1>SpringMVC</h1>
</header>
<div class="hui-wrap">
    <div class="hui-center-title" style="margin-top:15px;"><h1>基本内容</h1></div>
    <div style="padding:28px 5px;">
        <div class="hui-tab">
            <div class="hui-tab-title">
                <div>hello实例</div>
                <div>配置讲解</div>
                <div>其他的配置</div>
                <div>文件上传下载</div>
            </div>
            <div class="hui-tab-body">
                <div class="hui-tab-item hui-list">
                    <ul>
                        <li>hello实例</li>
                        <li>@Controller注解为控制器；</li>
                        <li>@RequestMapping("/first")映射控制器的访问路径</li>
                        <li>@RequestMapping(value="/hellow")映射控制器的方法的访问路径</li>
                        <li>@RequestMapping("/first")+@RequestMapping(value="/hellow")映射唯一的方法</li>
                    </ul>
                </div>
                <div class="hui-tab-item hui-list">
                    <ul>
                        <li>@Autowired：自动按照类型进行注入</li>
                        <li>@Resource：默认按照名称进行注入，若找不到方法则进行类型的注入</li>
                        <li>@GetMapping:通过get方法进行访问路径的注解</li>
                        <li>ModelAndView:该方法是把后台的数据反回到视图层</li>
                        <li>@PostMapping:通过post方法进行访问路径的注解</li>
                        <li>@RequestMapping("/findStudent/{id}"):通过RestForAPI的方式进行访问，{id}为参数，@PathVariable("id") 获取参数</li>
                    </ul>
                </div>
                <div class="hui-tab-item hui-list">
                    <ul>
                        <li>@Repository：DAO的注解</li>
                        <li>@Service:Service的注解</li>
                        <li>李克强访问圣彼得堡总理见17国领导人</li>
                        <li>英媒:释法系香港终结的开始 外交部:谢绝干涉</li>
                        <li>西安地铁三号线乘车全攻略：也有“区间车”</li>
                    </ul>
                </div>
                <div class="hui-tab-item hui-list">
                    <form action="<%=path%>/first/upload" method="post" enctype="multipart/form-data">
                        <input type="file" name="file" />
                        <input type="submit" value="上传">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=path%>/js/hui.js"></script>
<script src="<%=path%>/js/hui-tab.js" type="text/javascript"></script>
<script type="text/javascript">
    hui.tab('.hui-tab');
</script>
</body>
</html>