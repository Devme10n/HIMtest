package GoodsDb.DbAdd.DbAddUnderClass;

public class CodeProperty extends StrPropertyAdd {
    private static final CodeProperty cpaInstance = new CodeProperty();
    //물품의 종류마다 다르게 저장될 코드들의 정수 저장값들
    private static int eatGoodsCode = 1;
    private static int notEatGoodsCode = 1;
    private static int autoEatGoodsCode = 1;
    private static int autoNotEatGoodsCode = 1;

    private CodeProperty(){}
    //물품의 종류마다 앞의 로마자가 달라지고 발급순서대로 정수가 1씩 늘어나도록 코드를 발급해주는 메소드
    @Override
    public String add(String sel){
        switch (sel) {
            case "A" -> {
                out = "A" + eatGoodsCode;
                eatGoodsCode += 1;
                return out;
            }
            case "B" -> {
                out = "B" + notEatGoodsCode;
                notEatGoodsCode += 1;
                return out;
            }
            case "C" -> {
                out = "C" + autoEatGoodsCode;
                autoEatGoodsCode += 1;
                return out;
            }
            case "D" -> {
                out = "D" + autoNotEatGoodsCode;
                autoNotEatGoodsCode += 1;
                return out;
            }
            default -> {
                return out = "error";
            }
        }
    }
    //클래스의 인스턴스 주소값을 넘겨주는 메소드
    public static CodeProperty getInstance(){
        return cpaInstance;
    }

}
