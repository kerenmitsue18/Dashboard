import axios from 'axios';


export default class SeleccionarCarga{
    url = "http://localhost:8080/";

    getCarga(id_carga){ 
        return axios.get(this.url + "selected_carga/"+ id_carga);  
    }
}