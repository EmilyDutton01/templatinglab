import java.util.ArrayList;
import java.util.Scanner;

interface Ingredient{
    String getName();
    double getQuantity();
}
class SolidIngredient implements Ingredient{
    private String _name;
    private double _qtInGrams;
    public SolidIngredient(String n, double qt){
        _name = n;
        _qtInGrams = qt;
    }
    public String getName(){
        return _name;
    }
    public double getQuantity(){
        return _qtInGrams;
    }
}
class LiquidIngredient implements Ingredient{
    private String _name;
    private double _qtInMl;
    public LiquidIngredient(String n, double qt){
        _name = n;
        _qtInMl = qt;
    }
    public String getName(){ String n =_name;
        return n;
    }
    public double getQuantity(){ double qt =_qtInMl;
        return qt;
    }
}
class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;
    public Recipe(String n, String inst){
        _name = n;
        _instructions = inst;
        _ingredients = new ArrayList<>();
    }
    public void addIngredient(T t){
        _ingredients.add(t);
    }
    public void printIngredients(){
        System.out.println("Recipe: " + _name);
        System.out.println("Instructions: " + _instructions);
        System.out.println("Ingredients: ");
        for(T t : _ingredients){
            System.out.println("- " + t.getName() + ": " + t.getQuantity());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter recipe name:");
        String name = s.nextLine();
        System.out.println("Enter instructions:");
        String instructions = s.nextLine();
        Recipe<Ingredient> recipe = new Recipe<Ingredient>(name, instructions);
        int choice = Menu(s);
        while( choice != 3){
            switch(choice){
                case 1 -> addIngredient(recipe, s);
                //case 2 -> recipe.print();
            }
        }
    }
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner s){
        System.out.println("solid (s) or liquid(l)");
        char type = s.next().charAt(0);
        System.out.println("Enter ingredient name:");
        String name = s.nextLine();
        System.out.println("Enter ingredient quantity:");
        double quantity = Double.parseDouble(s.nextLine());
        Ingredient ingredient; //polymorphic reference
        if (type == 's'){
            ingredient = new SolidIngredient(name, quantity);
        } else {
            ingredient = new LiquidIngredient(name, quantity);
        }
        recipe.addIngredient(ingredient);
    }
    private static int Menu(Scanner s) {
        Recipe<Ingredient> r;
        System.out.println("Recipe Menu:");
        System.out.println("1. Add ingredient");
        System.out.println("2. Print ingredients");
        System.out.println("3. Exit");
        System.out.println("Enter your choice:");
        int choice = 0;
        while (choice != 3){
            try{
                choice = Integer.valueOf(s.nextLine());
            } catch(NumberFormatException e){
                System.out.println("invalid data entry");
                System.exit(-1);
            }
        }
        return choice;
    }
}