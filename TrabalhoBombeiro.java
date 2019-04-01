//Emerson Marques Ferreira
//Pedro Henrique Lacerda Aredes
package trabalhobombeiro;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TrabalhoBombeiro {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //criando o grafo do mapa
        mapaGrafo mapaGrafo;
        FileReader objTexto;
        Scanner ler = new Scanner(System.in);
        objTexto = new FileReader("Rotas.txt");
        BufferedReader objBufferizado;
        objBufferizado = new BufferedReader(objTexto);
        //criando linha e um vetor de string para ler o arquivo
        String linha, vetorString[];
        linha = objBufferizado.readLine();
        //pega o tamanho e instancia o grafoMapa
        int tamanho = Integer.parseInt(linha);        
        mapaGrafo = new mapaGrafo(tamanho+1);       
        //variavel das arestas (x-y)
        int x, y;
        
        
        //atribuindo as arestas ao vetor de objeto, atraves do arquivop txt
        while (true) {
            linha = objBufferizado.readLine();
            vetorString = linha.split(" ");
            x = Integer.parseInt(vetorString[0]);
            vetorString = linha.split(" ");
            y = Integer.parseInt(vetorString[1]);
            if(x == 0 && y ==0){
                break;
            }
            if(mapaGrafo.MensagemIgual(x,y) == 1){
                System.out.println("No par "+x+" "+y+" X deve ser diferente de Y");
            }
            if(mapaGrafo.TemPar(x,y) == 1){
                System.out.println("Par "+x+" "+y+" Ja foi inserido anteriormente!");
            }
            if(mapaGrafo.ExisteCiclo(x,y) == true){
                System.out.println("Par "+x+" "+y+" Forma Ciclo");
            }
            else if (mapaGrafo.MensagemIgual(x,y) == 0 && mapaGrafo.TemPar(x,y) == 0 && mapaGrafo.ExisteCiclo(x,y) == false){
                mapaGrafo.insereA(x,y);
            }
        }
        //mapaGrafo.mostra();
        mapaGrafo.buscaCaminho(1,0,tamanho);
    }
    
}
