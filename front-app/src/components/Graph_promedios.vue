<template>
  <div v-if="!isLoading && values">
    <div id="myChart"></div>
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
      chartData: {
        type: 'line',
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
    },
  mounted() {
    this.updateChartData()
  },
  methods: {
    renderChart() {
      ZingChart.render({
        id: 'myChart',
        data: this.chartData,
        height: 400,
        width: 600
      })
    },
    updateChartData() {

      this.maxFecha = "2023-03-14";
      this.minFecha = "2022-01-01";

      this.PML.getAllPromedios(this.minFecha, this.maxFecha).then(response=>{
         this.values = response.data;
         this.isLoading = false;
        });

      //this.chartData.series[0].values = [10, 20, 30, 40, 50]

      // Re-render the chart with the updated data
      this.renderChart()
    }
  }
}
</script>
