package br.com.pchermont.ag01;

import java.util.Random;

public class Individuo implements Comparable<Individuo> {
		
	double genes[];	
	Random random;
	
	public Individuo(int g, double d){

		random   = new Random();		
		genes = new double[g];
		
		for (int i = 0; i < g; i++){
			genes[i] = random.nextGaussian() * d;
		}		
		
	}
	
	public void mutacao(double d){
		int i = random.nextInt(genes.length);
		genes[i] += random.nextGaussian() * d;
	}
	
	public double fitness(){
		double soma = 0;		
		for (int i = 0; i < genes.length; i++){			
			soma += genes[i];
		}
		return soma/genes.length;
	}

	@Override
	public int compareTo(Individuo outro) {		
		return Double.compare(Math.abs(this.fitness()-1), Math.abs(outro.fitness()-1));
	}
	

}
