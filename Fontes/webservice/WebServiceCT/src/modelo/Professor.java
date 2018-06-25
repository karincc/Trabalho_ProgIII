/**
 * Classe de dados do Professor
 * 
 * @version 0.1
 * @see Horario, Modalidade
 */

package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="professor")
public class Professor {
	
	@Id
	@GeneratedValue
	@Column(name="id")	
	private int id;
	
	@Column(name="nome", nullable=false)
	private String nome;

	@Column(name="email", nullable=false)
	private String email;

	@Column(name="dataNascimento", nullable=false)
	private Date dataNascimento;

	@Column(name="sexo", nullable=false)
	private String sexo;

	@ManyToMany(targetEntity=Horario.class)
	@JoinTable(
	        name = "horariosProfessor", 
	        joinColumns = @JoinColumn(name="professorId",referencedColumnName="id") , 
	        inverseJoinColumns = @JoinColumn(name="horarioId",referencedColumnName="id")
	)
	private List<Horario> horarios;
	
	@ManyToOne
	@JoinColumn(name="modalidade", referencedColumnName="id")
	private Modalidade modalidade;
	
	public Professor() {
		
	}
	
	public Professor(String nome, String email, Date dataNascimento, String sexo, Modalidade modalidade) {
		setNome(nome);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setModalidade(modalidade);
	}

	public Professor(int id, String nome, String email, Date dataNascimento, String sexo, Modalidade modalidade) {
		setId(id);
		setNome(nome);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setModalidade(modalidade);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Modalidade getModalidade() {
		return modalidade;
	}
	
	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
}
