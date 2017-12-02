package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		super.init();
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
	protected void listar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario, String mensagem) throws ServletException, IOException {
		List<PressaoArterial> pressoesArteriais = this.pressaoArterialDao.obterTodos(usuario);
		
		req.setAttribute("pressoesArteriais", pressoesArteriais);
		
		if(super.mensagemSucesso.equals(mensagem))		
			req.setAttribute("mensagemSucesso", mensagem);
		else
			req.setAttribute("mensagemErro", mensagem);
		
		req.getRequestDispatcher("pressaoArterial.jsp").forward(req, resp);		
	}

	@Override
	protected void cadastrar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {

		String mensagem = super.mensagemSucesso;
		
		try {
			int pressaoSistolica = Integer.parseInt(req.getParameter("pressaoSistolica"));
			int pressaoDiastolica = Integer.parseInt(req.getParameter("pressaoDiastolica"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));
			
			this.pressaoArterialDao.cadastrar(new PressaoArterial(pressaoSistolica, pressaoDiastolica, data, usuario));			
			
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}
		
		listar(req, resp, usuario, mensagem);
	}

	@Override
	protected void editar(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
				
		String mensagem = super.mensagemSucesso;
		
		try {
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			int pressaoSistolica = Integer.parseInt(req.getParameter("pressaoSistolica"));
			int pressaoDiastolica = Integer.parseInt(req.getParameter("pressaoDiastolica"));
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Calendar data = Calendar.getInstance();
			data.setTime(format.parse(req.getParameter("data")));
			
			PressaoArterial pressaoArterial = this.pressaoArterialDao.obterPorId(codigo);
			pressaoArterial.setPressaoSistolica(pressaoSistolica);
			pressaoArterial.setPressaoDiastolica(pressaoDiastolica);
			pressaoArterial.setData(data);
			pressaoArterial.setSituacao();
			
			this.pressaoArterialDao.atualizar(pressaoArterial);			
			
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}
		
		listar(req, resp, usuario, mensagem);
	}

	@Override
	protected void excluir(HttpServletRequest req, HttpServletResponse resp, Usuario usuario) throws ServletException, IOException {
		
		String mensagem = super.mensagemSucesso;
		
		try {
			int codigo = Integer.parseInt(req.getParameter("codigo"));
			this.pressaoArterialDao.deletar(codigo);
			
		} catch (Exception e) {
			e.printStackTrace();
			mensagem = super.mensagemErro;
		}
		
		listar(req, resp, usuario, mensagem);
	}
}
