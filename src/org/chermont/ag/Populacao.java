package org.chermont.ag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Populacao {

	List<Individuo> individuos;
	
	int n;
	int g;
	double sd;
	
	public Populacao(int n, int g, double sd) {
		
		this.n  = n;
		this.g  = g;
		this.sd = sd;
		
		individuos = new ArrayList<Individuo>(n);
		for (int i = 0; i < n; i++){			
			individuos.add(i, new Individuo(n, sd));
		}
	}

	public void selecionar(int aptos) {
		
		Collections.sort(individuos);
		
		for (int i = 0; i < n-aptos; i++){
			individuos.remove(aptos);
		}
		
	}	

	public void adicionar(int novos) {
		for (int i = 0; i < novos; i++){
			individuos.add(new Individuo(g, sd));
		}
		
	}

	public String relatorio() {
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(individuos);
		
		for (int i = 0; i < n; i++){
			sb.append(individuos.get(i).fitness());
			if (i < n-1 ){
				sb.append(";");
			} else {
				sb.append("\n");
			}
		}
		System.out.print(sb);
		
		return new String(sb);
	}

	public void mutacao() {
		for (Individuo ind : individuos){
			ind.mutar();
		}		
	}


}
