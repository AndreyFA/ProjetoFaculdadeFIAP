package br.com.healthtrack.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import br.com.healthtrack.model.AlimentoConsumido;
import br.com.healthtrack.model.AtividadeFisica;
import br.com.healthtrack.model.Peso;
import br.com.healthtrack.model.PressaoArterial;
import br.com.healthtrack.model.TipoAtividadeFisica;
import br.com.healthtrack.model.TipoRefeicao;
import br.com.healthtrack.model.Usuario;

public class Test {
	
	private static Usuario usuario = new Usuario();

	public static void main(String[] args) {
		executarTestesDeUsuario();
		executarTestesDeTipoDeRefeicao();
		executarTestesDeAlimentoConsumido();
		executarTestesDeTipoDeAtividadeFisica();
		executarTestesDeAtividadeFisica();
		executarTestesDePeso();
		executarTestesDePressaoArterial();
		
		usuario.setCodigo(1);
	}
	
	private static void executarTestesDeUsuario() {	
		TesteUsuarioDAO testeDao = new TesteUsuarioDAO();
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastrarUmUsuario(new Usuario("Usuário " +  i, LocalDate.now(), 175, "M", "email@email.com", "senha@123"));
		}
		
		ArrayList<Usuario> usuarios = testeDao.deveSerPossivelRecuperarTodosUsuarios();
	}
	
	private static void executarTestesDeTipoDeRefeicao() {
		TesteTipoRefeicaoDAO testeDao = new TesteTipoRefeicaoDAO();
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastrarUmTipoDeRefeicao(new TipoRefeicao("Tipo de Refeição " + i));
		}
		
		ArrayList<TipoRefeicao> tiposDeRefeicao = testeDao.deveSerPossivelRecuperarTodosTiposDeRefeicao();
	}
	
	private static void executarTestesDeAlimentoConsumido() {
		TesteAlimentoConsumidoDAO testeDao = new TesteAlimentoConsumidoDAO();
		
		TipoRefeicao tipoRefeicao = new TipoRefeicao();
		tipoRefeicao.setCodigo(1);
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastrarUmAlimentoConsumido(new AlimentoConsumido(65, LocalDateTime.now(), "Alimento " + i, tipoRefeicao, usuario));
		}
		
		ArrayList<AlimentoConsumido> alimentosConsumidos = testeDao.deveSerPossivelRecuperarTodosAlimentosConsumidos();
	}
	
	private static void executarTestesDeTipoDeAtividadeFisica() {
		TesteTipoAtividadeFisicaDAO testeDao = new TesteTipoAtividadeFisicaDAO();
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastrarUmTipoDeAtividadeFisica(new TipoAtividadeFisica("Tipo de atividade física " + i));
		}
		
		ArrayList<TipoAtividadeFisica> tiposDeAtividadesFisicas = testeDao.deveSerPossivelRecuperarTodosTiposDeAtividadesFisicas();
	}
	
	private static void executarTestesDeAtividadeFisica() {
		TesteAtividadeFisicaDAO testeDao = new TesteAtividadeFisicaDAO();
		
		TipoAtividadeFisica tipoAtividadeFisica = new TipoAtividadeFisica();
		tipoAtividadeFisica.setCodigo(1);
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastarUmaAtividadeFisica(new AtividadeFisica(65, LocalDate.now(), LocalTime.now(), "Atividade " + i, tipoAtividadeFisica, usuario));
		}
		
		ArrayList<AtividadeFisica> atividadesFisicas = testeDao.deveSerPossivelRecuperarTodasAtividadesFisicas();
	}
	
	private static void executarTestesDePeso() {
		TestePesoDAO testeDao = new TestePesoDAO();
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastrarUmPeso(new Peso(65, LocalDate.now(), usuario));
		}
		
		ArrayList<Peso> pesos = testeDao.deveSerPossivelRecuperarTodosPesos();
	}
	
	private static void executarTestesDePressaoArterial() {
		TestePressaoArterialDAO testeDao = new TestePressaoArterialDAO();
		
		for(int i = 0; i < 5; i++) {
			testeDao.deveSerPossivelCadastrarUmaPressaoArterial(new PressaoArterial(120, 80, LocalDate.now(), usuario));
		}
		
		ArrayList<PressaoArterial> pressoesArteriais = testeDao.deveSerPossivelRecuperarTodasPressoesArteriais();
	}
}
