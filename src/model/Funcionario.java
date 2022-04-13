package model;

public class Funcionario {

	private static final Integer QUANTIDADE_MAXIMA_HORAS = 40;
	private static final Double VALOR_SALARIO_MINIMO = 1212.00;
	private static final Double PERCENTUAL_MINIMO_VALOR_HORAS = 0.04;
	private static final Double PERCENTUAL_MAXIMO_VALOR_HORAS = 0.10;
	
	private String nome;
	private Integer horasTrabalhadas;
	private Double valorHora;
	
	public Funcionario(String nome, Integer horasTrabalhadas, Double valorHora) {
		this.nome = nome;
		this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
		this.valorHora = validaValorHorasTrabalhadas(valorHora);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = validaHorasTrabalhadas(horasTrabalhadas);
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = validaValorHorasTrabalhadas(valorHora);
	}
	
	private Integer validaHorasTrabalhadas(Integer horasTrabalhadas) {
		if(horasTrabalhadas > QUANTIDADE_MAXIMA_HORAS) {
			throw new IllegalArgumentException("O número de horas trabalhadas por funcionários próprios deve ser menor ou igual a 40.");
		}
		return horasTrabalhadas;
	}
	
	private Double validaValorHorasTrabalhadas(Double valorHora ) {
		
		Double valorMinimo = VALOR_SALARIO_MINIMO * PERCENTUAL_MINIMO_VALOR_HORAS;
		Double valorMaximo = VALOR_SALARIO_MINIMO * PERCENTUAL_MAXIMO_VALOR_HORAS;
		
		if((valorHora < valorMinimo) || (valorHora > valorMaximo) ) {
			throw new IllegalArgumentException("O valor por hora precisa ser entre 4% e 10% do salário mínimo.");
		}
		return valorHora;
	}
	
	public Double calcularPagamento() {
		Double pagamento = valorHora * horasTrabalhadas;
		validaSalarioMinimo(pagamento);

		return pagamento;
	}
	
	protected final void validaSalarioMinimo(Double pagamento) {
		if(pagamento < VALOR_SALARIO_MINIMO) 
			throw new IllegalArgumentException("Pagamento Inválido! O valor do pagamento deve ser maior ou igual a R$1.212,00");
	}
	
}
