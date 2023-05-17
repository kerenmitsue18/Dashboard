import { createApp } from 'vue'
import App from './App.vue'

import { VueSelect } from "vue-select";
import 'vue-select/dist/vue-select.css';
import mitt from 'mitt'



const emitter = mitt()
const app = createApp(App);



app.component("v-select", VueSelect);
app.config.productionTip = false;
app.config.globalProperties.$emitter = emitter




const mountedApp = app.mount('#app');


