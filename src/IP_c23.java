public class IP_c23 {
    public static int IP_type(String ip) {
        int type = 0;
        boolean legal = true;
        boolean pri = false;

        // 分割 IP 地址
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return -1;  // IP 地址格式不正确


        }

        // 检查每个部分是否为合法的数字，且范围在 0 到 255 之间
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255 || part.length() > 1 && part.startsWith("0")) {
                    legal = false;  // IP 地址部分非法
                    break;
                }
            } catch (NumberFormatException e) {
                legal = false;  // IP 地址格式不正确
                break;
            }
        }

        // 如果 IP 地址不合法，返回 -1
        if (!legal) {
            return -1;
        }

        // 获取第一个数字部分并判断 IP 地址的类型
        int first = Integer.parseInt(parts[0]);

        if (first >= 1 && first <= 127) {
            type = 0;  // A 类
        } else if (first >= 128 && first <= 191) {
            type = 1;  // B 类
        } else if (first >= 192 && first <= 223) {
            type = 2;  // C 类
        } else if (first >= 224 && first <= 239) {
            type = 3;  // D 类
        } else if (first >= 240 && first <= 255) {
            type = 4;  // E 类
        } else {
            return -1;  // 无效的 IP 地址
        }

        // 判断是否是私有 IP 地址
        if ((first == 10) ||
                (first == 172 && Integer.parseInt(parts[1]) >= 16 && Integer.parseInt(parts[1]) <= 31) ||
                (first == 192 && Integer.parseInt(parts[1]) == 168)) {
            pri = true;
        }

        // 如果是私有 IP 地址，返回值加 10
        if (pri) {
            type = type + 10;
        }

        return type;
    }
}

