<template>
<div id="Menu">
	<div class="site-info">
		<h1>Aplicação</h1>
		<h3>Vue - Spring Boot MVC</h3>
	</div>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<router-link class="btn btn-primary" to="/">Customers</router-link>
		<router-link class="btn btn-primary" to="/add">Add</router-link>
		<router-link class="btn btn-primary" to="/search">Search</router-link>
	</nav>
	<router-view/>
</div>
</template>
 
<script>

export default {
  name: "Menu"
};
</script>