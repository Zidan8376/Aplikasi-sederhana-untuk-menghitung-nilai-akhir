/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas4percabangan;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

/**
 *
 * @author Xervert
 */
public class Tugas4Percabangan {
    public static Scanner input = new Scanner(System.in);
    public static float NA;
    public static int NT, NUAS, NUTS;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String nama, NRP, alamat;
        char ulang = 0;
        do {
            clearConsole();
            System.out.println("Selamat Datang di Aplikasi Sederhana untuk menghitung Nilai Akhir !");
            System.out.print('\n');
            if (ulang == 'y' || ulang == 'Y') {
                input.nextLine();
            }
            System.out.print("Masukkan Nama : "); 
            nama = input.nextLine();
            System.out.print("Masukkan NRP : "); 
            NRP = input.nextLine();
            System.out.print("Masukkan Alamat : "); 
            alamat = input.nextLine();
            
            try {
                DataInput();
            } catch (Exception e) {
                clearConsole();
                System.out.println(e);
            }
            DataTampil(nama, NRP, alamat, NA);
            
            System.out.print('\n');
            System.out.print("Apakah anda ingin mengulang program ?( y / t ) ");
            ulang = input.next().charAt(0);
        } while (ulang == 'y' || ulang == 'Y');
        clearConsole();
        System.out.print('\n');
        System.out.println("===============================================");
        System.out.println("TERIMA KASIH SUDAH MENGGUNAKAN PROGRAM INI !");
        System.out.print('\n');
        System.out.println("Program Ini di Kerjakan Oleh : ");
        System.out.println("Mohammad Zidan Fauzi - 201221023 - MI");
        System.out.println("===============================================");
        System.exit(0);
    }

    
    public static void clearConsole(){
        try {
            Robot pressBot = new Robot();
            pressBot.keyPress(17);
            pressBot.keyPress(76);
            pressBot.keyRelease(17);
            pressBot.keyRelease(76);
        } catch (AWTException e) {
            System.out.println(e);
        }
    }
    
    private static void DataInput() throws InterruptedException {
        clearConsole();
        System.out.print('\n');
        System.out.println("===============================================");
        System.out.println("Masukkan Rincian Nilai Anda");
        System.out.println("===============================================");
        System.out.print('\n');
        System.out.print("Masukkan Nilai Tugas : ");
        NT = input.nextInt();
        System.out.print("Masukkan Nilai UTS : "); 
        NUTS = input.nextInt();
        System.out.print("Masukkan Nilai UAS : "); 
        NUAS = input.nextInt();
        System.out.println("===============================================");
        
        NA = (float) ((0.15*NT)+(0.25*NUTS)+(0.6*NUAS));
        Thread.sleep(500);
    }

    private static void DataTampil(String nama, String NRP, String alamat, float NA) {
        clearConsole();
        System.out.println("===============================================");
        System.out.println("Aplikasi Sederhana untuk menghitung Nilai Akhir");
        System.out.println("===============================================");
        System.out.println("Halo "+nama);
        System.out.println("Nilai Akhir Anda Adalah "+NA);
        System.out.println("===============================================");
        System.out.println("Dengan Rincian");
        System.out.println("Nilai Tugas : "+NT);
        System.out.println("Nilai UTS   : "+NUTS);
        System.out.println("Nilai UAS   : "+NUAS);
        if(NA == 100){
            System.out.println("Grade       : A");
            System.out.println("Komentar    : NILAI SEMPURNA");
        }else if(NA >= 56){
            if(NA >= 80){
                System.out.println("Grade       : A");
            }else if(NA >= 75){
                System.out.println("Grade       : B+");
            }else if(NA >= 70){
                System.out.println("Grade       : B");
            }else if(NA >= 65){
                System.out.println("Grade       : C+");
            }else if(NA >= 56){
                System.out.println("Grade       : C");
            }
            System.out.println("Komentar    : ANDA LULUS");
        }else if(NA < 56){
            if(NA >= 44){
                System.out.println("Grade       : D");
            }else if(NA < 44){
                System.out.println("Grade       : E");
            }
            System.out.println("Komentar    : ANDA GAGAL");
        }else if(NA == 0){
            System.out.println("Komentar    : PERLU BELAJAR LEBIH KERAS");
            System.out.println("Grade       : E");
        }
        System.out.println("===============================================");
    }
    
}
