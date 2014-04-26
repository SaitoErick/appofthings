<#if pojo.needsToString()>    	/**
	 * @see Object#toString()
	 */
    @Override
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
<#foreach property in pojo.getToStringPropertiesIterator()>      buffer.append("${property.getName()}").append("='").append(${pojo.getGetterSignature(property)}()).append("' ");			
</#foreach>      buffer.append("]");
      
      return buffer.toString();
     }
</#if>