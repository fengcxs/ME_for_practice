import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println("请输入股票代码和时间间隔(秒为单位)，以空格隔开： ");
        Scanner scan = new Scanner(System.in);
        String code = scan.next();
        String strInterval = scan.next();

        int interval = Integer.parseInt(strInterval);

        while(true){
            getMarket(code);

            try {
                Thread.sleep(interval *1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void getMarket(String code){
        String body = null;
        String[] info_list = null;

        String[] ups_and_downs = {"↑", "↓", "→"};
        int index =2;

        try {
            body = doGet("http://hq.sinajs.cn/list=" + code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(body);
        String pattern = ".*=\"(.*)\"";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(body);
        if (!m.find( )) {
            System.out.println("");
            return;
        }
        else{
            info_list = m.group(1).split(",");
        }

        if(info_list.length < 3){
            System.out.print("获取数据失败！");
            return;
        }

        //判断涨跌
        float currPrice = Float.parseFloat(info_list[3]);
        float lastClosePrice = Float.parseFloat(info_list[2]);
        if(Math.abs(currPrice-lastClosePrice)<0.00000001){
            index = 2;
        }
        else if(currPrice > lastClosePrice){
            index = 0;
        }
        else{
            index = 1;
        }
        //处理名称编码
        String name = "名称";
        try {
            name = new String(info_list[0].getBytes("GBK"),"utf-8");
            //name = new String("测试".getBytes("GBK"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //处理输出
        System.out.println(info_list[info_list.length - 3] + " " + info_list[info_list.length - 2] + ": "
            +  name + " " + info_list[3] + " " + ups_and_downs[index]);
    }

    public static String doGet(String url) throws Exception {
        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type",
                "application/text");

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        if (httpURLConnection.getResponseCode() >= 300) {
            throw new Exception(
                    "HTTP Request is not success, Response code is "
                            + httpURLConnection.getResponseCode());
        }

        try {
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }

        }
        return resultBuffer.toString();
    }

}
