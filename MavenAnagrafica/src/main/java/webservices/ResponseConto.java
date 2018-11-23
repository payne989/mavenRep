/**
 * ResponseConto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public class ResponseConto  extends webservices.ResponseBase  implements java.io.Serializable {
    private webservices.Conto co;

    public ResponseConto() {
    }

    public ResponseConto(
           int errorCode,
           java.lang.String errorDesc,
           java.lang.String result,
           webservices.Conto co) {
        super(
            errorCode,
            errorDesc,
            result);
        this.co = co;
    }


    /**
     * Gets the co value for this ResponseConto.
     * 
     * @return co
     */
    public webservices.Conto getCo() {
        return co;
    }


    /**
     * Sets the co value for this ResponseConto.
     * 
     * @param co
     */
    public void setCo(webservices.Conto co) {
        this.co = co;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseConto)) return false;
        ResponseConto other = (ResponseConto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.co==null && other.getCo()==null) || 
             (this.co!=null &&
              this.co.equals(other.getCo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getCo() != null) {
            _hashCode += getCo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseConto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices/", "responseConto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("co");
        elemField.setXmlName(new javax.xml.namespace.QName("", "co"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://webservices/", "conto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
