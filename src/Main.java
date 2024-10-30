interface Ingredient{
    void getName();
    void getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public SolidIngredient(String n, double qt){
        _name = n;
        _quantity = qt;
    }
    public void getName(){String n = _name;}
    public void getQuantity(){ double qt = _quantity;}
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _quantity;
    public LiquidIngredient(String n, double qt){
        _name = n;
        _quantity = qt;
    }
    public void getName(){ String n =_name;}
    public void getQuantity(){ double qt =_quantity;}
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}