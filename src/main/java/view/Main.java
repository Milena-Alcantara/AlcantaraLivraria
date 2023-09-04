package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdministratorView administratorView = new AdministratorView();
        UserView userView = new UserView();
        int escolha;
        do {
            System.out.println("SEJA BEM VINDO A ALCANTARA LIVRARIA!");
            System.out.println("Você é: 1-Administrador | 2-Visitante | 0-Sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    administratorView.logInAdmin();
                    break;
                case 2:
                    userView.menuUser();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        } while (escolha != 0);
    }
}

