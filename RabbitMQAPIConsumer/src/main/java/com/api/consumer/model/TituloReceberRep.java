package com.api.consumer.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.api.consumer.model.id.TituloReceberRepId;

@Entity
@Table(name="TITULO_RECEBER_REP")
public class TituloReceberRep {
	
	@EmbeddedId
	private TituloReceberRepId tituloReceberRepId;
	
	@Column(name="CD_TIPO_DOCUMENTO")
	private Long cdTipoDocumento;
	
	@Column(name="CD_PESSOA")
	private Long cdPessoa;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_EMISSAO")
	private Date dtEmissao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ENTRADA")
	private Date dtEntrada;
	
	@Column(name="IE_PROVISIONA")
	private String ieProvisiona;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_VENCIMENTO")
	private Date dtVencimento;
	
	@Column(name="VL_TITULO")
	private BigDecimal vlTitulo;
	
	@Column(name="VL_TOTAL_NOTA")
	private BigDecimal vlTotalNota;
	
	@Column(name="NR_DOCUMENTO")
	private String nrDocumento;
	
	@Column(name="CD_SERIE")
	private String cdSerie;
	
	@Column(name="CD_PORTADOR")
	private Long cdPortador;
	
	@Column(name="CD_FUNCAO")
	private Long cdFuncao;
	
	@Column(name="CD_MOEDA")
	private Long cdMoeda;
	
	@Column(name="IE_TITULO")
	private Long ieTitulo;
	
	@Column(name="VL_SALDO_TITULO")
	private BigDecimal vlSaldoTitulo;
	
	@Column(name="NM_USUARIO")
	private String nmUsuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_ATUALIZACAO")
	private Date dtAtualizacao;
	
	@Column(name="IE_TIPO_INCORPORACAO")
	private String ieTipoIncorporacao;
	
	@Column(name="CD_BANCO")
	private Long cdBanco;
	
	@Column(name="CD_AGENCIA")
	private Long cdAgencia;
	
	@Column(name="CD_OPERACAO_BANCARIA")
	private Long cdOperacaoBancaria;
	
	@Column(name="DS_OBSERVACAO")
	private String dsObservacao;
	
	@Column(name="VL_DESCONTO")
	private BigDecimal vlDesconto;
	
	@Column(name="CD_CONTRATO")
	private String cdContrato;
	
	@Column(name="CD_TIPO_CONTRATO")
	private Long cdTipoContrato;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_CONTABIL_PROVISAO")
	private Date dtContabilProvisao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_DEBITO")
	private Date dtDebito;
	
	@Column(name="VL_MOEDA_PARCELA")
	private BigDecimal vlMoedaParcela;
	
	@Column(name="VL_MOEDA_NOTA")
	private BigDecimal vlMoedaNota;
	
	@Column(name="IE_RECEBIMENTO_ANTECIPADO")
	private String ieRecebimentoAntecipado;
	
	@Column(name="CD_CULTURA")
	private Long cdCultura;
	
	@Column(name="CD_SAFRA")
	private Long cdSafra;
	
	@Column(name="CD_CTB1")
	private Long cdCtb1;
	
	@Column(name="CD_TIPO_ATIVIDADE")
	private Long cdTipoAtividade;
	
	@Column(name="IE_ENVIO_EQUIFAX")
	private Long ieEnvioEquifax;
	
	@Column(name="IE_ENVIO_EMAIL_COBRANCA")
	private String ieEnvioEmailCobranca;
	
	@Column(name="NM_USUARIO_EMISSOR")
	private String nmUsuarioEmissor;
	
	@Column(name="IE_TITULO_PDD")
	private String ieTituloPdd;

	public TituloReceberRep() {
		super();
	}

