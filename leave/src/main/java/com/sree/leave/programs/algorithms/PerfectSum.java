package com.sree.leave.programs.algorithms;

public class PerfectSum {

    public static void main(final String args[]) {
        int[] arr = { 4, 7, 8, 2, 3 };
        int sum = 12;
        int output = perfectSum(arr, sum);
        System.out.println(output);
    }

    private static int perfectSum(final int[] arr, final int sum) {
        int output = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    output++;
                }
            }
            for (int k = 1; k < arr.length - 2; k++) {
                if (arr[i] + arr[k] + arr[k + 1] == sum) {
                    output++;
                }
            }
            for (int n = 1; n < arr.length - 3; n++) {
                if (arr[i] + arr[n] + arr[n + 1] + arr[n + 2] == sum) {
                    output++;
                }
            }
        }
        return output;
    }
}
