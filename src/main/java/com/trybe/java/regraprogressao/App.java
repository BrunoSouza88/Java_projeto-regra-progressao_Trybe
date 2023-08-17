package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Metodo main.
   */
  public class Main {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.println("Digite a quantidade de atividades para cadastrar:");
      int numberOfActivities = input.nextInt();
      input.nextLine();

      String[] activities = new String[numberOfActivities];
      double[] weights = new double[numberOfActivities];
      double[] grades = new double[numberOfActivities];
      double weightSum = 0;

      for (int i = 0; i < numberOfActivities; i++) {
        System.out.printf("Digite o nome da atividade %d:\n", i + 1);
        activities[i] = input.nextLine();

        System.out.printf("Digite o peso da atividade %d:\n", i + 1);
        weights[i] = input.nextDouble();
        weightSum += weights[i];
        input.nextLine();
      }

      if (weightSum != 100) {
        System.out.println("A soma dos pesos deve ser igual a 100!");
      } else {
        for (int i = 0; i < numberOfActivities; i++) {
          System.out.printf("Digite a nota da atividade %s:\n", activities[i]);
          grades[i] = input.nextDouble();
          input.nextLine();
        }

        double finalGrade = 0;
        for (int i = 0; i < numberOfActivities; i++) {
          finalGrade += grades[i] * weights[i] / 100;
        }
        System.out.printf("A nota final do período é: %.1f%%\n", finalGrade);
      }

      input.close();
    }
  }
  };