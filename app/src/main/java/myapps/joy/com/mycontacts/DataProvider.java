package myapps.joy.com.mycontacts;

/**
 * Created by Jecihjoy on 6/10/2016.
 */
public class DataProvider {
    private String name;
    private String mob;
    private String email;


public DataProvider(String name, String mob, String email) {
    this.name = name;
    this.mob = mob;
    this.email = email;


}

public void setName(String name){
    this.name = name;
}
    public void setMob(String mob){
        this.mob = mob;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public String getMob(){
        return mob;
    }
    public String getEmail(){
        return email;
    }



}
