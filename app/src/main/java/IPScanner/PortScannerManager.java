package IPScanner;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PortScannerManager extends PortScanner{
    private final Address address;
    private final List<String> addressRange;
    private final Map<String, List<Integer>> results;


    public PortScannerManager(Integer startPort, Integer endPort) throws UnknownHostException {
        super(startPort, endPort);
        address = new Address();
        results = new HashMap<>();
        addressRange = new ArrayList<>(getAddressRange());
    }

    private List<String> getAddressRange() {
        return address.getRange();
    }

    private void runTask() throws InterruptedException {
        for (String s : addressRange){
            RemotePortScanner rps = new RemotePortScanner(s, startPort, endPort);
            if (rps.getOpenPorts() != null){
                results.put(s, rps.getOpenPorts());
            }
        }
    }

    public Map<String, List<Integer>> getInetSocketAddresses() throws InterruptedException {
        runTask();
        return results;
    }
}
