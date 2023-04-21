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
public class KhachHang {
    private String maKH;
    private String hoTenKH;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private String SDT;
    private String diaChi;
    private String email;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
        this.hoTenKH = hoTenKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.email = email;
    }

    public KhachHang(String maKH, String hoTenKH, boolean gioiTinh, LocalDate ngaySinh, String sDT, String diaChi,
			String email) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.diaChi = diaChi;
		this.email = email;
	}
    

	public KhachHang(String maKH, String hoTenKH, String sDT) {
		super();
		this.maKH = maKH;
		this.hoTenKH = hoTenKH;
		SDT = sDT;
	}

	public KhachHang() {
    }
    
    @Override
    public String toString() {
        return "KhachHang [maKH=" + maKH + ", hoTenKH=" + hoTenKH + ", gioiTinh=" + gioiTinh + ", ngaySinh="
				+ ngaySinh + ", soDienThoai=" + SDT + ", diaChi=" + diaChi + ", email=" + email
				+ "]";
    }
    
    
}
