package GoodsDb.DbAdd.DbAddUnderClass;

public class ExpDateProperty extends StrPropertyAdd {

    @Override
    public String add(String sel){
        switch (sel) {
            case "Y" -> {
                out = userInput.year("물건의 유통기한은 몇년까지인가요? :");
                if (out.equals("error"))
                    add("Y");
                return out;
            }
            case "M" -> {
                out = userInput.month("물건의 유통기한은 몇월까지인가요? :");
                if (out.equals("error"))
                    add("M");
                return out;
            }
            case "D" -> {
                out = userInput.day("물건의 유통기한은 몇일까지인가요? :");
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
