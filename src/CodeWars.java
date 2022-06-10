import java.security.DrbgParameters.Reseed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int[][] a = new int[][] { {69, 130}, {87, 1310}, {3, 4} };
        System.out.println(sumFracts(a));
        
         
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
        ////Поиск наибольшего общего делителя массива чисел
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


    //public static int SomeName() {
    //}


}