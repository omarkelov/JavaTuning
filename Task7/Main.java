import java.util.Map;

public class Main {
    static {
        System.loadLibrary("cpuinfo");
    }

    static native Map<String, String> getCpuInfo();

    public static void main(String[] args) {
        Map<String, String> cpuInfo = getCpuInfo();

        System.out.println("CPU name:      " + cpuInfo.get("name"));
        System.out.println("CPU cores:     " + cpuInfo.get("cores"));
        System.out.println("CPU frequency: " + cpuInfo.get("frequency") + " ~MHz");
    }
}
