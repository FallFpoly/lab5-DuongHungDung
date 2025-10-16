/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab5;

/**
 *
 * @author ICT
 */
import java.util.ArrayList;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        
        while (true) {
            System.out.print("Nhap 1 so bat ki: ");
            Double x = scanner.nextDouble();
            list.add(x);
            scanner.nextLine();

            System.out.print("Nhap them so nua khong(Y/N)? ");
            String tiepTuc = scanner.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }
        System.out.println("\nDanh sach cac so vua nhap:");
        for (Double so : list) {
            System.out.println(so);
        }
        double tong = 0;
        for (Double so : list) {
            tong += so;
        }
        System.out.println("Tong cua danh sach la: " + tong);
    }
}