package models;

public class Product {

	private int pid;
	private String ptitle;
	private int pprct_id;
	private int phsnc_id;
	private String pbrand;
	private String pimage;
	private String pbatchno;
	private double pprice;
	private int pstock;
	private double pmrp;
	
	public Product(int pid, String ptitle, int pprct_id, int phsnc_id, String pbrand, String pimage, String pbatchno,
			double pprice, int pstock, double pmrp) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pprct_id = pprct_id;
		this.phsnc_id = phsnc_id;
		this.pbrand = pbrand;
		this.pimage = pimage;
		this.pbatchno = pbatchno;
		this.pprice = pprice;
		this.pstock = pstock;
		this.pmrp = pmrp;
	}
	
	public String getPbatchno() {
		return pbatchno;
	}
	public void setPbatchno(String pbatchno) {
		this.pbatchno = pbatchno;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public double getPmrp() {
		return pmrp;
	}
	public void setPmrp(double pmrp) {
		this.pmrp = pmrp;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public int getPprct_id() {
		return pprct_id;
	}
	public void setPprct_id(int pprct_id) {
		this.pprct_id = pprct_id;
	}
	public int getPhsnc_id() {
		return phsnc_id;
	}
	public void setPhsnc_id(int phsnc_id) {
		this.phsnc_id = phsnc_id;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	
	
	
}
