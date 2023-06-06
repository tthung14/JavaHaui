package de_2;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Sach> listBooks = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		do {
			System.out.println("CHUONG TRINH QUAN LY THU VIEN");
			System.out.println("1. Nhap");
			System.out.println("2. Hien thi");
			System.out.println("3. Sap xep");
			System.out.println("4. Tim kiem");
			System.out.println("5. Thoat");
			System.out.print("Nhap lua chon: ");
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
				System.out.println("thoat chuong trinh");
				System.exit(5);
				break;
			default:
				System.out.println("khong co lua chon nay");
			}
		} while(true);
	}
	
	public static void nhap() {
		System.out.print("nhap so luong sach: ");
		int soLuong = sc.nextInt();
		for (int i = 0; i < soLuong; i++) {
			System.out.println("nhap sach thu "+(i + 1)+": ");
			Sach s = new Sach();
			s.input();
			listBooks.add(s);
		}
		ghiFile();
	}
	public static void hienThi() {
		if (listBooks.isEmpty()) {
			System.out.println("danh sach sach rong");
		}
		else {
			System.out.printf("%20s%20s%20s%20s%20s", "id", "ten sach", "tac gia", "nha xuat ban", "nam xuat ban\n");
		}
		docFile();
	}
	public static void sapXep() {
		if (listBooks.isEmpty()) {
			System.out.println("danh sach sach rong");
		}
		else {
			Collections.sort(listBooks, (a, b) -> Integer.compare(a.getNamXB(), b.getNamXB()));
			System.out.printf("%20s%20s%20s%20s%20s", "id", "ten sach", "tac gia", "nha xuat ban", "nam xuat ban\n");
			for (Sach s : listBooks) {
				System.out.println(s);
			}
		}
	}
	public static void timKiem() {
		if (listBooks.isEmpty()) {
			System.out.println("danh sach sach rong");
		}
		else {
			sc.nextLine();
			System.out.print("nhap ma sach can tim: ");
			String foundId = sc.nextLine();
			Boolean flag = false;	
			for (Sach s : listBooks) {			
				if (s.getiD().compareTo(foundId) == 0) {
					System.out.printf("%20s%20s%20s%20s%20s", "id", "ten sach", "tac gia", "nha xuat ban", "nam xuat ban\n");
					System.out.println(s);
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				System.out.println("khong tim thay ma sach: " +foundId);
			}
		}
	}
	public static void ghiFile() {
		try {
			FileOutputStream fos = new FileOutputStream("book.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listBooks);
			oos.close();
			fos.close();
			System.out.println("Luu du lieu thanh cong.");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void docFile() {
		try {
			FileInputStream fis = new FileInputStream("book.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (fis.available() > 0) {
				listBooks = (ArrayList<Sach>) ois.readObject();
				for (Sach s : listBooks) {
					System.out.println(s);
				}
			}
			ois.close();
			fis.close();
			System.out.println("Doc du lieu thanh cong.");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
