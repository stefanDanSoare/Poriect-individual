
public class Angajat {

	String nume;
	String email;
	String post;
	String CNP;
	String salariu;
	String contact;
	String manager;
	String parola;
	int zile;
	
	public int getZile() {
		return zile;
	}
	public void setZile(int zile) {
		this.zile = zile;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public String getCNP() {
		return CNP;
	}
	public void setCNP(String cNP) {
		CNP = cNP;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Angajat() {
		nume="";
		email="";
		post="";
		CNP="";
		salariu="";
		contact="";
	}
	public Angajat(String nume,String email,String post,String id,String salariu,String contact) {
		this.nume=nume;
		this.email=email;
		this.post=post;
		this.CNP=id;
		this.salariu=salariu;
		this.contact=contact;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSalariu() {
		return salariu;
	}
	public void setSalariu(String salariu) {
		this.salariu = salariu;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String toString() {
		return nume + "|   " + email +"|   "+post+"|   "+CNP+"|   "+salariu+"|   "+contact ;
	}
	
}
