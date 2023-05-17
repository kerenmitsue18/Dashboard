<template>
    <div v-if="!isLoading">
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
            values: null,
            nodo: null,
            minFecha: null,
            maxFecha: null,
            sistema: null,
            chartData: {
                type: 'scatter',
                width: '80%',
                height: '50%',
                x: '10%',
                //y: '10%',
                plot: {
                    tooltip: {
                        text: "Hora del día: %kt \n  Prom.Precio Marginal Local: %v",
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
            console.log("aqui");
            this.updateChartData();
        })
        this.$emitter.on('cambio-minFecha', (evt) => {
            this.minFecha = evt.valor;
            this.updateChartData();
        })
        this.$emitter.on('cambio-maxFecha', (evt) => {
            this.maxFecha = evt.valor;
            this.updateChartData();
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
            this.minFecha = evt.valor;
        })
    },
    mounted() {

    this.maxFecha = "2023-03-14";
    this.minFecha = "2022-01-01";
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
        async updateChartData() {

            if (this.sistema === null || this.sistema === "Todos") {
                await this.PML.getAllPromedios(this.minFecha, this.maxFecha).then(response => {
                    this.values = response.data;
                    this.isLoading = false;
                });
            }else{
                //colocar para que retorne los promedios de cualquier nodo
            }

               

            this.chartData.series[0].values = this.values;
            this.renderChart();
        }, 

        
    }
}
</script>
