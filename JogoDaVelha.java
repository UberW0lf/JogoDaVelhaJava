import java.lang.reflect.Method;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Campo[][] velha = new Campo[3][3];
        String simboloAtual = "X";
        Boolean game = true;
        String vitoria = "";
        Scanner scan = new Scanner(System.in);

        iniciarJogo(velha);

        while (game) {
            limparTela();
            desenhaJogo(velha);
            vitoria = verificaVitoria(velha);
            if (!vitoria.equals("")) {
                System.out.printf("Jogador %s venceu%n", vitoria);
                break;
            }
            try {
                if (verificarJogada(velha, jogar(scan, simboloAtual), simboloAtual)) {
                    if (simboloAtual == "X") {
                        simboloAtual = "O";
                    } else {
                        simboloAtual = "X";
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
        System.out.println("Fim do Jogo");
    }

    public static void desenhaJogo(Campo[][] velha) {
        System.out.println("   0    1    2");
        System.out.printf("0   %s | %s | %s %n", velha[0][0].getSimbolo(), velha[0][1].getSimbolo(),
                velha[0][2].getSimbolo());
        System.out.println("    ------------");
        System.out.printf("1   %s | %s | %s %n", velha[1][0].getSimbolo(), velha[1][1].getSimbolo(),
                velha[1][2].getSimbolo());
        System.out.println("    ------------");
        System.out.printf("2   %s | %s | %s %n", velha[2][0].getSimbolo(), velha[2][1].getSimbolo(),
                velha[2][2].getSimbolo());
    }

    public static void limparTela() {
        for (int cont = 0; cont < 200; cont++) {
            System.out.println("");
        }
    }

    public static int[] jogar(Scanner scan, String sa) {
        int p[] = new int[2];
        System.out.printf("%s %s%n", "Quem joga: ", sa);
        System.out.print("Informa a linha: ");
        p[0] = scan.nextInt();
        System.out.print("Informa a coluna: ");
        p[1] = scan.nextInt();
        return p;
    }

    public static Boolean verificarJogada(Campo[][] velha, int p[], String simboloAtual) {
        if (velha[p[0]][p[1]].getSimbolo() == " ") {
            velha[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        } else {
            return false;
        }
    }

    public static void iniciarJogo(Campo[][] velha) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                velha[l][c] = new Campo();
            }
        }
    }

    public static String verificaVitoria(Campo[][] velha) {
        String vitoria = "";
        String[] simbolos = { "X", "O" };
        for (String s : simbolos) {
            int l = 0, c = 0;
            // Verificar linha
            while (l < 3) {
                int soma = 0;
                c = 0;
                while (c < 3) {
                    if (velha[l][c].getSimbolo().equals(s)) {
                        soma++;
                    }
                    c++;
                }
                if (soma == 3) {
                    vitoria = s;
                    break;
                }
                l++;
            }
            if (vitoria != "") {
                break;
            }
            // Verificar colunas
            l = 0;
            c = 0;
            while (c < 3) {
                int soma = 0;
                l = 0;
                while (l < 3) {
                    if (velha[l][c].getSimbolo().equals(s)) {
                        soma++;
                    }
                    l++;
                }
                if (soma == 3) {
                    vitoria = s;
                    break;
                }
                c++;
            }
            if (vitoria != "") {
                break;
            }

            // verificar diagonal 1
            int i = 0;
            int soma = 0;
            while (i < 3) {
                if (velha[i][i].getSimbolo().equals(s)) {
                    soma++;
                }
                i++;
            }
            if (soma == 3) {
                vitoria = s;
                break;
            }

            // verificar diagonal 2
            soma=0;
            int il = 0, ic = 2;
            while(ic>=0){
                if(velha[il][ic].getSimbolo().equals(s)){
                    soma++;
                }
                il++;
                ic--;
            }
            if(soma==3){
                vitoria=s;
                break;
            }
        }
        return vitoria;
    }

}
