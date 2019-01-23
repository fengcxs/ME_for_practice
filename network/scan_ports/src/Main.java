import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static HashSet<Integer> openPortsSet = new HashSet<Integer>();

    public static void main(String[] args) {
        System.out.println("请输入一个IP地址和端口范围(xx-xxx)：");
        Scanner scan = new Scanner(System.in);
        String strIp = scan.next();
        String strPorts = scan.next();

        int startPort = Integer.parseInt(strPorts.split("-")[0]);
        int endPort = Integer.parseInt(strPorts.split("-")[1]);

        for(int i = startPort; i<= endPort; i++){
            try {
                Socket sok = new Socket();
                sok.connect(new InetSocketAddress(strIp, i), 10);

                System.out.print("捕获到端口： " + i);
                openPortsSet.add(i);
                sok.close();
            } catch (Exception e) {
            }
        }
        System.out.print("打开端口为： " + openPortsSet + "\r\n");

        Iterator<Integer> it =openPortsSet.iterator();
        while(it.hasNext()){
            Integer in = it.next();
            System.out.print(in + ", ");
        }
    }
}
