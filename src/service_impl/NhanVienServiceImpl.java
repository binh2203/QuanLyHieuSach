package service_impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.NhanVienDao;
import entity.NhanVien;
import service.NhanVienService;

public class NhanVienServiceImpl implements NhanVienService {
	NhanVienDao nhanVienDao = new NhanVienDao();
	public static int errorsThem = 0;
	public static int errorscapNhat = 0;

	/**
	 * @author dell 1 Lỗi tên 2 Lỗi sdt 3 Lỗi cccd 4
	 */
	@Override
	public int themNhanVien(NhanVien nv) throws SQLException {
			nhanVienDao.themNhanvien(nv);
			return 1;
	}

	@Override
	public int xoaNhanVien(String maNV) throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.xoaNhanVien(maNV);
	}

	@Override
	public List<NhanVien> getDSNhanVien() throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.getDSNhanVien();
	}

	@Override
	public List<NhanVien> timDSNhanVienTheoTen(String tenNV) throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.timDSNhanVienTheoTen(tenNV);
	}

	@Override
	public int capNhatNhanVien(NhanVien nv) throws SQLException {
			nhanVienDao.capNhatNhanVien(nv);
			return 1;
	}
	public List<NhanVien> timDSNhanVien(NhanVien nv) throws SQLException{
		
		return nhanVienDao.timDSNhanVien(nv);
	}


	@Override
	public NhanVien timNhanVienTheoMa(String maNV) throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.timNhanVienTheoMa(maNV);
	}

	@Override
	public List<NhanVien> timDanhSachNhanVienTheoMa(String maNV) throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.timDanhSachNhanVienTheoMa(maNV);
	}

	@Override
	public List<NhanVien> timNhanVienTheoSDT(String sDT) throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.timNhanVienTheoSDT(sDT);
	}

	@Override
	public List<NhanVien> getListNhanVienByNameAndSDT(String tenNV, String sdt) {
		// TODO Auto-generated method stub
		return nhanVienDao.getListNhanVienByNameAndSDT(tenNV, sdt);
	}

	@Override
	public NhanVien timNhanVienTheoTen(String tenNV) throws SQLException {
		// TODO Auto-generated method stub
		return nhanVienDao.timNhanVienTheoTen(tenNV);
	}

	@Override
	public NhanVien getNhanVienByEmail(String email) {
		// TODO Auto-generated method stub
		return nhanVienDao.getNhanVienByEmail(email);
	}

	@Override
	public List<NhanVien> getNhanVienBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhanVien> getDoanhThuCuaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhanVien> thongKeDoanhThu10NVBanNhieuNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return null;
	}

}
