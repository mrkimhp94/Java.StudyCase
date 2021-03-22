package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public String getString() {
        String input = null;
        do {
            try {
                input = scanner.nextLine();
                if (input.equals("")) System.out.println("Nhập lại ");
            } catch (Exception e) {
                System.out.println("nhập lại");
            }
        } while (Objects.equals(input, ""));
        return input;
    }

    public int getInt() {
        int input = 0;
        do {
            try {
                input = scanner.nextInt();
                if (input == 0) System.out.println("nhập lại");
            } catch (Exception e) {
                System.out.println("nhập lại");
            }
        } while (input == 0);
        return input;
    }

    public int inputNumber() {
        System.out.println("Nhập số điện thoại");
        return getInt();
    }

    public String inputGroup() {
        System.out.println("Nhập nhóm");
        return getString();
    }

    public String inputName() {
        System.out.println("Nhập tên");
        return getString();
    }

    public String inputAddress() {
        System.out.println("Nhập địa chỉ");
        return getString();
    }

    public String inputEmail() {
        System.out.println("Nhập Email");
        return getString();
    }

    public String inputBornDay() {
        System.out.println("Nhâp ngày sinh");
        return getString();
    }

    public String inputSex() {
        System.out.println("Nhập giới tính");
        return getString();
    }
}
