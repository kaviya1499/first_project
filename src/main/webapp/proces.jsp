<%@ page language="java" %>
<%@ page import="java.util.*" %>
<%! 
  
%>
<%@ page import="insert.UserDao" %>
<jsp:useBean id="formHandler" class="test.FormBean" scope="request">
<jsp:setProperty name="formHandler" property="*"/>
</jsp:useBean>
<% 
int i = UserDao.save(formHandler);
if (formHandler.validate()) {
	if (i > 0) {
%>
<jsp:forward page="success.jsp"/>
<%
}
}else {
%>
<jsp:forward page="retry.jsp"/>
<%
}
%>