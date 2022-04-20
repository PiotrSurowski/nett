package IPScanner;

public abstract class PortScanner {
    String address;
    Integer startPort;
    Integer endPort;
    Integer currentPort;
    int counter;

    public PortScanner(String address, Integer startPort, Integer endPort) {
        this.address = address;
        this.startPort = startPort;
        this.endPort = endPort;
        this.counter = startPort;
    }

    public PortScanner(Integer startPort, Integer endPort) {
        this.startPort = startPort;
        this.endPort = endPort;
        this.counter = startPort;
    }

    public Integer getCurrentPort() {
        if (counter <= endPort) {
            counter++;
        }
        return counter;
    }
}
