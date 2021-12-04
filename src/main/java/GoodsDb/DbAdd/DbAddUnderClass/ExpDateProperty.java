package GoodsDb.DbAdd.DbAddUnderClass;

import Util.UserInput;

public class ExpDateProperty extends StrPropertyAdd {

    @Override
    public String add(String sel){
        switch (sel) {
            case "Y" -> {
                out = UserInput.year(" 물건의 유통기한은 몇년까지인가요? :");
                if (out.equals("error"))
                    add("Y");
                return out;
            }
            case "M" -> {
                out = UserInput.month(" 물건의 유통기한은 몇월까지인가요? :");
                if (out.equals("error"))
                    add("M");
                return out;
            }
            case "D" -> {
                out = UserInput.day(" 물건의 유통기한은 몇일까지인가요? :");
                if (out.equals("error"))
                    add("D");
                return out;
            }
            default -> {
                return out = "error";
            }
        }
    }
}
