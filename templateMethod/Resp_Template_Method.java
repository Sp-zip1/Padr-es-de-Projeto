package templateMethod;

abstract class Jogo {
    
    public final void logica() {
        colidir();
        atira();
        move();
    }
    
    private void colidir() {
        System.out.println("colidiu");
    }
    
    protected abstract void atira();
    protected abstract void move();
}

class Alien extends Jogo {
    
    @Override
    protected void atira() { 
        System.out.println("Estou atirando pelos olhos");
    }
    
    @Override
    protected void move() { 
        System.out.println("Estou me movendo com meus tentáculos");
    }
}

class Robo extends Jogo {
    
    @Override
    protected void atira() {
        System.out.println("Estou atirando com as mãos");
    }
    
    @Override
    protected void move() {
        System.out.println("Estou me movendo com minhas pernas robóticas");
    }
}

public class Resp_Template_Method {
    public static void main(String[] args) {
        Jogo alien = new Alien();
        Jogo robo = new Robo();
        
        System.out.println("=== ALIEN ===");
        alien.logica();
        System.out.println("\n=== ROBO ===");
        robo.logica(); 
    }
}
