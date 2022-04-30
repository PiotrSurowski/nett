package Addressation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public class IPAddressation {
    @NonNull
    private List<Integer> address;
    @NonNull
    private List<Integer> mask;
    @NonNull
    private List<Integer> networkAddress;
    @NonNull
    private List<Integer> broadcastAddress;

    public IPAddressation(List<Integer> address, List<Integer> mask, List<Integer> networkAddress, List<Integer> broadcastAddress) {
    }

    public List<Integer> getAddress() {
        return address;
    }

    public List<Integer> getMask() {
        return mask;
    }

    public List<Integer> getNetworkAddress() {
        return networkAddress;
    }

    public List<Integer> getBroadcastAddress() {
        return broadcastAddress;
    }
}
