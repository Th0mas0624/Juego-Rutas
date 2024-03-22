package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Equipo;
import Model.Juego;
import Model.Jugador;
import Model.Builder.Carta;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/iniciar")

public class Servlets_conex extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	Juego j;
    public Servlets_conex() {
        super();
        
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("s"+this.getServletContext().getAttribute("juego"));
    	if(this.getServletContext().getAttribute("juego") == null) {    		
    		j = new Juego();
    		// Estableces el atributo en la solicitud
    		this.getServletContext().setAttribute("juego", j);
    	}
    	System.out.println("s"+this.getServletContext().getAttribute("juego"));
		PrintWriter out=response.getWriter();
		String pa=request.getParameter("numJugadores");
		String pb=request.getParameter("modoJuego");
		System.out.println(pa + pb);
		int a=0;
		if(pa != null && !pa.isEmpty() && pb != null) {
		    a = Integer.parseInt(pa);
		    // Continúa con la lógica de tu servlet aquí
		    boolean iniciar = j.iniciarJuego( a,pb);
		    out.println(pb);
		    out.println(iniciar);
		    System.out.println("Equipos: "+j.getEquipos().size());
		    System.out.println("Jugadores: "+j.getEquipos().get(0).getJugadores().size());
		    System.out.println("Mazo: "+j.getMazoJuego().getCartasDisponibles().size());
		}	
		
		// Obtiene el RequestDispatcher para el siguiente servlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cartas");
        
        // Reenvía la solicitud junto con los atributos al siguiente servlet
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}