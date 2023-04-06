import axios from 'axios';


export default class selectSistema{
    url = "http://localhost:8080/";
    getAll() { return axios.get(this.url + "nodos");  }

    getNodosBySistema(id_sistema){ 
        return axios.get(this.url + "selected_sistema/"+ id_sistema);  
    }
}