package GoodsDb.DbAdd.DbAddUnderClass;

import Util.UserInput;

public class AutoBuyProperty extends PropertyAdd {
    @Override
    public String add(){

        out = UserInput.integer("물건이 다 떨어지면 몇개씩 자동구매 할까요? :");
        if (out.equals("error")){
            add();
        }
        return out;
    }
}