package webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.ArrayList;

public class AdafruitRequester {
	
public ArrayList<String> getLastData()
   {
     String last_value = "0";
     ArrayList<String> data = new ArrayList<String>();
     try
     {
       String myUrl = "http://io.adafruit.com/api/v2/mig3linho/feeds/kasvikosteus/data/last";
       String results = doHttpUrlConnectionAction(myUrl);
       
       JSONObject obj = new JSONObject(results);
       last_value = obj.getString("value");
       String created_at = obj.getString("created_at");
       
       String created_at_date = created_at.substring(0,10);
       String created_at_time = created_at.substring(11, 18);
       
       
       String date_splits[] = created_at_date.split("-");
       String time_splits[] = created_at_time.split(":");
       String date = date_splits[2] + "." + date_splits[1] + "." + date_splits[0];
       String time = time_splits[0] + "." + time_splits[1];
       
       data.add(last_value);
       data.add(date);
       data.add(time);
       data.add(created_at);
     }
     catch (Exception e)
     {
       // deal with the exception in your "controller"
     }
     return data;
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
