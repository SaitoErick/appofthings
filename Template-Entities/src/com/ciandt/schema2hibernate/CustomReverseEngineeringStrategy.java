package com.ciandt.schema2hibernate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.MetaAttribute;
import org.hibernate.mapping.Table;

/**
 * Customização de estratégia de geração de entidades a partir do banco.
 * @author Dagoberto S. de Souza
 * @since 15/05/2008
 */
public class CustomReverseEngineeringStrategy extends
		DefaultReverseEngineeringStrategy {
	/**
	 * Carrega se abreviações para permitir o BD-Java.
	 */
	protected Properties abr = new Properties();
	
	/** Construtor padrão. */
	public CustomReverseEngineeringStrategy() {
		this("Abbreviations.properties");
	}
	
	/** Construtor padrão. */
	public CustomReverseEngineeringStrategy(String abbreviationsFile) {
		try {
			abr.load(CustomReverseEngineeringStrategy.class.getClassLoader()
					.getResourceAsStream(abbreviationsFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				+ tableIdentifier.getName() + ".\n" + (t.getComment()==null?"":t.getComment()));
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
				+ (c.getComment()==null?"":c.getComment()));
		
		att.put("field-description", at);
		
		at = new MetaAttribute("use-in-tostring");
        at.addValue("true");
        att.put("use-in-tostring", at);
        
/*        if (t.getPrimaryKey().getColumns().contains(new Column(column))) {
            at = new MetaAttribute("use-in-equals");
            at.addValue("true");
            att.put("use-in-equals", at);
        }*/
		return att;

	}

	/**
	 * Sobreescreve o metodo de mapeamento de tipagem para permitir tratar o 
	 * tipo Timestamp do oracle 10.
	 */
	@Override
	public String columnToHibernateTypeName(TableIdentifier arg0, String arg1,
			int arg2, int arg3, int arg4, int arg5, boolean arg6, boolean arg7) {
		String ret = super.columnToHibernateTypeName(arg0, arg1, arg2, arg3,
				arg4, arg5, arg6, arg7);
		
		if(ret.equals("int")) {
            return "Integer";
        } else if(ret.equals("long")) {
		    return "Long";
		} else if (ret.equals("serializable")) {
			return "timestamp";
		} else {
			return ret;
		}
	}

	/**
	 * Sobreescrebe o método de conversão de nome de tabela para classe
	 * para utilizar as abreviações mapiadas.
	 */
	@Override
	public String tableToClassName(TableIdentifier tableIdentifier) {
		TableIdentifier ti = new TableIdentifier(unabbreviate(tableIdentifier
				.getName(),0));
		return super.tableToClassName(ti);
	}

	/**
	 * Sobreescrebe o método de conversão de nome de coluna para atributo
	 * para utilizar as abreviações mapiadas.
	 */
	@Override
	public String columnToPropertyName(TableIdentifier table, String columnName) {
		TableIdentifier ti = new TableIdentifier(unabbreviate(table.getName(), 0));
		return super.columnToPropertyName(ti, unabbreviate(columnName, 0));
	}

	/**
	 * Converte as abreviações.
	 * @param name Nome abreviado.
	 * @param ignorePrefix Número de prefíxos a serem ignorados na conversão.
	 * @return Nome sem abreviações.
	 */
	protected String unabbreviate(String name, int ignorePrefix) {
		StringTokenizer tok = new StringTokenizer(name, "_");
		StringBuffer buf = new StringBuffer();
		String t;
		while (tok.hasMoreTokens()) {
			t = tok.nextToken();
			if (ignorePrefix > 0) {
			    ignorePrefix--;
			} else {
			    buf.append(abr.getProperty(t, t)).append("_");
			}
		}
		return buf.toString();
	}
	

}
