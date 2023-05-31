import axios from 'axios';


export default class SeleccionarNodo{
    url = "http://localhost:8080/";
    getAll() { return axios.get(this.url + "nodos");  }

    getNodosBySistema(id_sistema){ 
        return axios.get(this.url + "selected_sistema/"+ id_sistema);  
    }

    getPromedios(id_nodo){
        return axios.get(this.url + "promedios/"+ id_nodo); 
    }

    async getMinFecha(){
        return axios.get(this.url + "minfecha"); 
    }

    async getMaxFecha(){
        return axios.get(this.url + "maxfecha"); 
    }
}