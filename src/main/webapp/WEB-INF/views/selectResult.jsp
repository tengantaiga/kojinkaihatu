<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="title.search.result" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <table>
    <caption>検索結果</caption>
    <thead>
      <tr>
        <th><fmt:message key="lbl.party.name" /></th>
        <th><fmt:message key="lbl.party.date" /></th>
        <th><fmt:message key="lbl.party.place" /></th>
        <th><fmt:message key="lbl.party.come" /></th>
      </tr>
    </thead>
    <tbody>
        <tr>
          <td>${fn:escapeXml(party.getPartyName())}</td>
          <td>${fn:escapeXml(party.getPartyDate())}</td>
          <td>${fn:escapeXml(party.getPartyPlace())}</td>
          <td>${fn:escapeXml(party.getCome())}</td>
        </tr>


    </tbody>
  </table>

  <table>
  <tr>
  	<th>参加者一覧</th>
  </tr>
  <c:forEach items="${joinlist}" var="join">
		<tr>
          <td>${fn:escapeXml(join.userName)}</td>
		</tr>
  </c:forEach>
  </table>

  <form:form action="join" modelAttribute="selectForm" method="post">

   		 <form:button>
     	 <fmt:message key="btn.join" />
    	</form:button>

  	</form:form>



  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>
</body>
</html>
