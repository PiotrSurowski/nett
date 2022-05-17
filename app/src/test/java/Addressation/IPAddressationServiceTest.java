package Addressation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IPAddressationServiceTest {

    IPAddressationService ipAddressation = new IPAddressationService(192, 168, 50, 0
    , 255, 255, 255, 0);
    @Test
    void getInstance() {
        assertNotNull(ipAddressation.getInstance());
    }
}