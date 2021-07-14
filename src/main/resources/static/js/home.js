$("document").ready(function() {
	new Chart(document.getElementById("pie-chart"), {
		type: 'pie',
		data: {
			labels: LabelList,
			datasets: [{
				label: '# of Votes',
				data: valueList,
				backgroundColor: [
					'rgba(255, 99, 132, 0.2)',
					'rgba(54, 162, 235, 0.2)',
					'rgba(255, 206, 86, 0.2)'
				]
			}]
		},
		options: {
		}
	});
});