package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.AlimentoConsumidoDAO;
import br.com.healthtrack.model.AlimentoConsumido;
import br.com.healthtrack.model.Usuario;

@WebServlet("/alimentoConsumido")
public class AlimentoConsumidoServlet extends BaseController {

	private static final long serialVersionUID = -7777517156215164706L;
	private AlimentoConsumidoDAO alimentoConsumidoDao;

	@Override
	public void init() throws ServletException {
		this.alimentoConsumidoDao = DAOFactory.getAlimentoConsumidoDAO();
	}

	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		AlimentoConsumido alimentoConsumido = this.alimentoConsumidoDao.obterPorId(codigo);
		
		req.setAttribute("alimentoConsumido", alimentoConsumido);
		req.getRequestDispatcher("alimentoConsumidoFormEdicao.jsp").forward(req, resp);
	}

	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("alimentoConsumidoFormCadastro.jsp").forward(req, resp);
	}

	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		List<AlimentoConsumido> alimentosConsumidos = alimentoConsumidoDao.obterTodos();

		req.setAttribute("alimentosConsumidos", alimentosConsumidos);
		req.getRequestDispatcher("alimentoConsumido.jsp").forward(req, resp);
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		listar(req, resp, usuario);
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		listar(req, resp, usuario);
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		listar(req, resp, usuario);
	}
}
