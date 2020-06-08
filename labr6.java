import java.io.*;
import java.util.Scanner;

public class labr6
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Knight []lz = new Knight[1];

        System.out.println("Укажите имя Рыцаря: ");
        lz[0] = new Knight(sc.nextLine());


        System.out.println(lz[0].Print_Knight());
    }
}



class Hierarchy{

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int m = 0;
        String[] am;
        int[] price;
        int[] weight;

    public Hierarchy() {
        try {
            System.out.println("\nУкажите количество возможной амуниции: ");
            this.m = sc.nextInt();
            this.am = new String[m];
            this.price = new int[m];
            this.weight = new int[m];

            for (int i = 0; i < m; i++) {
                System.out.println("\nУкажите название амуниции: ");
                this.am[i] = sc1.nextLine();
                System.out.println("Укажите цену: ");
                this.price[i] = sc.nextInt();
                System.out.println("Укажите вес: ");
                this.weight[i] = sc.nextInt();
            }
        } catch(Exception e){}
    }
}

class Equip extends Hierarchy{
    Scanner sc = new Scanner(System.in);
    int n;
    String []am_eq;
    int []price_eq;
    int []weight_eq;

    public Equip(){
        try {

            System.out.println("\nУкажите количество амуниции у Рыцаря: ");
            this.n = sc.nextInt();
            this.am_eq = new String[n];
            this.price_eq = new int[n];
            this.weight_eq = new int[n];

            for (int i = 0; i < m; i++) {
                System.out.println(i + ": " + am[i] + " " + price[i]);
            }

            System.out.println();

            for (int i = 0; i < n; i++) {
                System.out.println("Выберите амуницию по индексу: ");
                int j = sc.nextInt();
                am_eq[i] = am[j];
                price_eq[i] = price[j];
                weight_eq[i] = weight[j];
            }
        } catch(Exception e){}
    }


}

class Sort extends Equip{
    public Sort(){
        try {
            int j = 0;
            while (j < n - 1) {
                if (weight_eq[j + 1] > weight_eq[j]) {
                    int b = weight_eq[j];
                    weight_eq[j] = weight_eq[j + 1];
                    weight_eq[j + 1] = b;

                    b = price_eq[j];
                    price_eq[j] = price_eq[j + 1];
                    price_eq[j + 1] = b;

                    String c = am_eq[j];
                    am_eq[j] = am_eq[j + 1];
                    am_eq[j + 1] = c;

                    j = 0;
                } else j++;
            }
        } catch(Exception e){}


    }

}

class Print extends Sort{
    public String print(){
            String s = "";
            try{
            for (int i = 0; i < n; i++) {
                s += "\n" + am_eq[i] + " Цена: " + String.valueOf(price_eq[i]) + " Вес: " + String.valueOf(weight_eq[i]);
                s += " ";
            }
        } catch(Exception e){}

            return s;
    }

    public String full_price(){
            int full_price = 0;
            try {
                for (int i = 0; i < n; i++) {
                    full_price += price_eq[i];
                }
            }catch(Exception e){}

            return String.valueOf(full_price);
    }
}

class Knight extends Print{
    private String index;
    public Knight(String index){
        this.index=index;
    }

    public String Print_Knight(){
        return "\nРыцарь: " + index + "\nАмуниция: " + print() + "\nВся стоимость амуниции: " + full_price();
    }
}