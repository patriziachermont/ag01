package org.chermont.ag;

import java.util.Random;

public class Individuo implements Comparable<Individuo> {
		
	protected double genotipo[];
	protected double desvio;
	protected int genes;
	
	protected Random random;
	
	public Individuo(int n, double sd){
		
		genes    = n;
		desvio   = sd;
		random   = new Random();		
		genotipo = new double[genes];
		
		for (int i = 0; i < genes; i++){
			genotipo[i] = random.nextGaussian() * desvio;
		}		
		
	}
	
	public void mutar(){
		genotipo[0] = random.nextGaussian() * desvio;		
	}
	
	public double fitness(){
		double soma = 0;
		for (int i = 0; i < genes; i++){
			soma = soma + genotipo[i];
		}
		return soma/genes;
	}

	@Override
	public int compareTo(Individuo outro) {		
		return Double.compare(Math.abs(this.fitness()-1), Math.abs(outro.fitness()-1));
	}
	

}
