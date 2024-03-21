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

public class Servlets_Conex extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlets_Conex() {
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
		
		out.println(iniciar);
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
