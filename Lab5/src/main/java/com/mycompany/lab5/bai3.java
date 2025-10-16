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
import java.util.Comparator;
import java.util.Scanner;

class SanPham {
    String ten;
    Double donGia;

    public SanPham(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return String.format("%-20s | Gia: %.2f", ten, donGia);
    }
}

public class bai3 {
    static ArrayList<SanPham> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(scanner.nextLine());
            switch (chon) {
                case 1 -> nhap();
                case 2 -> sapXep();
                case 3 -> xoa();
                case 4 -> xuatTrungBinh();
                case 5 -> System.out.println("Ket thuc chuong trinh.");
                default -> System.out.println("Chuc nang khong hop le!");
            }
        } while (chon != 5);
    }

    public static void menu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Nhap danh sach san pham");
        System.out.println("2. Sap xep giam dan theo gia va xuat ra man hinh");
        System.out.println("3. Tim va xoa san pham theo ten");
        System.out.println("4. Xuat gia trung binh cua cac san pham");
        System.out.println("5. Ket thuc");
        System.out.println("==========================");
    }

    public static void nhap() {
        System.out.println("\nNhap danh sach san pham (de trong ten de dung):");
        while (true) {
            System.out.print("Ten san pham: ");
            String ten = scanner.nextLine();
            if (ten.equals("")) break;

            System.out.print("Don gia: ");
            Double gia = Double.valueOf(scanner.nextLine());

            list.add(new SanPham(ten, gia));
        }
    }

    public static void xuat() {
        for (SanPham sp : list) {
            System.out.println(sp);
        }
    }

    public static void sapXep() {
        Comparator<SanPham> comp = (SanPham o1, SanPham o2) -> o1.donGia.compareTo(o2.donGia);

        Collections.sort(list, comp);
        Collections.reverse(list);

        System.out.println("\nDanh sach sau khi sap xep giam dan theo gia:");
        xuat();
    }

    public static void xoa() {
        System.out.print("Nhap ten san pham can xoa: ");
        String tenXoa = scanner.nextLine();
        boolean found = false;

        for (SanPham sp : list) {
            if (sp.ten.equalsIgnoreCase(tenXoa)) {
                list.remove(sp);
                found = true;
                System.out.println("Da xoa san pham: " + tenXoa);
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay san pham co ten: " + tenXoa);
        }
    }

    public static void xuatTrungBinh() {
        if (list.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        double tong = 0;
        for (SanPham sp : list) {
            tong += sp.donGia;
        }
        double tb = tong / list.size();
        System.out.printf("Gia trung binh cua cac san pham la: %.2f\n", tb);
    }
}
