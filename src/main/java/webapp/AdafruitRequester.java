package webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
import java.util.ArrayList;

public class AdafruitRequester {
	
public String getLastData()
   {
     String last_value = "0";
     try
     {
       String myUrl = "http://io.adafruit.com/api/v2/mig3linho/feeds/kasvikosteus/data/last";
       String results = doHttpUrlConnectionAction(myUrl);
       JSONObject json = new JSONObject(results);
       last_value = json.getString("value");
       
       String date = json.getString("created_at");
       
       //ArrayList<String> data = new ArrayList<>();
       
     }
     catch (Exception e)
     {
       // deal with the exception in your "controller"
     }
     return last_value;
   }


private String doHttpUrlConnectionAction(String desiredUrl)
   throws Exception
   {
     URL url = null;
     BufferedReader reader = null;
     StringBuilder stringBuilder;

     try
     {
       // create the HttpURLConnection
       url = new URL(desiredUrl);
       HttpURLConnection connection = (HttpURLConnection) url.openConnection();

       //HTTP GET with specified Adafruit key
       connection.setRequestMethod("GET");
       connection.setRequestProperty("X-AIO-Key", "a73b7ea21eac48bf82a35c1b656e07eb");

       // give it 15 seconds to respond
       connection.setReadTimeout(15*1000);
       connection.connect();

       // read the output from the server
       reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
       stringBuilder = new StringBuilder();

       String line = null;
       while ((line = reader.readLine()) != null)
       {
         stringBuilder.append(line + "\n");
       }
       return stringBuilder.toString();
     }
     catch (Exception e)
     {
       e.printStackTrace();
       throw e;
     }
     finally
     {
       // close the reader; this can throw an exception too, so
       // wrap it in another try/catch block.
       if (reader != null)
       {
         try
         {
           reader.close();
         }
         catch (IOException ioe)
         {
           ioe.printStackTrace();
         }
       }
     }
   }
}
