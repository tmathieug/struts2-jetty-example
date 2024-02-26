<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title><s:text name="hello.message"/></title>
  <s:head/>
  <sx:head/>
</head>

<body>

    <h1>Resumen de factura: </h1>

    <s:set var="invoice" value="#session.invoice"/>
    <s:set var="totalAmount" value="#session.totalAmount"/>
    <p><strong>Concepto:</strong> <s:property value="#invoice.subject"/></p>
    <p><strong>Fecha de inicio:</strong> <s:property value="#invoice.dateFrom"/></p>
    <p><strong>Fecha de fin:</strong> <s:property value="#invoice.dateTo"/></p>
    <p><strong>Importe Bruto:</strong> <s:property value="#invoice.grossAmount"/></p>
    <p><strong>Importe Total (IVA incluido):</strong> <s:property value="#totalAmount"/></p>

</body>
</html>