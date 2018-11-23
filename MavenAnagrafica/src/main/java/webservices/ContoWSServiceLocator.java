/**
 * ContoWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public class ContoWSServiceLocator extends org.apache.axis.client.Service implements webservices.ContoWSService {

    public ContoWSServiceLocator() {
    }


    public ContoWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContoWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContoWSPort
    private java.lang.String ContoWSPort_address = "http://localhost:8080/contocorrente/ContoWS";

    public java.lang.String getContoWSPortAddress() {
        return ContoWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContoWSPortWSDDServiceName = "ContoWSPort";

    public java.lang.String getContoWSPortWSDDServiceName() {
        return ContoWSPortWSDDServiceName;
    }

    public void setContoWSPortWSDDServiceName(java.lang.String name) {
        ContoWSPortWSDDServiceName = name;
    }

    public webservices.ContoWS getContoWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContoWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContoWSPort(endpoint);
    }

    public webservices.ContoWS getContoWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservices.ContoWSServiceSoapBindingStub _stub = new webservices.ContoWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getContoWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContoWSPortEndpointAddress(java.lang.String address) {
        ContoWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservices.ContoWS.class.isAssignableFrom(serviceEndpointInterface)) {
                webservices.ContoWSServiceSoapBindingStub _stub = new webservices.ContoWSServiceSoapBindingStub(new java.net.URL(ContoWSPort_address), this);
                _stub.setPortName(getContoWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ContoWSPort".equals(inputPortName)) {
            return getContoWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices/", "ContoWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices/", "ContoWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContoWSPort".equals(portName)) {
            setContoWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
