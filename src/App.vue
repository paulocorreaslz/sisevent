<template>
    <div id="app" class="container-fluid">
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
        <span v-if="this.message != null" class="alert alert-primary" role="alert">{{ this.message }}</span>
		<br>
		<router-view/>
		
    </div>
</template>
 
<script>
import CustomersListVue from './components/CustomersList.vue';
export default {
  name: "app",
  message: "",
  data(){
	  return {
		  message: this.$route.params.message
	  }
  }
  
};
</script>
