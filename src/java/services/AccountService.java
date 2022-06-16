package services;
import models.User;

/**
 *
 * @author Diego Maia
 */
public class AccountService {
    
    private String[] usernameList = {"abe", "barb"};

        
    public User login(String username, String password) {
        for (int i=0; i< usernameList.length; i++){
            if (username.equals(usernameList[i]) && password.equals("password")){
                return new User(username, null);
            }            
        }
        return null;
    }
}
