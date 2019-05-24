<%@tag import="java.util.Date"%>
<%@tag import="java.text.SimpleDateFormat"%>
<%@ tag body-content="empty" pageEncoding="UTF-8"%>
<%-- <%@tag body-content="scriptless" %> --%>
<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>
<jsp:doBody/>

