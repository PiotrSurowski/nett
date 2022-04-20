package IPScanner;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Address {
    private final String localAddress;

    public Address() throws UnknownHostException {
        this.localAddress = InetAddress.getLocalHost().getHostAddress();
    }

    protected String splitAddress(){
        String[] temp =  localAddress.split("\\.");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < (temp.length - 1); i++) {
            sb.append(temp[i]).append(".");
        }

        return sb.toString();
    }

    public List<String> getRange(){
        List<String> resultList = new ArrayList<>();
        int i = 0;
        String address = splitAddress();
        while (i < 254){
            resultList.add(address
                    .concat(generateAddress(i)
                            .toString()));
            i++;
        }
        return resultList;
    }

    protected Integer generateAddress(Integer i){
        return i + 1;
    }

    public String getLocalAddress() {
        return localAddress;
    }
}