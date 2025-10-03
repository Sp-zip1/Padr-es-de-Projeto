package observer;

interface Observer {
    void update(String tarefa);
}

interface Subject {
    void adicionar(Observer observer);
    void remover(Observer observer);
    void notificar(String tarefa);
}

class Professor implements Subject {
    private java.util.List<Observer> alunos = new java.util.ArrayList<>();
    
    @Override
    public void adicionar(Observer observer) {
        alunos.add(observer);
    }
    
    @Override
    public void remover(Observer observer) {
        alunos.remove(observer);
    }
    
    @Override
    public void notificar(String tarefa) {
        for (Observer aluno : alunos) {
            aluno.update(tarefa);
        }
    }
    
    public void postarTarefa(String tarefa) {
        System.out.println("Professor postou: " + tarefa);
        notificar(tarefa);
    }
}

class Aluno implements Observer {
    private String nome;
    
    public Aluno(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void update(String tarefa) {
        System.out.println(nome + " recebeu a tarefa: " + tarefa);
    }
}

public class Resp_Observer {
    public static void main(String[] args) {
        
        Professor professor = new Professor();
        
        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");
        Aluno aluno3 = new Aluno("Pedro");
        
        professor.adicionar(aluno1);
        professor.adicionar(aluno2);
        professor.adicionar(aluno3);
        
        System.out.println("=== SISTEMA DE SALA DE AULA (OBSERVER) ===\n");
        
        professor.postarTarefa("Ler capítulo 5 do livro");
        System.out.println(); 
        
        professor.postarTarefa("Fazer exercício 10 da página 42");
        System.out.println();
        
        professor.postarTarefa("Preparar apresentação sobre OOP");
        
        professor.postarTarefa("Tarefa extra: revisar conceitos");
    }
}
