package com.webDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberSorter {
//    public static void main(String[] args) {
//        // Tạo dãy số
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
//
//        // Tạo các danh sách để chứa số chẵn và số lẻ
//        List<Integer> evenNumbers = new ArrayList<>();
//        List<Integer> oddNumbers = new ArrayList<>();
//
//        // Phân loại số vào các danh sách
//        for (int number : numbers) {
//            if (number % 2 == 0) {
//                evenNumbers.add(number);
//            } else {
//                oddNumbers.add(number);
//            }
//        }
//
//        // Sắp xếp các danh sách từ lớn đến nhỏ
//        Collections.sort(evenNumbers, Collections.reverseOrder());
//        Collections.sort(oddNumbers, Collections.reverseOrder());
//
//        // In kết quả
//        System.out.println("Số chẵn (từ lớn đến nhỏ): " + evenNumbers);
//        System.out.println("Số lẻ (từ lớn đến nhỏ): " + oddNumbers);
//
//        // Sắp xếp các danh sách từ nhỏ đến lớn
//        Collections.sort(evenNumbers);
//        Collections.sort(oddNumbers);
//
//        // In kết quả
//        System.out.println("Số chẵn (từ nhỏ đến lớn): " + evenNumbers);
//        System.out.println("Số lẻ (từ nhỏ đến lớn): " + oddNumbers);
//    }
    public static void main (String[] agrs){
        int[] numbers = {1,2,3,4,5,6,7,8};
        List<Integer> evenNumber = new ArrayList<>();
        List<Integer> oddNumber = new ArrayList<>();

        for (int number :numbers){
            if (number % 2 ==0){
                evenNumber.add(number);
            } else {
                oddNumber.add(number);
            }
        }
        //Sap xep tu lon den nho
        Collections.sort(evenNumber,Collections.reverseOrder());
        Collections.sort(oddNumber,Collections.reverseOrder());

        System.out.println("Day so chan sap xep tu lon den nho " + evenNumber);
        System.out.println("Day so le sap xep tu lon den nho " + oddNumber);
    }
//    public static void main(String[] agrs){
//        String[] array= {"a","m","b","y","c"};
//        Arrays.sort(array);
//        System.out.println("Sap xep tu a den z " + Arrays.toString(array));
//    }
}
