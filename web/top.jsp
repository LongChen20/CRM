<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD id=Head1>
<TITLE>顶部</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css>
BODY {
	PADDING-RIGHT: 0px;
	PADDING-LEFT: 0px;
	PADDING-BOTTOM: 0px;
	MARGIN: 0px;
	PADDING-TOP: 0px;
	BACKGROUND-COLOR: #2a8dc8
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

TD {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

DIV {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}

P {
	FONT-SIZE: 12px;
	COLOR: #003366;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif
}
</STYLE>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1 action="" method=post>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD width=10><IMG src="images/new_001.jpg" border=0></TD>
					<TD background=images/new_002.jpg><FONT size=5><B>客户关系管理系统v1.0</B></FONT></TD>
					<TD background=images/new_002.jpg>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD align=right height=35></TD>
								</TR>
								<s:if test="%{#session.loginUser}">
									<TR>
										<TD height=35 align="right">
											当前用户：${sessionScope.loginUser.user_name}
											&nbsp;&nbsp;&nbsp;&nbsp;
											<A href="#" target=_top><FONT color=red>修改密码</FONT></A>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<A href="${pageContext.request.contextPath}/user_outlogin.action" target=_top><FONT color=red>安全退出</FONT></A>
										</TD>
									</TR>
								</s:if>
								<s:else>
									<TR>
										<TD height=35 align="right">
											请管理员登陆·
											&nbsp;&nbsp;&nbsp;&nbsp;
											<A href="${pageContext.request.contextPath}/login.jsp" target=_top><FONT color=red>去登陆</FONT></A>
											&nbsp;&nbsp;&nbsp;&nbsp;
										</TD>
									</TR>
								</s:else>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=10><IMG src="images/new_003.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>
