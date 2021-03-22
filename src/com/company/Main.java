package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        boolean exit = false;
        do {
            System.out.println("--------MENU--------");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xoá");
            System.out.println("5.Tìm kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi từ file");
            System.out.println("8.Thoát");
            System.out.println("Please choose");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    ContactManage.showPhoneBook();
                    break;
                case "2":
                    ContactManage.add();
                    break;
                case "3":
                    ContactManage.edit();
                    break;
                case "4":
                    ContactManage.delete();
                    break;
                case "5":
                    break;
                case "6":
                    ContactManage.fileRead();
                    break;
                case "7":
                    ContactManage.fileWrite();
                    break;
                case "8":
                    exit = true;
                    break;
                default:
                    System.out.println("Không đúng!! Nhập lại");
                    break;
            }
        } while (!exit);
        System.exit(8);
    }

    public static void main(String[] args) {
        showMenu();
    }
}
