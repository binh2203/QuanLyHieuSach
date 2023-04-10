package service_impl;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.SanPhamDao;
//import dao.ThongKeDao;
import entity.Sach;
import entity.SanPham;
//import entity.VanPhongPham;
import service.SanPhamService;

public class SanPhamServiceImpl {
	SanPhamDao sanPhamDao = new SanPhamDao();
	
	public ArrayList<Sach> getListSach(String maSach, String tenSP, String maTheLoai, Long giaTu, Long giaDen,
			String maTacGia, String maNXB, String maNCC, boolean hetHang) throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.getListSach(maSach, tenSP, maTheLoai, giaTu, giaDen, maTacGia, maNXB, maNCC, hetHang);
	}
	public List<Sach> getAllSach() throws Exception {
		// TODO Auto-generated method stub
		return sanPhamDao.getAllSach();
	}
}
