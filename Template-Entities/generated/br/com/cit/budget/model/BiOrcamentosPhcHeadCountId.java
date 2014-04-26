/*
 * @(#) BiOrcamentosPhcHeadCountId.java
 * Copyright (c) 2008 Ci&T Software S/A.
 * All Rights Reserved.
 */
package br.com.cit.budget.model;


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BiOrcamentosPhcHeadCountId generated by hbm2java
 *
 * @author Generated by Hibernate Tools 3.2.4.GA
 * @since 11/11/2011 14:21:09
 * @version 09/01/19 1.1 10:08:00
 */
@Embeddable
public class BiOrcamentosPhcHeadCountId  implements java.io.Serializable
 {

	/**
	 * Valor do serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

    /** 
     * Constante para NamedQuery "BiOrcamentosPhcHeadCountId.findAll".
     */ 
	public static final String FIND_ALL = "BiOrcamentosPhcHeadCountId.findAll";




    @Column(name="ID", precision=3, scale=0)
    private Short ;



    @Column(name="TIPO", length=20)
    private String _1;



    @Column(name="PLANILHA", length=40)
    private String _2;



    @Column(name="RESPONSAVEL", length=20)
    private String _3;



    @Column(name="ID_VERSAO", precision=10, scale=0)
    private Long versao;



    @Column(name="VERSAO", length=20)
    private String _4;



    @Column(name="DATA_UPLOAD", length=7)
    private Date upload;



    @Column(name="CCUSTO", length=60)
    private String _5;



    @Column(name="SSO", length=20)
    private String _6;



    @Column(name="CARGO_RECURSO", length=60)
    private String recurso;



    @Column(name="TIPO_CONTRATO", length=40)
    private String contrato;



    @Column(name="BASE", length=3)
    private String _7;



    @Column(name="MES_ORCADO", length=7)
    private Date orcado;



    @Column(name="QTDE_PLANEJADA", precision=10, scale=4)
    private BigDecimal planejada;



    @Column(name="SAL_MEDIO", precision=10, scale=4)
    private BigDecimal medio;



    @Column(name="CARREGA", length=1)
    private String _8;



    @Column(name="NM_EMPRESA", length=35)
    private String empresa;



    @Column(name="MOEDA", length=5)
    private String _9;



    @Column(name="BOPH_CD_REGISTRO", precision=22, scale=0)
    private BigDecimal codigoRegistro;



    /**
     * Construtor default.
     */
    public BiOrcamentosPhcHeadCountId() {
    }

    /**
     * Construtor com preenchimento da entidade.
     * @param  Valor do atributo ;
     * @param _1 Valor do atributo _1;
     * @param _2 Valor do atributo _2;
     * @param _3 Valor do atributo _3;
     * @param versao Valor do atributo versao;
     * @param _4 Valor do atributo _4;
     * @param upload Valor do atributo upload;
     * @param _5 Valor do atributo _5;
     * @param _6 Valor do atributo _6;
     * @param recurso Valor do atributo recurso;
     * @param contrato Valor do atributo contrato;
     * @param _7 Valor do atributo _7;
     * @param orcado Valor do atributo orcado;
     * @param planejada Valor do atributo planejada;
     * @param medio Valor do atributo medio;
     * @param _8 Valor do atributo _8;
     * @param empresa Valor do atributo empresa;
     * @param _9 Valor do atributo _9;
     * @param codigoRegistro Valor do atributo codigoRegistro;
     */ 
    public BiOrcamentosPhcHeadCountId(Short , String _1, String _2, String _3, Long versao, String _4, Date upload, String _5, String _6, String recurso, String contrato, String _7, Date orcado, BigDecimal planejada, BigDecimal medio, String _8, String empresa, String _9, BigDecimal codigoRegistro) {
       this. = ;
       this._1 = _1;
       this._2 = _2;
       this._3 = _3;
       this.versao = versao;
       this._4 = _4;
       this.upload = upload;
       this._5 = _5;
       this._6 = _6;
       this.recurso = recurso;
       this.contrato = contrato;
       this._7 = _7;
       this.orcado = orcado;
       this.planejada = planejada;
       this.medio = medio;
       this._8 = _8;
       this.empresa = empresa;
       this._9 = _9;
       this.codigoRegistro = codigoRegistro;
    }
   
    /**
     * Obtem o valor do atributo .<BR>

     * @return Valor do atributo .
     */
    public Short get() {
        return this.;
    }

    /**
     * Atualiza o valor do atributo .<BR>

     * @param  Novo valor para o atributo .
     */    
    public void set(final Short ) {
        this. = ;
    }
    /**
     * Obtem o valor do atributo _1.<BR>

     * @return Valor do atributo _1.
     */
    public String get_1() {
        return this._1;
    }

    /**
     * Atualiza o valor do atributo _1.<BR>

     * @param _1 Novo valor para o atributo _1.
     */    
    public void set_1(final String _1) {
        this._1 = _1;
    }
    /**
     * Obtem o valor do atributo _2.<BR>

     * @return Valor do atributo _2.
     */
    public String get_2() {
        return this._2;
    }

    /**
     * Atualiza o valor do atributo _2.<BR>

     * @param _2 Novo valor para o atributo _2.
     */    
    public void set_2(final String _2) {
        this._2 = _2;
    }
    /**
     * Obtem o valor do atributo _3.<BR>

     * @return Valor do atributo _3.
     */
    public String get_3() {
        return this._3;
    }

    /**
     * Atualiza o valor do atributo _3.<BR>

     * @param _3 Novo valor para o atributo _3.
     */    
    public void set_3(final String _3) {
        this._3 = _3;
    }
    /**
     * Obtem o valor do atributo versao.<BR>

     * @return Valor do atributo versao.
     */
    public Long getVersao() {
        return this.versao;
    }

    /**
     * Atualiza o valor do atributo versao.<BR>

     * @param versao Novo valor para o atributo versao.
     */    
    public void setVersao(final Long versao) {
        this.versao = versao;
    }
    /**
     * Obtem o valor do atributo _4.<BR>

     * @return Valor do atributo _4.
     */
    public String get_4() {
        return this._4;
    }

    /**
     * Atualiza o valor do atributo _4.<BR>

     * @param _4 Novo valor para o atributo _4.
     */    
    public void set_4(final String _4) {
        this._4 = _4;
    }
    /**
     * Obtem o valor do atributo upload.<BR>

     * @return Valor do atributo upload.
     */
    public Date getUpload() {
        return this.upload;
    }

    /**
     * Atualiza o valor do atributo upload.<BR>

     * @param upload Novo valor para o atributo upload.
     */    
    public void setUpload(final Date upload) {
        this.upload = upload;
    }
    /**
     * Obtem o valor do atributo _5.<BR>

     * @return Valor do atributo _5.
     */
    public String get_5() {
        return this._5;
    }

    /**
     * Atualiza o valor do atributo _5.<BR>

     * @param _5 Novo valor para o atributo _5.
     */    
    public void set_5(final String _5) {
        this._5 = _5;
    }
    /**
     * Obtem o valor do atributo _6.<BR>

     * @return Valor do atributo _6.
     */
    public String get_6() {
        return this._6;
    }

    /**
     * Atualiza o valor do atributo _6.<BR>

     * @param _6 Novo valor para o atributo _6.
     */    
    public void set_6(final String _6) {
        this._6 = _6;
    }
    /**
     * Obtem o valor do atributo recurso.<BR>

     * @return Valor do atributo recurso.
     */
    public String getRecurso() {
        return this.recurso;
    }

    /**
     * Atualiza o valor do atributo recurso.<BR>

     * @param recurso Novo valor para o atributo recurso.
     */    
    public void setRecurso(final String recurso) {
        this.recurso = recurso;
    }
    /**
     * Obtem o valor do atributo contrato.<BR>

     * @return Valor do atributo contrato.
     */
    public String getContrato() {
        return this.contrato;
    }

    /**
     * Atualiza o valor do atributo contrato.<BR>

     * @param contrato Novo valor para o atributo contrato.
     */    
    public void setContrato(final String contrato) {
        this.contrato = contrato;
    }
    /**
     * Obtem o valor do atributo _7.<BR>

     * @return Valor do atributo _7.
     */
    public String get_7() {
        return this._7;
    }

    /**
     * Atualiza o valor do atributo _7.<BR>

     * @param _7 Novo valor para o atributo _7.
     */    
    public void set_7(final String _7) {
        this._7 = _7;
    }
    /**
     * Obtem o valor do atributo orcado.<BR>

     * @return Valor do atributo orcado.
     */
    public Date getOrcado() {
        return this.orcado;
    }

    /**
     * Atualiza o valor do atributo orcado.<BR>

     * @param orcado Novo valor para o atributo orcado.
     */    
    public void setOrcado(final Date orcado) {
        this.orcado = orcado;
    }
    /**
     * Obtem o valor do atributo planejada.<BR>

     * @return Valor do atributo planejada.
     */
    public BigDecimal getPlanejada() {
        return this.planejada;
    }

    /**
     * Atualiza o valor do atributo planejada.<BR>

     * @param planejada Novo valor para o atributo planejada.
     */    
    public void setPlanejada(final BigDecimal planejada) {
        this.planejada = planejada;
    }
    /**
     * Obtem o valor do atributo medio.<BR>

     * @return Valor do atributo medio.
     */
    public BigDecimal getMedio() {
        return this.medio;
    }

    /**
     * Atualiza o valor do atributo medio.<BR>

     * @param medio Novo valor para o atributo medio.
     */    
    public void setMedio(final BigDecimal medio) {
        this.medio = medio;
    }
    /**
     * Obtem o valor do atributo _8.<BR>

     * @return Valor do atributo _8.
     */
    public String get_8() {
        return this._8;
    }

    /**
     * Atualiza o valor do atributo _8.<BR>

     * @param _8 Novo valor para o atributo _8.
     */    
    public void set_8(final String _8) {
        this._8 = _8;
    }
    /**
     * Obtem o valor do atributo empresa.<BR>

     * @return Valor do atributo empresa.
     */
    public String getEmpresa() {
        return this.empresa;
    }

    /**
     * Atualiza o valor do atributo empresa.<BR>

     * @param empresa Novo valor para o atributo empresa.
     */    
    public void setEmpresa(final String empresa) {
        this.empresa = empresa;
    }
    /**
     * Obtem o valor do atributo _9.<BR>

     * @return Valor do atributo _9.
     */
    public String get_9() {
        return this._9;
    }

    /**
     * Atualiza o valor do atributo _9.<BR>

     * @param _9 Novo valor para o atributo _9.
     */    
    public void set_9(final String _9) {
        this._9 = _9;
    }
    /**
     * Obtem o valor do atributo codigoRegistro.<BR>

     * @return Valor do atributo codigoRegistro.
     */
    public BigDecimal getCodigoRegistro() {
        return this.codigoRegistro;
    }

    /**
     * Atualiza o valor do atributo codigoRegistro.<BR>

     * @param codigoRegistro Novo valor para o atributo codigoRegistro.
     */    
    public void setCodigoRegistro(final BigDecimal codigoRegistro) {
        this.codigoRegistro = codigoRegistro;
    }


   	/**
	 * @see Object#equals(Object)
	 */
	@Override
    public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BiOrcamentosPhcHeadCountId) ) return false;
		 BiOrcamentosPhcHeadCountId castOther = ( BiOrcamentosPhcHeadCountId ) other; 
         
		 return ( (this.get()==castOther.get()) || ( this.get()!=null && castOther.get()!=null && this.get().equals(castOther.get()) ) )
 && ( (this.get_1()==castOther.get_1()) || ( this.get_1()!=null && castOther.get_1()!=null && this.get_1().equals(castOther.get_1()) ) )
 && ( (this.get_2()==castOther.get_2()) || ( this.get_2()!=null && castOther.get_2()!=null && this.get_2().equals(castOther.get_2()) ) )
 && ( (this.get_3()==castOther.get_3()) || ( this.get_3()!=null && castOther.get_3()!=null && this.get_3().equals(castOther.get_3()) ) )
 && ( (this.getVersao()==castOther.getVersao()) || ( this.getVersao()!=null && castOther.getVersao()!=null && this.getVersao().equals(castOther.getVersao()) ) )
 && ( (this.get_4()==castOther.get_4()) || ( this.get_4()!=null && castOther.get_4()!=null && this.get_4().equals(castOther.get_4()) ) )
 && ( (this.getUpload()==castOther.getUpload()) || ( this.getUpload()!=null && castOther.getUpload()!=null && this.getUpload().equals(castOther.getUpload()) ) )
 && ( (this.get_5()==castOther.get_5()) || ( this.get_5()!=null && castOther.get_5()!=null && this.get_5().equals(castOther.get_5()) ) )
 && ( (this.get_6()==castOther.get_6()) || ( this.get_6()!=null && castOther.get_6()!=null && this.get_6().equals(castOther.get_6()) ) )
 && ( (this.getRecurso()==castOther.getRecurso()) || ( this.getRecurso()!=null && castOther.getRecurso()!=null && this.getRecurso().equals(castOther.getRecurso()) ) )
 && ( (this.getContrato()==castOther.getContrato()) || ( this.getContrato()!=null && castOther.getContrato()!=null && this.getContrato().equals(castOther.getContrato()) ) )
 && ( (this.get_7()==castOther.get_7()) || ( this.get_7()!=null && castOther.get_7()!=null && this.get_7().equals(castOther.get_7()) ) )
 && ( (this.getOrcado()==castOther.getOrcado()) || ( this.getOrcado()!=null && castOther.getOrcado()!=null && this.getOrcado().equals(castOther.getOrcado()) ) )
 && ( (this.getPlanejada()==castOther.getPlanejada()) || ( this.getPlanejada()!=null && castOther.getPlanejada()!=null && this.getPlanejada().equals(castOther.getPlanejada()) ) )
 && ( (this.getMedio()==castOther.getMedio()) || ( this.getMedio()!=null && castOther.getMedio()!=null && this.getMedio().equals(castOther.getMedio()) ) )
 && ( (this.get_8()==castOther.get_8()) || ( this.get_8()!=null && castOther.get_8()!=null && this.get_8().equals(castOther.get_8()) ) )
 && ( (this.getEmpresa()==castOther.getEmpresa()) || ( this.getEmpresa()!=null && castOther.getEmpresa()!=null && this.getEmpresa().equals(castOther.getEmpresa()) ) )
 && ( (this.get_9()==castOther.get_9()) || ( this.get_9()!=null && castOther.get_9()!=null && this.get_9().equals(castOther.get_9()) ) )
 && ( (this.getCodigoRegistro()==castOther.getCodigoRegistro()) || ( this.getCodigoRegistro()!=null && castOther.getCodigoRegistro()!=null && this.getCodigoRegistro().equals(castOther.getCodigoRegistro()) ) );
   }
   
	/**
	 * @see Object#hashCode()
	 */
	@Override
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( get() == null ? 0 : this.get().hashCode() );
         result = 37 * result + ( get_1() == null ? 0 : this.get_1().hashCode() );
         result = 37 * result + ( get_2() == null ? 0 : this.get_2().hashCode() );
         result = 37 * result + ( get_3() == null ? 0 : this.get_3().hashCode() );
         result = 37 * result + ( getVersao() == null ? 0 : this.getVersao().hashCode() );
         result = 37 * result + ( get_4() == null ? 0 : this.get_4().hashCode() );
         result = 37 * result + ( getUpload() == null ? 0 : this.getUpload().hashCode() );
         result = 37 * result + ( get_5() == null ? 0 : this.get_5().hashCode() );
         result = 37 * result + ( get_6() == null ? 0 : this.get_6().hashCode() );
         result = 37 * result + ( getRecurso() == null ? 0 : this.getRecurso().hashCode() );
         result = 37 * result + ( getContrato() == null ? 0 : this.getContrato().hashCode() );
         result = 37 * result + ( get_7() == null ? 0 : this.get_7().hashCode() );
         result = 37 * result + ( getOrcado() == null ? 0 : this.getOrcado().hashCode() );
         result = 37 * result + ( getPlanejada() == null ? 0 : this.getPlanejada().hashCode() );
         result = 37 * result + ( getMedio() == null ? 0 : this.getMedio().hashCode() );
         result = 37 * result + ( get_8() == null ? 0 : this.get_8().hashCode() );
         result = 37 * result + ( getEmpresa() == null ? 0 : this.getEmpresa().hashCode() );
         result = 37 * result + ( get_9() == null ? 0 : this.get_9().hashCode() );
         result = 37 * result + ( getCodigoRegistro() == null ? 0 : this.getCodigoRegistro().hashCode() );
         return result;
   }   


}

