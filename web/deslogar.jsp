<%-- 
    Document   : deslogar
    Created on : 02/02/2020, 18:39:30
    Author     : Jo�o Pedro

    P�gina para deslogar a ses�o salva.
--%>
<%
    session.invalidate(); //mata a sess�o
    response.sendRedirect("/Arte-E-Magia_tst/index.jsp"); //redireciona para a p�gina de login
%>   