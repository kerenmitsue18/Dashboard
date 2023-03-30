function drawCharts() {
	checkfieldDate("from");
	checkfieldDate("to");

	var params="";
	params+="?from="+escape( getFieldDate("from") );
	params+="&to="+escape( getFieldDate("to") );
	params+="&sistema="+escape( document.getElementById( "sistema" ).value );

	fetch('/api'+params, { credentials: "same-origin" }).then(function(response) {
		response.json().then(function(value) {
			drawChartP1( value.subsdia );
			drawChartP2( value.subssem );
			});
		});
	}