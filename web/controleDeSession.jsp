<%@page import="entidades.Usuario"%>
<%
    Usuario usuarioLogado = null;
    if(session.getAttribute("usuarioLogado") != null){ //verifca se tem usuario na session
        usuarioLogado = (Usuario) session.getAttribute("usuarioLogado"); //salva usuario da session em uma variavel usuário
    }else{
        response.sendRedirect("/Arte-E-Magia_tst/index.jsp"); // caso a session for nula será redirecionado para o index
    }
%>
