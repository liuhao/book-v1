<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Second of four possible bank-account-display pages
that illustrate the MVC approach.

Taken from Core Servlets and JavaServer Pages 2nd Edition
from Prentice Hall and Sun Microsystems Press,
http://www.coreservlets.com/.
(C) 2003 Marty Hall; may be freely used or adapted.
-->
<HTML>
<HEAD>
    <TITLE>You Owe Us Money!</TITLE>
    <LINK REL=STYLESHEET
          HREF="/mvc/JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
    <TR>
    <TH CLASS="TITLE">
        We Know Where You Live!
</TABLE>
<P>
    <IMG SRC="/mvc/Club.gif" ALIGN="LEFT">
    <jsp:useBean id="badCustomer"
                 type="com.coreservlets.book.mvc.BankCustomer"
                 scope="request"/>
    Watch out,
    <jsp:getProperty name="badCustomer" property="firstName"/>,
    we know where you live.

<P>
    Pay us the
    $<jsp:getProperty name="badCustomer" property="balanceNoSign"/>
    you owe us before it is too late!
</BODY>
</HTML>