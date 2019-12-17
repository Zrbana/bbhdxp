package Simple.daily.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 美团点评上有很多餐馆优惠券，用户可以在美团点评App上购买。每张优惠券有一个唯一的正整数编号。当用户在相应餐馆就餐时，可以在餐馆使用优惠券进行消费。优惠券的购买和使用按照时间顺序逐行记录在日志文件中，运营人员会定期抽查日志文件看业务是否正确。业务正确的定义为：一个优惠券必须先被购买，然后才能被使用。
 *
 * 某次抽查时，发现有硬盘故障，历史日志中有部分行损坏，这些行的存在是已知的，但是行的内容读不出来。假设损坏的行可以是任意的优惠券的购买或者使用。
 *
 * 现在问这次抽查中业务是否正确。若有错，输出最早出现错误的那一行，即求出最大s，使得记录1到s-1满足要求；若没有错误，输出-1。
 */
    //Coupon problem
public class Coupon {
        static int n;
        static boolean[] cards;
        static int[] pos;
        static List<Integer> uCard;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while ((str = br.readLine()) != null) {
                int num = Integer.parseInt(str);
                int m = -1;
                cards = new boolean[100001];
                pos = new int[100001];
                uCard = new ArrayList<Integer>();
                for (int i = 1; i <= num; i++) {
                    str = br.readLine();
                    if (m != -1) {
                        continue;
                    }
                    String[] strs = str.split(" ");
                    String type = strs[0];
                    if ("?".equals(type) || "？".equals(type)) {
                        uCard.add(i);
                    } else {
                        int x = Integer.parseInt(strs[1]);
                        if ("I".equals(type) && cards[x] || !"I".equals(type) && !cards[x]) {
                            if (!hasGig(pos[x])) {
                                m = i;
                            }
                        } else {
                            cards[x] = !cards[x];
                        }
                        pos[x] = i;
                    }
                }
                System.out.println(m);
            }
        }

        public static boolean hasGig(int x) {
            if (uCard.size() == 0) {
                return false;
            }
            int lower = 0;
            int higher = uCard.size() - 1;
            while (lower < higher) {
                int mid = (lower + higher) / 2;
                if (uCard.get(mid) < x) {
                    lower = mid + 1;
                } else {
                    higher = mid;
                }
            }
            if (uCard.get(lower) > x) {
                uCard.remove(lower);
                return true;
            } else {
                return false;
            }
        }

    }


