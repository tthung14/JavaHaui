package de_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test {
	static List<SinhVien> danhSachSinhVien = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {	
		
		do {
			System.out.println("\n-----------CHUONG TRINH QUAN LY SINH VIEN-----------");
			System.out.println("1. Nhap danh sach sinh vien");
			System.out.println("2. Hien thi");
			System.out.println("3. Sap xep");
			System.out.println("4. Thoat");
			System.out.print("Chon chuc nang: ");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				nhapDanhSachSinhVien();
				break;
			case 2:
				HienThi();
				break;
			case 3:
				SapXep();
				break;
			case 4:
				System.out.println("Thoat chuong trinh");
				System.exit(4);
				break;
			default:
				System.out.println("nhap lai di em");
			}
		}
		while(true);
	}
	
	public static void nhapDanhSachSinhVien() {
		System.out.print("Nhap so luong sinh vien:");
		int soLuong = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < soLuong; i++) {
			System.out.println("Nhap so luong sinh vien thu "+ (i+1) +": ");
			System.out.print("Ho ten: ");
			String hoTen = sc.nextLine();
			System.out.print("Ngay sinh: ");
			String ngaySinh = sc.nextLine();
			System.out.print("Gioi tinh: ");
			String gioiTinh = sc.nextLine();
			System.out.print("CCCD: ");
			String cccd = sc.nextLine();
			System.out.print("Ma sinh vien: ");
			String maSV = sc.nextLine();
			System.out.print("Nganh nghe: ");
			String nganhNghe = sc.nextLine();
			System.out.print("Diem 1: ");
			Double diem1 = sc.nextDouble();
			System.out.print("Diem 2: ");
			Double diem2 = sc.nextDouble();
			System.out.print("Diem 3: ");
			Double diem3 = sc.nextDouble();
			sc.nextLine();
			Diem diem = new Diem(diem1, diem2, diem3);
			SinhVien sv = new SinhVien(hoTen, ngaySinh, gioiTinh, cccd, maSV, nganhNghe, diem);
			danhSachSinhVien.add(sv);
		}
	}
	
	public static void HienThi() {
		for (SinhVien sv : danhSachSinhVien) {
			System.out.println(sv);
		}
	}
	
	public static void SapXep() {
		Collections.sort(danhSachSinhVien, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				double diem1 = sv1.getDiem().getDiemTB();
				double diem2 = sv2.getDiem().getDiemTB();
				if (diem1 < diem2) {
					return -1;
				}
				else if (diem1 > diem2) {
					return 1;
				}
				return 0;
			}
		});
		
		System.out.println("Danh sach sinh vien sau khi sap xep:");
		HienThi();
	}
}
