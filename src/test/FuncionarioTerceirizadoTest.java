package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import model.FuncionarioTerceirizado;

public class FuncionarioTerceirizadoTest {

	private FuncionarioTerceirizado funcionarioTerceirizado;
	
	@Test
	public void testarConstrutorEntradaDespesasInvalidas() {
		String nome = "Joao";
		Integer horasTrabalhadas = 50;
		Double valorHorasTrabalhadas = 200.00;
		Double despesasAdicionais = 2000.00;
		
		assertThrows(IllegalArgumentException.class, () -> new FuncionarioTerceirizado(nome,horasTrabalhadas, valorHorasTrabalhadas, despesasAdicionais));
	}
	
	@Test
	public void testarConstrutorEntradasValidas() {
		String nome = "Joao";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		Double despesasAdicionais = 1000.00;
		
		Integer resultadoEsperadoHorasTrabalhadas = horasTrabalhadas;
		Double resultadoEsperadoValorHorasTrabalhadas = valorHorasTrabalhadas;
		Double resultadoEsperadoDespesasAdicionais = despesasAdicionais;
		
		funcionarioTerceirizado = new FuncionarioTerceirizado(nome, horasTrabalhadas,valorHorasTrabalhadas,despesasAdicionais);
		
		Integer resultadoObtidoHorasTrabalhadas = funcionarioTerceirizado.getHorasTrabalhadas();
		Double resultadoObtidoValorHorasTrabalhadas = funcionarioTerceirizado.getValorHora();
		Double resultadoObtidoDespesasAdicionais = funcionarioTerceirizado.getDespesasAdicionais();
		
		assertEquals(resultadoEsperadoHorasTrabalhadas,resultadoObtidoHorasTrabalhadas);
		assertEquals(resultadoEsperadoValorHorasTrabalhadas,resultadoObtidoValorHorasTrabalhadas);
		assertEquals(resultadoEsperadoDespesasAdicionais, resultadoObtidoDespesasAdicionais);
	} 
	
	@Test
	public void testarModificarDespesasEntradasInvalidas() {
		String nome = "Joao";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		Double despesasAdicionais = 1000.00;
		
		funcionarioTerceirizado = new FuncionarioTerceirizado(nome, horasTrabalhadas, valorHorasTrabalhadas, despesasAdicionais);
		Double resultadoEsperadoDespesasAdicionais = 2000.00;
		
		assertThrows(IllegalArgumentException.class, () -> funcionarioTerceirizado.setDespesasAdicionais(resultadoEsperadoDespesasAdicionais));
	}
	
	@Test
	public void testarModificarDespesasEntradasValidas() {
		String nome = "Joao";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		Double despesasAdicionais = 1000.00;
		
		funcionarioTerceirizado = new FuncionarioTerceirizado(nome, horasTrabalhadas, valorHorasTrabalhadas, despesasAdicionais);
		Double resultadoEsperadoDespesasAdicionais = 500.00;
		
		funcionarioTerceirizado.setDespesasAdicionais(resultadoEsperadoDespesasAdicionais);
		Double resultadoObtidoDespesasAdicionais = funcionarioTerceirizado.getDespesasAdicionais();
		
		assertEquals(resultadoEsperadoDespesasAdicionais,resultadoObtidoDespesasAdicionais);
	}
	
}
