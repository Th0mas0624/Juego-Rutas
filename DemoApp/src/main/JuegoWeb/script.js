function mostrarBotones() {
    document.getElementById("botonMostrar").style.display = "none";
    document.getElementById("boton1").style.display = "block";
    document.getElementById("boton2").style.display = "block";
    document.getElementById("botonAtras").style.display = "block";
}

function volverAtras() {
    document.getElementById("botonMostrar").style.display = "block";
    document.getElementById("boton1").style.display = "none";
    document.getElementById("boton2").style.display = "none";
    document.getElementById("botonAtras").style.display = "none";
}
