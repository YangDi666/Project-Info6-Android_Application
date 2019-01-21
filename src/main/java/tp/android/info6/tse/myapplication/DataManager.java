package tp.android.info6.tse.myapplication;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager INSTANCE;
    private List<String> nameList;
    private String name;
    private DataManager(){
        nameList = new ArrayList<>();
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    static public DataManager getInstance(){
        if(INSTANCE == null){
            INSTANCE = new DataManager();
        }

        return INSTANCE;
    }

    public String getName() {
        return name;
    }
    public  void addName(String name){
        nameList.add(name);
    }
    public void setName(String name) {
        this.name = name;
    }
}
