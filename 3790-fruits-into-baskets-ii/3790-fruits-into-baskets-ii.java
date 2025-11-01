class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int NumberOfFruits = fruits.length;
        int NumberOfBaskets = fruits.length;

        boolean[] BasketsUsed = new boolean[NumberOfBaskets];

        int UnplacedFruits = NumberOfFruits;

        for ( int FruitSize : fruits ) {
            for ( int BasketIndex = 0; BasketIndex < NumberOfBaskets; BasketIndex ++ ) {
                if ( baskets[BasketIndex] >= FruitSize && !BasketsUsed[BasketIndex] ) {
                    BasketsUsed[BasketIndex] = true;
                    UnplacedFruits--;
                    break;
                }
            }
        }

        return UnplacedFruits;

    }
}