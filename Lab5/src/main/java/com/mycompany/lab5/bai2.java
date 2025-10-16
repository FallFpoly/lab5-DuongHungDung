/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

/**
 *
 * @author ICT
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bai2 {
    static ArrayList<String> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1 -> nhap();
                case 2 -> xuat();
                case 3 -> ngaunhien();
                case 4 -> sapxep();
                case 5 -> xoa();
                case 6 -> System.out.println("Ket thuc chuong trinh.");
                default -> System.out.println("Chuc nang khong hop le!");
            }
        } while (chon != 6);
    }

    public static void menu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Nhap danh sach ho va ten");
        System.out.println("2. Xuat danh sach vua nhap");
        System.out.println("3. Xuat danh sach ngau nhien");
        System.out.println("4. Sap xep giam dan va xuat danh sach");
        System.out.println("5. Tim va xoa ho ten nhap tu ban phim");
        System.out.println("6. Ket thuc");
        System.out.println("==========================");
    }

    public static void nhap() {
        list.clear(); // Xóa danh sách cũ
        System.out.println("Nhap danh sach ho ten (thoat de trong va nhan Enter):");
        while (true) {
            System.out.print("Nhap ho ten: ");
            String hoTen = scanner.nextLine();
            if (hoTen.equals("")) {
                break;
            }
            list.add(hoTen);
        }
    }
    public static void xuat() {
        System.out.println("\nDanh sach ho ten:");
        for (String hoTen : list) {
            System.out.println(hoTen);
        }
    }

    public static void ngaunhien() {
        Collections.shuffle(list);
        System.out.println("\nDanh sach sau khi hoan doi ngau nhien:");
        xuat();
    }

    public static void sapxep() {
        Collections.sort(list);      // Sắp xếp tăng dần
        Collections.reverse(list);   // Đảo ngược → giảm dần
        System.out.println("\nDanh sach sau khi sap xep giam dan:");
        xuat();
    }

    public static void xoa() {
        System.out.print("Nhap ho ten can xoa: ");
        String hoTen = scanner.nextLine();
        boolean found = false;

        for (String item : list) {
            if (item.equalsIgnoreCase(hoTen)) {
                list.remove(item);
                found = true;
                System.out.println("Da xoa họ tên: " + hoTen);
                break; // Ngắt vòng lặp sau khi xóa
            }
        }

        if (!found) {
            System.out.println("Khong tim thay ho ten trong danh sach.");
        }
    }
}
