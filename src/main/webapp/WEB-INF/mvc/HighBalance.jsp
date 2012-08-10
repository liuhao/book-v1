<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Fourth of four possible bank-account-display pages
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
          HREF="/mvc/JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
    <TR>
    <TH CLASS="TITLE">
        Your Balance
</TABLE>
<P>
<CENTER><IMG SRC="/mvc/Sailing.gif"></CENTER>
<BR CLEAR="ALL">
<jsp:useBean id="eliteCustomer"
             type="com.coreservlets.book.mvc.BankCustomer"
             scope="request"/>
It is an honor to serve you,
<jsp:getProperty name="eliteCustomer" property="firstName"/>
<jsp:getProperty name="eliteCustomer" property="lastName"/>
!
<P>
    Since you are one of our most valued customers, we would like
    to offer you the opportunity to spend a mere fraction of your
    $<jsp:getProperty name="eliteCustomer" property="balance"/>
    on a boat worthy of your status. Please visit our boat store for
    more information.
</BODY>
</HTML>