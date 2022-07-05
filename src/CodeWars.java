import java.math.BigInteger;
import java.security.DrbgParameters.Reseed;
import java.time.temporal.Temporal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.function.Function;
import static java.util.stream.Collectors.*;


public class CodeWars {
    public static void main(String[] args) throws Exception {

        /* int[] a = {30, 27, 8, 14, 7};
        bonus(a, 34067); */

        //System.out.println("multiples = " + multiples(10));

        //System.out.println("persistence = " + persistence(441888));

        //System.out.println("digital_root = " + digital_root(347149));

        //int[] ls = {0, 1, 3, 6, 10};
        //System.out.println(sumParts(ls));

        //System.out.println(countPairsInt(3, 100));

        /* int[] a = {1,2,2};
        int[] b = {2};
        System.out.println(arrayDiff(a, b)); */

        /* String[] b = {"red", "green", "blue", "blue", "red", "green", "red", "red", "red"};
        int a = numberOfPairs(b);
        System.out.println(a); */

        //long[] a = {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8};
        //System.out.println("a = " + divideAndMultipy(a));

        //int[][] a = new int[][] { {1,2}, {2,9}, {3,18}, {4,24}, {6,48} };
        //int[][] a = new int[][] { {1, 3}, {5, 3} };
        //int[][] a = new int[][] { {69, 130}, {87, 1310}, {3, 4} };
        //System.out.println(sumFracts(a));

        /*String a[] = new String[] { "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        String r[] = new String[] { "arp", "live", "strong" };
        printMatrix(inArray(a, b));*/

        /*int[] a = {2, 4, 5, 4, 7, 9, 5, 4, 7};
        int[] b = sortByFrequency(a);
        //printMatrix(b);*/

        /*int a = 70304;
        System.out.println(expandedNumber(a));*/

        /*int[] a = {1, 2, 3};
        System.out.println(sumDig_nthTerm(10, a, 6));*/

        /*System.out.println(playingWithDigits(89, 1));
        System.out.println(playingWithDigits(92, 1));
        System.out.println(playingWithDigits(695, 2));
        System.out.println(playingWithDigits(46288, 3));*/

        /*for (int i = -5; i < 102; i++)
            System.out.println("Number " + i + " is prime?: " + isPrime(i));*/

        //System.out.println(sumDigPow(1, 100));

        //System.out.println(sqInRect(3,7));

        /*int[] input = { 1, 2, 3, 4, 5 };
        int[] a = foldArray(input, 3);
        printMatrix(a);*/

        //System.out.println(backwardsReadPrimes(2, 100));

        /*int[] a = { 1, 2, 3, 4, 6, 7, 8, 9, 10 };//Отсутствует 5
        System.out.println(findMissingNumber(a));*/

        //System.out.println(looseChange(91));

        System.out.println(perimeter(BigInteger.valueOf(7)));

    }

    public static void printMatrix(String[] a) {
        //Сделать универсальным для всех типов матриц
        for (String element : a) {
            System.out.println(element);
        }
    }
    public static void printMatrix(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.println("Matrix[" + i + "] = " + a[i]);
        /*for (int element : a) {
            System.out.println(element);
        }*/
    }


    public static long[] bonus(int[] arr, long s) {
        //Вычисление бонусов сотрудникам, исходя из количества дней, которые работник отсутствовал на рабочем месте
        //Массив arr - количество пропусков
        //Размер массива arr - количество сотрудников
        //S - общее количество премиальных для всех сотрудников

        long [] a = new long[arr.length];           //Массив премиальных для каждого сотрудника
        double sum = 0.0;                           //Промежуточная переменная, необходимая для вычислений
        long big;                                   //Промежуточная переменная, необходимая для вычислений
        
        for (int i = 0; i < arr.length; i++) 
            sum += arr[0] / (double)arr[i];
        
        a[0] = (long)Math.round(s / sum);
        big = a[0] * arr[0];

        for (int i = 1; i < arr.length; i++) 
            a[i] = big / arr[i];

        return a;

    }


