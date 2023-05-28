package service_impl;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.SanPhamDao;
import dao.ThongKeDao;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;
import service.SanPhamService;

public class SanPhamServiceImpl implements SanPhamService {
	SanPhamDao sanPhamDao = new SanPhamDao();
	ThongKeDao thongKeDao = new ThongKeDao();
	public ArrayList<Sach> getListSach(String maSach, String tenSP, String maTheLoai, Long giaTu, Long giaDen,
			String maTacGia, String maNXB, String maNCC, boolean hetHang) throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.getListSach(maSach, tenSP, maTheLoai, giaTu, giaDen, maTacGia, maNXB, maNCC, hetHang);
	}
	public List<Sach> getAllSach() throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.getAllSach();
	}
	@Override
	public List<VanPhongPham> getAllVPP() {
		// TODO Auto-generated method stub
		return sanPhamDao.getAllVPP();
	}
	@Override
	public ArrayList<VanPhongPham> getListVanPhongPham(String maVPP, String tenVPP, String theLoaiVPP, Long giaTu,
			Long giaDen, String maNSX, String maNCC, boolean hetHang) throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.getListVanPhongPham(maVPP, tenVPP, theLoaiVPP, giaTu, giaDen, maNSX, maNCC, hetHang);
	}
	@Override
	public Sach getSachTheoTen(String ten) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Sach timSanPhamTheoMaSach(String maSach) throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.timSanPhamTheoMaSach(maSach);
	}
	@Override
	public Sach getSachTheoMaSP(String maSP) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public VanPhongPham timSanPhamTheoMaVPP(String maVPP) throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.timSanPhamTheoMaVPP(maVPP);
	}
	@Override
	public VanPhongPham getVPPTheoMaSP(String maSP) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SanPham getSanPhamTheoMa(String masp) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SanPham timSanPhamTheoMa(String maSP) throws SQLException {
		// TODO Auto-generated method stub
		return sanPhamDao.timSanPhamTheoMa(maSP);
	}
	@Override
	public boolean xoaSanPham(String maSP) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getSoLuongSachTon() throws SQLException {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongSachTon();
	}
	@Override
	public SanPham timSanPhamTheoMa1(String maSP) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getMaSPMax() throws SQLException {
		// TODO Auto-generated method stub
		return sanPhamDao.getMaSPMax();
	}
	@Override
	public boolean capNhatSanPham(String maSP, SanPham temp) throws SQLException {
		// TODO Auto-generated method stub
		return sanPhamDao.capNhatSanPham(maSP, temp);
	}
	@Override
	public boolean themSanPham(SanPham sanPham) throws Exception {
		// TODO Auto-generated method stub
		boolean exist = true;
		if(sanPham instanceof Sach) {
			Sach sach = (Sach) sanPham;
			exist = sanPhamDao.kiemTraTonTaiSanPham(sach.getTenSach());
		}else {
			VanPhongPham vanPhongPham = (VanPhongPham) sanPham;
			exist = sanPhamDao.kiemTraTonTaiSanPham(vanPhongPham.getTenVanPhongPham());
		}
		if(exist == true) {
			return false;
		}
		return sanPhamDao.themSanPham(sanPham);
	}
	@Override
	public int capNhatSoLuongSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getSoLuongVPPTon() throws SQLException {
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongVPPTon();
	}
	@Override
	public List<SanPham> getSanPhamBanNhieuNhatTheoNgayTuChon(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException{
		// TODO Auto-generated method stub
		return thongKeDao.getSanPhamBanNhieuNhatTheoNgayTuChon(ngayBatDau, ngayKetThuc);
	}
	@Override
	public int getSoLuongBanCuaSanPhamChayNhat(LocalDate ngayBatDau, LocalDate ngayKetThuc) throws SQLException{
		// TODO Auto-generated method stub
		return thongKeDao.getSoLuongBanCuaSanPhamChayNhat(ngayBatDau, ngayKetThuc);
	}
	
	
}
