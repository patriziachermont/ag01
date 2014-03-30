package br.com.pchermont.ag01;

public class Main {

	public static void main(String[] args) {
		
		int e = 100;
		int n = 10;
		int s = 5;		
		int g = 4;
		double d = 10;		
		
		Populacao populacao = new Populacao(n, g, d);
		
		for (int i = 0; i < e; i++){
			populacao.selecionar(s);
			populacao.mutacao(d);
			populacao.criar(n-s, g, d);
		}
		
		System.exit(0);

	}

}