	public TituloReceberRep(TituloReceberRepId tituloReceberRepId, Long cdTipoDocumento, Long cdPessoa, Date dtEmissao,
			Date dtEntrada, String ieProvisiona, Date dtVencimento, BigDecimal vlTitulo, BigDecimal vlTotalNota,
			String nrDocumento, String cdSerie, Long cdPortador, Long cdFuncao, Long cdMoeda, Long ieTitulo,
			BigDecimal vlSaldoTitulo, String nmUsuario, Date dtAtualizacao, String ieTipoIncorporacao, Long cdBanco,
			Long cdAgencia, Long cdOperacaoBancaria, String dsObservacao, BigDecimal vlDesconto, String cdContrato,
			Long cdTipoContrato, Date dtContabilProvisao, Date dtDebito, BigDecimal vlMoedaParcela,
			BigDecimal vlMoedaNota, String ieRecebimentoAntecipado, Long cdCultura, Long cdSafra, Long cdCtb1,
			Long cdTipoAtividade, Long ieEnvioEquifax, String ieEnvioEmailCobranca, String nmUsuarioEmissor,
			String ieTituloPdd) {
		super();
		this.tituloReceberRepId = tituloReceberRepId;
		this.cdTipoDocumento = cdTipoDocumento;
		this.cdPessoa = cdPessoa;
		this.dtEmissao = dtEmissao;
		this.dtEntrada = dtEntrada;
		this.ieProvisiona = ieProvisiona;
		this.dtVencimento = dtVencimento;
		this.vlTitulo = vlTitulo;
		this.vlTotalNota = vlTotalNota;
		this.nrDocumento = nrDocumento;
		this.cdSerie = cdSerie;
		this.cdPortador = cdPortador;
		this.cdFuncao = cdFuncao;
		this.cdMoeda = cdMoeda;
		this.ieTitulo = ieTitulo;
		this.vlSaldoTitulo = vlSaldoTitulo;
		this.nmUsuario = nmUsuario;
		this.dtAtualizacao = dtAtualizacao;
		this.ieTipoIncorporacao = ieTipoIncorporacao;
		this.cdBanco = cdBanco;
		this.cdAgencia = cdAgencia;
		this.cdOperacaoBancaria = cdOperacaoBancaria;
		this.dsObservacao = dsObservacao;
		this.vlDesconto = vlDesconto;
		this.cdContrato = cdContrato;
		this.cdTipoContrato = cdTipoContrato;
		this.dtContabilProvisao = dtContabilProvisao;
		this.dtDebito = dtDebito;
		this.vlMoedaParcela = vlMoedaParcela;
		this.vlMoedaNota = vlMoedaNota;
		this.ieRecebimentoAntecipado = ieRecebimentoAntecipado;
		this.cdCultura = cdCultura;
		this.cdSafra = cdSafra;
		this.cdCtb1 = cdCtb1;
		this.cdTipoAtividade = cdTipoAtividade;
		this.ieEnvioEquifax = ieEnvioEquifax;
		this.ieEnvioEmailCobranca = ieEnvioEmailCobranca;
		this.nmUsuarioEmissor = nmUsuarioEmissor;
		this.ieTituloPdd = ieTituloPdd;
	}

	public TituloReceberRepId getTituloReceberRepId() {
		return tituloReceberRepId;
	}

	public void setTituloReceberRepId(TituloReceberRepId tituloReceberRepId) {
		this.tituloReceberRepId = tituloReceberRepId;
	}

	public Long getCdTipoDocumento() {
		return cdTipoDocumento;
	}

	public void setCdTipoDocumento(Long cdTipoDocumento) {
		this.cdTipoDocumento = cdTipoDocumento;
	}

	public Long getCdPessoa() {
		return cdPessoa;
	}

