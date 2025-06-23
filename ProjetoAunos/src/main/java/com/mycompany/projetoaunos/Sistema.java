
package com.mycompany.projetoaunos;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void menu(){
        int opcao;
        
        do{
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Calcular média das notas");
            System.out.println("4 - Exibir a maior nota");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao){
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> calcularMedia();
                case 4 -> maiorNota();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção Invalida!");
            }
        }while (opcao != 0);
                     
    }
    
    private void cadastrarAluno(){
        System.out.print("Nome:");
        String nome = scanner.nextLine();
        System.out.print("Idade:");
        int idade = scanner.nextInt();
        System.out.print("Nota:");
        double nota = scanner.nextDouble();
        scanner.nextLine();
        
        Aluno novo = new Aluno(nome, idade, nota);
        alunos.add(novo);
        
        System.out.println("Aluno cadastrado com sucesso!");
    }
    private void listarAlunos(){
        if(alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado.");
        }else{
            for(Aluno a : alunos){
                a.mostrarInfo();
            }
        }
    }
    private void calcularMedia(){
        if(alunos.isEmpty()){
            System.out.println("Sem alunos para calcular média.");
            return;
        }
        
        double soma = 0;
        for (Aluno a : alunos){
            soma += a.getNota();
        }
        double media = soma / alunos.size();
        System.out.printf("Média geral das notas: %.2f%n", media);
    }
    
}
