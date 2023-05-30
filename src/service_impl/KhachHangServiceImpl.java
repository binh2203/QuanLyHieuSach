package service_impl;

import entity.KhachHang;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.KhachHangDao;
import service.KhachHangService;

/**
 *
 * @author Student
 */
public class KhachHangServiceImpl implements KhachHangService{
	private final KhachHangDao KhachHang = new KhachHangDao();
    @Override
    public int themKhachHang(KhachHang kh) throws SQLException {
            KhachHang.themKhachHang(kh);
            return 1;
    }

    @Override
    public List<KhachHang> getDSKhachHang() throws SQLException {
        return KhachHang.getDSKhachHang();
    }

    @Override
    public int capNhatKhachHang(KhachHang kh) {
        
        return KhachHang.capNhatKhachHang(kh);
    }

    @Override
    public int xoaKhachHang(String maKH) {
        return KhachHang.xoaKhachHang(maKH);
    }

	@Override
	public List<entity.KhachHang> timDSKH(entity.KhachHang kh) throws SQLException {
		// TODO Auto-generated method stub
		return KhachHang.timDSKH(kh);
	}

	@Override
	public entity.KhachHang getKhachHangTheoMa(String maKH) throws SQLException {
		// TODO Auto-generated method stub
		return KhachHang.getKhachHangTheoMa(maKH);
	}

	@Override
	public entity.KhachHang getKhachHangTheoSDT(String sDT) throws SQLException {
		// TODO Auto-generated method stub
		return KhachHang.getKhachHangTheoSDT(sDT);
	}

}
