package com.redcompany.red;

public class Main {
    //test
    final static int numberOfStarts = 10;

    public static void main(String[] args) {


        System.out.println(method1String("This is test a string This is a test string", 4, '%'));
        System.out.println(method2StringB("This is test a string This is a test string", 3, '%'));
        System.out.println(method3String("This is ingtest a singtrIng This is a test string This is test a string This is a test string", "ing", "%%%"));
        System.out.println(method4StringB("This is ingtest a singtrIng This is a test string This is test a string This is a test string", "ing", "%%%"));

        // speed test
        System.out.println("speed and memory test:");
        test1();
        test2();
        test3();
        test4();


    }

    static String method3String(String s, String find, String change) {
        String[] arrOfStr = s.split(" ");
        String result = "";
        tab:
        for (int i = 0; i < arrOfStr.length; i++) {
            if (arrOfStr[i].contains(find)) {
                if (find.equals(arrOfStr[i].substring((arrOfStr[i].length() - find.length()), arrOfStr[i].length()))) {
                    result = result.concat(arrOfStr[i].replace(find, change)).concat(" ");
                } else {
                    result = result.concat(arrOfStr[i]).concat(" ");
                }
            } else {
                result = result.concat(arrOfStr[i]).concat(" ");
                continue tab;
            }
        }
        return result;
    }

    static String method4StringB(String s, String find, String change) {
        String[] arrOfStr = s.split(" ");
        StringBuilder resultSB = new StringBuilder();
        tab:
        for (int i = 0; i < arrOfStr.length; i++) {
            StringBuilder sb = new StringBuilder(arrOfStr[i]);
            if (arrOfStr[i].contains(find)) {
                if (find.equals(sb.substring((arrOfStr[i].length() - find.length()), arrOfStr[i].length()))) {
                    resultSB.append(sb.replace(arrOfStr[i].length() - find.length(), arrOfStr[i].length(), change) + " ");
                } else {
                    resultSB.append(sb.append(" "));
                }
            } else {
                resultSB.append(sb.append(" "));
                continue tab;
            }
        }
        return resultSB.toString();
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
                result = result.concat(String.valueOf(tmp)).concat(" ");
            } else {
                result = result.concat(arrOfStr[i]).concat(" ");
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

    static void test1() {
        long average = 0;
        long a = 0;
        for (int i = 0; i < numberOfStarts; i++) {
            long startTime = System.nanoTime();
            method1String("This is test a string This is a test string", 4, '%');
            long endTime = System.nanoTime();
            average = average + (endTime -startTime);
        }
        for (int i = 0; i < numberOfStarts; i++) {
            long s = Runtime.getRuntime().freeMemory();
            method1String("This is test a string This is a test string", 4, '%');
            long f = Runtime.getRuntime().freeMemory();
            a = a + (s - f);
            System.gc();
        }
        average = average / numberOfStarts;
        a = a / numberOfStarts;
        System.out.println(" Method 1 execution time: " + average);
        System.out.println(" Method 1 execution memory: " + a);
    }

    static void test2() {
        long average = 0;
        long a = 0;
        for (int i = 0; i < numberOfStarts; i++) {
            long startTime = System.nanoTime();
            method2StringB("This is test a string This is a test string", 4, '%');
            long endTime = System.nanoTime();
            average = average + (endTime -startTime);
        }
        for (int i = 0; i < numberOfStarts; i++) {
            long s = Runtime.getRuntime().freeMemory();
            method2StringB("This is test a string This is a test string", 4, '%');
            long f = Runtime.getRuntime().freeMemory();
            a = a + (s - f);
            System.gc();
        }
        average = average / numberOfStarts;
        a = a / numberOfStarts;
        System.out.println(" Method 2(SB) execution time: " + average);
        System.out.println(" Method 2(SB) execution memory: " + a);
    }

    static void test3() {
        long average = 0;
        long a = 0;
        for (int i = 0; i < numberOfStarts; i++) {
            long startTime = System.nanoTime();
            method3String("This is ingtest a singtrIng This is a test string This is test a string This is a test string", "ing", "%%%");
            long endTime = System.nanoTime();
            average = average + (endTime -startTime);
        }
        for (int i = 0; i < numberOfStarts; i++) {
            long s = Runtime.getRuntime().freeMemory();
            method3String("This is ingtest a singtrIng This is a test string This is test a string This is a test string", "ing", "%%%");
            long f = Runtime.getRuntime().freeMemory();
            a = a + (s - f);
            System.gc();
        }
        average = average / numberOfStarts;
        a = a / numberOfStarts;
        System.out.println(" Method 3 execution time: " + average);
        System.out.println(" Method 3 execution memory: " + a);
    }

    static void test4() {
        long average = 0;
        long a = 0;
        for (int i = 0; i < numberOfStarts; i++) {
            long startTime = System.nanoTime();
            method4StringB("This is ingtest a singtrIng This is a test string This is test a string This is a test string", "ing", "%%%");
            long endTime = System.nanoTime();
            average = average + (endTime -startTime);
        }
        for (int i = 0; i < numberOfStarts; i++) {
            long s = Runtime.getRuntime().freeMemory();
            method4StringB("This is ingtest a singtrIng This is a test string This is test a string This is a test string", "ing", "%%%");
            long f = Runtime.getRuntime().freeMemory();
            a = a + (s - f);
            System.gc();
        }
        average = average / numberOfStarts;
        a = a / numberOfStarts;
        System.out.println(" Method 4(SB) execution time: " + average);
        System.out.println(" Method 4(SB) execution memory: " + a);
    }


}
