/**
 * Classe de dados do Usuario
 * 
 * @version 0.1
 * @see Agendamento
 */

package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
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
	
	@Column(name="senha", nullable=false)
	private String senha;
	
	@OneToMany(mappedBy="usuario",targetEntity=Agendamento.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Agendamento> agendamentos;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String nome, String email, Date dataNascimento, String sexo, String senha) {
		setId(id);
		setNome(nome);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setSenha(senha);
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
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
