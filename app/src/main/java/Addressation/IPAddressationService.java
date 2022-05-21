package Addressation;

import java.util.ArrayList;
import java.util.List;

public class IPAddressationService {

    private final Integer firstOctet;
    private final Integer secondOctet;
    private final Integer thirdOctet;
    private final Integer fourthOctet;
    private final Integer maskFirstOctet;
    private final Integer maskSecondOctet;
    private final Integer maskThirdOctet;
    private final Integer maskFurthOctet;

    private List<Integer> address;
    private List<Integer> mask;
    private List<Integer> networkAddress;
    private List<Integer> broadcastAddress;

    private List<String> binaryAddress;
    private List<String> binaryMask;
    private List<String> binaryNetworkAddress;

    private double hostMax;

    public IPAddressationService(Integer firstOctet
            , Integer secondOctet
            , Integer thirdOctet
            , Integer fourthOctet
            , Integer maskFirstOctet
            , Integer maskSecondOctet
            , Integer maskThirdOctet
            , Integer maskFurthOctet) {

        this.firstOctet = firstOctet;
        this.secondOctet = secondOctet;
        this.thirdOctet = thirdOctet;
        this.fourthOctet = fourthOctet;
        this.maskFirstOctet = maskFirstOctet;
        this.maskSecondOctet = maskSecondOctet;
        this.maskThirdOctet = maskThirdOctet;
        this.maskFurthOctet = maskFurthOctet;

        setAddress();
        setMask();
        setBinaryAddress();
        setBinaryMask();
        setNetworkAddress();
        setBinaryNetworkAddress();
        setBroadcastAddress();
        setHostMax();
    }

    public void setAddress(){
        address = new ArrayList<>();
        this.address.add(firstOctet);
        this.address.add(secondOctet);
        this.address.add(thirdOctet);
        this.address.add(fourthOctet);
    }

    public void setMask(){
        mask = new ArrayList<>();
        this.mask.add(maskFirstOctet);
        this.mask.add(maskSecondOctet);
        this.mask.add(maskThirdOctet);
        this.mask.add(maskFurthOctet);
    }

    public void setBinaryAddress(){
        binaryAddress = new ArrayList<>();

        for (Integer i : address){
            binaryAddress.add(String.format("%8s",Integer.toBinaryString(i)).replaceAll(" ", "0"));
        }
    }

    public void setBinaryNetworkAddress(){
        binaryNetworkAddress = new ArrayList<>();

        for (Integer i : networkAddress){
            binaryNetworkAddress.add(Integer.toBinaryString(i));
        }
    }

    public void setBinaryMask(){
        binaryMask = new ArrayList<>();
        for (Integer i : mask){
            binaryMask.add(String.format("%8s",Integer.toBinaryString(i)).replaceAll(" ", "0"));
        }
    }

    public void setNetworkAddress(){
        networkAddress = new ArrayList<>();
        for (int i = 0; i < mask.size(); i++){
            networkAddress.add(mask.get(i) & address.get(i));
        }
    }

    public void setBroadcastAddress(){
        broadcastAddress = new ArrayList<>();
        List<String> invertedBinaryMask = new ArrayList<>();
        List<Integer> invertedMask = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String s : binaryMask){
            sb.setLength(0);
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i)=='1'){
                    sb.append('0');
                } else{
                    sb.append('1');
                }

            }
            invertedBinaryMask.add(sb.toString());
        }

        for (String s : invertedBinaryMask){
            invertedMask.add(Integer.parseInt(s, 2));
        }

        for (int i = 0; i < invertedMask.size(); i++){
            broadcastAddress.add(invertedMask.get(i) + networkAddress.get(i));
        }
    }

    public void setHostMax() {
        int shortenedMask = 0;
        int amountAddressBits = 0;
        for (String s : binaryMask) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    shortenedMask++;
                }
            }
        }

        for (String t : binaryAddress){
            amountAddressBits += t.length();
        }
        hostMax = Math.pow(2, (amountAddressBits - shortenedMask));
        hostMax -= 2;
    }

    public IPAddressation getInstance(){
        return new IPAddressation(address, mask, networkAddress, broadcastAddress);
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

    public double getHostMax() {
        return hostMax;
    }
}
