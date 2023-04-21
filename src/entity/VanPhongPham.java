package entity;

public class VanPhongPham extends SanPham {
	private String tenVanPhongPham;
	private NhaSanXuat nhaSanXuat;
	private String mauSac;
	
	public VanPhongPham(String maSanPham, NhaCungCap nhaCungCap, String loaiSanPham, int soLuongTon, String donVi,
			long giaNhap, long giaBan,String tenVanPhongPham, String mauSac, NhaSanXuat nhaSanXuat) {
		super(maSanPham, nhaCungCap, loaiSanPham, soLuongTon, donVi, giaNhap,giaBan);
		this.tenVanPhongPham = tenVanPhongPham;
		this.nhaSanXuat = nhaSanXuat;
		this.mauSac = mauSac;
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

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public String toString() {
		return "VanPhongPham [tenVanPhongPham=" + tenVanPhongPham + ", nhaSanXuat=" + nhaSanXuat + ", mauSac=" + mauSac + "]";
	}
	
}
