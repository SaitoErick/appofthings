<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
 ${pojo.generateAnnIdGenerator()}
    @${pojo.importType("javax.persistence.GeneratedValue")}(generator="${pojo.getDeclarationName()}Seq")
    @${pojo.importType("javax.persistence.SequenceGenerator")}(name="${pojo.getDeclarationName()}Seq",sequenceName="SQ_${property.getColumnIterator().next().getName()}", allocationSize=1) 
<#-- if this is the id property (getter)-->
<#-- explicitly set the column name for this property-->
</#if>
</#if>
<#if c2h.isManyToOne(property)>
<#--TODO support @OneToOne true and false-->    
${pojo.generateManyToOneAnnotation(property)}
<#--TODO support optional and targetEntity-->    
${pojo.generateJoinColumnsAnnotation(property, cfg)}
<#elseif c2h.isCollection(property)>
${pojo.generateCollectionAnnotation(property, cfg)}
<#else>
${pojo.generateBasicAnnotation(property)}
${pojo.generateAnnColumnAnnotation(property)}
</#if>
</#if>
