<template>
		<div v-if="mensagem != ''" :msgalert="mensagem" @messageChanged="mensagem = $event" class="alert alert-success" role="alert">
			{{ mensagem }}
		</div>
</template>

<script>
export default {
  name: "Message",
  data(){
	  return {
		  mensagem: ''
	  }
  }
};
</script>