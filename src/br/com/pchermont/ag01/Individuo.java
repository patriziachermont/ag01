package br.com.pchermont.ag01;

import java.util.Random;

/**
 * Indiv�duo sujeito a uma sele��o natural. Possui um gen�tipo gerado por uma
 * distribui��o gaussiana de m�dia zero e desvio padr�o determinado pelo
 * m�todo construtor.
 * @author Patrizia
 *
 */
public class Individuo implements Comparable<Individuo> {
		
	// Gen�tipo do indiv�duo
	double genes[];	
	// Gerador de n�meros aleat�rios 
	Random random;
	
	/**
	 * M�todo construtor do indiv�duo.
	 * @param g N�mero de genes do indiv�duo.
	 * @param d Desvio padr�o da distribui��o gaussiana.
	 */
	public Individuo(int g, double d){

		random   = new Random();		
		genes = new double[g];
		
		for (int i = 0; i < g; i++){
			genes[i] = random.nextGaussian() * d;
		}		
		
	}
	
	/**
	 * Aplica a muta��o no indiv�duo. Por principio, a muta��o � aplicada
	 * em apenas um dos genes e de forma aditiva.
	 * @param d Desvio padr�o da distribui��o gaussiana.
	 */
	public void mutacao(double d){
		int i = random.nextInt(genes.length);
		genes[i] += random.nextGaussian() * d;
	}
	
	
	/**
	 * Fun��o de aptid�o do indiv�duo.
	 * @return Valor da aptid�o do indiv�duo.
	 */
	public double fitness(){
		double soma = 0;		
		for (int i = 0; i < genes.length; i++){			
			soma += genes[i];
		}
		return soma/genes.length;
	}

	@Override
	/**
	 * Compara o indiv�duo com outro.
	 * @return um valor negativo, zero ou positivo, caso o outro indiv�duo seja
	 * mais apto, t�o apto ou menos apto, respectivamente.
	 */
	public int compareTo(Individuo outro) {		
		return Double.compare(Math.abs(this.fitness()-1), Math.abs(outro.fitness()-1));
	}
	

}
