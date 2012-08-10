<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>A Prime Number</TITLE>
    <LINK REL=STYLESHEET
          HREF="/mvc/JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<H1>A Prime Number</H1>
<jsp:useBean id="primeBean" type="com.coreservlets.book.mvc.PrimeBean"
             scope="application"/>
<jsp:getProperty name="primeBean" property="prime"/>
</BODY>
</HTML>