package org.example;

import java.util.Stack;

public class DailyTemperature {

  public int[] dailyTemperatures(int[] temperatures) {
    int[] answer = new int[temperatures.length];
    Stack<Integer> waitingDays = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      int currentTemp = temperatures[i];

      while (!waitingDays.empty() && temperatures[waitingDays.peek()] < currentTemp) {
        int waitingDay = waitingDays.pop();
        answer[waitingDay] = i - waitingDay;
      }
      waitingDays.push(i);
    }
    return answer;
  }

  public int[] dailyTemperaturesWithStack(int[] temperatures) {
    int[] answer = new int[temperatures.length];
    Stack<Integer> waitingDays = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      int currentTemp = temperatures[i];

      while (!waitingDays.isEmpty() && temperatures[waitingDays.peek()] < currentTemp) {
        int waitingDay = waitingDays.pop();
        answer[waitingDay] = i - waitingDay;
      }

      waitingDays.push(i);
    }

    return answer;
  }
}
