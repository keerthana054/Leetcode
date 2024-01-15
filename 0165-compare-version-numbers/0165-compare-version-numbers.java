class Solution {
    public int compareVersion(String version1, String version2) {
    int result = 0, dot1 = 0, dot2 = 0, v1, v2;
    
    while (result == 0 && (dot1 >= 0 || dot2 >= 0)) {
        dot1 = version1.indexOf('.');
        dot2 = version2.indexOf('.');
        if (dot1 < 0) {
            v1 = Integer.parseInt(version1);
            if (v1 != 0) version1 = "0";
        } else {
            v1 = Integer.parseInt(version1.substring(0, dot1));
            version1 = version1.substring(dot1 + 1);
        }
        if (dot2 < 0) {
            v2 = Integer.parseInt(version2);
            if (v2 != 0) version2 = "0";
        } else {
            v2 = Integer.parseInt(version2.substring(0, dot2));
            version2 = version2.substring(dot2 + 1);
        }
        result = compareNumber(v1, v2);
    }
    
    return result;
}

private int compareNumber(int v1, int v2) {
    if (v1 == v2) {
        return 0;
    } else {
        return v1 < v2 ? -1 : 1;
    }
}
}