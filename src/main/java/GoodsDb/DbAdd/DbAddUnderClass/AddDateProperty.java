package GoodsDb.DbAdd.DbAddUnderClass;

import java.time.LocalDate;

public class AddDateProperty extends StrPropertyAdd {
    LocalDate nowdate = LocalDate.now(); //오늘날짜 받아오는거
    @Override
    public String add(String sel){
        switch(sel){
            case "Y":
                int y = nowdate.getYear();
                out = Integer.toString(y);
                return out;
            case "M":
                int m = nowdate.getMonthValue();
                out = Integer.toString(m);
                return out;
            case "D":
                int d = nowdate.getDayOfMonth();
                out = Integer.toString(d);
                return out;
            default:
                return out = "error";
        }
    }
}
