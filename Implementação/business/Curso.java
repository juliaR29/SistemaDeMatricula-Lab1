package business;
	
	import java.util.ArrayList;
	import java.util.List;

	public class Curso {
		
		private String nome;
		private int numCreditos;
		private List<Disciplina> listaDisciplinas = new ArrayList<Disciplina>() ;
		
		public String getNome() {
			return nome;
		}
		public int getNumCreditos() {
			return numCreditos;
		}
		public List<Disciplina> getListaDisciplinas() {
			return listaDisciplinas;
		}
		
		public void add(Disciplina d) {
			listaDisciplinas.add(d);
		}
		
		public void remove(Disciplina d) {
			listaDisciplinas.remove(d);
		}
	
}
