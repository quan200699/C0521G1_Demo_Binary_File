package com.company;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainWithoutObject {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        try {
            readBinaryFile("hello1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeToBinaryFile("hello2.txt", a); //sẽ tạo luôn file hello.txt trong thư mục dự án
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToBinaryFile(String filePath, int[] arr) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath, true); //append = true => sẽ là nối dữ liệu đã có trong file với dữ liệu mới được ghi thêm
        for (int i = 0; i < arr.length; i++) {
            fos.write(arr[i]);
        }
        fos.close();
    }

    public static void readBinaryFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        DataInputStream dis = new DataInputStream(fis);
        int isEOF = 0;
        while (isEOF != -1) {
            isEOF = dis.read();
            if(isEOF != -1){
                System.out.println(isEOF);
            }
        }
    }
}
