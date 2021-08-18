package src;

import java.util.ArrayList;
import java.util.List;

public class Curso {
	
	private String nome;
	private int numCreditos;
	private List<Disciplinas> listaDisciplinas = new ArrayList<Disciplinas>() ;
	
	public String getNome() {
		return nome;
	}
	public int getNumCreditos() {
		return numCreditos;
	}
	
}
