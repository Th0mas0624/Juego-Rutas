let diccionarioImagenes = {
	"Model.Builder.AtaqueGasolina":"falta de combustible","Model.Builder.AtaqueVelocidad": "velocidad maxima",
	"Model.Builder.AtaquePinchazo":"pinchadura","Model.Builder.AtaqueAccidente":"choque","Model.Builder.AtaqueSiga":"stop",
    "Model.Builder.DefensaGasolina":"combustible","Model.Builder.DefensaVelocidad":"fin velocidad maxima","Model.Builder.DefensaPinchazo":"rueda de auxilio",
    "Model.Builder.DefensaAccidente":"taller","Model.Builder.DefensaSiga":"siga","Model.Builder.SeguridadGasolina":"combustible extra",
    "Model.Builder.SeguridadPinchazo":"a prueba de pinchasos","Model.Builder.SeguridadAccidente":"as del volante","Model.Builder.SeguridadSiga":"prioridad de paso",
    "Model.Builder.Distancia200":"200","Model.Builder.Distancia100":"100","Model.Builder.Distancia75":"75","Model.Builder.Distancia50":"50","Model.Builder.Distancia25":"25"
    };

/*
    private String[] rutas = {"falta de combustible","velocidad maxima","pinchadura","choque","stop",
    "combustible","fin velocidad maxima","rueda de auxilio","taller","siga",
    "combustible extra","a prueba de pinchasos","as del volante","prioridad de paso",
    "200","100","75","50","25"};
 */

function iniciarJuego(numJugadores, modoJuego){
	
	/*let numJugadores=$("#numJugadores").val();
	let modoJuego=$("#modoJuego").val();*/
	let mydata={
		numJugadores:numJugadores,
		modoJuego:modoJuego
	};
	$.ajax({
        url: 'iniciar',
        type: 'GET',
        data: mydata,
        success: function(r) {
            paintAns("Inicio Juego"); // Convierte la respuesta a string si es necesario
        }
    });
	
	
}
function cartas(){	
    $.ajax({
        url: 'cartas',
        type: 'GET',
        success: function(r) {
            // Suponiendo que 'r' es la lista de cartas
            pintarLasCartas(JSON.parse(r)); // Ahora pasas 'r' directamente a pintarLasCartas
        }
    });
}
 
function pintarLasCartas(cartas) {
    cartas.forEach((carta, index) => {
        // Obtener el botón correspondiente (Carta1, Carta2, ..., Carta12)
        let boton = document.getElementById(`Carta${index + 1}`);
        console.log(boton)
        // Traducir el identificador de la carta a una ruta de imagen usando diccionarioImagenes
        let rutaImagen = "Pictures/"+diccionarioImagenes[carta]+".png";
        
        // Establecer la imagen en el botón
        boton.style.backgroundImage = `url(${rutaImagen})`;
        boton.style.backgroundSize = 'cover'; // Asegura que la imagen cubra todo el botón
    });
}
 
/*function mostrarBotonesIndividual() {
    document.getElementById("Individual").style.display = "none";
    document.getElementById("2 Jugadores").style.display = "block";
    document.getElementById("3 Jugadores").style.display = "block";
    document.getElementById("botonAtras").style.display = "block";
    document.getElementById("Equipos").style.display = "none";
    document.getElementById("buttonReglas").style.display = "none";
}*/

/*function mostrarBotonesEquipos() {
    document.getElementById("Equipos").style.display = "none";
    document.getElementById("2 Equipos").style.display = "block";
    document.getElementById("3 Equipos").style.display = "block";
    document.getElementById("botonAtras").style.display = "block";
    document.getElementById("Individual").style.display = "none";
    document.getElementById("buttonReglas").style.display = "none";
}*/

/*function volverAtras() {
    document.getElementById("Individual").style.display = "block";
    document.getElementById("Equipos").style.display = "block";
    document.getElementById("2 Equipos").style.display = "none";
    document.getElementById("3 Equipos").style.display = "none";
    document.getElementById("2 Jugadores").style.display = "none";
    document.getElementById("3 Jugadores").style.display = "none";
    document.getElementById("botonAtras").style.display = "none";
    document.getElementById("buttonReglas").style.display = "block";
}*/
 
function iniciar2Jugadores(){
	iniciarJuego(2,"Individual");
	console.log("Si se llama");
	document.getElementById("botones").style.display = "none";
	document.getElementById("contenedor").style.display = "flex";
	//window.location.href = 'Tablero.html'; // Redirecciona a dosJugadores.html
	cartas()
}

function iniciar2Equipos(){
	iniciarJuego(4,"Equipos");
	console.log("Si se llama");
	document.getElementById("botones").style.display = "none";
	document.getElementById("contenedor").style.display = "flex";
	//window.location.href = 'Tablero.html'; // Redirecciona a dosJugadores.html
	cartas()
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


function paintAns(ans) {
    $("#resultado").html("<h2>El resultado es: " + ans + "</h2>");
}


