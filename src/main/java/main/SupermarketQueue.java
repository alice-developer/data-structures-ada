package main;

import dataStructures.Queue;

import java.util.Scanner;

public class SupermarketQueue {
    public static void main(String[] args) {
        Queue<String> clientNames = new Queue<>();
        Queue<Float> clientTotals = new Queue<>();

        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.println("=--------= Super Mercado =--------=");
            System.out.println("= - 1: Adicionar cliente à fila   =");
            System.out.println("= - 2: Exibir cliente atual       =");
            System.out.println("= - 3: Próximo da fila            =");
            System.out.println("= - 4: Exibir fila de clientes    =");
            System.out.println("= - 5: Fechar caixa               =");
            System.out.println("=--------= ------------- =--------=");
            System.out.print("\n> ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    String name = "";
                    float total = 0;

                    System.out.print("[Nome do cliente]: ");
                    name = scanner.next();
                    System.out.print("[Valor total à pagar]: ");
                    total = scanner.nextFloat();

                    clientNames.enqueue(name);
                    clientTotals.enqueue(total);

                    System.out.println("[!] Cliente adicionado à fila com sucesso.\n\n");
                    break;

                case 2:
                    if (clientNames.getLength() == 0) {
                        System.out.println("[!] A fila se encontra vazia.");
                        break;
                    }

                    System.out.printf("#================#\nNome: %s\nTotal: R$%f\n#================#\n\n", clientNames.getFirst().getValue(), clientTotals.getFirst().getValue());
                    break;

                case 3:
                    if (clientNames.getLength() == 0) {
                        System.out.println("[!] A fila se encontra vazia.");
                        break;
                    }

                    clientNames.dequeue();
                    clientTotals.dequeue();

                    if (clientNames.getLength() > 0) {
                        System.out.printf("[!] Usuário atendido com sucesso. Próximo da fila: %s - R$%f\n", clientNames.getFirst().getValue(), clientTotals.getFirst().getValue());
                    } else {
                        System.out.println("[!] Usuário atendido com sucesso, a fila se encontra vazia.");
                    }
                    break;

                case 4:
                    var tempClientName = clientNames.getFirst();
                    var tempClientTotal = clientTotals.getFirst();
                    int count = 1;

                    System.out.println("#==================================#");

                    while(tempClientName != null) {
                        System.out.printf("%dº: %s - R$%f", count, tempClientName.getValue(), tempClientTotal.getValue());

                        tempClientName = tempClientName.getNext();
                        tempClientTotal = tempClientTotal.getNext();
                        count++;
                    }

                    System.out.println("\n#==================================#\n\n");
                    break;

                case 5:
                    System.out.println("[!] Caixa fechado. Até a próxima!");
                    break;

                default:
                    System.out.println("[!] Opção inválida.");
                    break;
            }
        } while (option != 5);
    }
}
