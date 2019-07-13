<template>
  <div class="searchform">
    <h4>Localizar por idade</h4>
    <div class="form-group">
      <input type="number" class="form-control" id="age" required v-model="age" name="age">
    </div>
	<div class="btn-group">
      <button v-on:click="searchCustomersAge" class="btn btn-success">Search</button>
    </div>
	<br>
	<h4>Localizar por nome</h4>
   <div class="form-group">
      <input type="text" class="form-control" id="name" required v-model="name" name="name">
    </div>
    <div class="btn-group">
      <button v-on:click="searchCustomersName" class="btn btn-success">Search</button>
    </div>
 
    <ul class="search-result">
	  <div v-if="verifyTotal() == 0">
		 <li> Nenhum! </li>
	  </div>
	  <div v-else>
		<li v-for="(customer, index) in customers" :key="index">
			<h6>{{customer.name}} (idade: {{customer.age}})</h6>
		</li>
	  </div>
    </ul>
  </div>
</template>
 
<script>
import http from "../http-common";
 
export default {
  name: "search-customer",
  data() {
    return {
		age: 0,
		name: '',
		customers: [],
		totalCustomers: 0
    };
  },  
  methods: {
	/* eslint-disable no-console */
	verifyTotal(){
	  if (this.customers.length == 0){
		  return this.totalCustomers = 0;
	  } else {
		  return this.totalCustomers = this.customers.length;
	  }
	},
    searchCustomersAge() {
      http
        .get("/customers/age/" + this.age)
        .then(response => {
          this.customers = response.data; // JSON are parsed automatically.
		  console.log(response.data);
		  this.verifyTotal();
        })
        .catch(e => {
          console.log(e);
        });
	},
	searchCustomersName() {
      http
        .get("/customers/name/" + this.name)
        .then(response => {
          this.customers = response.data; // JSON are parsed automatically.
		  console.log(response.data);
		  this.verifyTotal();
        })
        .catch(e => {
          console.log(e);
        });
	}
    /* eslint-enable no-console */
  },
  watch: {
	 
  }
};
</script>