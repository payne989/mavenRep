package webservices;

public class MovimentoWSProxy implements webservices.MovimentoWS {
  private String _endpoint = null;
  private webservices.MovimentoWS movimentoWS = null;
  
  public MovimentoWSProxy() {
    _initMovimentoWSProxy();
  }
  
  public MovimentoWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initMovimentoWSProxy();
  }
  
  private void _initMovimentoWSProxy() {
    try {
      movimentoWS = (new webservices.MovimentoWSServiceLocator()).getMovimentoWSPort();
      if (movimentoWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)movimentoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)movimentoWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (movimentoWS != null)
      ((javax.xml.rpc.Stub)movimentoWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservices.MovimentoWS getMovimentoWS() {
    if (movimentoWS == null)
      _initMovimentoWSProxy();
    return movimentoWS;
  }
  
  public webservices.ResponseBase createMovimento(int arg0, int arg1, double arg2, java.lang.String arg3) throws java.rmi.RemoteException{
    if (movimentoWS == null)
      _initMovimentoWSProxy();
    return movimentoWS.createMovimento(arg0, arg1, arg2, arg3);
  }
  
  public webservices.ResponseSelectMovimento selectMovimento(int arg0) throws java.rmi.RemoteException{
    if (movimentoWS == null)
      _initMovimentoWSProxy();
    return movimentoWS.selectMovimento(arg0);
  }
  
  
}