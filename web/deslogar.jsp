<%-- 
    Document   : deslogar
    Created on : 02/02/2020, 18:39:30
    Author     : João Pedro

    Página para deslogar a sesão salva.
--%>
<%
    session.invalidate(); //mata a sessão
    response.sendRedirect("/Arte-E-Magia_tst/index.jsp"); //redireciona para a página de login
%>   