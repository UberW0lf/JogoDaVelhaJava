public class Campo {
    private String simbolo;

    public Campo() {
        this.simbolo = " ";
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(String simbolo) {
        if (this.simbolo == " ") {
            this.simbolo = simbolo;
        } else {
            System.out.println("Campo ja usado");
        }
    }
}
