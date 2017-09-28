<%@page import="org.liko.framework.hibernate.dao.UserDao" %>
<jsp:useBean id="obj" class="org.liko.framework.hibernate.po.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>

<%
	int i = UserDao.save(obj);
	if (i > 0) {
		out.print("You are successfully registered!");
	}
%>