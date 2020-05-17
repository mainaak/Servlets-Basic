package login;

public class Validate {
    String username = "mainaak@gmail.com";
    String password = "Mettl@123";
    protected boolean authorize(String username,String password){
        if (username.equals(this.username)&&password.equals(this.password))
            return true;
        else
            return false;
    }
}
