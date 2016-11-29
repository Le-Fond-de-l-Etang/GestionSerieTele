import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by hugo on 04/11/2016.
 */
public class Serie {
    private int id;
    private String seriesName;
    private String[] aliases;
    private String banner;
    private int seriesId;
    private String status;
    private Date firstAired;
    private String network;
    private int networkId;
    private int runtime;
    private List<String> genre;
    private String overview;
    private long LastUpdated;
    private String airsDayOfWeek;
    private Time airsTime;
    private String rating;
    private String imdbID;
    private String zap2itId;
    private Date added;
    private String addedBy;
    private double siteRating;
    private int siteRatingCount;

    public Serie(int p_id,String p_seriesName,double p_siteRating, List<String> p_genre){
        this.id=p_id;
        this.seriesName=p_seriesName;
        this.siteRating= p_siteRating;
        this.genre = p_genre;
    }
    public String toString(){
        return this.id+" "+seriesName+""+this.genre;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return  this.seriesName;
    }

    public double getSiteRating(){
        return this.siteRating;
    }
    public List<String> getGenre(){
        return this.genre;
    }
    public boolean isInGenre(String search){
        for(String str: genre) {
            if(str.trim().contains(search))
                return true;
        }
        return false;
    }








}
