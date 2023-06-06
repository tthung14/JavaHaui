package de_2;

import java.io.Serializable;
import java.util.Scanner;

import javax.print.CancelablePrintJob;

public class Sach implements Serializable{
	private String iD;
	private String tenSach;
	private String tacGia;
	private String nhaXB;
	private int namXB;
	
	public Sach() {}

	public Sach(String iD, String tenSach, String tacGia, String nhaXB, int namXB) {
		this.iD = iD;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.nhaXB = nhaXB;
		this.namXB = namXB;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ma sach: ");
		iD = sc.nextLine();
		System.out.print("ten sach: ");
		tenSach = sc.nextLine();
		System.out.print("tac gia: ");
		tacGia = sc.nextLine();
		System.out.print("nha xuat ban: ");
		nhaXB = sc.nextLine();
		System.out.print("nam xuat ban: ");
		namXB = sc.nextInt();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%20s%20s%20s%20s%20d", iD, tenSach, tacGia, nhaXB, namXB);
	}
}
