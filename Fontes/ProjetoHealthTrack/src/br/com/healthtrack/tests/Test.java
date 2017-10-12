package br.com.healthtrack.tests;

public class Test {

	public static void main(String[] args) {
		executarTestesDeUsuario();			
	}
	
	private static void executarTestesDeUsuario() {
		TesteUsuarioDAO testeUsuario = new TesteUsuarioDAO();
		testeUsuario.deveSerPossivelCadastrarUmUsuario();
		testeUsuario.deveSerPossivelRecuperarUmUsuario();
		testeUsuario.deveSerPossivelAtualizarUmUsuario();
		testeUsuario.deveSerPossivelDeletarUmUsuario();	
	}
	
	private static void executarTestesDeAlimentoConsumido() {
		TesteAlimentoConsumidoDAO teste = new TesteAlimentoConsumidoDAO();		
		teste.deveSerPossivelCadastrarUmAlimentoConsumido();
		teste.deveSerPossivelRecuperarUmAlimentoConsumido();
		teste.deveSerPossivelAtualizarUmAlimentoConsumido();
		teste.deveSerPossivelDeleterUmAlimentoConsumido();
	}
}
