package Pratica;

import java.util.Scanner;
import java.util.Stack;

public class TestaPilha2 {
    private static Stack<Contato> contatos = new Stack<>();
    private static Scanner _scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opc;
        do {
            System.out.println("################################");
            System.out.println("Escolha uma opção");
            System.out.println("1. Adicionar elemento (Empilhar)");
            System.out.println("2. Verificar tamanho da pilha");
            System.out.println("3. Imprimir elementos da pilha (Desempilhando)");
            System.out.println("4. Topo da pilha");
            System.out.println("5. Verificar se existe elemento");
            System.out.println("6. Pesquisar por nome");
            System.out.println("7. Pesquisar por e-mail");
            System.out.println("8. Pesquisar por telefone");
            System.out.println("9. Excluir elemento (Desempilhar)");
            System.out.println("0. Sair");
            System.out.println("################################\n");

            opc = _scanner.nextInt();
            _scanner.skip("\n");

            switch (opc) {
                case 1: // Adicionar elemento - Empilhar (no topo da pilha)
                    Contato contato = ReadContato();
                    contatos.push(contato);
                    System.out.println("Contato adicionado: " + contato);
                    break;
                case 2: // Verificar o tamanho da pilha
                    System.out.println("Tamanho da pilha: " + contatos.size());
                    break;
                case 3: // Imprimir elementos da pilha (desempilhando)
                    if (contatos.isEmpty()) {
                        System.out.println("A pilha está vazia.");
                    } else {
                        System.out.println("Desempilhando elementos:");
                        while (!contatos.isEmpty()) {
                            System.out.println(contatos.pop());
                        }
                    }
                    break;
                case 4: // Topo da pilha (exibir o elemento no topo da pilha)
                    if (!contatos.isEmpty()) {
                        System.out.println("Topo da pilha: " + contatos.peek());
                    } else {
                        System.out.println("A pilha está vazia.");
                    }
                    break;
                case 5: // Verificar se elemento existe na pilha e retornar a posição
                    contato = ReadContato();
                    int pos = contatos.search(contato);
                    if (pos != -1) {
                        System.out.println("Contato encontrado na posição: " + pos);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 6: // Pesquisar por nome
                    String pesquisaNome = Read("nome");
                    contatos.stream()
                            .filter(c -> c.getNome().equalsIgnoreCase(pesquisaNome))
                            .forEach(System.out::println);
                    break;
                case 7: // Pesquisar por e-mail
                    String pesquisaEmail = Read("e-mail");
                    contatos.stream()
                            .filter(c -> c.getEmail().equalsIgnoreCase(pesquisaEmail))
                            .forEach(System.out::println);
                    break;
                case 8: // Pesquisar por telefone
                    String pesquisaTelefone = Read("telefone");
                    contatos.stream()
                            .filter(c -> c.getTelefone().equalsIgnoreCase(pesquisaTelefone))
                            .forEach(System.out::println);
                    break;
                case 9: // Excluir elemento - Desempilhar
                    if (!contatos.isEmpty()) {
                        Contato removed = contatos.pop();
                        System.out.println("Contato removido: " + removed);
                    } else {
                        System.out.println("A pilha está vazia.");
                    }
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
        System.out.print("Digite o nome: ");
        String nome = _scanner.nextLine();
        System.out.print("Digite o e-mail: ");
        String email = _scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = _scanner.nextLine();
        return new Contato(nome, email, telefone);
    }

    private static String Read(String campo) {
        System.out.print("Digite o " + campo + ": ");
        return _scanner.nextLine();
    }
}
