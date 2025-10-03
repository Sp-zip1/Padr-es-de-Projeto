package srategy;


interface EstrategiaCompressao {
    void comprimir(String nomeArquivo);
}

class CompressaoRar implements EstrategiaCompressao {
    @Override
    public void comprimir(String nomeArquivo) {
        System.out.println("Comprimindo " + nomeArquivo + " em RAR...");
    }
}

class CompressaoSeteZ implements EstrategiaCompressao {
    @Override
    public void comprimir(String nomeArquivo) {
        System.out.println("Comprimindo " + nomeArquivo + " em 7Z...");
    }
}

class CompressaoZip implements EstrategiaCompressao {
    @Override
    public void comprimir(String nomeArquivo) {
        System.out.println("Comprimindo " + nomeArquivo + " em ZIP...");
    }
}

class Compactador {
    private EstrategiaCompressao estrategia;
    
    public void definirEstrategia(EstrategiaCompressao estrategia) {
        this.estrategia = estrategia;
    }
    
    public void comprimirArquivo(String nomeArquivo) {
        if (estrategia == null) {
            System.out.println("Erro: Nenhuma estratégia de compressão definida!");
            return;
        }
        estrategia.comprimir(nomeArquivo);
    }
}

class CompressaoTar implements EstrategiaCompressao {
    @Override
    public void comprimir(String nomeArquivo) {
        System.out.println("Comprimindo " + nomeArquivo + " em TAR...");
    }
}

public class Resp_Strategy {
    public static void main(String[] args) {
        Compactador compactador = new Compactador();
        
        System.out.println("=== SISTEMA DE COMPRESSÃO COM STRATEGY ===");
        
        
        compactador.definirEstrategia(new CompressaoZip());
        compactador.comprimirArquivo("documento.pdf");
        
        
        compactador.definirEstrategia(new CompressaoRar());
        compactador.comprimirArquivo("imagem.png");
        
        
        compactador.definirEstrategia(new CompressaoSeteZ());
        compactador.comprimirArquivo("video.mp4");
        
        
        System.out.println("\n=== ADICIONANDO NOVO FORMATO TAR ===");
        compactador.definirEstrategia(new CompressaoTar());
        compactador.comprimirArquivo("backup.sql");
        
        System.out.println("\n=== VANTAGENS DO STRATEGY ===");
        System.out.println("- Elimina condicionais complexas");
        System.out.println("- Fácil adição de novos formatos");
        System.out.println("- Cada algoritmo isolado em sua classe");
        System.out.println("- Facilita testes e manutenção");
    }
}
