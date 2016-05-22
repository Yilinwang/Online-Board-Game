package game;

import java.io.Serializable;

/**
 * Created by ralph on 2016/1/17.
 */
public class Mission implements Serializable{
    public static final String[] cityName = {"", "117", "118", "119", "思亮館", "新體", "萬才館",
                                            "醉月湖", "牙買加", "舊體", "德田", "小福", "普通",
                                            "新月台", "長星小七", "總圖後草皮", "總圖", "活大",
                                            "傅鐘", "女五", "大門", "男宿", "生態池", "鹿鳴",
                                            "共同", "大一女", "管院", "動物醫院", "台科", "雅頌廣場",
                                            "二活", "牛奶生產處", "牛的家", "公館國小", "民族國中", "百老匯", "東南亞"};
    private int cityOne;
    private int cityTwo;
    private int value;
    public Mission(int _cityOne, int _cityTwo, int _value){
        cityOne = _cityOne;
        cityTwo = _cityTwo;
        value = _value;
    }
    public int getCityOne(){
        return cityOne;
    }
    public int getCityTwo(){
        return cityTwo;
    }
    public int getValue(){
        return value;
    }
    public String getCityOneName(){
        return cityName[cityOne];
    }
    public String getCityTwoName(){
        return cityName[cityTwo];
    }
}
