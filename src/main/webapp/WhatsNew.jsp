<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!--
Example of including files at request time.

Taken from Core Servlets and JavaServer Pages 2nd Edition
from Prentice Hall and Sun Microsystems Press,
http://www.coreservlets.com/.
(C) 2003 Marty Hall; may be freely used or adapted.
-->
<HTML>
<HEAD>
    <TITLE>What's New at JspNews.com</TITLE>
    <LINK REL=STYLESHEET
          HREF="JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
    <TR>
    <TH CLASS="TITLE">
        What's New at JspNews.com
</TABLE>
<P>
    Here is a summary of our three most recent news stories:
<OL>
    <LI><jsp:include page="/include_pages/Item1.html"/>
    <LI><jsp:include page="/include_pages/Item2.html"/>
    <LI><jsp:include page="/include_pages/Item3.html"/>
</OL>
</BODY>
</HTML>