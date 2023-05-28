package service_impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import dao.NhanVienDao;
import entity.NhanVien;
import service.NhanVienService;

import dao.ThongKeDao;
public class NhanVienServiceImpl implements NhanVienService {
	NhanVienDao nhanVienDao = new NhanVienDao();
	
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
	public NhanVien timNhanVienTheoTen(String ten) throws SQLException{
		return nhanVienDao.timNhanVienTheoTen(ten);
	}

	@Override
	public List<NhanVien> getNhanVienBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return thongKeDao.getNhanVienBanNhieuNhatTheoNgayTuChon(ngayBatDau, ngayKetThuc);
	}

	@Override
	public List<NhanVien> getDoanhThuCuaNhanVien(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NhanVien> thongKeDoanhThu10NVBanNhieuNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc) {
		// TODO Auto-generated method stub
		return nhanVienDao.thongKeDoanhThu10NVBanNhieuNhat(ngayBatDau, ngayKetThuc);
	}

	
	//lĩnh
	private ThongKeDao thongKeDao = new ThongKeDao();

	@Override
	public NhanVien getNhanVienByEmail(String email) {
		// TODO Auto-generated method stub
		return nhanVienDao.getNhanVienByEmail(email);
	}
}
