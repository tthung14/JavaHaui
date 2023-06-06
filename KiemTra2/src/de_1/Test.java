package de_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
	static List<SinhVien> danhSachSV = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		do {
			System.out.println("CHUONG TRINH QLSV");
			System.out.println("-----------------");
			System.out.println("1. Nhap");
			System.out.println("2. Hien thi");
			System.out.println("3. Sap xep");
			System.out.println("4. Tim kiem");
			System.out.println("5. Thoat");
			System.out.print("Chon chuc nang:");
			int choose = sc.nextInt();
			switch (choose) {
			case 1: 			
				nhap();
				break;
			case 2: 
				hienThi();
				break;
			case 3: 
				sapXep();
				break;
			case 4: 
				timKiem();
				break;
			case 5: 
				System.out.println("program exit");
				System.exit(5);
				break;
			default:
				System.out.println("khong co lua chon nay");
			}
		}while(true);
	}
	
	public static void nhap() {
		System.out.print("nhap so luong sinh vien: ");
		int soLuong = sc.nextInt();	
		sc.nextLine();
		for (int i = 0; i < soLuong; i++) {
			System.out.println("Nhap sinh vien thu "+ (i+1) +": ");
			System.out.print("Nhap ma sinh vien: ");
	        String maSV = sc.nextLine();
			System.out.print("Nhap ho ten: ");
	        String hoTen = sc.nextLine();
	        System.out.print("Nhap gioi tinh: ");
	        String gioiTinh = sc.nextLine();
	        System.out.print("Nhap nam sinh: ");
	        int namSinh = sc.nextInt();	
	        sc.nextLine();
			SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, namSinh);
			danhSachSV.add(sv);
		}
		
		ghiFile();
	}
	
	public static void hienThi() {
		if (danhSachSV.isEmpty()) {
			System.out.println("Danh sach sinh vien rong.");
		} 
		else {
			System.out.printf("%20s%20s%20s%20s", "ma sinh vien", "ho ten", "gioi tinh", "nam sinh");	
			System.out.println();
		}
		docFile();
	}
	
	public static void sapXep() {
		if (danhSachSV.isEmpty()) {
	        System.out.println("Danh sach sinh vien rong.");
	    } else {
	        Collections.sort(danhSachSV, (sv1, sv2) -> Integer.compare(sv1.getNamSinh(), sv2.getNamSinh()));
	        System.out.println("Danh sach sinh vien da sap xep theo nam sinh.");
	        for (SinhVien sv : danhSachSV) {
	        	System.out.println(sv);
			}
	    }
	}
	
	public static void timKiem() {
		if (danhSachSV.isEmpty()) {
	        System.out.println("Danh sach sinh vien rong.");
	    } else {
	    	sc.nextLine();
	        System.out.print("Nhap ma sinh vien can tim: ");
	        String maSV = sc.nextLine();
	        boolean flag = false;
	        for (SinhVien sv : danhSachSV) {
	            if (sv.getMaSV().equals(maSV)) {
	            	System.out.printf("%20s%20s%20s%20s", "ma sinh vien", "ho ten", "gioi tinh", "nam sinh\n");
	                System.out.println(sv);
	                flag = true;
	                break;
	            }
	        }

	        if (!flag) {
	            System.out.println("Khong tim thay sinh vien co ma sinh vien " + maSV);
	        }
	    }
	}
	
	public static void ghiFile() {
		try {
	        FileOutputStream fos = new FileOutputStream("QLSV.dat");
	        ObjectOutputStream oos = new ObjectOutputStream(fos);
	        oos.writeObject(danhSachSV);
	        oos.close();
	        fos.close();
	        System.out.println("Luu du lieu thanh cong.");
	    } catch (IOException e) {
	        System.out.println("Luu du lieu that bai: " + e.getMessage());
	    }
	}
	
	public static void docFile() {
		try {
	        FileInputStream fis = new FileInputStream("QLSV.dat"); 
	        ObjectInputStream ois = new ObjectInputStream(fis); // doc ghi doi tuong
	        while (fis.available() > 0) {
	        	danhSachSV = (ArrayList<SinhVien>) ois.readObject();
	        	for (SinhVien s : danhSachSV) {
					System.out.println(s);
				}
	        }	        
	        ois.close();
	        fis.close();
	        System.out.println("Doc du lieu thanh cong.");
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
}
