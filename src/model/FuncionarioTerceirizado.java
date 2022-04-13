package model;

public class FuncionarioTerceirizado extends Funcionario {
	
	private static final Double PERCENTUAL_BONUS = 1.10;
	private static final Double VALOR_MAXIMO_DESPESAS = 1000.00;
	
	private Double despesasAdicionais;
	
	public FuncionarioTerceirizado(String nome, Integer horasTrabalhadas, Double valorHora, Double despesasAdicionais) {
		super(nome, horasTrabalhadas, valorHora);
		this.despesasAdicionais = validaDespesasAdicionais(despesasAdicionais);
	}

	public Double getDespesasAdicionais() {
		return despesasAdicionais;
	}

	public void setDespesasAdicionais(Double despesasAdicionais) {
		this.despesasAdicionais = validaDespesasAdicionais(despesasAdicionais);
	}
	
	private Double validaDespesasAdicionais(Double despesasAdicionais) {
		if(despesasAdicionais > VALOR_MAXIMO_DESPESAS) {
			throw new IllegalArgumentException("O valor das despesas adicionais não pode ser maior que R$1.000,00");
		} 
		return despesasAdicionais;
	}
	
	public Double calculaBonus(Double despesasAdicionais) {
		return despesasAdicionais * PERCENTUAL_BONUS;
	}
	
	@Override
	public Double calcularPagamento() {
		Double pagamento = (getValorHora() * getHorasTrabalhadas()) + despesasAdicionais;
		validaSalarioMinimo(pagamento);

		return pagamento + calculaBonus(despesasAdicionais);	
	}

}
