<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>Random Number</TITLE>
    <LINK REL=STYLESHEET
          HREF="/mvc/JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<jsp:useBean id="randomNum" type="com.coreservlets.book.mvc.NumberBean"
             scope="request"/>
<H2>Random Number:
    <jsp:getProperty name="randomNum" property="number"/>
</H2>
</BODY>
</HTML>