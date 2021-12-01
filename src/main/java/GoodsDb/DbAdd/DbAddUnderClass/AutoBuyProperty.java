package GoodsDb.DbAdd.DbAddUnderClass;

public class AutoBuyProperty extends PropertyAdd {
    @Override
    public String add(){

        out = userInput.integer("물건이 다 떨어지면 몇개씩 자동구매 할까요? :");
        if (out.equals("error")){
            add();
        }
        return out;
    }
}