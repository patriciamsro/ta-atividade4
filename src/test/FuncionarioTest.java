package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import model.Funcionario;

public class FuncionarioTest {

	private Funcionario funcionario;
	
	@Test
	public void testarConstrutorPagamentoInvalido() {
		String nome = "Maria";
		Integer horasTrabalhadas = 50;
		Double valorHorasTrabalhadas = 200.00;
		
		assertThrows(IllegalArgumentException.class, () -> new Funcionario(nome, horasTrabalhadas, valorHorasTrabalhadas));
	}
	
	@Test
	public void testarConstrutorEntradaValorHorasInvalido() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 30.00;
		
		assertThrows(IllegalArgumentException.class, () -> new Funcionario(nome, horasTrabalhadas, valorHorasTrabalhadas));	
	}
	
	@Test
	public void testarConstrutorEntradaValorHorasValido() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas, valorHorasTrabalhadas);
		
		Double resultadoEsperadoValorHorasTrabalhadas = valorHorasTrabalhadas;
		Double resultadoObtidoValorHorasTrabalhadas = funcionario.getValorHora();
		
		assertEquals(resultadoEsperadoValorHorasTrabalhadas, resultadoObtidoValorHorasTrabalhadas);	
	}
	
	@Test
	public void testarConstrutorEntradaHorasInvalida() {
		String nome = "Maria";
		Integer horasTrabalhadas = 60;
		Double valorHorasTrabalhadas = 50.00;
				
		assertThrows(IllegalArgumentException.class, () -> new Funcionario(nome, horasTrabalhadas, valorHorasTrabalhadas));
	}
	
	@Test
	public void testarConstrutorEntradasValidas() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		
		Integer resultadoEsperadoHorasTrabalhadas = horasTrabalhadas;
		Double resultadoEsperadoValorHorasTrabalhadas = valorHorasTrabalhadas;
		
		funcionario = new Funcionario(nome, horasTrabalhadas, valorHorasTrabalhadas);
		
		Integer resultadoObtidoHorasTrabalhadas = funcionario.getHorasTrabalhadas();
		Double resultadoObtidoValorHorasTrabalhadas = funcionario.getValorHora();
		
		assertEquals(resultadoEsperadoHorasTrabalhadas,resultadoObtidoHorasTrabalhadas);
		assertEquals(resultadoEsperadoValorHorasTrabalhadas, resultadoObtidoValorHorasTrabalhadas);
	}
	
	@Test
	public void testarModificarHorasPagamentoInvalido() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 100.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas,valorHorasTrabalhadas);

		Integer resultadoEsperadoHorasTrabalhadas = 10;
		funcionario.setHorasTrabalhadas(resultadoEsperadoHorasTrabalhadas);

		assertThrows(IllegalArgumentException.class, () -> funcionario.calcularPagamento());		
	} 
	
	@Test
	public void testarModificarValorPagamentoInvalido() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 100.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas,valorHorasTrabalhadas);
		
		Double resultadoEsperadoValorHorasTrabalhadas = 10.00;
		
		
		assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora(resultadoEsperadoValorHorasTrabalhadas));		
	}

	@Test
	public void testarModificarHorasEntradaInvalida() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas,valorHorasTrabalhadas);
		Integer resultadoEsperadoHorasTrabalhadas = 100;
		
		assertThrows(IllegalArgumentException.class, () -> funcionario.setHorasTrabalhadas(resultadoEsperadoHorasTrabalhadas));		
	}
	
	@Test
	public void testarModificarHorasEntradaValida() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas,valorHorasTrabalhadas);
		Integer resultadoEsperadoHorasTrabalhadas = 30;
		
		funcionario.setHorasTrabalhadas(resultadoEsperadoHorasTrabalhadas);
		Integer resultadoObtidoHorasTrabalhadas = funcionario.getHorasTrabalhadas();
		
		assertEquals(resultadoEsperadoHorasTrabalhadas, resultadoObtidoHorasTrabalhadas);
	} 
	
	@Test
	public void testarModificarValorEntradaInvalida() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas,valorHorasTrabalhadas);
		Double resultadoEsperadoValorHorasTrabalhadas = 200.00;
		
		assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora(resultadoEsperadoValorHorasTrabalhadas));
	} 

	@Test
	public void testarModificarValorEntradaValida() {
		String nome = "Maria";
		Integer horasTrabalhadas = 40;
		Double valorHorasTrabalhadas = 50.00;
		
		funcionario = new Funcionario(nome, horasTrabalhadas,valorHorasTrabalhadas);
		Double resultadoEsperadoValorHorasTrabalhadas = 100.00;
		
		funcionario.setValorHora(resultadoEsperadoValorHorasTrabalhadas);
		Double resultadoObtidoValorHorasTrabalhadas = funcionario.getValorHora();
		
		assertEquals(resultadoEsperadoValorHorasTrabalhadas, resultadoObtidoValorHorasTrabalhadas);
	}
}
