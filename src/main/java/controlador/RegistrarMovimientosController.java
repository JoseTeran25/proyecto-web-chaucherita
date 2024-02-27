package controlador;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Categoria;
import entities.Cuenta;
import entities.Movimiento;
import entities.TipoMovimiento;

/**
 * @author Carlos Iñiguez
 */
@WebServlet("/RegistrarMovimientosController")
public class RegistrarMovimientosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			try {
				ruteador(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ruteador(request, response);
		} catch (ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String ruta = (request.getParameter("ruta") != null) ? request.getParameter("ruta") : "ver";

		switch (ruta) {
		case "nuevoingreso":
			nuevoIngreso(request, response);
			break;
		case "nuevogasto":
			nuevoGasto(request,response);
			break;
		case "guardaregreso":
			guardarEgreso(request, response);
			break;
		}

	}

	private void nuevaTransferencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void nuevoGasto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 1.- obtengo datos
		int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		// 2.- Llamo al Modelo
		List<Categoria> categoria = Categoria.getAllOfExpenseType();
		Cuenta cuenta = Cuenta.getById(idCuenta);
		// 3.- llamo a la vista
		request.setAttribute("categorias", categoria);
		request.setAttribute("cuenta", cuenta);
		request.getRequestDispatcher("/jsp/egreso.jsp").forward(request, response);

	}

	private void nuevoIngreso(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.- obtengo datos
		int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		// 2.- Llamo al Modelo
		List<Categoria> categoria = Categoria.getAllOfIngresoType();
		Cuenta cuenta = Cuenta.getById(idCuenta);
		// 3.- llamo a la vista
		request.setAttribute("categorias", categoria);
		request.setAttribute("cuenta", cuenta);
		request.getRequestDispatcher("/jsp/ingreso.jsp").forward(request, response);

	}

	private void eliminarGasto(HttpServletRequest request, HttpServletResponse response) {

	}

	private void eliminarIngreso(HttpServletRequest request, HttpServletResponse response) {

	}

	private void guardarTransferencia(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void guardarEgreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		// 1.- obtengo datos
		int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		String concepto = request.getParameter("concepto");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = formato.parse(request.getParameter("fecha"));
        double valor = Double.parseDouble(request.getParameter("valor"));
	
		
		// 2.- Llamo al Modelo
		Categoria categoria = Categoria.getById(idCategoria);
		Cuenta cuenta = Cuenta.getById(idCuenta);
		
		Movimiento gasto = new Movimiento();
		gasto.setConcepto(concepto);
		gasto.setFecha(fecha);
		gasto.setMonto(valor);
		gasto.setTipo(TipoMovimiento.EGRESO);
		
		gasto.setCategoria(categoria);
		gasto.setOrigen(cuenta); //o destino? 
		gasto.setDestino(null);
		
		
		
		if(!Movimiento.createGasto(gasto)) {
			System.out.println("Error al ingresar gasto");
			
		}
		// 3.- llamo a la vista
		request.getRequestDispatcher("/DashboardController?ruta=ver").forward(request, response);

	}

	private void guardarIngreso(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	/**
	 * Default constructor
	 */
	public RegistrarMovimientosController() {
	}

}