package Pratica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestaArrayList2 {
    private static Scanner _scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nomes = {"Marcos", "Juliana", "Roberto", "Claudia", "Tiago"};
        String[] telefones = {"01234567", "07654321", "13579246", "24681357", "98765432"};
        String[] emails = {"marcos.martins@example.com", "juliana.oliveira@example.com", "roberto.santos@example.com", "claudia.martins@example.com", "tiago.silva@example.com"};

        ArrayList<Contato> contatos = new ArrayList<>();

        for (int i = 0; i < nomes.length; i++) {
            contatos.add(new Contato(nomes[i], telefones[i], emails[i]));
        }

        int opc = 0;
        int pos;
        Contato contato;

        do {
            System.out.println("################################");
            System.out.println("Escolha uma opção");
            System.out.println("1. Adicionar elemento ");
            System.out.println("2. Verificar quantidade ");
            System.out.println("3. Imprimir vetor ");
            System.out.println("4. Obter valor de uma posição ");
            System.out.println("5. Verificar se existe elemento ");
            System.out.println("6. Adicionar elemento em uma posição");
            System.out.println("7. Remover elemento ");
            System.out.println("8. Pesquisar por nome ");
            System.out.println("9. Pesquisar por e-mail ");
            System.out.println("10. Pesquisar por telefone ");
            System.out.println("11. Ordernar por nome ");
            System.out.println("12. Ordernar por e-mail ");
            System.out.println("13. Ordernar por telefone ");
            System.out.println("0. Sair ");
            System.out.println("################################\n");

            opc = _scanner.nextInt();
            _scanner.skip("\n");
            
            switch(opc) {
                case 1:
                    contato = ReadContato();
                    contatos.add(contato);
                    System.out.println("Pratica.Contato adicionado: " + contato);
                    break;
                case 2:
                    System.out.println("Quantidade: " + contatos.size());
                    break;
                case 3:
                    System.out.println(contatos);
                    break;
                case 4:
                    pos = ReadPosition();
                    System.out.println("Pratica.Contato na posição " + pos + ": " + contatos.get(pos));
                    break;
                case 5:
                    contato = ReadContato();
                    System.out.println("Contém contato: " + contatos.contains(contato));
                    break;
                case 6:
                    contato = ReadContato();
                    pos = ReadPosition();
                    contatos.add(pos, contato);
                    System.out.println("Pratica.Contato adicionado na posição " + pos + ": " + contato);
                    break;
                case 7:
                    pos = ReadPosition();
                    contatos.remove(pos);
                    System.out.println("Pratica.Contato na posição " + pos + " removido.");
                    break;
                case 8:
                    String pesquisaNome =  Read("nome");
                    System.out.println(contatos
                            .stream()
                            .filter(c -> c.getNome().equals(pesquisaNome))
                            .collect(Collectors.toList())
                    );
                    break;
                case 9:
                    String pesquisaEmail =  Read("e-mail");
                    System.out.println(contatos
                            .stream()
                            .filter(c -> c.getNome().equals(pesquisaEmail))
                            .collect(Collectors.toList())
                    );
                    break;
                case 10:
                    String pesquisaTelefone =  Read("telefone");
                    System.out.println(contatos
                            .stream()
                            .filter(c -> c.getNome().equals(pesquisaTelefone))
                            .collect(Collectors.toList())
                    );
                    break;
                case 11:
                    contatos.sort(Comparator.comparing(Contato::getNome));
                    System.out.println("Contatos ordenados por nome: " + contatos);
                    break;
                case 12:
                    contatos.sort(Comparator.comparing(Contato::getEmail));
                    System.out.println("Contatos ordenados por e-mail: " + contatos);
                    break;
                case 13:
                    contatos.sort(Comparator.comparing(Contato::getTelefone));
                    System.out.println("Contatos ordenados por telefone: " + contatos);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            if (opc != 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        } while (opc != 0);
    }
    
    private static Contato ReadContato() {
        Contato contato = new Contato();
        contato.setNome(Read("nome"));
        contato.setEmail(Read("e-mail"));
        contato.setTelefone(Read("telefone"));
        return contato;
    }

    private static String Read(String field) {
        System.out.print("Digite o " + field + ": ");
        return _scanner.nextLine();
    }

    private static int ReadPosition() {
        System.out.print("Digite a posição: ");
        int pos = _scanner.nextInt();
        _scanner.skip("\n");
        return pos;
    }
}
