<template>
    <Dashboard />
    <br>
    <br>
    <Graph_promedios></Graph_promedios>
</template>

<script>
import Dashboard from './components/Dashboard.vue'
import Graph_promedios from './components/Graph_promedios.vue'


export default {
  name: 'App',
  components: {
    Dashboard,
    Graph_promedios,
  }
}
</script>

<style>
</style>
