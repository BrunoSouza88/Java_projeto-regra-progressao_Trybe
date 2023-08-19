package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Main.
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar:");
    int quantidadeAtividadesCadastradas = sc.nextInt();
    sc.nextLine();

    String[] nomesAtividades = new String[quantidadeAtividadesCadastradas];
    int[] pesosAtividade = new int[quantidadeAtividadesCadastradas];
    int[] notasObtidas = new int[quantidadeAtividadesCadastradas];
    int somaPesos = 0;

    for (int i = 0; i < quantidadeAtividadesCadastradas; i++) {
      System.out.printf("Digite o nome da atividade %d:\n", i + 1);
      nomesAtividades[i] = sc.nextLine();

      System.out.printf("Digite o peso da atividade %d:\n", i + 1);
      pesosAtividade[i] = getValidatedWeight(sc);

      somaPesos += pesosAtividade[i];

      System.out.printf("Digite a nota obtida para %s:\n", nomesAtividades[i]);
      notasObtidas[i] = getValidatedGrade(sc);

      sc.nextLine();
    }

    if (somaPesos != 100) {
      System.out.println("Erro: A soma dos pesos não é igual a 100.");
    }

    double mediaPonderada = calculateWeightedAverage(
            quantidadeAtividadesCadastradas, pesosAtividade, notasObtidas);

    String resultadoFinal = mediaPonderada >= 85
            ? "Parabéns! Você alcançou " + mediaPonderada
            + "%! E temos o prazer de informar "
            + "que você obteve aprovação!"
            : "Lamentamos informar que, com base na sua pontuação alcançada " + "neste período, "
            + mediaPonderada + "%, você não atingiu a pontuação mínima "
            + "necessária para sua aprovação.";
    System.out.println(resultadoFinal);
  }

  /**
   * Validates and returns a valid weight for an activity.
   *
   * @param sc The Scanner instance for input.
   * @return The validated weight.
   */
  private static int getValidatedWeight(Scanner sc) {
    int weight = sc.nextInt();
    while (weight < 1 || weight > 100) {
      System.out.println("Erro: Peso inválido! O peso deve ser entre 1 e 100.");
      System.out.println("Digite novamente o peso:");
      weight = sc.nextInt();
    }
    return weight;
  }

  /**
   * Validates and returns a valid grade for an activity.
   *
   * @param sc The Scanner instance for input.
   * @return The validated grade.
   */
  private static int getValidatedGrade(Scanner sc) {
    int grade = sc.nextInt();
    while (grade < 0 || grade > 100) {
      System.out.println("Erro: Nota inválida! A nota deve ser entre 0 e 100.");
      System.out.println("Digite novamente a nota:");
      grade = sc.nextInt();
    }
    return grade;
  }

  /**
   * Calculates the weighted average of grades for all activities.
   *
   * @param quantidadeAtividades The number of activities.
   * @param pesosAtividade       The weights of activities.
   * @param notasObtidas         The obtained grades of activities.
   * @return The calculated weighted average.
   */
  private static double calculateWeightedAverage(
          int quantidadeAtividades, int[] pesosAtividade, int[] notasObtidas) {
    double mediaPonderada = 0;
    for (int i = 0; i < quantidadeAtividades; i++) {
      mediaPonderada += ((double) notasObtidas[i] * pesosAtividade[i]) / 100;
    }
    return mediaPonderada;
  }
}
