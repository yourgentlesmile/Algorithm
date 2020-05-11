package offer;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        char[] v = s.toCharArray();
        char[] n = new char[v.length * 3];
        int size = 0;
        for (char c : v) {
            if (c == ' ') {
                n[size++] = '%';
                n[size++] = '2';
                n[size++] = '0';
            } else {
                n[size++] = c;
            }
        }
        return new String(n, 0, size);
    }
}
