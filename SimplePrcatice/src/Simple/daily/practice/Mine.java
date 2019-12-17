package Simple.daily.practice;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 扫雷规则：
 *
 * n 个地雷排成一排，必须从 1 到 n 依次扫过。扫一个雷需要花费 1s 的时间，如果成功排除当前雷，
 * 则可以排除下一个雷；否则的话地雷就会引爆，游戏失败，还需要从头开始重新扫雷。扫完第 n 个雷后才会胜利，游戏结束。
 *
 *
 */
public class Mine {
    public static final int mod=1000000007;

    public static long quickPow(long x,long y) {
        long res=1;

        while(y>0) {
            if((y&1)==1)
                res=res*x%mod;
            x=x*x%mod;
            y>>=1;
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        InputReader sc=new InputReader(System.in);
        PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n=sc.nextInt();
        long ans=0;

        for(int i=1;i<=n;i++) {
            long a=sc.nextLong();
            long b=sc.nextLong();
            ans=(1+ans)*b%mod*quickPow(a,mod-2)%mod;                 //ans0=((1+1/p1)*(1/p2))*(1/p3)...
        }

        System.out.println(ans);
    }
}

class InputReader {
    private InputStreamReader reader;
    private char[] buf;
    private int len, now;

    public InputReader(InputStream stream) {
        reader = new InputStreamReader(stream);
        buf = new char[1024];
        len = 0;
        now = 0;
    }

    public String next() throws IOException {
        if (!hasNext()) throw new NullPointerException();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(buf[now])) {
            sb.append(buf[now]);
            if (!move()) break;
        }
        return sb.toString();
    }

    public int nextInt() throws IOException {
        if (!hasNext()) throw new NullPointerException();
        boolean x = false;
        if (buf[now] == '-') {
            x = true;
            if (!move()) throw new NumberFormatException();
        }
        int ans = 0;
        while (!isSpaceChar(buf[now])) {
            if (isNum(buf[now])) ans = ans * 10 + buf[now] - '0';
            else throw new NumberFormatException();
            if (!move()) break;
        }
        return (x ? -1 : 1) * ans;
    }

    public String nextLine() throws IOException {
        if (!hasNextLine()) throw new NullPointerException();
        StringBuilder sb = new StringBuilder();
        while (buf[now] != '\n') {
            sb.append(buf[now]);
            if (!move()) return sb.toString();
        }
        now++;
        return sb.toString();
    }

    public long nextLong() throws IOException {
        if (!hasNext()) throw new NullPointerException();
        boolean x = false;
        if (buf[now] == '-') {
            x = true;
            if (!move()) throw new NumberFormatException();
        }
        long ans = 0;
        while (!isSpaceChar(buf[now])) {
            if (isNum(buf[now])) ans = ans * 10 + buf[now] - '0';
            else throw new NumberFormatException();
            if (!move()) break;
        }
        return (x ? -1 : 1) * ans;
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public int nextHexInt() throws IOException {
        if (!hasNext()) throw new NullPointerException();
        boolean x = false;
        if (buf[now] == '-') {
            x = true;
            if (!move()) throw new NumberFormatException();
        }
        int ans = 0;
        while (!isSpaceChar(buf[now])) {
            if (isHex(buf[now])) ans = ans * 16 + toHex(buf[now]);
            else throw new NumberFormatException();
            if (!move()) break;
        }
        return (x ? -1 : 1) * ans;
    }

    public char nextChar() throws IOException {
        if (!hasNext()) throw new NullPointerException();
        char tmp = buf[now];
        move();
        return tmp;
    }
    public int next(char[] s) throws IOException {
        if (!hasNext()) throw new NullPointerException();
        int len=0;
        while (!isSpaceChar(buf[now])&&len<s.length) {
            s[len++]=buf[now];
            if (!move()) break;
        }
        return len;
    }
    public boolean hasNext() throws IOException {
        return skip();
    }

    public boolean hasNextLine() throws IOException {
        return now < len || refill();
    }

    private boolean move() throws IOException {
        now++;
        return hasNextLine();
    }

    private boolean skip() throws IOException {
        if (!hasNextLine()) return false;
        while (isSpaceChar(buf[now])) {
            if (!move()) return false;
        }
        return true;
    }

    private boolean isSpaceChar(char c) {
        return !(c >= 33 && c <= 126);
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isHex(char c) {
        return c >= '0' && c <= '9' || c >= 'A' && c <= 'F';
    }

    private int toHex(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        else return c - 'A' + 10;
    }

    private boolean refill() throws IOException {
        len = reader.read(buf);
        now = 0;
        return len > 0;
    }
}
