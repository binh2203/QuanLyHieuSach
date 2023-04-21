package entity;

public class SanPham {

	private String maSanPham;
	private NhaCungCap nhaCungCap;
	private String loaiSanPham;
	private int soLuongTon;
	private String donVi;
	private long giaNhap;
	private long giaBan;
		
	public SanPham() {
		super();
	}
		
	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}

	public SanPham(String maSanPham, NhaCungCap nhaCungCap, String loaiSanPham, int soLuongTon, String donVi,
			long giaNhap, long giaBan) {
		super();
		this.maSanPham = maSanPham;
		this.nhaCungCap = nhaCungCap;
		this.loaiSanPham = loaiSanPham;
		this.soLuongTon = soLuongTon;
		this.donVi = donVi;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
	}

	public SanPham(String maSanPham, int soLuongTon) {
		super();
		this.maSanPham = maSanPham;
		this.soLuongTon = soLuongTon;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public long getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(long giaNhap) {
		this.giaNhap = giaNhap;
	}

	public long getGiaBan() {
		return (giaNhap*20/100)+giaNhap;
	}
	//Tính giá bán: 
	public void setGiaBan() {
		this.giaBan = getGiaNhap() + (getGiaNhap()*20/100);
	}

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", nhaCungCap=" + nhaCungCap + ", loaiSanPham=" + loaiSanPham
				+ ", soLuongTon=" + soLuongTon + ", donVi=" + donVi + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan
				+ "]";
	}
	
	
}
