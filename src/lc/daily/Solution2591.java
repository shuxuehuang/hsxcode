package lc.daily;

public class Solution2591 {
    public int distMoney(int money, int children) {
        if (money < children){
            return -1;
        }
        for (int i = children; i >= 0; i--){
            int leftMoney = money - 8 * i;
            int leftChild = children - i;
            if (8 * i > money || (leftChild == 0 && leftMoney > 0)
                    || (leftMoney < leftChild) || (leftMoney == 4 && leftChild == 1)) continue;
            return i;
        }
        return -1;
    }
}
