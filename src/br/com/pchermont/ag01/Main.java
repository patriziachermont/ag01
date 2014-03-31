package br.com.pchermont.ag01;

/**
 * Classe principal que executa o método main do programa
 * @author Patrizia
 *
 */
public class Main {

	/**
	 * Rotina principal do programa
	 * @param args Argumentos de Execução do programa
	 */
	public static void main(String[] args) {
		
		// Número de épocas da simulação
		int e = 100;
		// Número de Indivíduos da população inicial
		int n = 10;
		// Número de indivíduos selecionados para a próxima geração
		int s = 5;
		// Número de genes em cada indivíduo
		int g = 4;
		
		// Desvio padrão da distribuição gaussiana para geração dos genes
		double d = 0.25;	
		
		// Criação da população inicial
		Populacao populacao = new Populacao(n, g, d);
		
		// Loop de seleção, mutação e criação de novos indivíduos em cada época
		for (int i = 0; i < e; i++){
			populacao.selecionar(s);
			populacao.mutacao(d);
			populacao.criar(n-s, g, d);
		}
		
		// Término da simulação
		System.exit(0);

	}

}
