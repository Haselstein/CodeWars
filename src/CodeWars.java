public class CodeWars {
    public static void main(String[] args) throws Exception {
        int[] a = {30, 27, 8, 14, 7};
        bonus(a, 34067);
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
}