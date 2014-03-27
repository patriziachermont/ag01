package org.chermont.ag;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Relatorio {
	
	protected StringBuilder texto;
	protected String arquivo;

	public Relatorio(String texto, String arquivo){
		this.texto = new StringBuilder(texto);
		this.arquivo = arquivo;
	}
	
	public void adicionar(String texto){
		this.texto.append(texto);
	}
	
	public void escrever(){
		try {
			File f = new File(arquivo);
			if (!f.exists()){	
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
