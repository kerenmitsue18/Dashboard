<template>
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
	<div class="col-6">
	    <h2>Sistema seleccionado:</h2>
	    {{selectSis}}
	    <h2>Nodo seleccionado:</h2>
	    {{selectNod}}
	</div>



</template>


<script>
	import axios from "axios";
	import selectSistema from '../service/selectSistema';
	import selectNodo from '../service/selectNodo';

	export default{
		name : 'Dashboard',
		data(){
			return{
				sistema: undefined,
				nodos: undefined,
				selectSis : '', 
				selectNod: ''		
			}
		},
		selectSistema : null, 
		selectNodo : null,
		watch : {
			selectSis: function(value){
				if(value == "Todos"){
					this.selectNodo.getAll().then(response =>{
					this.nodos = response.data;
				});

				}else{
					this.selectSis = value;
					this.selectNodo.getNodosBySistema(this.selectSis.id_sistema).then(response =>{
						console.log(response.data);
					this.nodos = response.data;
					});
				}
				
			}

		},
		created(){
			this.selectSistema = new selectSistema();
			this.selectNodo = new selectNodo();
			
		}, 
		mounted(){
			this.selectSistema.getAll().then(response =>{
				this.sistema = response.data;
			});
			this.selectNodo.getAll().then(response =>{
				this.nodos = response.data;
			});

		}
	}

</script>

<style>
	@import "vue-select/dist/vue-select.css";
</style>