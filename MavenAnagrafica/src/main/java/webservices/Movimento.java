/**
 * Movimento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservices;

public class Movimento  implements java.io.Serializable {
    private java.lang.String data;

    private int idconto;

    private int idmov;

    private int idtipo;

    private double importo;

    public Movimento() {
    }

    public Movimento(
           java.lang.String data,
           int idconto,
           int idmov,
           int idtipo,
           double importo) {
           this.data = data;
           this.idconto = idconto;
           this.idmov = idmov;
           this.idtipo = idtipo;
           this.importo = importo;
    }


    /**
     * Gets the data value for this Movimento.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this Movimento.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the idconto value for this Movimento.
     * 
     * @return idconto
     */
    public int getIdconto() {
        return idconto;
    }


    /**
     * Sets the idconto value for this Movimento.
     * 
     * @param idconto
     */
    public void setIdconto(int idconto) {
        this.idconto = idconto;
    }


    /**
     * Gets the idmov value for this Movimento.
     * 
     * @return idmov
     */
    public int getIdmov() {
        return idmov;
    }


    /**
     * Sets the idmov value for this Movimento.
     * 
     * @param idmov
     */
    public void setIdmov(int idmov) {
        this.idmov = idmov;
    }


    /**
     * Gets the idtipo value for this Movimento.
     * 
     * @return idtipo
     */
    public int getIdtipo() {
        return idtipo;
    }


    /**
     * Sets the idtipo value for this Movimento.
     * 
     * @param idtipo
     */
    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }


    /**
     * Gets the importo value for this Movimento.
     * 
     * @return importo
     */
    public double getImporto() {
        return importo;
    }


    /**
     * Sets the importo value for this Movimento.
     * 
     * @param importo
     */
    public void setImporto(double importo) {
        this.importo = importo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Movimento)) return false;
        Movimento other = (Movimento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            this.idconto == other.getIdconto() &&
            this.idmov == other.getIdmov() &&
            this.idtipo == other.getIdtipo() &&
            this.importo == other.getImporto();
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
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        _hashCode += getIdconto();
        _hashCode += getIdmov();
        _hashCode += getIdtipo();
        _hashCode += new Double(getImporto()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Movimento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservices/", "movimento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
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
        elemField.setFieldName("idmov");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idmov"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idtipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idtipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importo"));
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
