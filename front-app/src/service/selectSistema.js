import axios from 'axios';


export default class selectSistema{
    url = "http://localhost:8080/";
    getAll() {return axios.get(this.url + "sistema");  }                        
}

