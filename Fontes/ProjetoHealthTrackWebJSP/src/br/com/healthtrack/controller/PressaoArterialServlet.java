package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.dao.DAOFactory;
import br.com.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.healthtrack.model.PressaoArterial;
import br.com.healthtrack.model.Usuario;

@WebServlet("/pressaoArterial")
public class PressaoArterialServlet extends BaseController {

	private static final long serialVersionUID = 8243346958428949560L;
	private PressaoArterialDAO pressaoArterialDao;

	@Override
	public void init() throws ServletException {
		this.pressaoArterialDao = DAOFactory.getPressaoArterialDAO();
	}

	@Override
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		List<PressaoArterial> pressoesArteriais = this.pressaoArterialDao.obterTodos();
		
		req.setAttribute("pressoesArteriais", pressoesArteriais);
		req.getRequestDispatcher("pressaoArterial.jsp").forward(req, resp);
		
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
