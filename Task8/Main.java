import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Context context = Context.newBuilder().allowAllAccess(true).build();
        Source source = Source.newBuilder("llvm", new File("cpuinfo.bc")).build();
        Value getCpuInfoMethod = context.eval(source).getMember("getCpuInfo");

        Map<String, String> cpuInfo = getCpuInfoMethod.execute().as(HashMap.class);

        System.out.println("CPU name:      " + cpuInfo.get("model name"));
        System.out.println("CPU cores:     " + cpuInfo.get("cpu cores"));
        System.out.println("CPU frequency: " + cpuInfo.get("cpu MHz") + " ~MHz");
    }
}
