package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManage {
    static Scanner scanner = new Scanner(System.in);
    public static List<PhoneBook> phoneBookList = new ArrayList<>();
    public final static String COMMA_DELIMITER = ",";
    static {
        PhoneBook phoneBook1 = new PhoneBook(123,"sss","hùng","Nam","hà nội","21/05/1994","mrkimhp94@gmail.com");
        phoneBookList.add(phoneBook1);
    }

    public static void showPhoneBook() {
        if (phoneBookList != null) {
            for (PhoneBook phoneBook : phoneBookList) {
                showList(phoneBook);
            }
        }else System.out.println("Không có danh bạ");
    }

    public static void add() {
        int number = new Input().inputNumber();
        if (!checkNumber(number)) {
            String group = new Input().inputGroup();
            String name = new Input().inputName();
            String sex = new Input().inputSex();
            String address = new Input().inputAddress();
            String bornDay = new Input().inputBornDay();
            String email = new Input().inputEmail();
            PhoneBook phoneBook = new PhoneBook(number, group, name, sex, address, bornDay, email);
            phoneBookList.add(phoneBook);
            System.out.println("Đã thêm vào danh bạ");
        } else {
            System.out.println("Số đã tồn tại");
        }
    }

    public static void edit() {
        int number = new Input().inputNumber();
        if (checkNumber(number)) {
            for (PhoneBook phoneBook : phoneBookList) {
                phoneBook.setGroup(new Input().inputGroup());
                phoneBook.setName(new Input().inputName());
                phoneBook.setSex(new Input().inputSex());
                phoneBook.setAddress(new Input().inputAddress());
                phoneBook.setBornDay(new Input().inputBornDay());
                phoneBook.setEmail(new Input().inputEmail());
                System.out.println("Đã sửa");
            }
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    public static void delete() {
        int number = new Input().inputNumber();
        if (checkNumber(number)) {
            phoneBookList.remove(getPhoneBookByNumber(number));
            System.out.println("Đã xoá");
        } else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }

    public static void find(){
        boolean exit = false;
        do {
        System.out.println("1.Tìm kiếm theo số điện thoại");
        System.out.println("2.Tìm kiếm theo tên");
        String input = scanner.nextLine();
        switch (input){
            case "1":
                new ContactManage().findByNumber();
                break;
            case "2":
                new ContactManage().findByName();
                break;
            case "":
                exit = true;
                break;
            default:
                System.out.println("Không đúng !! Nhập lại");
                break;
        }
    }while (!exit);
        Main.showMenu();
    }

    private void findByName() {
        String name = new Input().inputName();
        for (PhoneBook phoneBook: phoneBookList){
            if (phoneBook.getName().equals(name)){
                showList(getPhoneBookByName(name));
            }
        }
    }

    private void findByNumber() {
        int number = new Input().inputNumber();
        for (PhoneBook phoneBook : phoneBookList){
            if (phoneBook.getNumber() == number){
                showList(getPhoneBookByNumber(number));
            }
        }
    }

    public static void showList(PhoneBook phoneBook) {
        System.out.println("Số điện thoại : " + phoneBook.getNumber());
        System.out.println("Nhóm : " + phoneBook.getGroup());
        System.out.println("Họ Tên : " + phoneBook.getName());
        System.out.println("Giới tính : " + phoneBook.getSex());
        System.out.println("Địa chỉ : " + phoneBook.getAddress());
        scanner.nextLine();
    }

    public static boolean checkNumber(int number) {
        for (PhoneBook phoneBook : phoneBookList) {
            if (phoneBook.getNumber() == number)
                return true;
        }
        return false;
    }

    public static PhoneBook getPhoneBookByNumber(int number) {
        PhoneBook phoneBook = null;
        for (PhoneBook p : phoneBookList) {
            if (p.getNumber() == number) {
                phoneBook = p;
                break;
            }
        }
        return phoneBook;
    }
    public static PhoneBook getPhoneBookByName(String name) {
        PhoneBook phoneBook = null;
        for (PhoneBook p : phoneBookList) {
            if (p.getName().equals(name)) {
                phoneBook = p;
                break;
            }
        }
        return phoneBook;
    }

    public static void fileRead() {
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/document.csv"));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                System.out.println("Số điện thoại : " + split[0]);
                System.out.println("Nhóm : " + split[1]);
                System.out.println("Họ tên : " + split[2]);
                System.out.println("Giới tính : " + split[3]);
                System.out.println("Địa chỉ : " + split[4]);
                System.out.println("Ngày sinh : " + split[5]);
                System.out.println("Email : " + split[6]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileWrite() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/document.csv");
            for (PhoneBook phoneBook : phoneBookList) {
                fileWriter.append((char)phoneBook.getNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getGroup());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getSex());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getBornDay());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getEmail());
                fileWriter.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
