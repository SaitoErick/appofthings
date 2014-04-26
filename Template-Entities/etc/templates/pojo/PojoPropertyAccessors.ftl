<#-- // Property accessors -->
<#foreach property in pojo.getAllPropertiesIterator()>
<#if pojo.getMetaAttribAsBool(property, "gen-property", true)>
    /**
     * Obtem o valor do atributo ${property.name}.${"<BR>"}
${pojo.getFieldJavaDoc(property, 4)}
     * @return Valor do atributo ${property.name}.
     */
    ${pojo.getPropertyGetModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} ${pojo.getGetterSignature(property)}() {
        return this.${property.name};
    }

    /**
     * Atualiza o valor do atributo ${property.name}.${"<BR>"}
${pojo.getFieldJavaDoc(property, 4)}
     * @param ${property.name} Novo valor para o atributo ${property.name}.
     */    
    ${pojo.getPropertySetModifiers(property)} void set${pojo.getPropertyName(property)}(final ${pojo.getJavaTypeName(property, jdk5)} ${property.name}) {
        this.${property.name} = ${property.name};
    }
</#if>
</#foreach>
