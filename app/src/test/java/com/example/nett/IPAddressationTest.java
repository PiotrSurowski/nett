package com.example.nett;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class IPAddressationTest {

    IPAddressation ip;
    IPAddressationTest(){
        ip = new IPAddressation(192, 168,1,145
                ,255,255,255,128);
    }

    @Test
    void getAddress() {
        Assert.assertNotNull(ip.getAddress());
        assertEquals(192, ip.getAddress().get(0));
    }

    @Test
    void getMask() {
        Assert.assertNotNull(ip.getMask());
        assertEquals(255, ip.getMask().get(0));
    }

    @Test
    void getNetworkAddress() {
        Assert.assertNotNull(ip.getNetworkAddress());
        assertEquals(192, ip.getNetworkAddress().get(0));
        assertEquals(128, ip.getNetworkAddress().get(3));
    }

    @Test
    void getBroadcastAddress() {
        Assert.assertNotNull(ip.getBroadcastAddress());
    }

    @Test
    void getHostMax() {
        Assert.assertNotNull(ip.getHostMax());
        assertEquals(126, ip.getHostMax());
    }
}