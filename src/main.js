import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Menu from './components/Menu.vue'
import Message from './components/Message.vue'

Vue.component('Menu', Menu)
Vue.component('Message', Message)
Vue.config.productionTip = false

new Vue({
	router,
	render: h => h(App)
}).$mount("#app");