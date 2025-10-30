class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if(person1[0]==person2[0]) {
                return person1[1] - person2[1];
            }
            else {
                return person2[0] - person1[0];
            }
        });

        List<int[]> resultQueue = new ArrayList<>(people.length);

        for(int[] person:people) {
            int insertPosition = person[1];
            resultQueue.add(insertPosition,person);
        }

        return resultQueue.toArray(new int[resultQueue.size()][]);
    }
}