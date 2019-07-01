<template>
  <div v-if="this.customer">
    <h4>Cliente</h4>
    <div>
      <label>Nome: </label> {{this.customer.name}}
    </div>
    <div>
      <label>Idade: </label> {{this.customer.age}}
    </div>
    <div>
      <label>Ativo: </label> {{this.customer.active}}
    </div>  
    <button v-if="this.customer.active"
      v-on:click="updateActive(false)"
      class="button btn-primary">Inactive</button>
    <button v-else
      v-on:click="updateActive(true)"
      class="button btn-primary">Active</button>
    <button class="button btn-danger" v-on:click="deleteCustomer()">Delete</button>
	<br>
			<div class="submitform">
				<div v-if="customer.address != null">
					<div class="form-group">
					<label for="name">Rua</label>
					<input type="text" class="form-control" id="street" required v-model.trim="customer.address.street" name="street">
					</div>
					<div class="form-group">
					<label for="age">Numero</label>
					<input type="number" class="form-control" id="placenumber" required v-model.trim="customer.address.placenumber" name="placenumber">
					</div>
					<div class="form-group">
					<label for="age">Codigo postal</label>
					<input type="number" class="form-control" id="postalcode" required v-model.trim="customer.address.postalcode" name="postalcode">
					</div>
					<button v-on:click="addAddress" class="btn btn-success">Salvar</button>
				</div>
				<div v-else>
				<h2> Cadastrar Endereço:</h2>
					<div class="submitform">
					<div v-if="!submittedAddress">
						<div class="form-group">
						<label for="name">Rua</label>
						<input type="text" class="form-control" id="street" required v-model="customer.address.street" name="street">
						</div>
						<div class="form-group">
						<label for="age">Numero</label>
						<input type="number" class="form-control" id="placenumber" required name="placenumber">
						</div>
						<div class="form-group">
						<label for="age">Código postal</label>
						<input type="number" class="form-control" id="postalcode" required name="postalcode">
						</div>
						<button v-on:click="addAddress" class="btn btn-success">Salvar</button>
					</div>
					<div v-else>
					<h4> Nenhum endereço!</h4>
					</div>
				</div>
				</div>
			</div>
  		
  </div>
  <div v-else>
    <br/>
    <p>Selecione um cliente...</p>
  </div>
</template>
 
<script>
import http from "../http-common";
 
export default {
  name: "customer",
  props: ["customer"],
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
	  submittedAddress: false
    };
  },
  methods: {
    /* eslint-disable no-console */
    updateActive(status) {
      var data = {
        id: this.customer.id,
        name: this.customer.name,
        age: this.customer.age,
		active: status,
		address: this.customer.address
      };
 
      http
        .put("/customer/" + this.customer.id, data)
        .then(response => {
          this.customer.active = response.data.active;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
	},
    deleteCustomer() {
      http
        .delete("/customer/" + this.customer.id)
        .then(response => {
          console.log(response.data);
          this.$emit("refreshData");
		  this.mensagem = "Usuario deletado!";
		  console.log(this.mensagem); 
		  this.$router.push({name: 'customers', params: { message:this.mensagem }});
        })
        .catch(e => {
          console.log(e);
        });
	},
	/* eslint-disable no-console */
    addAddress() {
      var data = {
		street: '',
		placenumber: '',
		postalcode: ''
      };
 
      http
        .post("/address", data)
        .then(response => {
		  this.customer.id = response.data.id;
		  this.customer = response.data.customer;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
 
	  this.submittedAddress = true;
    },
    newAddress() {
      this.submittedAddress = false;
	  this.customer = {};
    }
    /* eslint-enable no-console */
  }
};
</script>