	public void setCdPessoa(Long cdPessoa) {
		this.cdPessoa = cdPessoa;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public String getIeProvisiona() {
		return ieProvisiona;
	}

	public void setIeProvisiona(String ieProvisiona) {
		this.ieProvisiona = ieProvisiona;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public BigDecimal getVlTitulo() {
		return vlTitulo;
	}

	public void setVlTitulo(BigDecimal vlTitulo) {
		this.vlTitulo = vlTitulo;
	}

	public BigDecimal getVlTotalNota() {
		return vlTotalNota;
	}

	public void setVlTotalNota(BigDecimal vlTotalNota) {
		this.vlTotalNota = vlTotalNota;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public String getCdSerie() {
		return cdSerie;
	}

	public void setCdSerie(String cdSerie) {
		this.cdSerie = cdSerie;
	}

	public Long getCdPortador() {
		return cdPortador;
	}

	public void setCdPortador(Long cdPortador) {
		this.cdPortador = cdPortador;
	}

	public Long getCdFuncao() {
		return cdFuncao;
	}

	public void setCdFuncao(Long cdFuncao) {
		this.cdFuncao = cdFuncao;
	}

	public Long getCdMoeda() {
		return cdMoeda;
	}

	public void setCdMoeda(Long cdMoeda) {
		this.cdMoeda = cdMoeda;
	}

	public Long getIeTitulo() {
		return ieTitulo;
	}

	public void setIeTitulo(Long ieTitulo) {
		this.ieTitulo = ieTitulo;
	}

	public BigDecimal getVlSaldoTitulo() {
		return vlSaldoTitulo;
	}

	public void setVlSaldoTitulo(BigDecimal vlSaldoTitulo) {
		this.vlSaldoTitulo = vlSaldoTitulo;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	public String getIeTipoIncorporacao() {
		return ieTipoIncorporacao;
	}

	public void setIeTipoIncorporacao(String ieTipoIncorporacao) {
		this.ieTipoIncorporacao = ieTipoIncorporacao;
	}

	public Long getCdBanco() {
		return cdBanco;
	}

	public void setCdBanco(Long cdBanco) {
		this.cdBanco = cdBanco;
	}

	public Long getCdAgencia() {
		return cdAgencia;
	}

	public void setCdAgencia(Long cdAgencia) {
		this.cdAgencia = cdAgencia;
	}

	public Long getCdOperacaoBancaria() {
		return cdOperacaoBancaria;
	}

	public void setCdOperacaoBancaria(Long cdOperacaoBancaria) {
		this.cdOperacaoBancaria = cdOperacaoBancaria;
	}

	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public BigDecimal getVlDesconto() {
		return vlDesconto;
	}

	public void setVlDesconto(BigDecimal vlDesconto) {
		this.vlDesconto = vlDesconto;
	}

	public String getCdContrato() {
		return cdContrato;
	}

	public void setCdContrato(String cdContrato) {
		this.cdContrato = cdContrato;
	}

	public Long getCdTipoContrato() {
		return cdTipoContrato;
	}

	public void setCdTipoContrato(Long cdTipoContrato) {
		this.cdTipoContrato = cdTipoContrato;
	}

	public Date getDtContabilProvisao() {
		return dtContabilProvisao;
	}

	public void setDtContabilProvisao(Date dtContabilProvisao) {
		this.dtContabilProvisao = dtContabilProvisao;
	}

	public Date getDtDebito() {
		return dtDebito;
	}

	public void setDtDebito(Date dtDebito) {
		this.dtDebito = dtDebito;
	}

	public BigDecimal getVlMoedaParcela() {
		return vlMoedaParcela;
	}

	public void setVlMoedaParcela(BigDecimal vlMoedaParcela) {
		this.vlMoedaParcela = vlMoedaParcela;
	}

	public BigDecimal getVlMoedaNota() {
		return vlMoedaNota;
	}

	public void setVlMoedaNota(BigDecimal vlMoedaNota) {
		this.vlMoedaNota = vlMoedaNota;
	}

	public String getIeRecebimentoAntecipado() {
		return ieRecebimentoAntecipado;
	}

	public void setIeRecebimentoAntecipado(String ieRecebimentoAntecipado) {
		this.ieRecebimentoAntecipado = ieRecebimentoAntecipado;
	}

	public Long getCdCultura() {
		return cdCultura;
	}

	public void setCdCultura(Long cdCultura) {
		this.cdCultura = cdCultura;
	}

	public Long getCdSafra() {
		return cdSafra;
	}

	public void setCdSafra(Long cdSafra) {
		this.cdSafra = cdSafra;
	}

	public Long getCdCtb1() {
		return cdCtb1;
	}

	public void setCdCtb1(Long cdCtb1) {
		this.cdCtb1 = cdCtb1;
	}

	public Long getCdTipoAtividade() {
		return cdTipoAtividade;
	}

	public void setCdTipoAtividade(Long cdTipoAtividade) {
		this.cdTipoAtividade = cdTipoAtividade;
	}

	public Long getIeEnvioEquifax() {
		return ieEnvioEquifax;
	}

	public void setIeEnvioEquifax(Long ieEnvioEquifax) {
		this.ieEnvioEquifax = ieEnvioEquifax;
	}

	public String getIeEnvioEmailCobranca() {
		return ieEnvioEmailCobranca;
	}

	public void setIeEnvioEmailCobranca(String ieEnvioEmailCobranca) {
		this.ieEnvioEmailCobranca = ieEnvioEmailCobranca;
	}

	public String getNmUsuarioEmissor() {
		return nmUsuarioEmissor;
	}

	public void setNmUsuarioEmissor(String nmUsuarioEmissor) {
		this.nmUsuarioEmissor = nmUsuarioEmissor;
	}

	public String getIeTituloPdd() {
		return ieTituloPdd;
	}

	public void setIeTituloPdd(String ieTituloPdd) {
		this.ieTituloPdd = ieTituloPdd;
	}
	
	
	
}
