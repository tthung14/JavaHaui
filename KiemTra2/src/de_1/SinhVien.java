package de_1;

import java.io.Serializable;
import java.util.Scanner;

public class SinhVien implements Serializable{
	private String maSV;
	private String hoTen;
	private String gioiTinh;
	private int namSinh;
	
	public SinhVien() {
		
	}
	public SinhVien(String maSV, String hoTen, String gioiTinh, int namSinh) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.namSinh = namSinh;
	}
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        maSV = sc.nextLine();
		System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        gioiTinh = sc.nextLine();
        System.out.print("Nhap nam sinh: ");
        namSinh = sc.nextInt();
	}
	
	@Override
    public String toString() {
        return String.format("%20s%20s%20s%20d", maSV, hoTen, gioiTinh, namSinh);
    }
}
