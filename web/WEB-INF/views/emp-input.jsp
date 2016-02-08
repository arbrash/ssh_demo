<%--
  Created by IntelliJ IDEA.
  User: Arbrash
  Date: 2016/2/6
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert</title>
    <script type="text/javascript" src="../../scripts/jquery-1.12.0.js"></script>
    <script type="text/javascript">

        $(function(){
            $("#name").change(function(){
                var val = $(this).val();
                val = $.trim(val);
                var $this = $(this);
                if(val != ""){

                    $this.nextAll("font").remove();

                    var url = "emp-validateName";
                    var args = {"name":val, "time":new Date()};
                    $.post(url, args, function(data){
                        if(data == "1"){
                            $this.after("<font color='green'>Name is valid.</font>");
                        }else if(data == "0"){
                            $this.after("<font color='red'>Name is already exist!</font>");
                        }else{
                            alert("Server error!");
                        }
                    })

                }else{
                    alert("Name cannot be null!");
                    this.focus();
                }
            });

        })

    </script>
</head>
<body>

    <s:debug/>
    <h4>Employee Input Page</h4>

    <s:form action="emp-save" method="post">

        <s:if test="id != null">
            <s:textfield id="name" name="name" label="Name" disabled="true"/>
            <s:hidden name="id"/>
            <%--Hidden area--%>
            <%--<s:hidden name="name"/>
            <s:hidden name="createtime"/>--%>
        </s:if>
        <s:else>
            <s:textfield id="name" name="name" label="Name"/>
        </s:else>

        <s:textfield name="email" label="Email"/>
        <s:textfield name="birth" label="Birth"/>
        <s:select list="#request.departments"
                  listKey="id" listValue="deptname" name="department.id"
                label="Department"/>
        <s:submit/>
    </s:form>


</body>
</html>
