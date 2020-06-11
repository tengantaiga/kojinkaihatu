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

<p>これでよろしいですか？</p>

  <c:if test="${not empty errMsg}">
    <p class="error">${fn:escapeXml(errMsg)}</p>
  </c:if>

  <form:form action="create" method="post" modelAttribute="selectForm">
    <fieldset class="label-130">
      <div>
        <label><fmt:message key="lbl.party.name" /></label>
        <form:input path="partyName" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.party.date" /></label>
        <form:input type="date" path="partyDate" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.party.place" /></label>
        <form:input path="partyPlace" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.party.come" /></label>
        <form:input path="partyCome" readonly="true" />
      </div>
      <div>
        <label><fmt:message key="lbl.pass" /> <fmt:message
             key="lbl.confirm.input" /></label>
                      <form:password path="confirmPass" />
      </div>
    </fieldset>

      <div>
      <form:button name="create">
        <fmt:message key="btn.partyinsert" />
      </form:button>
      <form:button name="back">
        <fmt:message key="btn.back" />
      </form:button>
    </div>
  </form:form>


</body>
</html>