/**
 * Conto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public class Conto  implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;

	private java.lang.String datain;

    private int idconto;

    private int idimp;

    private double saldo;

    public Conto() {
    }

    public Conto(
           java.lang.String datain,
           int idconto,
           int idimp,
           double saldo) {
           this.datain = datain;
           this.idconto = idconto;
           this.idimp = idimp;
           this.saldo = saldo;
    }


    /**
     * Gets the datain value for this Conto.
     * 
     * @return datain
     */
    public java.lang.String getDatain() {
        return datain;
    }


    /**
     * Sets the datain value for this Conto.
     * 
     * @param datain
     */
    public void setDatain(java.lang.String datain) {
        this.datain = datain;
    }


    /**
     * Gets the idconto value for this Conto.
     * 
     * @return idconto
     */
    public int getIdconto() {
        return idconto;
    }


    /**
     * Sets the idconto value for this Conto.
     * 
     * @param idconto
     */
    public void setIdconto(int idconto) {
        this.idconto = idconto;
    }


    /**
     * Gets the idimp value for this Conto.
     * 
     * @return idimp
     */
    public int getIdimp() {
        return idimp;
    }


    /**
     * Sets the idimp value for this Conto.
     * 
     * @param idimp
     */
    public void setIdimp(int idimp) {
        this.idimp = idimp;
    }


    /**
     * Gets the saldo value for this Conto.
     * 
     * @return saldo
     */
    public double getSaldo() {
        return saldo;
    }


    /**
     * Sets the saldo value for this Conto.
     * 
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Conto)) return false;
        Conto other = (Conto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.datain==null && other.getDatain()==null) || 
             (this.datain!=null &&
              this.datain.equals(other.getDatain()))) &&
            this.idconto == other.getIdconto() &&
            this.idimp == other.getIdimp() &&
            this.saldo == other.getSaldo();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDatain() != null) {
            _hashCode += getDatain().hashCode();
        }
        _hashCode += getIdconto();
        _hashCode += getIdimp();
        _hashCode += new Double(getSaldo()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Conto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices/", "conto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("datain");
        elemField.setXmlName(new javax.xml.namespace.QName("", "datain"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anySimpleType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idconto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idconto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idimp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idimp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saldo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "saldo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
