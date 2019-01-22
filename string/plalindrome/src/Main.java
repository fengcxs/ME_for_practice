import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入一个字符串： ");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();

        if(check_plalindrome(read)){
            System.out.println("该字符串是回文 ");
        }
        else{
            System.out.println("该字符串不是回文 ");
        }
    }

    public static boolean check_plalindrome(String input){
        int j = input.length()/2;
        int len = input.length();

        for(int i=0; i <= j; i++){
            if(input.charAt(i) != input.charAt(len-1 -i)){
                return false;
            }
        }
        return true;
    }
}
