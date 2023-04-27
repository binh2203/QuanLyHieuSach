package entity;

public class Sach extends SanPham{
	private String tenSach;
	private TacGia tacGia;
	private NhaXuatBan nhaXuatBan;
	private TheLoaiSach theLoaiSach;

	public Sach() {
		super();
	}

	public Sach(String maSanPham) {
		super(maSanPham);
	}

	public Sach(String maSanPham, NhaCungCap nhaCungCap, String loaiSanPham, int soLuongTon, String donVi,
			long giaNhap, long giaBan,String tenSach, TacGia tacGia, NhaXuatBan nhaXuatBan, TheLoaiSach theLoaiSach) {
		super(maSanPham, nhaCungCap, loaiSanPham, soLuongTon, donVi, giaNhap,giaBan);
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

	public TheLoaiSach getTheLoaiSach() {
		return theLoaiSach;
	}

	public void setTheLoaiSach(TheLoaiSach theLoaiSach) {
		this.theLoaiSach = theLoaiSach;
	}

	@Override
	public String toString() {
		return "Sach [tenSach=" + tenSach + ", tacGia=" + tacGia + ", nhaXuatBan=" + nhaXuatBan + ", theLoaiSach="
				+ theLoaiSach + "]";
	}
	
	
	
}
