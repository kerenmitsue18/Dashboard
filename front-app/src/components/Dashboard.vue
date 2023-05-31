<template>
	<div v-if="!isLoading">
		<div class="col-6">
			<div class="form-group">
			<label>Sistema: </label>
			<select  v-model="selectSis"
			placeholder="Sistema">
					<option disabled value="">Sistema</option>
					<option value="Todos">Todos</option>
					<option v-for="sis in sistema" :value="sis">
						{{sis.nomenclatura}}
					</option>
				</select>
			</div>
		</div>
		<br>
		<div class="col-6">
			<div class="form-group">
			<label>Nodos: </label>
			<select  v-model="selectNod"
			placeholder="Nodo">
					<option disabled value="">Nodos</option>
					<option v-for="nodo in nodos" :value="nodo">
						{{nodo.id_nodo + " - " + nodo.clave}}
					</option>
				</select>
			</div>
		</div>
		<div >
			<h3>Range: {{getFecha(value[0])}}, {{ getFecha(value[1]) }}</h3>
			<Slider  v-model="value" :range="true" :min="minVal" :max="maxVal" :step="stepVal" />
		</div>

		<div>
			<br>
			<table>
					<tr>
						<th>Clave nodo</th>
						<th>Nombre</th>
						<th>Zona Distribución</th>
						<th>Zona Carga</th>
						<th>Promedio PML Histótico mpx/Wh</th>
						<th>Congestión</th>
						<th>Energía</th>
						<th>Pérdidas</th>
					</tr>
					<tr>
						<td>{{selectNod.clave}}</td>
						<td>{{selectNod.nombre_nodo}}</td>
						<td>{{distribucion.zona_distribucion}}</td>
						<td>{{carga.zona_carga}}</td>
						<td>{{promedios.precio_marginal}}</td>
						<td>{{promedios.comp_congestion}}</td>
						<td>{{promedios.comp_energia}}</td>
						<td>{{promedios.comp_perdidas}}</td>
					</tr>
			</table>
		</div>
	</div>
</template>


<script>
	import axios from "axios";
	import SeleccionarSistema from '../service/selectSistema';
	import SeleccionarNodo from '../service/selectNodo';
	export default{
		name : 'Dashboard',
		SeleccionarSistema : null, 
		SeleccionarNodo : null,
		data(){
			return{
				isLoading: true,
				sistema: undefined,
				nodos: undefined,
				selectSis : '', 
				selectNod: '',
				carga : '',
				distribucion: '',
				promedios: '',
				minVal: undefined,
                maxVal: undefined,
                value: undefined,
                stepVal: 86400000,
			}
		},
		methods: {
            getFecha(value) {
                let totalMiliSeconds = Number(value);
                // Convert the current milliseconds to the respective date in desired format
                let custom = { year: "numeric", month: "short", day: "numeric" };
                value = new Date(totalMiliSeconds).toLocaleDateString(
                    "es-mx",
                    custom
                );
                return value;
            },
			async getDates() {
				await this.SeleccionarNodo.getMinFecha().then( response => {
					this.minVal = new Date(response.data.fecha).getTime();
				});

				await this.SeleccionarNodo.getMaxFecha().then( response => {
					this.maxVal = new Date(response.data.fecha).getTime();
				});
				
				this.value = [this.minVal, this.maxVal];
				this.isLoading = false;
			}
        },
		watch : {
			selectSis: function(value){
				if(value == "Todos"){
					this.SeleccionarNodo.getAll().then(response =>{
					this.nodos = response.data;
				});

				}else{
					this.selectSis = value;
					this.SeleccionarNodo.getNodosBySistema(this.selectSis.id_sistema).then(response =>{
						this.nodos = response.data;
					});
				}
				
			},
			selectNod: function(value){
				this.selectNod = value; 
				this.carga = this.selectNod.carga;
				this.distribucion = this.selectNod.distribucion;

				this.SeleccionarNodo.getPromedios(this.selectNod.id_nodo).then(response =>{
					this.promedios = response.data;
					
				});
			}
		},
		created(){
			this.SeleccionarSistema = new SeleccionarSistema();
			this.SeleccionarNodo = new SeleccionarNodo();
		}, 
		mounted(){
			this.SeleccionarSistema.getAll().then(response =>{
				this.sistema = response.data;
			});
			this.SeleccionarNodo.getAll().then(response =>{
				this.nodos = response.data;
			});

			this.getDates();

			// Donde van???
			
		}
	}

</script>

<style>
	@import "vue-select/dist/vue-select.css";

	table, th, td {
		border: 1px #000 solid;
	}
</style>
<style scoped>


</style>