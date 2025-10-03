package Entidades;

public class BotaoModerno implements ElementoDesign {
    private String corFundo;
        private String corTexto;
                private String fonte;
                    public BotaoModerno() { 
                        this.corFundo = "#3498db";
                    this.corTexto = "#ffffff";
                this.fonte = "Arial, 14px, bold";
    }
    public ElementoDesign clone() {
        BotaoModerno clone = new BotaoModerno();
        clone.corFundo = this.corFundo;
        clone.corTexto = this.corTexto;
        return clone;
    }
    
    @Override
    public String getCorFundo() { 
        return corFundo; 
    }
    @Override
    public String getCorTexto() { 
        return corTexto; 
    }
    @Override
    public String getFonte() { 
        return fonte; 
    }
    @Override
    public void setCorFundo(String cor) { 
        this.corFundo = cor; 
    }
    @Override
    public void setCorTexto(String cor) { 
        this.corTexto = cor; 
    }
    @Override
    public void setFonte(String fonte) { 
        this.fonte = fonte; 
    }

}