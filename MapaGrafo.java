//Emerson Marques Ferreira
//Pedro Henrique Lacerda Aredes
package trabalhobombeiro;

class mapaGrafo {

    private int V; // número de vértices
    private int A; // número de arestas
    private int adj[][]; // matriz de adjcência
    private int respo[];

    // inicializa os atributos da classe e cria a 
    // matriz de adjacência para V vértices
    public mapaGrafo(int V) {
        this.V = V;
        this.A = 0; // nao tenho nenhuma aresta
        // criar a matriz de adjacencia

        adj = new int[V][V];
        respo= new int [V];
    }

    /*
    Método insere uma aresta v-w no grafo. O método supõe 
    que v e w são distintos, positivos e menores que V. 
    Se o grafo já tem aresta v-w, o método não faz nada, 
    após a inserção da aresta, o atributo A da classe é 
    atualizado.
     */
    public void insereA(int v, int w) {
        if (this.adj[v][w] == 0) {
            this.adj[v][w] = 1;
            this.A++;
        }
    }

    /*
    Para cada vértice v do grafo, este método imprime, 
    em uma linha, todos os vértices adjacentes a v. 
     */
    public void mostra() {
        for (int v = 1; v < this.V; v++) {
            System.out.print(v + ":");
            for (int w = 0; w < this.V; w++) {
                if (this.adj[v][w] == 1) {
                    System.out.print(" " + w);
                }

            }
            System.out.println();
        }
    }

    public int MensagemIgual(int x, int y) {
        if (x == y || y == x) {
            return 1;

        }
        return 0;
    }

    public int TemPar(int v, int w) {
        if (this.adj[v][w] == 1) {
            return 1;
        }
        return 0;
    }

    public boolean ExisteCiclo(int s, int t) {
        // cria o vetor de visitados                ;       
        // chama a funcao que faz a busca em profundidade a 
        // partir do vertice s
        if (s == t) {
            return false;
        }

        boolean visitados[] = new boolean[this.V];

        busca_prof(t, visitados);

        // como saber se existe caminho até t ?
        // se visitados na posicao t eh igual a true - t foi visitado
        // caso contrario tem false na posicao t
        return visitados[s];

    }

    // implementacao da busca em profundidade a partir de somente um vertice
    public void busca_prof(int v, boolean visitados[]) {
        //marque v como visitado
        visitados[v] = true;
        //para Cada vértice w adjacente a v faça
        for (int w = 0; w < this.V; w++) {// w anda na linha da matriz
            // se w eh adjacente a v E
            // se w não foi visitado então
            if (this.adj[v][w] != 0 && visitados[w] == false) {
                busca_prof(w, visitados);
            }
        }
    }

    public void buscaCaminho(int v, int i,int fim) {

        this.respo[i]=v; 
        //if(this.respo[i]== 6){
          //  
        //}            
        //System.out.print(this.respo[i] + " ");
        if (this.respo[i] == fim) {
            respo[i] = v;
            this.MostraCaminho(1, fim, respo);
        }
        for (int w = 1; w < this.V; w++) {
            if (this.adj[v][w] != 0 /*&& this.respo[i + 1] == 0*/) {               
                 buscaCaminho(w, i + 1,fim);
            }
        }
    }
    
    public void MostraCaminho(int s, int t, int resposta[]) {
        for (int i = 0; i < resposta.length; i++) {
            if (resposta[i] == t) {
                System.out.print(resposta[i]+" ");
                System.out.println("");
                break;
            }
            System.out.print(resposta[i]+" ") ;
        }
    }
}
