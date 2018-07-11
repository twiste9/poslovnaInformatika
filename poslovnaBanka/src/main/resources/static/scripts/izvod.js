function preuzmi() {
	var brojRacuna = $("#broj_racuna").val();
	var datum = $("#datum").val();
	
	$.ajax({
		url: "../izvod/preuzmi?brojRacuna=" +brojRacuna + "&datum=" + datum,
		type: "GET",
		contentType: "application/json",
		dataType: "json",
		success: function(data){
			success('yeey');
		}
	});
}