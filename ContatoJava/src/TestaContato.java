public class TestaContato {
    public static void main(String[] args) {
        //Define o vetor
        VetorObjetos vetor = new VetorObjetos(2);
        System.out.println("Capacidade: " + vetor.capacidade());
        //Adiciona contatos ao vetor
        Contato c1 = new Contato("Contato 3","3333-3333","contato3@email.com");
		Contato c2 = new Contato("Contato 2","2222-2222","contato2@email.com");
		Contato c3 = new Contato("Contato 1","1111-1111","contato1@email.com");
        Contato cB = new Contato(null,"3333-3333",null);
		System.out.println("vetor vazio: " + vetor);
        vetor.adiciona(c1);
        System.out.println("Adicionei 1º contato");
        System.out.println("Capacidade: " + vetor.capacidade());
        System.out.println(vetor);
        System.out.println("Tamanho atual: "+ vetor.tamanho());
        vetor.adiciona(c2);
        System.out.println("Adicionei 2º contato");
        System.out.println("Capacidade: " + vetor.capacidade());
        System.out.println(vetor);
        System.out.println("Tamanho atual: "+ vetor.tamanho());
        vetor.adiciona(c3);
        System.out.println("Adicionei 3º contato");
        System.out.println("Capacidade: " + vetor.capacidade());
        System.out.println(vetor);
        System.out.println("Tamanho atual: "+ vetor.tamanho());
        System.out.println("Buscar contato na posição 1");
        System.out.println(vetor.busca(1));
        System.out.println("Verificar se existe Contato 3");
        System.out.println("Posicão: " + vetor.busca(c1));

        System.out.println("Verificar se existe Contato B");
        System.out.println("Posicão: " + vetor.busca(cB));

        System.out.println("Adicionar contato 2.5 na posição 2");
        Contato c25 = new Contato("Contato 2.5","2222-5555","contato25@email.com");
        vetor.adiciona(2,c25);
        System.out.println("Capacidade: " + vetor.capacidade());
        System.out.println(vetor);
        System.out.println("Adicionar contato 1.5 na posição 1");
        Contato c15 = new Contato("Contato 1.5","1111-5555","contato15@email.com");
        vetor.adiciona(1,c15);
        System.out.println("Capacidade: " + vetor.capacidade());
        System.out.println(vetor);
        System.out.println("Remover contato 1.5");
        vetor.remove(vetor.busca(c15));
        System.out.println(vetor);
        System.out.println("Capacidade: " + vetor.capacidade());
        System.out.println("Ordenar o vetor");
        vetor.ordena();
        System.out.println(vetor);

        

    }
}
