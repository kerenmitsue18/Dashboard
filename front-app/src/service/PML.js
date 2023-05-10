import axios from 'axios';


export default class PML{
    url = "http://localhost:8080/";
    getMaxFecha() { return axios.get(this.url+ "maxFecha");  }
    getMinFecha() { return axios.get(this.url+ "minFecha");  }
    getAllPromedios(minFecha, maxFecha){ return axios.get(this.url + minFecha + "/fecha/"+ maxFecha);}


}