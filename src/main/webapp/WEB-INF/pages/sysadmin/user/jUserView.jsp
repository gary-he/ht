<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户详细信息</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<!-- 	<li id="update"><a href="#" onclick="formSubmit('update','_self');this.blur();">更新</a></li> -->
	<li id="back"><a href="javascript:void(0)" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户详细信息
  </div> 
  
<div>


<div class="eXtremeTable" >
	<table id="ec_table" class="tableRegion" width="98%" >
		<tr class="odd" hidden="hidden">
			<td>用户id:</td>
			<td><input type="text" name="userId" value="${user.userId }"/></td>
			<td>用户信息id:</td>
			<td><input type="text" name="userInfo.userInfoId" value="${user.userInfo.userInfoId }"/></td>
		</tr>
		<tr class="odd">
			<td>用户名:</td>
			<td><span>${user.username }</span></td>
			<td>密码:</td>
			<td><span>                                                                                                         </span></td>
		</tr>
		<tr class="odd">
			<td>所属部门:</td>
			<td><span>${user.dept.deptName }</span></td>
			<td>真实姓名:</td>
			<td><span>${user.userInfo.name }</span></td>
		</tr>
		<tr class="odd">
			<td>身份证号:</td>
			<td><span>${user.userInfo.cardNo }</span></td>
			<td>上级领导:</td>
			<td><span>${user.userInfo.manager.name }</span></td>
		</tr>
		<tr class="odd">
			<td>入职日期:</td>
			<td><span><fmt:formatDate value="${user.userInfo.joinDate }" pattern="yyyy-MM-dd"/></span></td>
			<td>薪资:</td>
			<td><span>${user.userInfo.salary }</span></td>
		</tr>
		<tr class="odd">
			<td>出生日期:</td>
			<td><span><fmt:formatDate value="${user.userInfo.birthday }" pattern="yyyy-MM-dd"/></span></td>
			<td>性别:</td>
			<td><span>${user.userInfo.gender }</span></td>
		</tr>
		<tr class="odd">
			<td>岗位描述:</td>
			<td><span>${user.userInfo.station }</span></td>
			<td>电话号码:</td>
			<td><span>${user.userInfo.telephone }</span></td>
		</tr>
		<tr class="odd">
			<td>用户级别:</td>
			<td>
				<c:if test="${user.userInfo.userLevel==1 }"><span>总经理</span></c:if>
				<c:if test="${user.userInfo.userLevel==2 }"><span>副总</span></c:if>
				<c:if test="${user.userInfo.userLevel==3 }"><span>部门经理</span></c:if>
				<c:if test="${user.userInfo.userLevel==4 }"><span>普通员工</span></c:if>
			</td>
			<td>排序号:</td>
			<td><span>${user.userInfo.orderNo }</span></td>
		</tr>
		<tr class="odd">
			<td>状态:</td>
			<td colspan="3"><c:if test="${user.state==1 }"><span><font color="green">启用</font></span></c:if></td>
			<td colspan="3"><c:if test="${user.state==0 }"><span><font color="red">停用</font></span></c:if></td>
		</tr>
		<tr class="odd">
			<td>备注信息:</td>
			<td colspan="3"><span>${user.userInfo.remark }</span></td>
		</tr>
	</table>
</div>
 
</div>
</form>
</body>
</html>

