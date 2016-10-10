package model;

public class Utente {
	private int id;//oppure long
	
	private String nome;
	private String cognome;
	private String password;
	
	public Utente() {

	}

	public Utente(int id, String nome, String cognome, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
