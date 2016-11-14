import org.json.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by hugo on 21/10/2016.
 */
public class jsonDeserialiser {




   public static String readfile() {
       File file = new File(System.getProperty("user.dir") + "\\series.json");


       try {
           Scanner scanner = new Scanner(file);
           String s ="";
           while(scanner.hasNext()){

               s += scanner.nextLine();
           }
           return s;
       } catch (FileNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
           return e.toString();
       }

   }

    public static Actor getActorFromjson(JSONObject p_json){
        try{
            String image = p_json.getString("image");


            String role = p_json.getString("role");
            int sortOrder= p_json.getInt("sortOrder");
            int  imageAuthor=0;
            if(p_json.get("imageAuthor") != null) {
                imageAuthor = p_json.getInt("imageAuthor");
            }
                else
                {
                 imageAuthor =0;
                }
            //System.out.println(imageAuthor);
            String name = p_json.getString("name");
            int id = p_json.getInt("id");
            int serieid = p_json.getInt("seriesId");

         //   2008-10-24 16:06:13
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date lastUpdate;
            Date imageAdded;
            try{
                lastUpdate = df.parse(p_json.getString("lastUpdated"));
                imageAdded=df.parse(p_json.getString("imageAdded"));
            }
            catch (ParseException pe) {
                lastUpdate = new Date();
                imageAdded = new Date();
            }

            return  new Actor(image, lastUpdate, role, sortOrder, imageAuthor, imageAdded,name,id ,serieid);



        }catch (org.json.JSONException jse){
            System.out.println(jse.toString());
            return  null;
        }

    }
    public static Serie getSerieFromJson(JSONObject p_json){
       try {
           int id = p_json.getInt("id");
           String seriesName = p_json.getString("seriesName");
           double siteRating=  p_json.getDouble("siteRating");
           List<String> genre= new ArrayList<String>();
           for(int i = 0; i<p_json.getJSONArray("genre").length(); i++){
              genre.add(p_json.getJSONArray("genre").getString(i));
           }
           return new Serie(id,seriesName,siteRating,genre);
       }
       catch (JSONException jse){
           System.out.println(jse.toString());
           return null;
       }
    }



}
