import { createApp } from 'vue'
import App from './App.vue'


import { PrimeVue }  from 'primevue/config';
import Slider from 'primevue/slider';
import { VueSelect } from "vue-select";
import 'vue-select/dist/vue-select.css';
import mitt from 'mitt'

const emitter = mitt()
const app = createApp(App);

app.component("v-select", VueSelect);
app.config.productionTip = false;
app.config.globalProperties.$emitter = emitter



// import CSS resources
import 'primevue/resources/primevue.min.css'            // core 
import 'primevue/resources/themes/saga-blue/theme.css'  // theme
import 'primeicons/primeicons.css'                      // icons
import 'vue-select/dist/vue-select.css'

const app = createApp(App);
app.use(PrimeVue);

app.component("v-select", VueSelect);
app.component('Slider', Slider);


const mountedApp = app.mount('#app');


