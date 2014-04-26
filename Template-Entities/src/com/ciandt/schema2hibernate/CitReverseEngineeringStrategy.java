package com.ciandt.schema2hibernate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.Table;

/**
 * Customização de estratégia de geração de entidades a partir do banco.
 * Customização para utilizar o padrão de nomenclatura da Ci&T.
 * @author Dagoberto S. de Souza
 * @since 15/05/2008
 */
public class CitReverseEngineeringStrategy extends
	CustomReverseEngineeringStrategy {
	
    static String acentuado = "çÇáéíóúıÁÉÍÓÚİàèìòùÀÈÌÒÙãõñäëïöüÿÄËÏÖÜÃÕÑâêîôûÂÊÎÔÛ";   
    static String semAcento = "cCaeiouyAEIOUYaeiouAEIOUaonaeiouyAEIOUAONaeiouAEIOU";   
    static char[] tabela;   
    static {   
        tabela = new char[256];   
        for (int i = 0; i < tabela.length; ++i) {   
        tabela [i] = (char) i;   
        }   
        for (int i = 0; i < acentuado.length(); ++i) {   
            tabela [acentuado.charAt(i)] = semAcento.charAt(i);   
        }   
    }   

	/** Construtor padrão. */
	public CitReverseEngineeringStrategy() {
		super("AbbreviationsCit.properties");
	}
	
	/**
	 * Sobreescreve o metodo de geração de metatada da tabela para permitir 
	 * a inclusão de JavaDoc.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map tableToMetaAttributes(TableIdentifier tableIdentifier) {
		Map att = new HashMap();
		Table t = getRuntimeInfo().getTable(tableIdentifier);
		MetaAttribute at = new MetaAttribute("class-description");
		at.addValue("Entity gerado a partir da tabela "
				+ tableIdentifier.getName() + ".\n" + (t.getComment()==null?"":removerAcentos(t.getComment())));
		att.put("class-description", at);
		return att;

	}
	

	/**
	 * Sobreescreve o metodo de geração de metatada das colunas para permitir 
	 * a inclusão de JavaDoc e geração de toString e Equals.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Map columnToMetaAttributes(TableIdentifier identifier, String column) {
		Map att = new HashMap();
		Table t = getRuntimeInfo().getTable(identifier);
		Column c = t.getColumn(new Column(column));
		MetaAttribute at = new MetaAttribute("field-description");

		at.addValue("Atributo gerado a partir da coluna " + column + ".\n"
				+ (c.getComment()==null?"":removerAcentos(c.getComment())));
		
		att.put("field-description", at);
		
		at = new MetaAttribute("use-in-tostring");
        at.addValue("true");
        att.put("use-in-tostring", at);
        
		return att;
	}
	
	
	/**
	 * Filtra para utilizar somente as tabelas com o prefixo "SIM". 
	 */
    @Override
    public boolean excludeTable(TableIdentifier ti) {
    	Set<String> ex = new HashSet<String>();
    	ex.add("EXEMPLO");
        return ex.contains(ti.getName());
    }
    
	/**
	 * Sobreescrebe o método de conversão de nome de coluna para atributo
	 * para utilizar as abreviações mapeadas. Ignora 2 prefixos dos
	 * nomes das tabelas.
	 */
	@Override
	public String columnToPropertyName(TableIdentifier table, String columnName) {
		TableIdentifier ti = new TableIdentifier(unabbreviate(table.getName(), 0));
		return super.columnToPropertyName(ti, unabbreviate(columnName, 1));
	}

    public static String removerAcentos (final String s) {   
        StringBuffer sb = new StringBuffer();   
        for (int i = 0; i < s.length(); ++i) {   
            char ch = s.charAt (i);   
            if (ch < 256) {   
                sb.append (tabela [ch]);   
            } else {   
                sb.append (ch);   
            }   
        }   
        return sb.toString();   
    }   
    
	public static void main(String[] args) {
		CitReverseEngineeringStrategy c = new CitReverseEngineeringStrategy();
		System.out.println(c.unabbreviate("EVEN_IN_ENCERRADO", 1));
	}
}

