package sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchMethod {

    public static List<String> byName(String str, List<String>player) {
        List<String> selectByName = new ArrayList<>();
        for(String p: player){
            String[] token = p.split(",");
            if(token[0].equalsIgnoreCase(str)){
                selectByName.add(p);
            }
        }
        return selectByName;
    }
    public static List<String> byClubAndCountry(String str2, List<String>player) {

        List<String> selectByClubandCountry = new ArrayList<>();

        for(String p: player){
            String[] token = p.split(",");
            if(token[1].equalsIgnoreCase(str2)){
                selectByClubandCountry.add(p);
            }
        }
        return selectByClubandCountry;
    }
    public static List<String> byPosition(String str, List<String>player) {
        List<String> selectByPosition = new ArrayList<>();

        for(String p: player){
            String[] token = p.split(",");
            if(token[5].equalsIgnoreCase(str)){
                selectByPosition.add(p);
            }
        }
        return selectByPosition;
    }
    public static List<String> bySalary(double HigherLimit , double LowerLimit, List<String>player){
        List<String> selectBySalary = new ArrayList<>();

        for(String p: player){
            String[] token = p.split(",");
            if(Double.parseDouble(token[7])<HigherLimit && Double.parseDouble(token[7])>LowerLimit){
                selectBySalary.add(p);
            }
        }
        return selectBySalary;
    }
    public static List<String> byHeight(double HigherLimit , double LowerLimit, List<String>player){
        List<String> selectByHeight = new ArrayList<>();

        for(String p: player){
            String[] token = p.split(",");
            if(Double.parseDouble(token[3])<HigherLimit && Double.parseDouble(token[3])>LowerLimit){
                selectByHeight.add(p);
            }
        }
        return selectByHeight;
    }
    public static Map<String, Double> findMaxSalary(String str, List<String>player){
        Map<String,Double> maxSalary =new HashMap<>();

        double salary = -1;
        for(String p: player){
            String[] token = p.split(",");
            if(Double.parseDouble(token[7])>salary && token[4].equalsIgnoreCase(str)){
                salary= Double.parseDouble(token[7]);
            }
        }

        if(salary!=-1)maxSalary.put(str,salary);
        return maxSalary;

    }
    public static Map<String, Double> findMaxHeight(String str, List<String>player){
        Map<String,Double>maxHeight = new HashMap<>();
        double height = -1;
        for(String p: player){
            String[] token = p.split(",");
            if(Double.parseDouble(token[3])>height && token[4].equalsIgnoreCase(str)){          //Find max height of a particular club
                height = Double.parseDouble(token[3]);
            }
        }
        if(height!=-1)maxHeight.put(str,height);
        return maxHeight;
    }
    public static Map<String, Integer> findMaxAge(String str, List<String>player){
        Map<String,Integer> maxAge =new HashMap<>();
        int age=-1;
        for(String p: player){
            String[] token = p.split(",");
            if(Integer.parseInt(token[2])>age && token[4].equalsIgnoreCase(str)){           //Find max age of a particular club
                age = Integer.parseInt(token[2]);
            }
        }
        if(age!=-1)maxAge.put(str,age);
        return maxAge;
    }
}
