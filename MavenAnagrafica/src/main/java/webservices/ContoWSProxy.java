package webservices;

public class ContoWSProxy implements webservices.ContoWS {
  private String _endpoint = null;
  private webservices.ContoWS contoWS = null;
  
  public ContoWSProxy() {
    _initContoWSProxy();
  }
  
  public ContoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initContoWSProxy();
  }
  
  private void _initContoWSProxy() {
    try {
      contoWS = (new webservices.ContoWSServiceLocator()).getContoWSPort();
      if (contoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contoWS != null)
      ((javax.xml.rpc.Stub)contoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservices.ContoWS getContoWS() {
    if (contoWS == null)
      _initContoWSProxy();
    return contoWS;
  }
  
  public webservices.ResponseBase deleteConto(int arg0) throws java.rmi.RemoteException{
    if (contoWS == null)
      _initContoWSProxy();
    return contoWS.deleteConto(arg0);
  }
  
  public webservices.ResponseSelectAllConto selectAllConto() throws java.rmi.RemoteException{
    if (contoWS == null)
      _initContoWSProxy();
    return contoWS.selectAllConto();
  }
  
  public webservices.ResponseBase insertConto(double arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException{
    if (contoWS == null)
      _initContoWSProxy();
    return contoWS.insertConto(arg0, arg1, arg2);
  }
  
  public webservices.ResponseConto selectIdConto(int arg0) throws java.rmi.RemoteException, webservices.DatatypeConfigurationException, webservices.SQLException, webservices.NamingException{
    if (contoWS == null)
      _initContoWSProxy();
    return contoWS.selectIdConto(arg0);
  }
  
  
}