    public static int multiples(int number) {
        //Складывает все числа, кратные 3 или 5, вплоть до number

        if (number < 0)
          return 0;
        
        int sum = 0;
        
        for (int i = 0; i < number; i++) {
          if (i %3 == 0 || i %5 == 0)
            sum += i;
        }
        
        return sum;

    }


    public static int persistence(long n) {
        //"Стойкость" числа. Количество итераций умножения цифр числа до 1 цифры
        //Пример: 999 --> 4 (9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, 1*2 = 2)

        if (n < 10)
          return 0;
        
        long result = n;
        int answer = 0;
        
        do {
            n = result;
            result = 1;
            answer++;
            while (n > 0) {
                result *= n%10;
                n /= 10;
            }

        } while (result > 9);

        return answer;

    }


    public static int digital_root(int n) {
        //Цифровой корень
        //Находит однозначное число по сумме исходных значений
        //Пример: 982 -> 9+8+2 = 19 -> 1+9 = 10 -> 1+0 = 1

        if (n < 10)
            return n;

        int sum = 0;
        while (n >= 10) {
            sum += n%10;
            n /= 10;
        }

        sum += n;
        n = sum;

        return digital_root(n);

    }


    public static int[] sumParts(int[] ls) {
        //Сумма чисел массива, начиная с конца, заканчивая нулём
        //Например: 
        //ls = [0, 1, 3, 6, 10] result = [0]
        //ls = [1, 3, 6, 10]    result = [0, 10]
        //ls = [3, 6, 10]       result = [0, 10, 16]
        //ls = [6, 10]          result = [0, 10, 16, 19]
        //ls = [10]             result = [0, 10, 16, 19, 20]
        //ls = []               result = [0, 10, 16, 19, 20, 20]

        int[] result = new int[ls.length+1];

        for (int i = ls.length-1; i >= 0; --i) 
            result[i] = result[i+1] + ls[i];
        
        return result;
    }


    public static int countDivisors(int number) {
        //подсчёт количества делителей числа number

        int result = 1; //=1, чтобы учитывать само число

        for (int i = 1; i <= number/2; i++) 
            if ((number % i) == 0) {
                result++;
            }

        return result;

    }
    public static int countPairsInt(int diff, long nMax) {
        //Количество таких чисел, разница между которыми равна diff,
        //не превышающие nMax, и имеющих одинаковое количество делителей

        int count = 0;

        for (int i = 1; i < nMax-diff; i++) {
            if (countDivisors(i) == countDivisors(i+diff))
                count++;
        }

        return count;
    }


    public static int[] arrayDiff(int[] a, int[] b) {
        //Array diff. Вычитание матрицы b из матрицы a с сохранением порядка
        //Также сохраняет количество повторяющихся элементов(Нужно по заданию)
        //Посмотреть решение через мапы

        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> blist = new ArrayList<Integer>();

        for (int i = 0; i < a.length; i++)
            alist.add(a[i]);
        for (int i = 0; i < b.length; i++)
            blist.add(b[i]);

        List<Integer> newList = blist.stream().distinct().collect(Collectors.toList());

        for (int j = 0; j < newList.size(); j++)
            for (int i = alist.size()-1; i >= 0; i--)
                if (alist.get(i) == newList.get(j)) 
                   alist.remove(i);

        int[] result = new int[alist.size()];
        for (int i = 0; i < alist.size(); i++)
            result[i] = alist.get(i);

        return result;
    }


    public static int numberOfPairs(String[] gloves) {
        //Имеется массив с разноцветными перчатками
        //Нужно посчитать и вернуть количество одноцветных пар
        
        int result = 0;
        
        Arrays.sort(gloves);
        
        int i = 0;//?
        while (i < gloves.length-1) {
            if (gloves[i].equals(gloves[i+1])) {
                result++;
                i += 2;
            }
            else {
                i++;
            }
        }

        return result;
    }


