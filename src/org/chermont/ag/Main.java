package org.chermont.ag;

public class Main {

	public static void main(String[] args) {
		
		int epo    = 100;
		int pop    = 10;
		int apt    = 5;		
		int gen    = 4;
		double sdv = 2;		
		
		Populacao populacao = new Populacao(pop, gen, sdv);
		StringBuilder relatorio = new StringBuilder();
		
		for (int i = 0; i < epo; i++){
			populacao.selecionar(apt);
			populacao.mutacao();
			populacao.adicionar(pop-apt);			
			relatorio.append(populacao.relatorio());
		}
		
		Relatorio r = new Relatorio(relatorio.toString(), "relatorio.csv");
		r.escrever();
		
		System.exit(0);

	}

}
