import Entidades.BotaoModerno;
import Entidades.ElementoDesign;

public class App {
    public static void main(String[] args){
        BotaoModerno original = new BotaoModerno();
        ElementoDesign clone = original.clone();
        System.out.println("Clone criado com sucesso!");
    } 
}
