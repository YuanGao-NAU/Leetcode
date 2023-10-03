package greedy;

public class MinHeap {

    private int[] heapArray;
    private int size;
    private int n;

    MinHeap(int size, int n) {
        this.size = size;
        this.n = n;
        heapArray = new int[size+1];
    }

    public void siftdown(int i) {
        int t;
        boolean flag = false;

        while(i*2 <= n && !flag) {
            if(heapArray[i] > heapArray[i*2]) {
                t = i*2;
            } else {
                t = i;
            }

            if(i*2+1 <= n) {
                if(heapArray[i] > heapArray[i*2+1]) {
                    t = i*2+1;
                }
            }

            if(t != i) {
                swap(t, i);
                i = t;
            } else {
                flag = true;
            }
        }
    }

    public void siftup(int i) {

        if(i == 1) return;

        boolean flag = false;

        while(i != 1 && !flag) {
            if(heapArray[i] < heapArray[i/2]) {
                swap(i, i/2);
            } else {
                flag = true;
            }

            i = i/2;
        }
    }

    public void create() {
        for(int i = n/2; i >= 1; i--) {
            siftdown(i);
        }
    }

    public void addNewElement(int num) {
        this.n = n+1;
        heapArray[this.n] = num;
        siftup(this.n);
    }

    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    public void heapSort() {
        int i = n;
        while(n > 1) {
            swap(1, n);
            n--;
            siftdown(1);
        }
        n = i;
    }


    public static void main(String[] args) {

        int[] nums = {99, 5, 36, 7, 22, 17, 46, 12, 2, 19, 25, 28, 1, 29};
        MinHeap minHeap = new MinHeap(100, 0);
        for(int num : nums) {
            minHeap.addNewElement(num);
        }
        minHeap.heapSort();
        System.out.println();
    }
}
