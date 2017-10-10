package br.com.healthtrack.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import br.com.healthtrack.model.*;

public class Test {

	public static void main(String[] args) {
		
		try {
			Usuario andrey = new Usuario(
					"Andrey Frazatti Alves",
					LocalDate.of(1991, Month.NOVEMBER, 12),
					1.75F,
					'M',
					"frazatti.andrey@gmail.com",
					"Mudar@2017");
			
			LocalDate hoje = LocalDate.now();
			
			Peso peso = new Peso(65.25F, hoje, andrey);
			PressaoArterial pressao = new PressaoArterial(136, 81, hoje, andrey);
			
			peso = peso.buscarPorCodigo(12);
			
			AlimentoConsumido sucoNatural = new AlimentoConsumido(
					12,
					LocalDateTime.of(hoje, LocalTime.now()),
					"Suco de Laranja",
					new TipoRefeicao("Café da manhã"),
					andrey);
			
			System.out.println("Código do peso: " + peso.getCodigo());
			System.out.println("Nome completo: " + andrey.getNomeCompleto());
			System.out.println("Peso: " + peso.getPeso() +  " kg");
			System.out.println("Situação da pressão: " + pressao.getSituacao());
			System.out.println("Calorias ingeridas: " + sucoNatural.getCalorias() + " no " + sucoNatural.getTipo().getNome());
			
		} catch (Exception e) {
			System.err.println("Ocorreu o seguinte erro: " + e.getMessage());
		}	
	}

}
