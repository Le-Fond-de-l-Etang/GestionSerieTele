import java.util.Date;

/**
 * Created by hugo on 04/11/2016.
 */
public class Actor {
    private String image;
    private Date lastUpdated;
    private String role;
    private int sortOrder;
    private int imageAuthor;
    private Date imageAdded;
    private String name;
    private int id;
    private int serieid;

    public  Actor(String p_image, Date p_lastUpdated, String p_role, int p_sortOrder, int p_imageAthor, Date p_imageAdded, String p_name, int p_id,int p_serie){
        this.image=p_image;
        this.lastUpdated=p_lastUpdated;
        this.role= p_role;
        this.sortOrder=p_sortOrder;
        this.imageAuthor =p_imageAthor;
        this.imageAdded= p_imageAdded;
        this.name=p_name;
        this.id =p_id;
        this.serieid = p_serie;
    }
    public String toString(){
        return this.name+" "+this.role+" "+this.lastUpdated+" "+serieid;
    }

    public int getId(){
       return this.id;
    }

    public int getSerieId(){
        return this.serieid;
    }
    public String getName(){
        return this.name;
    }
}