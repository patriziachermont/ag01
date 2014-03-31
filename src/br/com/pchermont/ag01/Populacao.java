package br.com.pchermont.ag01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe de implementação de uma população sujeita a uma seleção natural.
 * @author Patrizia
 *
 */
public class Populacao {

	// Lista de indivíduos da população
	List<Individuo> individuos;
	
	/**
	 * Método construtor da população.
	 * @param n Número inicial de indivíduos.
	 * @param g Número de genes em cada indivíduo.
	 * @param d Desvio padrão da ditribuição gaussiana.
	 */
	public Populacao(int n, int g, double d) {		
		individuos = new ArrayList<Individuo>(n);
		criar(n, g, d);
	}
	
	/**
	 * Cria novos indivíduos na população.
	 * @param n Número inicial de indivíduos.
	 * @param g Número de genes em cada indivíduo.
	 * @param d Desvio padrão da ditribuição gaussiana.
	 */
	public void criar(int n, int g, double d){
		for (int i = 0; i < n; i++){			
			individuos.add(i, new Individuo(g, d));
		}
	}

	/**
	 * Ordena os indivíduos por aptidão. Os indivíduos mais aptos são
	 * poupados enquanto os menos aptos são eliminados da lista.
	 * @param s Número de indivíduos selecionados.
	 */
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

	/**
	 * Aplica a mutação em todos os indivíduos da população.
	 * @param d
	 */
	public void mutacao(double d) {
		for (Individuo individuo : individuos){
			individuo.mutacao(d);
		}		
	}


}
