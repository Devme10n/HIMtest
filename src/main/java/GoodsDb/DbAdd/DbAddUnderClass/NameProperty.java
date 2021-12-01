package GoodsDb.DbAdd.DbAddUnderClass;

public class NameProperty extends PropertyAdd {
    @Override
    public String add(){
        out = userInput.simple("물건의 이름은 무엇인가요? :");
        return out;
    }

}
