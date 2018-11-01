package com.redcompany.red;

public class Main {

    public static void main(String[] args) {
        //

          System.out.println(method1String("This is test a string This is a test string", 4, '%'));
          System.out.println(method2StringB("This is test a string This is a test string", 3, '%'));

        // speed test
        //test1();
        //test2();


    }


    static void test1() {
        int numberOfStarts = 1000000;
        long average = 0;
        // long a = 0;
        for (int i = 0; i < numberOfStarts; i++) {
            //    long s = Runtime.getRuntime().freeMemory();
            long startTime = System.nanoTime();
            method1String("This is test a string This is a test string", 4, '%');
            long endTime = System.nanoTime();
            average = average + (startTime - endTime);
            //   long f = Runtime.getRuntime().freeMemory();
            //   a = a + (s-f);
            //   System.gc();
        }
        average = average / numberOfStarts;
        //  a = a / numberOfStarts;
        System.out.println(" Method 1 execution time: " + average);
        //   System.out.println(" Method 1 execution mem: " + a);
    }

    static void test2() {
        int numberOfStarts = 1000000;
        long average = 0;
        //  long a = 0;
        for (int i = 0; i < numberOfStarts; i++) {
            //      long s = Runtime.getRuntime().freeMemory();
            long startTime = System.nanoTime();
            method2StringB("This is test a string This is a test string", 4, '%');
            long endTime = System.nanoTime();
            average = average + (startTime - endTime);
            //      long f = Runtime.getRuntime().freeMemory();
            //     a = a + (s-f);
            //     System.gc();
        }
        average = average / numberOfStarts;
        //   a = a / numberOfStarts;
        System.out.println(" Method 2 execution time: " + average);
        //  System.out.println(" Method 2 execution mem: " + a);
    }


    static String method1String(String s, int k, char change) {
        if (s.length() <= 0 | s == null | k <= 0) {
            return "This string is not valid";
        }
        String[] arrOfStr = s.split(" ");
        String result = "";
        tab:
        for (int i = 0; i < arrOfStr.length; i++) {
            if ((arrOfStr[i].length()) >= k) {
                char[] tmp = arrOfStr[i].toCharArray();
                tmp[k - 1] = change;
                result = result + String.valueOf(tmp) + " ";
            } else {
                result = result + arrOfStr[i] + " ";
                continue tab;
            }
        }
        return result;
    }

    static String method2StringB(String s, int k, char change) {
        if (s.length() <= 0 | s == null | k <= 0) {
            return "This string is not valid";
        }
        String[] arrOfStr = s.split(" ");
        StringBuilder resultSB = new StringBuilder();
        tab:
        for (int i = 0; i < arrOfStr.length; i++) {
            StringBuilder sb = new StringBuilder(arrOfStr[i]);
            if ((arrOfStr[i].length()) >= k) {
                sb.setCharAt(k - 1, change);
                resultSB.append(sb.append(' '));
            } else {
                resultSB.append(sb.append(' '));
                continue tab;
            }
        }
        return resultSB.toString();
    }


}
