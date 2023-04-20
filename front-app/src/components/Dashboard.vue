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


</template>

<script>
	import axios from "axios";
	import SeleccionarSistema from '../service/selectSistema';
	import SeleccionarNodo from '../service/selectNodo';

	export default{
		name : 'Dashboard',
		data(){
			return{
				sistema: undefined,
				nodos: undefined,
				selectSis : '', 
				selectNod: '',
				carga : '',
				distribucion: '',
				promedios: ''
			}
		},

		SeleccionarSistema : null, 
		SeleccionarNodo : null,

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

		}
	}

	//  *******************SECCIONES DE GRAFICAS *****************************// 

	ZC.LICENSE = ["569d52cefae586f634c54f86dc99e6a9", "b55b025e438fa8a98e32482b5f768ff5"];
    let chartData = [69, 68, 54, 48, 70, 74, 98, 70, 72, 68, 49, 69];

    let chartConfig = {

      graphset: [{
      type: 'scatter',
      width: '60%',
      height: '50%',
      x: '30%',
      y: '35.2%',
      plot: {
        tooltip: {
          text: 'Hora del día: %k2 \n Prom.Precio Marginal Local: %kl',
          fontSize: '10px',
          thousandsSeparator: ',',
        },
        
      },
      plotarea: {
        margin: '30px 25px 60px 46px',
      },
      scaleY: {
        label: {
          text: 'Prom. PML ++ ($MWh)',
        },
        values: '0:100:25',
        guide: {
          alpha: 0.6,
          lineColor: '#d2dae2',
          lineStyle: 'solid',
          lineWidth: '1px',
        },
        lineColor: 'none',
          tick: { visible: false,  },
      },
      scaleX: {
            values: '0:24:1',
            guide: { visible: false, },
          },
      series: [{
          values: chartData,
          legendItem: {
            visible: false,
          },
          legendMarker: {
            visible: false,
          },
        },
      ],
      },],
    };

    zingchart.render({
      id: 'myChart',
      data: chartConfig,
      height: '100%',
      width: '100%',
    });


</script>

<style>

	.chart--container {
      min-height: 530px;
      width: 100%;
      height: 100%;
      background: lightgray;

    }

    .zc-ref {
      display: none;
    }
</style>