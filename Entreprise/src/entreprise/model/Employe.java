package entreprise.model;

import java.time.LocalDate;

public class Employe {

	private Integer id;
	private String ename;
	private String job;
	private LocalDate hiredate;
	private int sal;
	private Integer comm;
	private Employe manager;
	private Departement departement;
	
	
	
	public Employe(Integer id, String ename, String job, LocalDate hiredate, int sal, Integer comm, Employe manager, Departement departement) {
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.hiredate=hiredate;
		this.sal = sal;
		this.comm = comm;
		this.manager = manager;
		this.departement = departement;
	}



	public Integer getId() {
		return id;
	}



	public String getEname() {
		return ename;
	}



	public String getJob() {
		return job;
	}



	public int getSal() {
		return sal;
	}



	public Integer getComm() {
		return comm;
	}



	public Employe getManager() {
		return manager;
	}



	public Departement getDepartement() {
		return departement;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public void setSal(int sal) {
		this.sal = sal;
	}



	public void setComm(Integer comm) {
		this.comm = comm;
	}



	public void setManager(Employe manager) {
		this.manager = manager;
	}



	public void setDepartement(Departement departement) {
		this.departement = departement;
	}



	public LocalDate getHiredate() {
		return hiredate;
	}



	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}



	@Override
	public String toString() {
		return "Employe [id=" + id + ", ename=" + ename + ", hiredate=" + hiredate + ", job=" + job + ", sal=" + sal
				+ ", comm=" + comm + ", manager=" + manager + ", departement=" + departement + "]";
	}



	
	
	
	
}
