package brigde;

interface Canal {
    void enviar(String mensagem);
}

class Email implements Canal {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando por Email: " + mensagem);
    }
}

class SMS implements Canal {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando por SMS: " + mensagem);
    }
}

abstract class Mensagem {
    protected Canal canal;
    
    public Mensagem(Canal canal) {
        this.canal = canal;
    }
    
    public abstract void enviar(String mensagem);
}

class MensagemUrgente extends Mensagem {
    
    public MensagemUrgente(Canal canal) {
        super(canal);
    }
    
    @Override
    public void enviar(String mensagem) {
        String mensagemFormatada = "-> URGENTE: " + mensagem + " <-";
        canal.enviar(mensagemFormatada);
    }
}

class MensagemNormal extends Mensagem {
    
    public MensagemNormal(Canal canal) {
        super(canal);
    }
    
    @Override
    public void enviar(String mensagem) {
        canal.enviar(mensagem);
    }
}

public class Resp_Bridge {
    public static void main(String[] args) {

        Mensagem mensagem1 = new MensagemUrgente(new Email());
        
        Mensagem mensagem2 = new MensagemUrgente(new SMS());
        
        Mensagem mensagem3 = new MensagemNormal(new Email());
        
        Mensagem mensagem4 = new MensagemNormal(new SMS());
        
        System.out.println("=== SISTEMA DE MENSAGENS COM BRIDGE ===\n");
        
        mensagem1.enviar("Reunião cancelada!");
        mensagem2.enviar("Projeto atrasado!");
        mensagem3.enviar("Lembrete: Pagamento em dia");
        mensagem4.enviar("Código de verificação: 123456");
        
        System.out.println("\n=== DEMONSTRANDO FLEXIBILIDADE ===");

        String mesmaMensagem = "Alerta do sistema";
        Mensagem urgenteEmail = new MensagemUrgente(new Email());
        Mensagem urgenteSMS = new MensagemUrgente(new SMS());
        Mensagem normalEmail = new MensagemNormal(new Email());
        Mensagem normalSMS = new MensagemNormal(new SMS());
        
        urgenteEmail.enviar(mesmaMensagem);
        urgenteSMS.enviar(mesmaMensagem);
        normalEmail.enviar(mesmaMensagem);
        normalSMS.enviar(mesmaMensagem);
    }
}