/**
 * Classe de dados de agendamento de horarios 
 * 
 * @version 0.1
 * @see Usuario, Modalidade
 */

package modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Agendamento")
public class Agendamento {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="dataHora",nullable=false)
	private Date dataHora;
	
	@ManyToOne
	@JoinColumn(name="usuario", referencedColumnName="id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="modalidade", referencedColumnName="id")
	private Modalidade modalidade;
	
	public Agendamento() {
		
	}
	
	public Agendamento(Date dataHora, Usuario usuario, Modalidade modalidade){
		setDataHora(dataHora);
		setUsuario(usuario);
		setModalidade(modalidade);
	}
	
	public Agendamento(int id, Date dataHora, Usuario usuario, Modalidade modalidade){
		setId(id);
		setDataHora(dataHora);
		setUsuario(usuario);
		setModalidade(modalidade);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	
}
