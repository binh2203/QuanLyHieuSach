package entity;

import java.time.LocalDate;

public class PhieuDatHang {
	private String maPDH;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDate ngayLapPDH;
	private LocalDate ngayLayHang;
	private boolean trangThai;
	public String getMaPDH() {
		return maPDH;
	}
	public void setMaPDH(String maPDH) {
		this.maPDH = maPDH;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public LocalDate getNgayLapPDH() {
		return ngayLapPDH;
	}
	public void setNgayLapPDH(LocalDate ngayLapPDH) {
		this.ngayLapPDH = ngayLapPDH;
	}
	public LocalDate getNgayLayHang() {
		return ngayLayHang;
	}
	public void setNgayLayHang(LocalDate ngayLayHang) {
		this.ngayLayHang = ngayLayHang;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public PhieuDatHang(String maPDH, NhanVien nhanVien, KhachHang khachHang, LocalDate ngayLapPDH,
			LocalDate ngayLayHang, boolean trangThai) {
		this.maPDH = maPDH;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLapPDH = ngayLapPDH;
		this.ngayLayHang = ngayLayHang;
		this.trangThai = trangThai;
	}

	public PhieuDatHang() {

	}
	@Override
	public String toString() {
		return "PhieuDatHang [maPDH=" + maPDH + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayLapPDH="
				+ ngayLapPDH + ", ngayLayHang=" + ngayLayHang + ", trangThai=" + trangThai + "]";
	}
	
	
}
