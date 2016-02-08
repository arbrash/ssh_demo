<%--
  Created by IntelliJ IDEA.
  User: Arbrash
  Date: 2016/1/25
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../scripts/jquery-1.12.0.js"></script>
    <script type="text/javascript">

        $(function(){
            $(".delete").click(function(e){
                var name = $(this).next(":input").val();
                var flag = confirm("Delete " + name + "'s information?");
                if(flag){
                    var $tr = $(this).parent().parent();
                    var url = this.href;
                    var args = {"time":new Date()};
                    $.post(url, args, function(data){
                        if(data==1){
                            alert("Delete successful");
                            $tr.remove();
                        }else{
                            alert("Delete failed");
                        }
                    });
                }
                e.preventDefault();
            });
        })

    </script>

</head>
<body>
    <h4>Employee List Page</h4>

    <s:if test="#request.employees == null || #request.employees.size() == 0">
        No result!
    </s:if>
    <s:else>
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <td>ID</td>
                <td>NAME</td>
                <td>EMAIL</td>
                <td>BIRTH</td>
                <td>CREATETIME</td>
                <td>DEPT</td>
                <td>OPTION</td>
            </tr>
            <s:iterator value="#request.employees">
                <tr>
                    <td>${id}</td>
                    <td>${name}</td>
                    <td>${email}</td>
                    <td>
                        <s:date name="birth" format="yyyy-MM-dd"/>
                    </td>
                    <td>
                        <s:date name="createtime" format="yyyy-MM-dd hh:mm:ss"/>
                    </td>
                    <td>${department.deptname}</td>
                    <td>
                        <a href="emp-input?id=${id}">Edit</a> | <a href="emp-delete?id=${id}" class="delete">Delete</a>
                        <input type="hidden" value="${name}"/>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </s:else>
</body>
</html>
