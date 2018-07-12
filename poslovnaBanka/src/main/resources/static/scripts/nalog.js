function submit() {
	
	var fajl = new FormData();
	fajl.append('fajl',document.getElementById('importFajl').files[0]);
	
	$.ajax({
    	url: "../nalog/importuj",
		type: "POST",
	    enctype: 'multipart/form-data',
	    data: fajl,
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        success: function (data) {
        	$("#nalogodavac").val(data.nalogodavac);
        	$("#svrhaPlacanja").val(data.svrhaPlacanja);
        	$("#primalac").val(data.primalac);
        	$("#mesto").val(data.mestoPrijema);
        	$("#datum").val(data.datumPrijema);
        	$("#sifraPlacanja").val(data.sifraPlacanja);
        	$("#valuta").val(data.valuta);
        	$("#iznos").val(data.iznos);
        	$("#racunNalogodavca").val(data.racunDuznika);
        	$("#modelZaduzenje").val(data.modelZaduzenja);
        	$("#pozivNaBrojZaduzenje").val(data.pozivNaBrojZaduzenja);
        	$("#racunPrimaoca").val(data.racunPrimaoca);
        	$("#modelOdobrenje").val(data.modelOdobrenja);
        	$("#pozivNaBrojOdobrenje").val(data.pozivNaBrojOdobrenja);
        	$("#datumValute").val(data.datumValute);
        	if (data.hitno) {
        		$("#hitno").attr('checked','checked');
        	} else {
        		$("#hitno").attr('checked','');
        	}
        	
        },
		error: function(thrownError){
			console.log(thrownError.responseText);
		}
	});
}

function exportuj() {
	var nalogodavac = $("#nalogodavac").val();
	var svrhaPlacanja = $("#svrhaPlacanja").val();
	var primalac = $("#primalac").val();
	var mestoPrijema = $("#mesto").val();
	var datumPrijema = $("#datum").val();
	
	var sifraPlacanja = $("#sifraPlacanja").val();
	var valuta = $("#valuta").val();
	var iznos = $("#iznos").val();
	var racunNalogodavca = $("#racunNalogodavca").val();
	var modelZaduzenje = $("#modelZaduzenje").val();
	var pozivNaBrojZaduzenje = $("#pozivNaBrojZaduzenje").val();
	
	var racunPrimaoca = $("#racunPrimaoca").val();
	var modelOdobrenje = $("#modelOdobrenje").val();
	var pozivNaBrojOdobrenje = $("#pozivNaBrojOdobrenje").val();
	
	var datumValute = $("#datumValute").val();
	var hitno = $("#hitno").val();	
	
	var obj = new Object();
	obj.nalogodavac = nalogodavac;
	obj.svrhaPlacanja = svrhaPlacanja;
	obj.primalac = primalac;
	obj.mestoPrijema = mestoPrijema;
	obj.datumPrijema = datumPrijema;
	obj.sifraPlacanja = sifraPlacanja;
	obj.valuta = valuta;
	obj.iznos = iznos;
	obj.racunDuznika = racunNalogodavca;
	obj.modelZaduzenja = modelZaduzenje;
	obj.pozivNaBrojZaduzenja = pozivNaBrojZaduzenje;
	obj.racunPrimaoca = racunPrimaoca;
	obj.pozivNaBrojOdobrenja = pozivNaBrojOdobrenje;
	obj.modelOdobrenja = modelOdobrenje;
	obj.datumValute = datumValute;
	
	if ($('#hitno').is(":checked")) {
		obj.hitno = true;	
	} else {
		obj.hitno = false;
	}
	
	$.ajax({
		url: "../nalog/exportuj",
		type: "POST",
		contentType: "application/json",
		data: JSON.stringify(obj),
		success: function() {
			$('#preuzmi').css("visibility", "visible");
		}
	});	
}