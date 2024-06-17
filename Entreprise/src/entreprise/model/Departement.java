package entreprise.model;

public class Departement {

	private Integer deptno;
	private String dname;
	private String loc;
	
	public Departement(Integer deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public String getDname() {
		return dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departement [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}

	
	
}
