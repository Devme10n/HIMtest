package GoodsDb.DbAdd.DbAddUnderClass;

import Util.UserInput;

public class QtyProperty extends PropertyAdd {
    @Override
    public String add(){
        out = UserInput.integer(" 물건의 수량은 몇개인가요? :");
        if (out.equals("error"))
            add();
        return out;
    }
}
