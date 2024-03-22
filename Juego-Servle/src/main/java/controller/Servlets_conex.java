package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Juego;


import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ruta")

public class Servlets_conex extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlets_conex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		Juego m=new Juego();
		
		String pa=request.getParameter("numJugadores");
		String pb=request.getParameter("modoJuego");
		
		int a=Integer.parseInt(pa);
		

	
		
		
		boolean iniciar = m.iniciarJuego( a,pb);
		out.println(pb);
		out.println(iniciar);
		System.out.println("Equipos: "+m.getEquipos().size());
		System.out.println("Jugadores: "+m.getEquipos().get(0).getJugadores().size());
		System.out.println("Mazo: "+m.getMazoJuego().getCartasDisponibles().size());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}