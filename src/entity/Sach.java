package entity;

public class Sach extends SanPham{
	private String tenSach;
	private TacGia tacGia;
	private NhaXuatBan nhaXuatBan;
	private String theLoaiSach;

	public Sach() {
		super();
	}

	public Sach(String maSanPham) {
		super(maSanPham);
	}

	public Sach(String tenSach, TacGia tacGia, NhaXuatBan nhaXuatBan, String theLoaiSach) {
		super();
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.theLoaiSach = theLoaiSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TacGia getTacGia() {
		return tacGia;
	}

	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}

	public NhaXuatBan getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getTheLoaiSach() {
		return theLoaiSach;
	}

	public void setTheLoaiSach(String theLoaiSach) {
		this.theLoaiSach = theLoaiSach;
	}

	@Override
	public String toString() {
		return "Sach [tenSach=" + tenSach + ", tacGia=" + tacGia + ", nhaXuatBan=" + nhaXuatBan + ", theLoaiSach="
				+ theLoaiSach + "]";
	}
	
	
	
}
