/**
 * ContoWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public interface ContoWS extends java.rmi.Remote {
    public webservices.ResponseBase deleteConto(int arg0) throws java.rmi.RemoteException;
    public webservices.ResponseSelectAllConto selectAllConto() throws java.rmi.RemoteException;
    public webservices.ResponseBase insertConto(double arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException;
    public webservices.ResponseConto selectIdConto(int arg0) throws java.rmi.RemoteException, webservices.DatatypeConfigurationException, webservices.SQLException, webservices.NamingException;
}
