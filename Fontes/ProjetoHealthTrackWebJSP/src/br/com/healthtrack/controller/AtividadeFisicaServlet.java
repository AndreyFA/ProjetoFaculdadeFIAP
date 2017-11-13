package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.AtividadeFisicaDAO;
import br.com.healthtrack.model.AtividadeFisica;
import br.com.healthtrack.model.Usuario;

@WebServlet("/atividadeFisica")
public class AtividadeFisicaServlet extends BaseController {

	private static final long serialVersionUID = -3119950102476292024L;
	private AtividadeFisicaDAO atividadeFisicaDao;
	
	@Override
	public void init() throws ServletException {
		this.atividadeFisicaDao = DAOFactory.getAtividadeFisicaDAO();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AtividadeFisica> atividadesFisicas = this.atividadeFisicaDao.obterTodos();
		
		req.setAttribute("atividadesFisicas", atividadesFisicas);
		req.getRequestDispatcher("atividadeFisica.jsp").forward(req, resp);
	}

	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
