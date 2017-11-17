package br.com.healthtrack.controller;

import java.io.IOException;
import java.time.LocalDate;
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
	protected void abrirFormularioEdicao(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		PressaoArterial pressaoArterial = this.pressaoArterialDao.obterPorId(codigo);
		
		req.setAttribute("pressaoArterial", pressaoArterial);
		req.getRequestDispatcher("pressaoArterialFormEdicao.jsp").forward(req, resp);
	}

	@Override
	protected void abrirFormularioCadastro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("pressaoArterialFormCadastro.jsp").forward(req, resp);		
	}

	@Override
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		List<PressaoArterial> pressoesArteriais = this.pressaoArterialDao.obterTodos();
		
		req.setAttribute("pressoesArteriais", pressoesArteriais);
		req.getRequestDispatcher("pressaoArterial.jsp").forward(req, resp);		
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		int pressaoSistolica = Integer.parseInt(req.getParameter("pressaoSistolica"));
		int pressaoDiastolica = Integer.parseInt(req.getParameter("pressaoDiastolica"));
		LocalDate data = LocalDate.now();
		
		this.pressaoArterialDao.cadastrar(new PressaoArterial(pressaoSistolica, pressaoDiastolica, data, usuario));
		
		listar(req, resp, usuario);
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		int pressaoSistolica = Integer.parseInt(req.getParameter("pressaoSistolica"));
		int pressaoDiastolica = Integer.parseInt(req.getParameter("pressaoDiastolica"));
		LocalDate data = LocalDate.now();
		
		PressaoArterial pressaoArterial = this.pressaoArterialDao.obterPorId(codigo);
		pressaoArterial.setPressaoSistolica(pressaoSistolica);
		pressaoArterial.setPressaoDiastolica(pressaoDiastolica);
		pressaoArterial.setData(data);
		pressaoArterial.setSituacao();
		
		this.pressaoArterialDao.atualizar(pressaoArterial);
		
		listar(req, resp, usuario);
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		int codigo = Integer.parseInt("codigo");
		this.pressaoArterialDao.deletar(codigo);
		
		listar(req, resp, usuario);
	}
}
