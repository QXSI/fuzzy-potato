package it.cefi.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sviluppatori")
public class Sviluppatore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	
	@OneToMany (mappedBy="sviluppatore", orphanRemoval = true, cascade = CascadeType.MERGE)
	private List<Videogioco> videogiochi = new ArrayList<>();

	
	public Sviluppatore() {
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

	
	public List<Videogioco> getVideogiochi() {
		return videogiochi;
	}
	public void setVideogiochi(List<Videogioco> videogiochi) {
		this.videogiochi = videogiochi;
	}
}
