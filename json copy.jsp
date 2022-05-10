<%@ page contentType="application/xml; charset=utf-8" pageEncoding="utf-8" %>
{
    <%
        int end = Integer.parseInt(request.getParameter("cnt"));
        for(int i=0; i<end; i++) {
    %>
    "student":{
        "num" : <%=i+1%>,
        "name" : "user<%=i+1%>",
        "kor" : 90,
        "eng" : 80,
        "math" : 70,
    }
    <%}%>
}