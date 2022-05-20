public class CodeWars {
    public static void main(String[] args) throws Exception {
        /* int[] a = {30, 27, 8, 14, 7};
        bonus(a, 34067); */

        //System.out.println("multiples = " + multiples(10));

        //System.out.println("persistence = " + persistence(441888));

        System.out.println(digital_root(347149));


        
    }
    
    public static long[] bonus(int[] arr, long s) {
        //6kyu
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
        //Проверить однострочный вариант, в теории должен работать return (n != 0 && n%9 == 0) ? 9 : n % 9;
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
}