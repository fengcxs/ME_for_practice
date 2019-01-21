import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        System.out.print("输入一个字符串:");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        System.out.println("输入数据："+read);
        String res = reverse(read);
        System.out.println("输出数据："+res);

    }


    private static String reverse(String str){
        String res="";

        for(int i = str.length() - 1; i >= 0; i--){
            res += str.charAt(i);
        }
        return res;
    }
}
