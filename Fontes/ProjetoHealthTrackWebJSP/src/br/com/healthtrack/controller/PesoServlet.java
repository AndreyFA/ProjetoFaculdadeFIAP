package br.com.healthtrack.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.PesoDAO;
import br.com.healthtrack.model.Peso;
import br.com.healthtrack.model.Usuario;

@WebServlet("/peso")
public class PesoServlet extends BaseController {

	private static final long serialVersionUID = 1L;
	
	private PesoDAO pesoDao;

	@Override
	public void init() throws ServletException {
		this.pesoDao = DAOFactory.getPesoDAO();
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = this.obterUsuario(req);
		
		switch (req.getParameter("opcao")) {
			case "editar": {
				abrirFormularioEdicao(req, resp);
				break;
			}
			case "cadastrar": {
				abrirFormularioCadastro(req, resp);
				break;
			}
			case "listar": {
				listar(req, resp, usuario);
				break;
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario usuario = this.obterUsuario(req);

		switch (req.getParameter("opcao")) {
			case "cadastrar": {
				cadastrar(req, resp, usuario);
				break;
			}
			case "editar": {
				editar(req, resp, usuario);
				break;
			}
			case "excluir": {
				excluir(req, resp, usuario);
				break;
			}
		}
	}
	
	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		Peso peso = this.pesoDao.obterPorId(codigo);
		
		req.setAttribute("peso", peso);
		req.getRequestDispatcher("pesoFormEdicao.jsp").forward(req, resp);
	}
	
	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("pesoFormCadastro.jsp").forward(req, resp);
	}
	
	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		List<Peso> pesos = this.pesoDao.obterTodos();

		req.setAttribute("pesos", pesos);
		req.getRequestDispatcher("peso.jsp").forward(req, resp);
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		float peso = Float.parseFloat(req.getParameter("peso"));
		LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		this.pesoDao.cadastrar(new Peso(peso, data, usuario));
		
		listar(req, resp, usuario);
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		float peso = Float.parseFloat(req.getParameter("peso"));
		LocalDate data = LocalDate.parse(req.getParameter("data"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

		Peso registroPeso = this.pesoDao.obterPorId(codigo);
		registroPeso.setData(data);
		registroPeso.setPeso(peso);

		this.pesoDao.atualizar(registroPeso);
		
		listar(req, resp, usuario);
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		this.pesoDao.deletar(codigo);
		
		listar(req, resp, usuario);
	}
}
