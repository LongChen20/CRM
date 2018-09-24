<%--
  Created by IntelliJ IDEA.
  User: LGCN
  Date: 2018/8/1
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>struts2入门配置。</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/user_test1.action" method="post">
                    <h2>第一种方式接收提交数据。完全解耦合方式。</h2><br/>
                    用户名:<input type="text" name="user"><br/>
                    密码:<input type="text" name="password"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/user_test2.action" method="post">
                    <h2>第二种方式接收提交数据。原生的方式。</h2><br/>
                    用户名:<input type="text" name="user"><br/>
                    密码:<input type="text" name="password"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/user_test3.action" method="post">
                    <h2>第三种方式接收提交数据。接口注入。</h2><br/>
                    用户名:<input type="text" name="user"><br/>
                    密码:<input type="text" name="password"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/user_property1.action" method="post">
                    <h2>接收数据，封装到对象，属性驱动(set个个属性)</h2><br/>
                    名字:<input type="text" name="cust_name"><br/>
                    来源:<input type="text" name="cust_source"><br/>
                    行业:<input type="text" name="cust_industry"><br/>
                    级别:<input type="text" name="cust_level"><br/>
                    电话:<input type="text" name="cust_phone"><br/>
                    手机:<input type="text" name="cust_mobile"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/user_property2.action" method="post">
                    <h2>接收数据，封装到对象，属性驱动(POJO)</h2><br/>
                    名字:<input type="text" name="customer.cust_name"><br/>
                    来源:<input type="text" name="customer.cust_source"><br/>
                    行业:<input type="text" name="customer.cust_industry"><br/>
                    级别:<input type="text" name="customer.cust_level"><br/>
                    电话:<input type="text" name="customer.cust_phone"><br/>
                    手机:<input type="text" name="customer.cust_mobile"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/user_property3.action" method="post">
                    <h2>接收数据，封装到对象，模型驱动</h2><br/>
                    名字:<input type="text" name="cust_name"><br/>
                    来源:<input type="text" name="cust_source"><br/>
                    行业:<input type="text" name="cust_industry"><br/>
                    级别:<input type="text" name="cust_level"><br/>
                    电话:<input type="text" name="cust_phone"><br/>
                    手机:<input type="text" name="cust_mobile"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>

        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/collection_property4.action" method="post">
                    <h2>接收数据，封装到List</h2><br/>
                    名字:<input type="text" name="customers[0].cust_name"><br/>
                    来源:<input type="text" name="customers[0].cust_source"><br/>
                    行业:<input type="text" name="customers[0].cust_industry"><br/>
                    级别:<input type="text" name="customers[1].cust_level"><br/>
                    电话:<input type="text" name="customers[1].cust_phone"><br/>
                    手机:<input type="text" name="customers[1].cust_mobile"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>

            <td>
                <form action="${pageContext.request.contextPath}/collection_property5.action" method="post">
                    <h2>接收数据，封装到Map</h2><br/>
                    名字:<input type="text" name="map['A'].cust_name"><br/>
                    来源:<input type="text" name="map['A'].cust_source"><br/>
                    行业:<input type="text" name="map['B'].cust_industry"><br/>
                    级别:<input type="text" name="map['B'].cust_level"><br/>
                    电话:<input type="text" name="map['C'].cust_phone"><br/>
                    手机:<input type="text" name="map['C'].cust_mobile"><br/>
                    <input type="submit" value="提交">
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
