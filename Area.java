import java.util.HashMap;
import java.util.HashSet;

public class Area {

    private HashSet<String> usersSet;
    private HashMap<Integer, HashSet> areaUsers;
    //the correct way is private HashMap<Integer, HashSet<Integer>> areaUsers;
    //or also better Map<String,Set<Integer>> areaUsers; or also using two specific objects instead of normal fields


    public Area(){
        areaUsers = new HashMap<>();
        usersSet = new HashSet<>();


    }

    public boolean checkPermissionArea(String userID, int areaID){
        if(areaUsers.containsKey(areaID)){
            usersSet = areaUsers.get(areaID);
            if(usersSet.contains(userID)) {
                return true;
            }else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public void givePermission (String userID, int areaID) {

        if (areaUsers.containsKey(areaID)) {
            usersSet = areaUsers.get(areaID);
            usersSet.add(userID);
            areaUsers.replace(areaID, usersSet);
        }
             else {
                usersSet.clear();
                usersSet.add(userID);
                areaUsers.put(areaID, usersSet);
            }
    }

    public void revokePermission (String userID, int areaID) {

        if (areaUsers.containsKey(areaID)) {
            usersSet = areaUsers.get(areaID);
            if (usersSet.contains(userID)) {
                usersSet.remove(userID);
                areaUsers.replace(areaID, usersSet);
            }
        }
    }

    public void addUserToArea(String userID, int areaID){
        if(areaExists(areaID)){
            usersSet = areaUsers.get(areaID);
            usersSet.add(userID);
            areaUsers.replace(areaID,usersSet);
        }else{
            usersSet = new HashSet<>();
            usersSet.add(userID);
            areaUsers.put(areaID,usersSet);
        }
    }

    public boolean areaExists (int areaID){
        return areaUsers.containsKey(areaID);
    }

    public boolean userExsists(String userID, int areaID) {
        if (areaUsers.containsKey(areaID)) {
            usersSet = areaUsers.get(areaID);
            return usersSet.contains(userID);
        }else{
            return false;
        }
    }
}


