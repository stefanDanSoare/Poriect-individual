
public class Angajat {

	String nume;
	String email;
	String post;
	String id;
	String salariu;
	String contact;
	
	public Angajat() {
		nume="";
		email="";
		post="";
		id="";
		salariu="";
		contact="";
	}
	public Angajat(String nume,String email,String post,String id,String salariu,String contact) {
		this.nume=nume;
		this.email=email;
		this.post=post;
		this.id=id;
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
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
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
		return nume + "|   " + email +"|   "+post+"|   "+id+"|   "+salariu+"|   "+contact ;
	}
	
}
