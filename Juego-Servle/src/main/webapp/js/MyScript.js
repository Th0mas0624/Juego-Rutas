function iniciarJuego(numJugadores, modoJuego){
	
	/*let numJugadores=$("#numJugadores").val();
	let modoJuego=$("#modoJuego").val();*/
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
 
function mostrarBotonesIndividual() {
    document.getElementById("Individual").style.display = "none";
    document.getElementById("2 Jugadores").style.display = "block";
    document.getElementById("3 Jugadores").style.display = "block";
    document.getElementById("botonAtras").style.display = "block";
    document.getElementById("Equipos").style.display = "none";
    document.getElementById("buttonReglas").style.display = "none";
}

function mostrarBotonesEquipos() {
    document.getElementById("Equipos").style.display = "none";
    document.getElementById("2 Equipos").style.display = "block";
    document.getElementById("3 Equipos").style.display = "block";
    document.getElementById("botonAtras").style.display = "block";
    document.getElementById("Individual").style.display = "none";
    document.getElementById("buttonReglas").style.display = "none";
}

function volverAtras() {
    document.getElementById("Individual").style.display = "block";
    document.getElementById("Equipos").style.display = "block";
    document.getElementById("2 Equipos").style.display = "none";
    document.getElementById("3 Equipos").style.display = "none";
    document.getElementById("2 Jugadores").style.display = "none";
    document.getElementById("3 Jugadores").style.display = "none";
    document.getElementById("botonAtras").style.display = "none";
    document.getElementById("buttonReglas").style.display = "block";
}
 
function iniciar2Jugadores(){
	iniciarJuego(2,"Individual");
	console.log("Si se llama");
	window.location.href = 'Tablero.html'; // Redirecciona a dosJugadores.html
}

function iniciar2Equipos(){
	iniciarJuego(4,"Equipos");
	console.log("Si se llama");
	window.location.href = 'Tablero.html';
}
function reglasJuego(){
	var contenedor = document.getElementById("contenedorImagen");
    var imagen = document.getElementById("imagenReglas");
    // Especifica la ruta de tu imagen
    imagen.src = 'Pictures/100.png'; // Asegúrate de reemplazar esto con la URL real de tu imagen
    // Hace el contenedor visible
    contenedor.style.display = "block";
	
}

function cerrarImagen() {
    var contenedor = document.getElementById("contenedorImagen");
    // Oculta el contenedor, lo que también oculta la imagen y el botón de cerrar
    contenedor.style.display = "none";
}
 function paintAns(ans){
	$("#resultado").html("<h2>El resultado es: "+ans+"</h2>");
	
 }