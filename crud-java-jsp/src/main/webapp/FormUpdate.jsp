<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CRUD java - Atualizar usuarios </title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>    <nav class="navbar navbar-expand-lg bg-light">
      <div class="container-fluid">

        <button class="navbar-toggler" type="button" data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0 topnav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.html">HOME</a>
            </li>

            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="destino.html">DESTINO</a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="promocao.html">PROMOÇÕES</a>
            </li>

            <li>
              <a class="nav-link active" href="contato.html"> CONTATOS </a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="ListUsuario.jsp">Lista de Usuarios </a>
            </li>
          </ul>
        
        </div>
      </div>
    </nav>

    
<div class="container">
  <div class= "row">
     <div class="cold-np-7" >
       <hr>
          <h3> Atualizar Usuario </h3>
        <hr>
        <br>
        <form action="createandselect" method="GET" class="d-flex">
            <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o nome ou cpf " arial-label="seach"/>
            <button class="btn btn-outline-success me-2" type="submit"> Buscar </button>
          </form>
          <br>
        <form action="UpdateUsuario" method="post">
         <input value="${usuario.id}" name="id" style="Visibility:hidden">
      
 		<div class="form-floting mb-3">
 		  <input value="${usuario.nome}" name="nome" maxlength="30" type="text" class="form-control"> 
 		  <label> Nome Completo </label>
 	    </div>
 		
 		<div class="form-floting mb-3">
 		  <input  value="${usuario.cpf}" name="cpf" maxlength="11" type="text" class="form-control"> 
 		   <label> Cpf (apenas numeros ) </label>
 	    </div>
 	    
 		<div class="form-floting mb-3">
 		  <input  value="${usuario.telefone}" name="telefone" maxlength="30" type="text" class="form-control"> 
 		  <label> Telefone (apenas numeros) </label>
 	    </div>
 		
 		<div class="form-floting mb-3">
 		  <input  value="${usuario.email}" name="email" maxlength="30" type="text" class="form-control"> 
 		  <label> Email </label>
 	    </div>
 	    
 	    <div> Sexo 
 		  <input  value="${usuario.sexo}" type="radio" name="sexo" value="masculino"/>Masculino
 		  <input  value="${usuario.sexo}" type="radio" name="sexo" value="feminino"/>Feminino
 		</div>
 		<br>
 		
 	     <div> País
 		      <select name="pais">
 		         <option>Argentina</option>
 		         <option>Brasil</option>
 		         <option>EUA</option>
 		         <option>Portugal</option>
 		         <option>Outro</option>
 		      </select>
 		   </div>   
 		 <br>
 	 
 	<button class ="btn btn-success" type="subimit"> Atualizar dados de Usuario </button>
 	<button class ="btn btn-primary" type="subimit"> Limpar Formulário </button>
        </form>
        <br>
     </div>
  </div>
</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>