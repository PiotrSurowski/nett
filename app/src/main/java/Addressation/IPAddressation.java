package Addressation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IPAddressation {
    private List<Integer> address;
    private List<Integer> mask;
    private List<Integer> networkAddress;
    private List<Integer> broadcastAddress;
}
