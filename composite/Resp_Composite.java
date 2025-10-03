package composite;

import java.util.ArrayList;
import java.util.List;

interface MenuComponent {
    void show();
}

class MenuItem implements MenuComponent {
    private String name;
    
    public MenuItem(String name) {
        this.name = name;
    }
    
    @Override
    public void show() {
        System.out.println("-> " + name);  
    }
}

class Menu implements MenuComponent {
    private String name;
    private List<MenuComponent> children;
    
    public Menu(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    
    public void add(MenuComponent item) {
        children.add(item);
    }
    
    public void remove(MenuComponent item) {
        children.remove(item);
    }
    
    @Override
    public void show() {
        System.out.println("+ " + name);
        for (MenuComponent child : children) {
            child.show();
        }
    }
}

public class Resp_Composite {
    public static void main(String[] args) {
        
        Menu arquivos = new Menu("ARQUIVOS");
        
        MenuItem salvar = new MenuItem("SALVAR");
        MenuItem deletar = new MenuItem("DELETAR");
        Menu opcoes = new Menu("OPÇÕES");
        
        MenuItem colar = new MenuItem("COLAR");
        MenuItem copiar = new MenuItem("COPIAR");

        opcoes.add(colar);
        opcoes.add(copiar);
        
        arquivos.add(salvar);
        arquivos.add(deletar);
        arquivos.add(opcoes);
        
        System.out.println("=== ESTRUTURA DE MENUS ===");
        arquivos.show();
    }
}