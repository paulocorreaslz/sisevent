<template>
    <div class="mx-auto list">
		<Message></Message>
		<p v-on:click="printPdf"> <a href="#"> Imprimir </a></p>
		<div class="table">
			<div class="tr">
				<div class="td">
					<h4>Lista de Clientes</h4>
					<ul>
						<li v-for="(customer, index) in customers" :key="index">
							<router-link :to="{
									name: 'customer-details',
									params: { customer: customer, id: customer.id }
								}">
									{{customer.name}}
							</router-link>
						</li>
					</ul>
				</div>
				<div class="td">
					<router-view @refreshData="refreshList"></router-view>
				</div>
			</div>
		</div>
    </div>
</template>
 
<script>
import http from "../http-common";

export default {
  name: "customers-list",
  props: ['msgalert'],
  data() {
    return {
	  customers: [],
	  messageList: "",
	};
  },
  methods: {
    /* eslint-disable no-console */
    retrieveCustomers() {
      http
        .get("/customers")
        .then(response => {
          this.customers = response.data; // JSON are parsed automatically.
		  console.log(response.data);
		  console.log("apos get customers");
		  this.messageList = this.$route.params.message;
		  console.log(this.messageList);
        })
        .catch(e => {
		  console.log(e);
		  alert(e);
        });
	},
    refreshList() {
      this.retrieveCustomers();
	},
	printPdf(){
		
		http
        .get("/getCustomerReport",{
            responseType: 'arraybuffer',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/pdf'
            }
        })
        .then(response => {
			
			// open in window pdf
			// var blob = new Blob([response.data], {
          	//	type: 'application/pdf'
		   	//});
		   	//var url = window.URL.createObjectURL(blob)
			//window.open(url);

			//download pdf
			const url = window.URL.createObjectURL(new Blob([response.data]));
            const link = document.createElement('a');
            link.href = url;
            link.setAttribute('download', 'file.pdf'); //or any other extension
            document.body.appendChild(link);
            link.click();
	   })
        .catch(e => {
		  console.log(e);
		  alert(e);
        });
	}
    /* eslint-enable no-console */
  },
  mounted() {
	this.retrieveCustomers();
  },
  watch: {
	$route(to, from){
		this.retrieveCustomers();
		this.refreshList();
	}
  }
};
</script>