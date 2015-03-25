package fr.whatscook.wc;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
public class TitreRecettes {

    public TitreRecettes() {
    }
    public String getJSONFromUrl(String url) {
        String result="";
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet= new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String res = EntityUtils.toString(httpEntity);
            result = new String(res.getBytes("ISO-8859-1"),"UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}