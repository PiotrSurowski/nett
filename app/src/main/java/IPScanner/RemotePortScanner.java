package IPScanner;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class RemotePortScanner extends PortScanner{
    private ExecutorService service;
    private List<Integer> openPorts;

    public RemotePortScanner(String address, Integer startPort, Integer endPort) {
        super(address, startPort, endPort);
        this.counter = startPort;
        this.openPorts = new ArrayList<>();
    }

    public List<Integer> getOpenPorts() {
        runTask();
        return openPorts;
    }

    Runnable task = () -> {
        for (currentPort = getCurrentPort(); currentPort <= endPort; currentPort++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(address, currentPort), 1000);
                socket.close();
                openPorts.add(currentPort);
                service.wait();
                sleep(5);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        service.shutdown();
    };

    private void runTask() {
        int counter = startPort;
        service = Executors.newScheduledThreadPool(10);

        while ((counter * 10) <= endPort){
            service.execute(task);
            counter++;
        }
    }
}

