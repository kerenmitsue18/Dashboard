import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config';
import Slider from 'primevue/slider';
import VueSelect from "vue-select";

import mitt from 'mitt'


// import CSS resources
import 'primevue/resources/primevue.min.css'            // core 
import 'primevue/resources/themes/saga-blue/theme.css'  // theme
import 'primeicons/primeicons.css'                      // icons
import 'vue-select/dist/vue-select.css'

const emitter = mitt()
const app = createApp(App);

app.component("v-select", VueSelect);
app.component('Slider', Slider);
app.use(PrimeVue);
app.config.productionTip = false;
app.config.globalProperties.$emitter = emitter

const mountedApp = app.mount('#app');