    public static String sumFracts(int[][] l) {
        //Калькулятор дробей
        //На вход подаётся двумерный массив
        //элементы которого - дроби, представленные в виде {числитель, знаменатель}
        //Найти сумму дробей

        if (l.length < 1)
            return null;

        if (l.length < 2)
            return "[" + l[0][0] + ", " + l[0][1] + "]";
        
        String answer;

        int[] a = new int[l.length];    //Массив всех знаменателей
        for (int i = 0; i < a.length; i++) {
            a[i] = l[i][1];
        }
        int b = findLeastCommonMultiple(a); //Общий знаменатель

        int temp_1 = 0; //i-й числитель
        int sum = 0;    //Сумма всех числителей
        for (int i = 0; i < l.length; i++) {
            temp_1 = b / l[i][1] * l[i][0];
            sum += temp_1;
        }

        while (findGreatestCommonDivisor(sum, b) != 1) {//Сокращение дроби, если возможно
            int divider = findGreatestCommonDivisor(sum, b);
            sum /= divider;
            b /= divider;
        }

        if (sum %b == 0)
            answer = "" + (sum/b);
        else
            answer = "[" + sum + ", " + b + "]";

        return answer;

    }
    public static int findGreatestCommonDivisor(int a, int b) {
        //Поиск наибольшего общего делителя двух чисел
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int findGreatestCommonDivisor(int[] sourceNumbers) {
        //Поиск наибольшего общего делителя массива чисел
        int result = sourceNumbers[0];
        if (result == 0) {
            System.out.println("Наибольший общий делитель: " + result);
        } else {
            for (int i = 1; i < sourceNumbers.length; i++) {
                result = findGreatestCommonDivisor(result, sourceNumbers[i]);
            }
            System.out.println("Наибольший общий делитель: " + result);
        }
        return result;
    }
    public static int findLeastCommonMultiple(int a, int b) {
        //Поиск наименьшего общего кратного двух чисел
        return a * (b / findGreatestCommonDivisor(a, b));
    }
    public static int findLeastCommonMultiple(int[] sourceNumbers) {
        //Поиск наименьшего общего кратного массива чисел
        int result = sourceNumbers[0];
        if (result == 0) {
            System.out.println("Наименьшее общее кратное: " + result);
        } else {
            for (int i = 1; i < sourceNumbers.length; i++) {
                if (sourceNumbers[i] == 0) {
                    break;
                }
                result = findLeastCommonMultiple(result, sourceNumbers[i]);
            }
        }
        System.out.println("Наименьшее общее кратное: " + result);
        return result;
    }


    public static String[] inArray(String[] array1, String[] array2) {
        //Метод возвращает массив строк, каждый элемент которого является
        //вхождением элементов массива array1 в любой из элементов массива array2
        //Результат отсортирован и без дубликатов
        //Например:
        // array1 = { "arp", "live", "strong" }
        // array2 = { "harp", "karp", "alive", "stronger" }
        // result = { "arp", "live", "strong" }

        ArrayList<String> result = new ArrayList<String>();

        for (int j = 0; j < array2.length; j++)
            for (int i = 0; i < array1.length; i++)
                if (array2[j].contains(array1[i]))
                    result.add(array1[i]);

        Collections.sort(result);

        List<String> newResult = result.stream().distinct().collect(Collectors.toList());

        String[] answer = new String[newResult.size()];
        for (int i = 0; i < newResult.size(); i++)
            answer[i] = newResult.get(i);

        return answer;
    }


    public static String expandedNumber(int a) {
        //Развёрнутая запись числа "a" в виде строки

        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<String> arrayString = new ArrayList<>();
        String b = null;
        int i = 0;

        while (a > 0) {
            if (a %10 != 0) {
                array.add((int)(a%10 * (Math.pow(10,i))));
            }
            a /= 10;
            i++;
        }

        Collections.sort(array, Collections.reverseOrder());
        for (int j = 0; j < array.size(); j++) {
            arrayString.add(array.get(j).toString());
        }
        String arrayToString = String.join(" + ", arrayString);

        return  arrayToString;

    }


    public static int sumDig_nthTerm(int initVal, int[] patternL, int nthTerm) {
        //Имеется последовательность:
        //term1 = initVal
        //term2 - term1 = k1
        //term3 - term2 = k2
        //term4 - term3 = k3
        //term5 - term4 = k4
        //...
        //Где patternL = [k1, k2, k3, k4, ...]
        //Найти сумму цифр числа nthTerm(порядковый номер числа последовательности) в этой последовательности
        int i = 0;
        int n = 0;
        int nextNumber = initVal;

        while (n < nthTerm-1) {
            n++;
            nextNumber += patternL[i];
            if ((i+1) == patternL.length)
                i = 0;
            else
                i++;
        }

        return sumOfTheDigits(nextNumber);

    }
    public static int sumOfTheDigits(int a) {
        //Сумма цифр числа
        int sum = 0;
        while(a > 0) {
            sum += a%10;
            a /= 10;
        }
        return sum;
    }


    public static int playingWithDigits(int num, int n) {
        //На вход поступает число и номер первой степени
        //Нужно разложить число на его цифры
        //Слева направо возвести каждую цифру в степень n + порядковый номер
        //Просуммировать все числа. Если сумма делится нацело на изначальное число, то вернуть результат деления
        //Иначе вернуть -1
        //Например:
        //(695, 2): 6^2 + 9^3 + 5^4 = 1390 = 695*2 -> вернуть 2

        int sum = 0;
        int i = (int) (Math.log10(num));
        int sourceNum = num;

        while (num > 0) {
            sum += Math.pow((num%10), (n+i));
            num /= 10;
            i--;
        }

        if (sum%sourceNum == 0) {
            return sum/sourceNum;
        }

        return -1;

    }


    public static boolean isPrime(int a) {
        //На вход поступает число, проверить, является ли оно простым
        //Все числа целые

        //return IntStream.rangeClosed(2, (int) Math.sqrt(a)).anyMatch(i -> a % i == 0);
        if (a < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a%i == 0)
                return false;
        }

        return true;

    }
    public static boolean isPrime(long a) {
        //На вход поступает число, проверить, является ли оно простым
        //Все числа целые

        //return IntStream.rangeClosed(2, (int) Math.sqrt(a)).anyMatch(i -> a % i == 0);
        if (a < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a%i == 0)
                return false;
        }

