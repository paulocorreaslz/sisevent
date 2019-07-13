<template>
    <div id="app" class="container-fluid">
		<Menu></Menu>
		<router-view/>
    </div>
</template>
 
<script>
export default {
  name: "app",
  msg: '',
  data(){
	  return {
		  msg: ""
	  }
  }
};
</script>
