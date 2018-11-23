/**
 * MovimentoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public interface MovimentoWS extends java.rmi.Remote {
    public webservices.ResponseBase createMovimento(int arg0, int arg1, double arg2, java.lang.String arg3) throws java.rmi.RemoteException;
    public webservices.ResponseSelectMovimento selectMovimento(int arg0) throws java.rmi.RemoteException;
}
