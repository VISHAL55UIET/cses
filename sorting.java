import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class sorting{
      public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] tops = new int[n];
        int size = 0;

        for (int i = 0; i < n; i++) {
            int cube = fs.nextInt();

            int l = 0, r = size;
            while (l < r) {
                int mid = (l + r) / 2;
                if (tops[mid] > cube) r = mid;
                else l = mid + 1;
            }

            tops[l] = cube;
            if (l == size) size++;
        }

        System.out.println(size);
    }

    // 🚀 Fast I/O
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
