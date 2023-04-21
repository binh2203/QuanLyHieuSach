/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String maHD;
    private NhanVien nhanVien;
    private KhachHang khachHang;
    private LocalDate ngayLapHD;
    private float tienKhachDua;

    public String getMaHD() {
        return maHD;
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
  
    public LocalDate getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(LocalDate ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public float getTienKhachDua() {
        return tienKhachDua;
    }

    public void setTienKhachDua(float tienKhachDua) {
        this.tienKhachDua = tienKhachDua;
    }

    public HoaDon() {
        super();
    }

    public HoaDon(String maHD) {
        this.maHD = maHD;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayLapHD = ngayLapHD;
        this.tienKhachDua = tienKhachDua;
    }
    
    public static String auto_Date() {
		LocalDate myObj = LocalDate.now();
		String ngay = String.valueOf(myObj.getDayOfMonth());
		String thang = String.valueOf(myObj.getMonthValue());
		String nam = String.valueOf(myObj.getYear());
		String finalDate = ngay + "-" + thang + "-" + nam;
		return finalDate;
	}

    @Override
    public String toString() {
        return "HoaDon [maHD=" + maHD + ", nhanVien=" + nhanVien + "khachHang=" + khachHang + "ngayLapHD=" + ngayLapHD + "tienKhachDua=" + tienKhachDua  + "]";
    }
    
    
}
