package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class ExcludedSoapTests extends TestBase {

    private int id = 1;

    @Test
    public void testExcludeSoap() throws RemoteException, ServiceException, MalformedURLException {
        skipIfNotFixed(id);
        System.out.println("test");
    }
}
