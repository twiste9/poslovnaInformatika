function preuzmi() {
	var brojRacuna = $("#broj_racuna").val();
	var datum = $("#datum").val();
	var redniBrojPreseka = $("#redni_broj_preseka").val();
	
	$.ajax({
		url: "../izvod/preuzmi?brojRacuna=" +brojRacuna + "&datum=" + datum + "&redniBrojPreseka=" + redniBrojPreseka,
		type: "GET",
		contentType: "application/json",
		dataType: "json",
		success: function(event){
			alert('success');
		}
	});
}