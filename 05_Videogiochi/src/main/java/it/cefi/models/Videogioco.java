package it.cefi.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "videogiochi")
public class Videogioco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(length = 100, nullable = false)
	private String titolo;
	
	
	@ManyToOne (cascade = CascadeType.MERGE)
	@JoinColumn (name = "sviluppatore", referencedColumnName = "id")
	private Sviluppatore sviluppatore;
	
	
	@Column
	private int anno;
	
	
	public Videogioco() {
		anno = LocalDate.now().getYear();
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	
	public Sviluppatore getSviluppatore() {
		return sviluppatore;
	}
	public void setSviluppatore(Sviluppatore sviluppatore) {
		this.sviluppatore = sviluppatore;
	}

	
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}

}
