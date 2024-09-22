import java.util.Stack;

public class TestaPilha {

    //Implementar TestaPilha.java usando a classe Stack do Java para:
    //Adicionar elemento - Empilhar (no topo da pilha)
    //Verificar o tamanho da pilha
    //Imprimir elementos da pilha (desempilhando)
    //Topo da pilha (exibir o elemento no topo da pilha)
    //Verificar se elemento existe na pilha
    //Excluir elemento - Desempilhar

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push("Marcos");
        stack.push("Henrique");
        stack.push("Rodolfo");
        System.out.println("Tamanho da pilha: " + stack.size());
        System.out.println("Elementos da pilha:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Tamanho da pilha: " + stack.size());
        stack.push("Marcos");
        stack.push("Henrique");
        stack.push("Rodolfo");
        System.out.println("Topo da pilha: " + stack.peek());
        System.out.println("Existe 'Marcos' na pilha? " + stack.contains("Marcos"));
        stack.pop();
        System.out.println("Tamanho da pilha: " + stack.size());
    }
}
