import java.util.ArrayList;

public class TestaArrayList {
    public static void main(String[] args) {

        String[] nome = {"Gabriel", "João", "Pedro", "Marcelo"};
        String[] telefone = {"09872349", "098257", "023985", "90142"};
        String[] email = {"gabrielslaoq21@gmail.com", "jpmassademais2020@gmail.com", "pedrobao3212@gmail.com", "marcelomaluco@gmail.com"};

        ArrayList<Contato> contatos = new ArrayList<>();

        for (int i = 0; i < nome.length; i++) {
            contatos.add(new Contato(nome[i], telefone[i], email[i]));
        }

        // Adicionar elemento ao final
        contatos.add(new Contato("Bernardo", "50978", "bernardonerd@gmail.com"));

        // Verificar a quantidade de elementos
        System.out.println(contatos.size());

        // Imprimir elementos do vetor
        System.out.println(contatos);

        // Obter elemento de uma posição do vetor
        System.out.println(contatos.get(2));

        // Verificar se elemento existe no vetor
        Contato busca = new Contato("Bernardo", "50978", "bernardonerd@gmail.com");
        System.out.println(contatos.contains(busca));

        // Adicionar elemento em qualquer posição do vetor
        contatos.add(2, new Contato("Ricardo", "49832", "ricardonildo@gmail.com"));

        // Duplicar o tamanho do vetor
        System.out.println(contatos.size());

        String[] nome2 = {"Matheus", "Samuel", "Leandro", "Henrique", "Nathan", "Victor"};
        String[] telefone2 = {"0427913", "901276", "969201", "0914278", "6489081", "1243456"};
        String[] email2 = {"matheusslaoq21@gmail.com", "samumassademais2020@gmail.com", "leandrobao3212@gmail.com",
                "henriquemaluco@gmail.com", "nathandapesada@gmail.com", "victorcorderosa@gmail.com"};

        for (int i = 0; i < nome2.length; i++) {
            contatos.add(new Contato(nome2[i], telefone2[i], email2[i]));
        }

        System.out.println(contatos.size());

        // Remover elemento do vetor
        contatos.remove(1);

        // Pesquisar por nome
        Contato buscaNome = new Contato("Victor", "", "");
        System.out.println(contatos.contains(buscaNome));

        // Pesquisar por e-mail
        Contato buscaEmail = new Contato("", "", "nathandapesada@gmail.com");
        System.out.println(contatos.contains(buscaEmail));

        // Pesquisar por telefone
        Contato buscaTelefone = new Contato("", "969201", "");
        System.out.println(contatos.contains(buscaTelefone));

    }
}
