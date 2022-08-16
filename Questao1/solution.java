package Questao1;

class Solution {
    int[] less;
    int[] greater;

    public long goodTriplets(int[] n1, int[] n2) {
        int n = n1.length;
        int[] map = new int[n]; // map do n2 para o vetor
        for (int i = 0; i < n; i++) {
            map[n2[i]] = i;
        }
        int[] index = new int[n]; // vetor representando posições do n1 no n2
        for (int i = 0; i < n; i++) {
            index[i] = map[n1[i]];
        }
        less = new int[n];
        greater = new int[n];
        mergesort(index, 0, index.length);
        long answer = 0L;
        for (int i = 0; i < n; i++) {
            answer += 1L * less[i] * greater[i];
        }
        return answer;
    }

    void mergesort(int[] arr, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int n = arr.length;
        int mid = lo + (hi - lo) / 2;
        mergesort(arr, lo, mid);
        mergesort(arr, mid, hi);
        merge(arr, lo, mid, hi);
    }

    void merge(int[] arr, int lo, int mid, int hi) {
        int n = hi - lo;
        int[] tmp = new int[n];
        int id = 0;
        int i = lo, j = mid;
        while (i < mid && j < hi) {
            if (arr[i] < arr[j]) {
                tmp[id] = arr[i];
                greater[arr[i]] += (hi - j);
                i++;
            } else if (arr[i] > arr[j]) {
                tmp[id] = arr[j];
                less[arr[j]] += (i - lo);
                j++;
            }
            id++;
        }
        while (i < mid) {
            tmp[id] = arr[i];
            i++;
            id++;
        }
        while (j < hi) {
            tmp[id] = arr[j];
            less[arr[j]] += (i - lo);
            j++;
            id++;
        }
        System.arraycopy(tmp, 0, arr, lo, n);
    }
}