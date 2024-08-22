package com.nopcommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeSorter {
    public static void main(String[] args) {
        // Tạo dãy số
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

        // Danh sách để chứa các số nguyên tố
        List<Integer> primeNumbers = new ArrayList<>();

        // Lọc số nguyên tố
        for (int number : numbers) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        // Sắp xếp danh sách số nguyên tố từ lớn đến nhỏ
        Collections.sort(primeNumbers, Collections.reverseOrder());

        // In kết quả
        System.out.println("Các số nguyên tố (từ lớn đến nhỏ): " + primeNumbers);
    }

    // Phương thức kiểm tra số nguyên tố
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true; // 2 là số nguyên tố
        if (number % 2 == 0) return false; // Loại các số chẵn khác 2

        // Kiểm tra các số lẻ từ 3 đến căn bậc hai của số
        for (int i = 3; i < number; i= i+ 2) {
            if (number % i == 0) return false;
        }

        return true;
    }
}
