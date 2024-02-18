public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st = 1;
        if (isBadVersion(st)) return 1;

        while (n > st) {
            if (n - st == 1) break;
            if (isBadVersion((n - st) / 2 + st)) n = (n - st) / 2 + st;
            else st = (n - st) / 2 + st;
        }
        System.out.println(n);
        return n;
    }
}