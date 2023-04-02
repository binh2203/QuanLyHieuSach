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
	public static int errorsSua = 0;

	/**
	 * @author dell 1 Lỗi tên 2 Lỗi sdt 3 Lỗi cccd 4
	 */
	@Override
	public int themNhanVien(NhanVien nv) throws SQLException {
		if (!(nv.getHoTenNV().length() > 0 && nv.getHoTenNV()
				.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊ"
						+ "ỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]*"))) {
			errorsThem = 1;
			return -1;
		} else if (!(nv.getSoDienThoaiNV().length() > 0 && nv.getSoDienThoaiNV().matches("^[0-9]{10}$"))) {
			errorsThem = 2;
			return -1;

		} else if (!(nv.getEmailNV().length() > 0 && nv.getEmailNV().matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {
			errorsThem = 3;
			return -1;
		} else if (!(nv.getDiaChiNV().length() > 0 && nv.getDiaChiNV()
				.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊ"
						+ "ỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ,\\w\\s]*"))) {
			errorsThem = 4;
			return -1;
		} else {
			nhanVienDao.themNhanvien(nv);
			return 1;

		}

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
	public int suaNhanVien(NhanVien nv) throws SQLException {
		// TODO Auto-generated method stub
		if (!(nv.getHoTenNV().length() > 0 && nv.getHoTenNV()
				.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊ"
						+ "ỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]*"))) {
			errorsSua = 1;
			return -1;
		} else if (!(nv.getSoDienThoaiNV().length() > 0 && nv.getSoDienThoaiNV().matches("^[0-9]{10}$"))) {
			errorsSua = 2;
			return -1;

		} else if (!(nv.getEmailNV().length() > 0 && nv.getEmailNV().matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {
			errorsSua = 3;
			return -1;
		} else if (!(nv.getDiaChiNV().length() > 0 && nv.getDiaChiNV()
				.matches("[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊ"
						+ "ỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ,\\w\\s]*"))) {
			errorsSua = 4;
			return -1;
		} else {
			nhanVienDao.suaNhanVien(nv);
			return 1;
		}

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
