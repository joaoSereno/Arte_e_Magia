<%@page import="entidades.Usuario"%>
<%@page import="persistence.UsuarioSQL"%>
<%
    String usuario = request.getParameter("usuario"); //recebe parametro do campo usuario da tela de login
    String senha = request.getParameter("senha"); //recebe parametro do campo senha da tela de login

    Usuario usuarioLogado = UsuarioSQL.verificaUsuarioLogin(usuario, senha);//chama método que busca o usuario no banco e seta na variavel do tipo Usuario

    if(usuarioLogado != null){ //se retornou alguma coisa do banco cai aqui
        
        session.setAttribute("usuarioLogado", usuarioLogado);//seta o usuario retornado pelo banco na session
        
        response.sendRedirect("paginaInicial.jsp"); //redireciona para a pagina de inicial
    }else{ //se não aqui
        response.sendRedirect("index.jsp?usarioInvalido=USUARIO_NAO_EXISTE"); //redireciona para a página de login novamente
    }
%>