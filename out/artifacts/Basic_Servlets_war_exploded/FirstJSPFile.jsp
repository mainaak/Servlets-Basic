<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FirstJSPFile</title>
</head>
<body>
<%!
    public Integer calculateSum(Integer firstNumber, Integer secondNumber) {
        return (firstNumber + secondNumber);
    }

    public Integer calculateProduct(Integer firstNumber, Integer secondNumber) {
        Integer increments = firstNumber;
        for (int a = 1; a < secondNumber; a++)
            firstNumber += increments;
        return firstNumber;
    }
%>

<%
    Integer sum = calculateSum(5, 15);
%>

The value of the sum is <%=sum%> <br/>
The value of product is <%=calculateProduct(5, 15)%> <br/>
Today's date is <%=new Date()%> <br/>
The init param name is <%=getServletConfig().getInitParameter("default")%>
</body>
</html>
