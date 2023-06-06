package de_2;

public class SinhVien extends Nguoi{
	private String maSV;
	private String nganhNghe;
	private Diem diem;
	
	public SinhVien(String hoTen, String ngaySinh, String gioiTinh, String cccd, String maSV, String nganhNghe, Diem diem) {
		super(hoTen, ngaySinh, gioiTinh, cccd);
		this.maSV = maSV;
		this.nganhNghe = nganhNghe;
		this.diem = diem;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getNganhNghe() {
		return nganhNghe;
	}

	public void setNganhNghe(String nganhNghe) {
		this.nganhNghe = nganhNghe;
	}

	public Diem getDiem() {
		return diem;
	}

	public void setDiem(Diem diem) {
		this.diem = diem;
	}
	
	@Override
	public String toString() {
		return "Ma sinh vien: " + maSV + ", Ho ten: " + getHoTen() + ", Ngay sinh: " + getNgaySinh() + ", Gioi tinh: "
			    + getGioiTinh() + ", CCCD: " + getCccd() + ", Nganh nghe: " + nganhNghe + ", Diem 1: " + diem.getDiem1() + ", Diem 2: " + diem.getDiem2() + ", Diem 3: " + diem.getDiem3() +", Diem trung binh: "
			    + diem.getDiemTB();
	}
}
