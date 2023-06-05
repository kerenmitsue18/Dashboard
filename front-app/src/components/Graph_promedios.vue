<template>
    <div v-if="!isLoading && !isLoadingDash">
        <div id="myChart"></div>
        <p>{{ nodo }}</p>

    </div>
  
</template>

<script>
import ZingChart from 'zingchart';
import PML from '../service/PML';

export default {
    data() {
        return {
            isLoading: true,
            isLoadingDash : true,
            values: null,
            nodo: null,
            minFecha: '',
            maxFecha: '',
            sistema: null,
            fechas: null,
            chartData: {
                type: 'scatter',
                width: '80%',
                height: '50%',
                x: '10%',
                //y: '10%',
                plot: {
                    tooltip: {
                        text: "Hora del d�a: %kt \n  Prom.Precio Marginal Local: %v",
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
                    values: '0:1000:100',
                    guide: {
                        alpha: 0.6,
                        lineColor: '#d2dae2',
                        lineStyle: 'solid',
                        lineWidth: '1px',
                    },
                    lineColor: 'none',
                    tick: { visible: false, },
                },
                scaleX: {
                    values: '0:24:1',
                    guide: { visible: false, },
                },
                series: [{
                    values: [],
                    legendItem: {
                        visible: false,
                    },
                    legendMarker: {
                        visible: false,
                    },
             
                },
                ],
            }
        }
    },
    PML: null,
    created(){
        this.PML = new PML();
        this.$emitter.on('cambio-nodo', (evt) => {
            this.nodo = evt.valor;
            this.updateChartData();
        })
        this.$emitter.on('cambio-sistema', (evt) => {
            this.sistema = evt.valor;
            this.updateChartData();
        })
        this.$emitter.on('cambio-fecha', (evt) => {
            this.isLoading = true;
            this.minFecha = evt.valor[0];
            this.maxFecha = evt.valor[1];
            this.updateChartData();
        })
        this.$emitter.on('cambio-cargarDatos', (evt) => {
            this.isLoadingDash = evt.valor;
           
        })
        },

    destroyed() {
        this.$emitter.off('cambio-nodo', (evt) => {
            this.nodo = evt.valor;
        })
        this.$emitter.off('cambio-sistema', (evt) => {
            this.nodo = evt.valor;
        })
        this.$emitter.off('cambio-minFecha', (evt) => {
            this.minFecha = evt.valor;
        })
        this.$emitter.off('cambio-maxFecha', (evt) => {
            this.maxFecha = evt.valor;
        })
    },
    mounted() {

    this.updateChartData();
    
    },
    methods: {
        renderChart() {
            ZingChart.render({
            id: 'myChart',
            data: this.chartData,
            height: 460,
            width: 600
            })
        },
        getFecha(date){
            var fecha = new Date(date);
            var anio = fecha.getFullYear().toString().substr(-2); // Obtiene los últimos dos dígitos del año
            var mes = ("0" + (fecha.getMonth() + 1)).slice(-2); // Agrega un cero inicial si el mes es menor a 10
            var dia = ("0" + fecha.getDate()).slice(-2); // Agrega un cero inicial si el día es menor a 10

            return anio + "-" + mes + "-" + dia;

        },
        async updateChartData() {
            this.isLoading = true;
            if (this.sistema === "Todos") {
               this.nodo == null;
               this.loadCharData();
            }
            
            if(this.nodo === null){
                await this.PML.getPromByFecha(this.getFecha(this.minFecha),this.getFecha( this.maxFecha)).then(response => {
                    this.values = response.data;
                    this.isLoading = false;
                });
                
                this.chartData.series[0].values = this.values;
                this.renderChart();

            }
           
        },

        
    }
}
</script>
