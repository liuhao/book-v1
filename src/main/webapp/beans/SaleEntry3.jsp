<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Example of using jsp:setProperty and a general association
with the input parameters. See SaleEntry1.jsp
and SaleEntry2.jsp for alternatives.

Taken from Core Servlets and JavaServer Pages 2nd Edition
from Prentice Hall and Sun Microsystems Press,
http://www.coreservlets.com/.
(C) 2003 Marty Hall; may be freely used or adapted.
-->
<HTML>
<HEAD>
    <TITLE>Using jsp:setProperty</TITLE>
    <LINK REL=STYLESHEET
          HREF="JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<CENTER>
    <TABLE BORDER=5>
        <TR>
        <TH CLASS="TITLE">
            Using jsp:setProperty
    </TABLE>
    <jsp:useBean id="entry" class="com.coreservlets.book.beans.SaleEntry"/>
    <jsp:setProperty name="entry" property="*"/>
    <BR>
    <TABLE BORDER=1>
        <TR CLASS="COLORED">
            <TH>Item ID
            <TH>Unit Price
            <TH>Number Ordered
            <TH>Total Price
        <TR ALIGN="RIGHT">
            <TD><jsp:getProperty name="entry" property="itemID"/>
            <TD>$<jsp:getProperty name="entry" property="itemCost"/>
            <TD><jsp:getProperty name="entry" property="numItems"/>
            <TD>$<jsp:getProperty name="entry" property="totalCost"/>
    </TABLE>
</CENTER>
</BODY>
</HTML>