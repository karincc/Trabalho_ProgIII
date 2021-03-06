/**
 * Classe de dados de horarios disponieis 
 * 
 * @version 0.1
 * @see Professor
 */

package modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@ManyToMany(mappedBy="horarios", targetEntity=Professor.class)
	private List<Professor> professores;
	
	@Column(name="horario", nullable=false)
	private String horario;
	
	public Horario() {
		
	}

	public Horario(String horario) {
		setHorario(horario);
	}
	
	public Horario(int id, String horario) {
		setId(id);
		setHorario(horario);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}	
}
