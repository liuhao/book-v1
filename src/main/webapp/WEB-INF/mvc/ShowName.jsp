<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
    <TITLE>Thanks for Registering</TITLE>
    <LINK REL=STYLESHEET
          HREF="/mvc/JSP-Styles.css"
          TYPE="text/css">
</HEAD>
<BODY>
<H1>Thanks for Registering</H1>
<jsp:useBean id="nameBean" type="com.coreservlets.book.mvc.NameBean"
             scope="session"/>
<H2>First Name:
    <jsp:getProperty name="nameBean" property="firstName"/>
</H2>

<H2>Last Name:
    <jsp:getProperty name="nameBean" property="lastName"/>
</H2>
</BODY>
</HTML>