import axios from 'axios';


export default class PML{
    url = "http://localhost:8080/";
    getAllPromedios(){ return axios.get(this.url + "allPML");}
    getPromByFecha(minFecha, maxFecha){ return axios.get(this.url + minFecha + "/fecha/" + maxFecha); }


}