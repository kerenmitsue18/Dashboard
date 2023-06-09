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

    getFechas(){
        return axios.get(this.url + "get_fechas");
    }

}