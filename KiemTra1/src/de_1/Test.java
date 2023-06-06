package de_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
static List<SinhVien> danhSachSV = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n-----------CHUONG TRINH QUAN LY SINH VIEN-----------");
			System.out.println("1. Nhap danh sach sinh vien");
		    System.out.println("2. Hien thi");
		    System.out.println("3. Tim kiem");
			System.out.println("4. Thoat");
			System.out.print("Chon chuc nang: ");
			int choose = sc.nextInt();
			
			switch (choose) {
			case 1: 
				nhapDanhSachSinhVien();
				break;
			case 2: 
				hienThiDanhSachSinhVien();
				break;
			case 3: 
				String foundMa;
				sc.nextLine();
				System.out.println("Nhap ma sinh vien can tim: ");
				foundMa = sc.nextLine();
				timKiemSinhVien(foundMa);
				break;
			case 4:
				System.out.println("thoat chuong trinh");
				System.exit(4);
				break;
			default:
				System.out.println("khong co lua chon nay!");
			}
		}
		while(true);
	}
	
	public static void nhapDanhSachSinhVien() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin sinh vien " + (i + 1) + ": ");
            System.out.print("Ho ten: ");
            String hoTen = scanner.nextLine();
            System.out.print("Ngay sinh: ");
            String ngaySinh = scanner.nextLine();
            System.out.print("Gioi tinh: ");
            String gioiTinh = scanner.nextLine();
            System.out.print("CCCD: ");
            String cccd = scanner.nextLine();
            System.out.print("Ma sinh vien: ");
            String maSV = scanner.nextLine();
            System.out.print("Nganh nghe: ");
            String nganhNghe = scanner.nextLine();
            SinhVien sv = new SinhVien(hoTen, ngaySinh, gioiTinh, cccd, maSV, nganhNghe);
            danhSachSV.add(sv);
        }
	}
	
	public static void hienThiDanhSachSinhVien() {
	    for (SinhVien sv : danhSachSV) {
	        sv.hienThiThongTin();
	        System.out.println("------------------------");
	    }
	}

	public static void timKiemSinhVien(String maSV) {
	    boolean found = false;

	    for (SinhVien sinhVien : danhSachSV) {
	        if (sinhVien.getMaSV().equals(maSV)) {
	            sinhVien.hienThiThongTin();
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Khong tim thay sinh vien co ma " + maSV);
	    }
	}
}
