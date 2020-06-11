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
<title>Insert title here</title>
</head>
<body>

	<p>
    飲み会情報を入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="createConfirm" method="post"
    modelAttribute="selectForm">
    <fieldset class="label-60">
      <div>
        <label class="required"><fmt:message key="lbl.party.name" /></label>
        <form:input path="partyName" />
        <form:errors path="partyName" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.pass" /></label>
        <form:password path="pass" showPassword="true" />
        <form:errors path="pass" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.party.date" /></label>
        <form:input type="date" path="partyDate" />
        <form:errors path="partyDate" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.party.place" /></label>
        <form:input path="partyPlace" />
        <form:errors path="partyPlace" class="error" />
      </div>
      <div>
        <label class="required"><fmt:message key="lbl.party.come" /></label>
        <form:input path="partyCome" />
        <form:errors path="partyCome" class="error" />
      </div>
    </fieldset>
    <form:button>
      <fmt:message key="btn.confirm" />
    </form:button>
  </form:form>
  <div>
    <a href="menu"><fmt:message key="btn.menu" /></a>
  </div>

</body>
</html>