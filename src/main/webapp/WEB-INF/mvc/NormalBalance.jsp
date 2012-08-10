<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Third of four possible bank-account-display pages
that illustrate the MVC approach.

Taken from Core Servlets and JavaServer Pages 2nd Edition
from Prentice Hall and Sun Microsystems Press,
http://www.coreservlets.com/.
(C) 2003 Marty Hall; may be freely used or adapted.
-->
<HTML>
<HEAD>
    <TITLE>Your Balance</TITLE>
    <LINK REL=STYLESHEET
          HREF="/bank-support/JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
    <TR>
    <TH CLASS="TITLE">
        Your Balance
</TABLE>
<P>
    <IMG SRC="/mvc/Money.gif" ALIGN="RIGHT">
    <jsp:useBean id="regularCustomer"
                 type="com.coreservlets.book.mvc.BankCustomer"
                 scope="request"/>
<UL>
    <LI>First name:
        <jsp:getProperty name="regularCustomer"
                         property="firstName"/>
    <LI>Last name:
        <jsp:getProperty name="regularCustomer"
                         property="lastName"/>
    <LI>ID:
        <jsp:getProperty name="regularCustomer"
                         property="id"/>
    <LI>Balance: $<jsp:getProperty name="regularCustomer"
                                   property="balance"/>
</UL>
</BODY>
</HTML>