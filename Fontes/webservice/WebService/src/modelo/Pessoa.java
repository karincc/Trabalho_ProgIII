package modelo;

public class Pessoa {
	private String nome;
	private float peso;

	public Pessoa() {
		//construtor em branco por conta do JPA
	}
	
	public Pessoa(String nome, float peso) throws Exception{
		setNome(nome);
		setPeso(peso);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws Exception {
		if  (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome inválido");
		}
		this.nome = nome;
	}
	
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
