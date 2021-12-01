package GoodsDb.DbAdd.DbAddUnderClass;

import java.time.LocalDate;

public class AddDateProperty extends StrPropertyAdd {
    LocalDate now = LocalDate.now(); //오늘날짜 받아오는거
    @Override
    public String add(String sel){
        switch(sel){
            case "Y":
                int y = now.getYear();
                out = Integer.toString(y);
                return out;
            case "M":
                int m = now.getMonthValue();
                out = Integer.toString(m);
                return out;
            case "D":
                int d = now.getDayOfMonth();
                out = Integer.toString(d);
                return out;
            default:
                return out = "error";
        }
    }
}
