package writtenexamination.huawei;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Union union = new Union(m);
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            union.connect(start, end);
        }
        System.out.println(union.getNum());
    }
}
class Union{
    int num;

    int parent[];

    public Union(int num) {
        this.num = num;
        parent = new int[num];
        for (int i = 0; i < num; i++){
            parent[i] = i;
        }
    }
    public int find(int x){
        while (parent[x] != x){
            x = parent[x];
        }
        return x;
    }


    public void connect(int p, int q){
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ){
            return;
        }
        parent[parentP] = parentQ;
        num--;
    }
    public int getNum(){
        return num;
    }

}
