import java.util.HashSet;

public class Building {
    HashSet<String> userInsideBuilding;
    HashSet<String> userWhoExitBuilding;

    public Building(){
        userInsideBuilding = new HashSet<>();
        userWhoExitBuilding = new HashSet<>();
    }

    public void enterBuilding(String userID){
            userInsideBuilding.add(userID);
    }

    public void exitBuilding(String userID){
        userWhoExitBuilding.add(userID);
        userInsideBuilding.remove(userID);
    }

    public boolean checkUsersInsideBuilding(String userID){

            return userInsideBuilding.contains(userID);
    }

    public boolean checkUserWhoExitBuilding(String userID){
        return userWhoExitBuilding.contains(userID);
    }

    public HashSet<String> getUsersBuilding(){
        return userInsideBuilding;
    }
}
