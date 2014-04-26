<#-- // Constants -->
	/**
	 * Valor do serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

    /** 
     * Constante para NamedQuery "${pojo.getDeclarationName()}.findAll".
     */ 
	public static final String FIND_ALL = "${pojo.getDeclarationName()}.findAll";

<#-- // Fields -->

<#foreach property in pojo.getAllPropertiesIterator()><#if pojo.getMetaAttribAsBool(property, "gen-property", true)><#if pojo.hasMetaAttribute(property, "field-description")>    /**
${pojo.getFieldJavaDoc(property, 4)}
     */</#if>
<#include "GetPropertyAnnotation.ftl"/>    ${pojo.getFieldModifiers(property)} ${pojo.getJavaTypeName(property, jdk5)} ${property.name}<#if pojo.hasFieldInitializor(property, jdk5)> = ${pojo.getFieldInitialization(property, jdk5)}</#if>;${'\n'}</#if>
</#foreach>

