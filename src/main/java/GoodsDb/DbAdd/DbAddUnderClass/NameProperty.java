package GoodsDb.DbAdd.DbAddUnderClass;

import Util.UserInput;

public class NameProperty extends PropertyAdd {
    @Override
    public String add(){
        out = UserInput.simple(" 물건의 이름은 무엇인가요? :");
        return out;
    }

}
