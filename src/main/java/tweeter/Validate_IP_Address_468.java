package tweeter;

public class Validate_IP_Address_468 {

    public String validIPAddress(String IP) {
        if (IP == null)
            return "Neither";
        else if (IP.indexOf('.') == -1)
            return validateIP6(IP);
        else
            return validateIP4(IP);
    }

    String validateIP6(String IP) {
        if (!IP.matches("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}")) {
            return "Neither";
        }
        return "IPv6";
    }

    String validateIP4(String IP) {
        if (!IP.matches("(([0]|([1-9][0-9]{0,2}))\\.){3}([0]|([1-9][0-9]{0,2}))")) {
            return "Neither";
        }
        for (String p : IP.split("\\.")) {
            if (Integer.parseInt(p) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public static void main(String[] args) {
        Validate_IP_Address_468 v = new Validate_IP_Address_468();
        System.out.println(v.validateIP4("172.16.256.1"));
        System.out.println(v.validateIP4("172.16.255.1"));
        System.out.println(v.validateIP4("192.0.0.1"));
//        System.out.println(v.validateIP6("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