        return true;

    }


    public static List<Long> sumDigPow(long a, long b) {
        //На вход подаются границы области значений
        //Нужно вернуть массив таких чисел, сумма цифр в степени их позиции в числе которых равна самому числу
        //Например 89 = 8^1 + 9^2 -> искомое
        //88 != 8^1 + 8^2 = 72 -> ненужное число

        ArrayList<Long> result = new ArrayList<Long>();

        for (long i = a; i <= b; i++) {
            if (isEureka(i)) {
                result.add(i);
            }
        }

        return result;

    }
    public static boolean isEureka(long a) {

        long sum = 0;
        int i = (int) (Math.log10(a) + 1); //Количество цифр в числе
        long sourceNum = a;

        while (a > 0) {
            sum += Math.pow((a%10), i);
            a /= 10;
            i--;
        }

        if (sum == sourceNum)
            return true;

        return false;

    }


    public static List<Integer> sqInRect(int lng, int wdth) {
        //На вход подаются длина и ширина прямоугольника
        //Нужно вернуть массив квадратов, на которые можно разбить данный прямоугольник

        List<Integer> array = new ArrayList<>();

        while (lng > 0 && wdth > 0) {
            if (lng > wdth) {
                array.add(wdth);
                lng -= wdth;

            }
            else if (lng < wdth) {
                array.add(lng);
                wdth -= lng;
            }
            else {
                array.add(lng);
                lng = 0;
                wdth = 0;
            }
        }

        return array;

    }


    public static int[] foldArray(int[] array, int runs) {
        //"Сворачивание массива чисел"
        //На вход подаётся массив чисел
        //Нужно "сложить" пополам этот массив runs раз
        //Например массив чисел от 1 до 5 и runs = 1:
        // ([1, 2, 3, 4, 5], 1) -> [6, 6, 3]
        /*Step 1         Step 2        Step 3       Step 4       Step5
                             5/           5|         5\
                            4/            4|          4\
        1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
                ----*----      ----*          ----*        ----*        ----**/

        if (runs == 0 || array.length == 1)
            return array;

        int midleLengt = (int)Math.round(array.length/2.0);
        int[] answer = new int[midleLengt];


        for (int i = 0; i < midleLengt; i++) {
            answer[i] = array[i] + array[array.length-1-i];
        }

        if (array.length %2 != 0)
            answer[answer.length-1] = array[midleLengt-1];

        return foldArray(answer, --runs);

    }


    public static String backwardsReadPrimes(long start, long end) {
        //Нахождение "обрытных" простых чисел в диапазоне от start до end
        //Обратные простые - это такие простые числа, которые при обратном чтении (справа налево) дают простое число
        //Например: start = 2, end = 100
        //В этом диапазоне удовлетворять условиям будут такие простые числа:
        //[13, 31, 17, 71, 37, 73, 79, 97]

        ArrayList<String> answer = new ArrayList<String>();

        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
                if (isBackwardPrime(i)) {
                    answer.add(String.valueOf(i));
                }
            }
        }

        if (answer.size() < 1)
            return "";

        return answer.stream().reduce((x, y) -> x + " " + y).get().toString();

    }
    public static boolean isBackwardPrime(long value) {
        //Метод проверки числа на обратное простое, на то, что это не однозначное число и на то, что это не палиндром

        if (isPrime(inverse(value)) && value != inverse(value)) {
            return true;
        }

        return false;

    }
    public static long inverse(long value) {
        //Обратная запись числа

        long result = 0;
        while(value > 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }

        return result;

    }


    public static int findMissingNumber(int[] numbers) {
        //Найти пропавшее число в массиве numbers
        //Этот массив состояит из последоательных уникальных чисел от 1 до n
        //Но эти числа разбросаны по массиву
        //Например:
        //{ 3, 7, 1, 8, 5, 2, 4 } - > return 6

        int sum = 0;

        for (int i = 0; i <= numbers.length+1; i++)
            sum += i;

        return sum - Arrays.stream(numbers).sum();

    }


    public static HashMap<String, Integer> looseChange(int cent) {
        //На вход подаётся количество центов
        //Нужно произвести размен на монеты

        HashMap<String, Integer> map = new HashMap<>();//Возможно можно сделать инициализацию сразу в ретёрне

        map.put("Pennies", 0);
        map.put("Nickels", 0);
        map.put("Dimes", 0);
        map.put("Quarters", 0);

        if (cent <= 0)
            return map;

        map.put("Quarters", cent / 25);
        map.put("Dimes", cent %25 / 10);
        map.put("Nickels", cent %25 %10 / 5);
        map.put("Pennies", cent %25 %10 %5);

        return map;

    }


    /*public static int perimeter(int n) {

        if (n < 0)
            return 0;

        if (n <= 2)
            return n;

        int f_0 = 1;
        int f_1 = 1;
        int sum = 2;

        for (int i = 3; i <= n+1; i++) {
            int temp = f_0 + f_1;
            f_0 = f_1;
            f_1 = temp;
            sum += f_1;
        }

        return sum*4;

    }*/

    public static BigInteger perimeter(BigInteger n) {
        //Прямоугольник разбит на квадраты
        //На вход подаётся количество квадратов
        //Стороны квадратов равны последовательности чисел Фибоначчи
        //Нужно посчитать периметр прямоугольника

        BigInteger f_0 = BigInteger.valueOf(1);
        BigInteger f_1 = BigInteger.valueOf(1);
        BigInteger sum = f_0.add(f_1);
        int l = n.intValue();

        for (int i = 3; i <= l+1; i++) {
            BigInteger temp = f_0.add(f_1);
            f_0 = f_1;
            f_1 = temp;
            sum = sum.add(f_1);
        }

        return sum.multiply(BigInteger.valueOf(4));

    }

}