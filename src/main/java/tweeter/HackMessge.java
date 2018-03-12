package tweeter;

public class HackMessge {

    static String key = getKey();//"4071321";//"2512208";

    static String getKey() {
        String message = "Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez.";
        int size = 0;
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c))
                size++;
        }
        size %= 7;

        String from = "YourfriendAlice";
        String to =   "AtvthrqgseCnikg";

        StringBuilder key = new StringBuilder();

        int len = from.length();
        for (int i = 0; i < len; i++) {
            int t = to.charAt(i) - from.charAt(i);
            if (t < 0) {
                t += 26;
            }
            key.append(t);
        }
//        System.out.println(key.substring(7 - size%7, 14 - size%7));
        return key.substring(7 - size%7, 14 - size%7);
    }

    static String decrypt(String messge) {
        char[] keys = key.toCharArray();

        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (char c : messge.toCharArray()) {

            if (Character.isLetter(c)) {
                char starWith = c <= 'Z' ? 'A' : 'a';
                c = (char)(c - keys[j] + '0');

                if (c < starWith) {
                    c = (char)(c + 26);
                }
                j = (++j) % keys.length;

            }
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
//        System.out.println(getKey());
//        System.out.println(getKey().length());

//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
        System.out.println(key);
//        System.out.println(decrypt("Li,ailu jw au facntll"));

//        System.out.println(decrypt("-Atvt hrqgse, Cnikg"));
//        key = "8251220";
        System.out.println(decrypt("Otjfvknou kskgnl,K mbxg iurtsvcnb ksgq hoz atv.Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg"));
    }


}
