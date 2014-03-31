package br.com.pchermont.ag01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe de implementa��o de uma popula��o sujeita a uma sele��o natural.
 * @author Patrizia
 *
 */
public class Populacao {

	// Lista de indiv�duos da popula��o
	List<Individuo> individuos;
	
	/**
	 * M�todo construtor da popula��o.
	 * @param n N�mero inicial de indiv�duos.
	 * @param g N�mero de genes em cada indiv�duo.
	 * @param d Desvio padr�o da ditribui��o gaussiana.
	 */
	public Populacao(int n, int g, double d) {		
		individuos = new ArrayList<Individuo>(n);
		criar(n, g, d);
	}
	
	/**
	 * Cria novos indiv�duos na popula��o.
	 * @param n N�mero inicial de indiv�duos.
	 * @param g N�mero de genes em cada indiv�duo.
	 * @param d Desvio padr�o da ditribui��o gaussiana.
	 */
	public void criar(int n, int g, double d){
		for (int i = 0; i < n; i++){			
			individuos.add(i, new Individuo(g, d));
		}
	}

	/**
	 * Ordena os indiv�duos por aptid�o. Os indiv�duos mais aptos s�o
	 * poupados enquanto os menos aptos s�o eliminados da lista.
	 * @param s N�mero de indiv�duos selecionados.
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
	 * Aplica a muta��o em todos os indiv�duos da popula��o.
	 * @param d
	 */
	public void mutacao(double d) {
		for (Individuo individuo : individuos){
			individuo.mutacao(d);
		}		
	}


}
