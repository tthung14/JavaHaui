package de_1;

import java.util.Scanner;

public class SinhVien extends Nguoi implements TaiKhoan{
	private String maSV;
	private String nganhNghe;
	private String tenTK;
	private String mkTK;
	
	public SinhVien() {
		
	}
	public SinhVien(String hoTen, String ngaySinh, String gioiTinh, String cccd, String maSV, String nganhNghe) {
		super(hoTen, ngaySinh, gioiTinh, cccd);
		this.maSV = maSV;
		this.nganhNghe = nganhNghe;
		nhapTk();
	}

	@Override
	public void nhapTk() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap ten tai khoan: ");
		tenTK = sc.nextLine();
		System.out.println("nhap mat khau tai khoan: ");
		mkTK = sc.nextLine();
	}

	@Override
	public void hienThiTk() {
		System.out.println("Tai khoan: "+tenTK);
		System.out.println("mat khau: "+mkTK);
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
	public String getTenTK() {
		return tenTK;
	}
	public void setTenTK(String tenTK) {
		this.tenTK = tenTK;
	}
	public String getMkTK() {
		return mkTK;
	}
	public void setMkTK(String mkTK) {
		this.mkTK = mkTK;
	}
	public void hienThiThongTin() {
        System.out.println("Ho ten: " + getHoTen());
        System.out.println("Ngay sinh: " + getNgaySinh());
        System.out.println("Gioi tinh: " + getGioiTinh());
        System.out.println("CCCD: " + getCccd());
        System.out.println("Ma sinh vien: " + maSV);
        System.out.println("Nganh nghe: " + nganhNghe);
        hienThiTk();
    }
}
