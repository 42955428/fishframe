<%@page import="com.bestnet.bfb.erp.entity.RegUser"%>
<%@page import="com.bestnet.base.util.Constants"%>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<% 
RegUser user = (RegUser)session.getAttribute(com.bestnet.base.util.Constants.LOING_MEMBER_SESSION);
if(user!=null)
{
	session.removeAttribute(com.bestnet.base.util.Constants.LOING_MEMBER_SESSION);
	session.invalidate();
	java.util.Hashtable hashTable = (java.util.Hashtable)request.getSession().getServletContext().getAttribute("goalSession");
	hashTable.remove(user.getRegCode());
	
}
%>
<script type="text/javascript">

top.window.location.href="<%=request.getContextPath()%>/login.shtml";
</script>
