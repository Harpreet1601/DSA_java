public class r_move0ToEnd {
    public static void practice(int arr[]){
      int idx = 0;

      for(int i=0; i<arr.length; i++){
        if(arr[i] != 0){
            arr[idx] = arr[i];
            idx++;
        }
      }

      while(idx < arr.length){
        arr[idx] = 0;
        idx++;
      }

    }

     public static void main(String[] args) {
        int arr[] = {0, 1, 0, 3, 12};

       practice(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
