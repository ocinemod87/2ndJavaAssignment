import java.util.HashSet;

public class AccessControl {
    Building building;
    Area area;

    public AccessControl(){

        building = new Building();
        area = new Area();
    }

    public boolean enter(String userID){
        if(!building.checkUsersInsideBuilding(userID)){
            building.enterBuilding(userID);
            return true;
        }
        else{
            System.out.println("ERROR: According to our logs, user " + userID + " is already inside, and therefore must be questioned!");
            return false;
        }
    }
    public boolean exit(String userID){
        if(building.checkUsersInsideBuilding(userID)){
            building.exitBuilding(userID);
            return true;
        }
        else{
            System.out.println("ERROR: According to our logs, user " + userID + " is not inside, and therefore must be questioned!");
            return false;
        }
    }
    public Iterable<String> getUsersInside(){
        return building.getUsersBuilding();
    }

    public boolean canAccess(String userID, int areaID){

        if(building.checkUsersInsideBuilding(userID) && area.checkPermissionArea(userID, areaID)){
            return true;
        }
        else if (!building.checkUsersInsideBuilding(userID) && !area.checkPermissionArea(userID, areaID)){
            System.out.println("ERROR: User " +userID+ " has not entered the main door, and therefore cannot enter area "+areaID+"!");
            return false;
        }
        else if(building.checkUsersInsideBuilding(userID) && !area.checkPermissionArea(userID, areaID)){
            System.out.println("ERROR: User "+userID+" does not have access privileges to area "+areaID+"!");
            return false;
        }
        else if(!building.checkUsersInsideBuilding(userID) && area.checkPermissionArea(userID, areaID)){
            System.out.println("ERROR: User " +userID+ " has not entered the main door, and therefore cannot enter area "+areaID+"!");
            return false;
        }
        else if(building.checkUserWhoExitBuilding(userID)){
            return area.checkPermissionArea(userID, areaID);
        }
        else{
            return false;
        }
    }


    public void grantAccess(String userID, int areaID){
        if(area.areaExists(areaID) && area.userExsists(userID, areaID)){
            area.givePermission(userID, areaID);
        }else{
            area.addUserToArea(userID, areaID);
            area.givePermission(userID, areaID);
        }
    }

    public void revokeAccess(String userID, int areaID){

        area.revokePermission(userID, areaID);
    }
}
