<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_submitupdate"
		method=post enctype="multipart/form-data">
		<input type="hidden" name="cust_id" value="<s:property value="cust_id"/>"/>
		<input type="hidden" name="uploadFile" value="<s:property value="uploadFile"/> ">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称 :</td>
								<td>
								<INPUT class=textbox id=sChannel2
											style="WIDTH: 180px" maxLength=50 name="cust_name" value="<s:property value="cust_name"/> ">
								</td>
								<td>客户级别 :</td>
								<td>
									<select name="baseDictLevel.dict_id" id="cust_level">
										<option value="">--请选择--</option>
									</select>
								</td>
							</TR>
							
							<TR>
								<td>信息来源 :</td>
								<td>
									<select name="baseDictSource.dict_id" id="cust_source">
										<option value="">--请选择--</option>
									</select>
								</td>
								<td>所属行业 :</td>
								<td>
									<select name="baseDictIndustry.dict_id" id="cust_industry">
										<option value="">--请选择--</option>

									</select>
								</td>
							</TR>
							<TR>
								
								
								<td>固定电话 :</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="${cust_phone }">
								</td>
								<td>移动电话 :</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="${cust_mobile }">
								</td>
							</TR>
							<tr>
								<td>公司资质图片:</td>
								<td>
									<input type="file" name="upload">
								</td>
							</tr>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
        $(this).ready(function(){
            // 异步查询数据列表数据 客户来源
            $.post("${pageContext.request.contextPath}/basedice_getResource.action",{"dict_type_code":"002"},function (data) {
                $(data).each(function (i,n) {
                    $("#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
                });
                // 匹配给定的属性是某个特定值的元素,通过字符串拼接ONJL取值栈中的数据。， prop方法设置或返回被选元素的属性和值。
                $("#cust_source option[value='"+<s:property value='baseDictSource.dict_id'/> +"']").prop("selected","selected");
            },"json");

            //所属行业
            $.post("${pageContext.request.contextPath}/basedice_getResource.action",{"dict_type_code":"001"},function (data) {
                $(data).each(function (i,n) {
                    $("#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
                });
                // 匹配给定的属性是某个特定值的元素,通过字符串拼接ONJL取值栈中的数据。， prop方法设置或返回被选元素的属性和值。
                $("#cust_industry option[value='"+<s:property value='baseDictIndustry.dict_id'/> +"']").prop("selected","selected");
            },"json");
            //客户级别
            $.post("${pageContext.request.contextPath}/basedice_getResource.action",{"dict_type_code":"006"},function (data) {
                $(data).each(function (i,n) {
                    $("#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
                });
                // 匹配给定的属性是某个特定值的元素,通过字符串拼接ONJL取值栈中的数据。， prop方法设置或返回被选元素的属性和值。
                $("#cust_level option[value='"+<s:property value='baseDictLevel.dict_id'/> +"']").prop("selected","selected");
            },"json");
        });
	</script>

</BODY>
</HTML>
