package business;
	
	import java.util.ArrayList;
	import java.util.List;

	public class Curso {
		
		private String nome;
		private int codigoCurso;
		private List<Disciplina> listaDisciplinas;
		
		public Curso(String nome, int numCreditos) {
			this.nome = nome;
			this.codigoCurso = numCreditos;
			this.listaDisciplinas = new ArrayList<Disciplina>() ;
		}
		public String getNome() {
			return nome;
		}
		public int getCodigoCurso() {
			return codigoCurso;
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
		
		public void printDisciplinasCurso() {
			for (Disciplina disciplina : listaDisciplinas) {
				System.out.println("----Curso de " + this.getNome() + "-----" + "\n" + "Disciplinas do Curso: \n" + disciplina.toString());
			}
		}
		
		@Override
		public String toString() {
			return "[ Nome Curso: " + this.getNome() + " Código do Curso: " + this.getCodigoCurso() + " ]";
		}
	
}
