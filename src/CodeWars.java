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

        int[] a = {1,2,2};
        int[] b = {2};
        /* int[] a = new int[5];
        int[] b = new int[5];
        for(int i = 0; i < 5; i++) {
            a[i] = i;
            b[i] = 7;
        } */
        System.out.println(arrayDiff(a, b));
         
    }
    
    public static long[] bonus(int[] arr, long s) {
        //Вычисление бонусов сотрудникам, исходя из количества дней, которые работник отсутствовал на рабочем месте
        //Массив arr - количество пропусков
        //Размер массива arr - количество сотрудников
        //S - общее количество премиальных для всех сотрудников
        long [] a = new long[arr.length];           //Массив премиальных для каждого сотрудника
        double sum = 0.0;                           //Промежуточная переменная, необходимая для вычислений
        long big;                                   //Промежуточная переменная, необходимая для вычислений
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[0] / (double)arr[i];
            //System.out.println("Sum0 = " + sum);
        }

        //System.out.println("Sum = " + sum);
        a[0] = (long)Math.round(s / sum);
        System.out.println("a[0] = " + a[0]);
        big = a[0] * arr[0];
        //System.out.println("Big = " + big);

        for (int i = 1; i < arr.length; i++) {
            a[i] = big / arr[i];
            System.out.println("a[" + i + "] = " + a[i]);
        }

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

        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> blist = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++)
            alist.add(a[i]);
        for (int i = 0; i < b.length; i++)
            blist.add(b[i]);
        //System.out.println("list of a: " + alist.toString());
        //System.out.println("list of b: " + blist.toString());
        List<Integer> newList = blist.stream().distinct().collect(Collectors.toList());
        //System.out.println("New list: " + newList);
        //System.out.println("Size of new list = " + newList.size());
        //System.out.println("Get new list index 3 = " + alist.get(index));
        //System.out.println("alist size 1 = " + alist.size());
        for (int j = 0; j < newList.size(); j++)
            for (int i = alist.size()-1; i >= 0; i--)
                if (alist.get(i) == newList.get(j)) 
                   alist.remove(i);
                   //System.out.println("list of a: " + alist.toString());
        System.out.println("result: " + alist.toString());
        //System.out.println("list of a: " + alist.toString());
        int[] result = new int[alist.size()];
        //System.out.println("alist size 2 = " + alist.size());
        for (int i = 0; i < alist.size(); i++)
            result[i] = alist.get(i);
        return result;
    }

    

}