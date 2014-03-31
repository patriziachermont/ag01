package br.com.pchermont.ag01;

/**
 * Classe principal que executa o m�todo main do programa
 * @author Patrizia
 *
 */
public class Main {

	/**
	 * Rotina principal do programa
	 * @param args Argumentos de Execu��o do programa
	 */
	public static void main(String[] args) {
		
		// N�mero de �pocas da simula��o
		int e = 100;
		// N�mero de Indiv�duos da popula��o inicial
		int n = 10;
		// N�mero de indiv�duos selecionados para a pr�xima gera��o
		int s = 5;
		// N�mero de genes em cada indiv�duo
		int g = 4;
		
		// Desvio padr�o da distribui��o gaussiana para gera��o dos genes
		double d = 0.25;	
		
		// Cria��o da popula��o inicial
		Populacao populacao = new Populacao(n, g, d);
		
		// Loop de sele��o, muta��o e cria��o de novos indiv�duos em cada �poca
		for (int i = 0; i < e; i++){
			populacao.selecionar(s);
			populacao.mutacao(d);
			populacao.criar(n-s, g, d);
		}
		
		// T�rmino da simula��o
		System.exit(0);

	}

}
