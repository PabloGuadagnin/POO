package A1;

public class estudante {

	private int Matricula;
	private String Nome;
	private String Curso;
	
	public estudante(int matricula, String nome, String curso) {
		Matricula = matricula;
		Nome = nome;
		Curso = curso;
	}
	public int getMatricula() {
		return Matricula;
	}
	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCurso() {
		return Curso;
	}
	public void setCurso(String curso) {
		Curso = curso;
	}	
}