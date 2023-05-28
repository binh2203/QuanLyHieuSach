package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import entity.NhanVien;

public interface NhanVienService {
	public int themNhanVien(NhanVien nv) throws SQLException;

	public NhanVien timNhanVienTheoMa(String maNV) throws SQLException;

	public int xoaNhanVien(String maNV) throws SQLException;

	public List<NhanVien> getDSNhanVien() throws SQLException;

	public int capNhatNhanVien(NhanVien nv) throws SQLException;
	
	public NhanVien timNhanVienTheoTen(String ten) throws SQLException;

	public List<NhanVien> getNhanVienBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc);

	public List<NhanVien> getDoanhThuCuaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException;

	public List<NhanVien> timDSNhanVien(NhanVien nv) throws SQLException;
	
//Lĩnh
	public List<NhanVien> thongKeDoanhThu10NVBanNhieuNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc);
	public NhanVien getNhanVienByEmail(String email);

}
