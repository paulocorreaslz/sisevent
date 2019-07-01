<template>
  <div class="submitform">
    <div v-if="!submitted">
        <div class="form-group">
          <label for="name">Nome</label>
          <input type="text" class="form-control" id="name" required v-model="customer.name" name="name">
        </div>
    
        <div class="form-group">
          <label for="age">Idade</label>
          <input type="number" class="form-control" id="age" required v-model="customer.age" name="age">
        </div>
    
        <button v-on:click="saveCustomer" class="btn btn-success">Submit</button>
    </div>
    
    <div v-else>
      <h4> Cliente cadastrado!</h4>
      <button class="btn btn-success" v-on:click="newCustomer">Add</button>
    </div>
  </div>
</template>
 
<script>
import http from "../http-common";
 
export default {
  name: "add-customer",
  data() {
    return {
      customer: {
        id: 0,
        name: "",
        age: 0,
		active: false,
		address: {
			id:0,
			street: "",
			placenumber: 0,
			postalcode:""
		}
      },
	  submitted: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    saveCustomer() {
      var data = {
        name: this.customer.name,
        age: this.customer.age
      };
 
      http
        .post("/customer", data)
        .then(response => {
		  this.customer.id = response.data.id;
		  this.customer = response.data.customer;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
 
	  this.submitted = true;
    },
    newCustomer() {
      this.submitted = false;
	  this.customer = {};
    }
    /* eslint-enable no-console */
  }
};
</script>