package untils;

import android.os.Handler;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by tianyun chen on 2016/9/13.
 */
public class HttpUtils {
    private URL url;
    private HttpURLConnection connection;
    private byte[] mydata;
    private Handler mHandler;
    public HttpUtils(String url,String apiName) {
        try {
            this.url = new URL(url+apiName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void loadData(Map<String,String> paramers){
          StringBuffer buffer = new StringBuffer();
          for(Map.Entry<String,String> entry:paramers.entrySet()){
              try {
                  buffer.append(entry.getKey())
                          .append("=")
                          .append(URLEncoder.encode(entry.getValue(),"UTF-8"))
                          .append("&");

              } catch (UnsupportedEncodingException e) {
                  e.printStackTrace();
              }

          }
          buffer.deleteCharAt(buffer.length()-1);
          mydata = buffer.toString().getBytes();
      }

    public InputStream excusePost(){
        try {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(3000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", String.valueOf(mydata.length));
            connection.connect();
            OutputStream  outputStream =  connection.getOutputStream();
            outputStream.write(mydata,0,mydata.length);
            int responseCode = connection.getResponseCode();
            if(responseCode==200){
               return  connection.getInputStream();
                //encodeStream(connection.getInputStream());
            }else
            {
                //Log.d("Http","exception");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
   /* private void encodeStream(InputStream inputStream){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len =0;
        String result = "";
        try {
            while((len=inputStream.read(data))!=-1){
                data.toString();
                outputStream.write(data,0,len);
            }
            result = new String(outputStream.toByteArray(),"UTF-8");
            Log.d("Http",result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
/*    @Override
    public void run(){
          excusePost();
    }*/
}
