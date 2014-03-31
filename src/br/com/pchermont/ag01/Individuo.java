package br.com.pchermont.ag01;

import java.util.Random;

/**
 * Indivíduo sujeito a uma seleção natural. Possui um genótipo gerado por uma
 * distribuição gaussiana de média zero e desvio padrão determinado pelo
 * método construtor.
 * @author Patrizia
 *
 */
public class Individuo implements Comparable<Individuo> {
		
	// Genótipo do indivíduo
	double genes[];	
	// Gerador de números aleatórios 
	Random random;
	
	/**
	 * Método construtor do indivíduo.
	 * @param g Número de genes do indivíduo.
	 * @param d Desvio padrão da distribuição gaussiana.
	 */
	public Individuo(int g, double d){

		random   = new Random();		
		genes = new double[g];
		
		for (int i = 0; i < g; i++){
			genes[i] = random.nextGaussian() * d;
		}		
		
	}
	
	/**
	 * Aplica a mutação no indivíduo. Por principio, a mutação é aplicada
	 * em apenas um dos genes e de forma aditiva.
	 * @param d Desvio padrão da distribuição gaussiana.
	 */
	public void mutacao(double d){
		int i = random.nextInt(genes.length);
		genes[i] += random.nextGaussian() * d;
	}
	
	
	/**
	 * Função de aptidão do indivíduo.
	 * @return Valor da aptidão do indivíduo.
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
	 * Compara o indivíduo com outro.
	 * @return um valor negativo, zero ou positivo, caso o outro indivíduo seja
	 * mais apto, tão apto ou menos apto, respectivamente.
	 */
	public int compareTo(Individuo outro) {		
		return Double.compare(Math.abs(this.fitness()-1), Math.abs(outro.fitness()-1));
	}
	

}
