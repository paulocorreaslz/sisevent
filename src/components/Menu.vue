<template>
	<div class="mx-auto list">
	<div class="site-info">
            <h1>Aplicação</h1>
            <h3>Vue - Spring Boot MVC</h3>
        </div>
        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <router-link class="btn btn-primary" to="/">Clientes</router-link>
            <router-link class="btn btn-primary" to="/add">Adicionar</router-link>
            <router-link class="btn btn-primary" to="/search">Buscar</router-link>
        </nav>
		<br>
	</div>
</template>

<script>
export default {
  name: "Menu",
  data(){
	  return {
		  mensagem: ''
	  }
  }
};
</script>    