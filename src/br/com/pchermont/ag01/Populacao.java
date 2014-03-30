package br.com.pchermont.ag01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Populacao {

	List<Individuo> individuos;
	
	public Populacao(int n, int g, double d) {		
		individuos = new ArrayList<Individuo>(n);
		criar(n, g, d);
	}
	
	public void criar(int n, int g, double d){
		for (int i = 0; i < n; i++){			
			individuos.add(i, new Individuo(g, d));
		}
	}

	public void selecionar(int s) {
		
		int n = individuos.size();
		Collections.sort(individuos);
		
		for (int i = 0; i < n-s; i++){
			individuos.remove(s);
		}
		
		Individuo primeiro = individuos.get(0);
		System.out.println((primeiro.fitness()+"\t"+
				primeiro.genes[0]+"\t"+
				primeiro.genes[1]+"\t"+
				primeiro.genes[2]+"\t"+
				primeiro.genes[3]).replace('.', ','));
		
	}

	public void mutacao(double d) {
		for (Individuo individuo : individuos){
			individuo.mutacao(d);
		}		
	}


}
