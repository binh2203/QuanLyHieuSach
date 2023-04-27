package entity;

public class VanPhongPham extends SanPham {
	private String tenVanPhongPham;
	private NhaSanXuat nhaSanXuat;
	private MauSac mauSac;
	private TheLoaiVanPhongPham loaiVanPhongPham;

	public VanPhongPham(String maSanPham, NhaCungCap nhaCungCap, String loaiSanPham, int soLuongTon, String donVi,
			long giaNhap, long giaBan,String tenVanPhongPham, MauSac mauSac, NhaSanXuat nhaSanXuat,TheLoaiVanPhongPham loaiVanPhongPham) {
		super(maSanPham, nhaCungCap, loaiSanPham, soLuongTon, donVi, giaNhap,giaBan);
		this.tenVanPhongPham = tenVanPhongPham;
		this.nhaSanXuat = nhaSanXuat;
		this.mauSac = mauSac;
		this.loaiVanPhongPham = loaiVanPhongPham;
	}
	
	public VanPhongPham() {
		// TODO Auto-generated constructor stub
		super();
	}

	public VanPhongPham(String maSanPham) {
		super(maSanPham);
	}

	public String getTenVanPhongPham() {
		return tenVanPhongPham;
	}

	public void setTenVanPhongPham(String tenVanPhongPham) {
		this.tenVanPhongPham = tenVanPhongPham;
	}

	public NhaSanXuat getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public MauSac getMauSac() {
		return mauSac;
	}

	public void setMauSac(MauSac mauSac) {
		this.mauSac = mauSac;
	}
	
	
	public TheLoaiVanPhongPham getLoaiVanPhongPham() {
		return loaiVanPhongPham;
	}

	public void setLoaiVanPhongPham(TheLoaiVanPhongPham loaiVanPhongPham) {
		this.loaiVanPhongPham = loaiVanPhongPham;
	}

	@Override
	public String toString() {
		return "VanPhongPham [tenVanPhongPham=" + tenVanPhongPham + ", nhaSanXuat=" + nhaSanXuat + ", mauSac=" + mauSac + ", loaiVanPhongPham=" + loaiVanPhongPham + "]";
	}
	
}
