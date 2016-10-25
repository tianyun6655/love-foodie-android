package untils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianyun chen on 2016/10/6.
 */
public class SearchUntils {
    private static List<String> dataarrayList;

    private static void GenerData(){
        dataarrayList = new ArrayList<String>();
        dataarrayList.add("San Jose");
        dataarrayList.add("San Franscio");
        dataarrayList.add("Santa Calar");
        dataarrayList.add("Milpitas");
        dataarrayList.add("Frement");
    }
    public static ArrayList<String>search(String a){
                GenerData();
        ArrayList<String> resultString = new ArrayList<>();
        for(int i =0;i<dataarrayList.size();i++){
            if(dataarrayList.get(i).contains(a)){
                resultString.add(dataarrayList.get(i));
            }
        }
        return resultString;
    }
}
