package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import escenario2.proAndes;

public class ServletRFC5 extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private proAndes pro = new proAndes();

	/**
	 * Inicializacin del Servlet
	 */
	public void init( ) throws ServletException
	{

	}

	/**
	 * fin de un servlet
	 */
	public void destroy( )
	{

	}



	/**
	 * Maneja un pedido GET de un cliente
	 * @param request Pedido del cliente
	 * @param response Respuesta
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Maneja el GET y el POST de la misma manera
		try {
			procesarSolicitud( request, response );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Maneja un pedido POST de un cliente
	 * @param request Pedido del cliente
	 * @param response Respuesta
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		// Maneja el GET y el POST de la misma manera
		try {
			procesarSolicitud( request, response );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@SuppressWarnings("deprecation")
	private void procesarSolicitud(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		PrintWriter out = response.getWriter( );
		String accion = request.getParameter("accion");    	


		if (accion.equals("actualizar"))
		{
			System.out.println("Hey!");
		}  	

		if (accion.equals("darInform5"))
		{
			String sel = request.getParameter("sela5");
			String id = request.getParameter("idSel5");
			System.out.println(sel);
			System.out.println(id);
			ArrayList<ArrayList<String>> arr = pro.informacionPedido(sel, id);
			imprimirRta(out, arr);
		}
	}

	private void imprimirRta(PrintWriter out, ArrayList<ArrayList<String>> arr)
	{

		out.println("<h3> INFORMACION </h3>");
		out.println("<div class=\"table-responsive\">");
		out.println("<table class=\"table table-condensed table-bordered table-hover\">");
		out.println("<tr>");
		ArrayList<String> arrin = arr.get(0);
		for(int j = 0; j < arrin.size(); j++)
		{
			System.out.println(arrin.get(j));
			out.println("<th>"+arrin.get(j)+"</th>");
		}				
		out.println("</tr>");
		for (int i=1; i<arr.size(); i++)
		{
			out.println("<tr>");
			arrin = arr.get(i);

			for(int j = 0; j < arrin.size(); j++)
			{
				System.out.println(arrin.get(j));
				out.println("<td>"+arrin.get(j)+"</td>");
			}				
			out.println("</tr>");
		}
		out.println("</table> </div>");


		//		{accion: 'registrar', parametro: '"+cod+"',cantidad: cant,fecha: fech, cliente:idclient }


	}

}
