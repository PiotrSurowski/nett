package IPScanner;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalPortScanner extends PortScanner{
    private final Address address;
    private final List<String> addressRange;
    private final Map<String, List<Integer>> results;


    public LocalPortScanner(Integer startPort, Integer endPort) throws IOException {
        super(startPort, endPort);
        address = new Address();
        results = new HashMap<>();
        addressRange = new ArrayList<>(getAddressRange());
    }

    private List<String> getAddressRange() {
        return address.getRange();
    }

    private void runTask() throws IOException {
        for (String s : addressRange){
            RemotePortScanner rps = new RemotePortScanner(s, startPort, endPort);

            if(InetAddress.getByName(s).isReachable(500)){
                if (rps.getOpenPorts() != null){
                    results.put(s, rps.getOpenPorts());
                }
            }
            counter++;
        }
    }

    public Map<String, List<Integer>> getInetSocketAddresses() throws InterruptedException, IOException {
        runTask();
        return results;
    }
}
