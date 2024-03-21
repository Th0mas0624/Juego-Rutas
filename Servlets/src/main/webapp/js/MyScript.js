
 function iniciarJuego(){
	
	let numJugadores=$("#numJugadores").val();
	let modoJuego=$("#modoJuego").val();
	let mydata={
		numJugadores:numJugadores,
		modoJuego:modoJuego
	};
	$.ajax({
		url:'ruta',
		type:'GET',
		data: mydata,
		
		success:function(r){
			paintAns(r);
		}
	});
	
 }
 
 function paintAns(ans){
	$("#resultado").html("<h2>El resultado es: "+ans+"</h2>");
	
 }