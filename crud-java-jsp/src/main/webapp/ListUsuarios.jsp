<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="controllers.Usuariocreateandselect, dao.UsuarioDao, model.Usuario"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> CRUD java Lista de Usuarios</title>
<link rel="stylesheet" href="viagem.css">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>


<body class="logo">
  <div>
    <nav id="menu" class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="index.html">HOME</a>
        
        <button class="navbar-toggler" type="button" data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class=" navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="destino.html">DESTINO</a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="promocao.html">PROMOÇÕES</a>
            </li>

            <li>
              <a class="nav-link active" href="contato.html"> CONTATOS </a>
            </li>

          </ul>
          
          <input class="form-control me-2" type="search">
          <form class="d-flex" role="search">
           <button class="btn btn-outline-success me-2" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  </div>  
<br>
<h1 class="text-align: center"> Vumbora, Agência de Viagem </h1>

    
<div class="container">
  <div class= "row">
     <div class="cold-np-7" >
       <hr>
          <h3> Lista de Usuarios </h3>
        <hr>
         <form action="createandselect" method="GET" class="d-flex">
            <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o nome ou cpf " arial-label="seach"/>
            <button class="btn btn-outline-success me-2" type="submit"> Buscar </button>
          </form>
        <table class="table">
          <thead>
             <tr>
               <th>id</th>
               <th>Nome</th>
               <th>Cpf</th>
               <th>Telefone</th>
               <th>Email</th>
               <th>Sexo</th>
               <th>Pais</th>
               <th>Editar</th>
               <th>Excluir</th>
             </tr>
          </thead>
          <tbody>
                <c:forEach items="${usuarios}" var= "usuario">
           <tr>
              <td>${usuario.getId()}</td>
              <td>${usuario.getNome()}</td> 
              <td>${usuario.getCpf()}</td>
              <td>${usuario.getTelefone()}</td>
              <td>${usuario.getEmail()}</td>
              <td>${usuario.getSexo()}</td>
              <td>${usuario.getPais()}</td>
              
              <td><a href="UpdateUsuario?usuarioId=${usuario.getId()}"> Atualizar </a></td>
              <td><a href="DeleteUsuario?usuarioId=${usuario.getId()}"> Deletar </a></td>
             
           </tr>
               </c:forEach>  
         
            </tbody>
          </table>
         <h5><a href="index.html">Voltar para o cadastro de usuarios </a></h5>
      </div>
    </div>
  </div>
</div>
 
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>