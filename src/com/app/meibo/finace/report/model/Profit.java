package com.app.meibo.finace.report.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 利润
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-21 下午9:29:58
 */
@Entity
@Table(name = "profit")
public class Profit {
	private Integer id;
	private Double yyshr;// 营业收入
	private Double y_yyshr;// 本年累计
	private Double yychb;// 营业成本
	private Double y_yychb;// 营业成本
	private Double yyshj;// 营业税金及附加
	private Double y_yyshj;// 营业成本
	private Double xshfy;// 销售费用
	private Double y_xshfy;// 销售费用

	private Double glfy;// 管理费用
	private Double y_glfy;// 管理费用
	private Double cwfy;// 财务费用
	private Double y_cwfy;// 财务费用
	private Double zijzhssh;// 资产减值损失
	private Double y_zijzhssh;// 资产减值损失

	private Double gyjzh;// 公允价值变动收益
	private Double y_gyjzh;// 公允价值变动收益
	private Double tzshy;// 投资收益
	private Double y_tzshy;// 投资收益
	private Double lyqy;// 对联营企业和合营企业的投资收益
	private Double y_lyqy;// 对联营企业和合营企业的投资收益
	private Double yylr;// 营业利润
	private Double y_yylr;// 营业利润
	private Double yywshr;// 营业外收入
	private Double y_yywshr;// 营业外收入
	private Double btshr;// 补贴收入
	private Double y_btshr;// 补贴收入
	private Double yywzhch;// 营业外支出
	private Double y_yywzhch;// 营业外支出
	private Double flqzch;// 非流动资产处理损失
	private Double y_flqzch;// 非流动资产处理损失

	private Double lrze;// 利润总额
	private Double y_lrze;// 利润总额
	private Double sdshfy;// 所得税费用
	private Double y_sdshfy;// 所得税费用

	private Double jlr;// 净利润
	private Double y_jlr;// 净利润

	private Date createDate;

	private String bzhdw;// 编制单位
	private int isDelete = 0;

	/**
	 * 主键ID
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public Double getYyshr() {
		return yyshr;
	}

	public Double getYychb() {
		return yychb;
	}

	public Double getYyshj() {
		return yyshj;
	}

	public Double getXshfy() {
		return xshfy;
	}

	public Double getGlfy() {
		return glfy;
	}

	public Double getY_yyshr() {
		return y_yyshr;
	}

	public Double getY_yychb() {
		return y_yychb;
	}

	public Double getY_yyshj() {
		return y_yyshj;
	}

	public Double getY_xshfy() {
		return y_xshfy;
	}

	public Double getY_glfy() {
		return y_glfy;
	}

	public Double getY_cwfy() {
		return y_cwfy;
	}

	public Double getY_zijzhssh() {
		return y_zijzhssh;
	}

	public Double getY_gyjzh() {
		return y_gyjzh;
	}

	public Double getY_tzshy() {
		return y_tzshy;
	}

	public Double getY_lyqy() {
		return y_lyqy;
	}

	public Double getY_yylr() {
		return y_yylr;
	}

	public Double getY_yywshr() {
		return y_yywshr;
	}

	public Double getY_btshr() {
		return y_btshr;
	}

	public Double getY_yywzhch() {
		return y_yywzhch;
	}

	public Double getY_flqzch() {
		return y_flqzch;
	}

	public Double getY_lrze() {
		return y_lrze;
	}

	public Double getY_sdshfy() {
		return y_sdshfy;
	}

	public Double getY_jlr() {
		return y_jlr;
	}

	public String getBzhdw() {
		return bzhdw;
	}

	public void setY_yyshr(Double y_yyshr) {
		this.y_yyshr = y_yyshr;
	}

	public void setY_yychb(Double y_yychb) {
		this.y_yychb = y_yychb;
	}

	public void setY_yyshj(Double y_yyshj) {
		this.y_yyshj = y_yyshj;
	}

	public void setY_xshfy(Double y_xshfy) {
		this.y_xshfy = y_xshfy;
	}

	public void setY_glfy(Double y_glfy) {
		this.y_glfy = y_glfy;
	}

	public void setY_cwfy(Double y_cwfy) {
		this.y_cwfy = y_cwfy;
	}

	public void setY_zijzhssh(Double y_zijzhssh) {
		this.y_zijzhssh = y_zijzhssh;
	}

	public void setY_gyjzh(Double y_gyjzh) {
		this.y_gyjzh = y_gyjzh;
	}

	public void setY_tzshy(Double y_tzshy) {
		this.y_tzshy = y_tzshy;
	}

	public void setY_lyqy(Double y_lyqy) {
		this.y_lyqy = y_lyqy;
	}

	public void setY_yylr(Double y_yylr) {
		this.y_yylr = y_yylr;
	}

	public void setY_yywshr(Double y_yywshr) {
		this.y_yywshr = y_yywshr;
	}

	public void setY_btshr(Double y_btshr) {
		this.y_btshr = y_btshr;
	}

	public void setY_yywzhch(Double y_yywzhch) {
		this.y_yywzhch = y_yywzhch;
	}

	public void setY_flqzch(Double y_flqzch) {
		this.y_flqzch = y_flqzch;
	}

	public void setY_lrze(Double y_lrze) {
		this.y_lrze = y_lrze;
	}

	public void setY_sdshfy(Double y_sdshfy) {
		this.y_sdshfy = y_sdshfy;
	}

	public void setY_jlr(Double y_jlr) {
		this.y_jlr = y_jlr;
	}

	public void setBzhdw(String bzhdw) {
		this.bzhdw = bzhdw;
	}

	public Double getCwfy() {
		return cwfy;
	}

	public Double getZijzhssh() {
		return zijzhssh;
	}

	public Double getGyjzh() {
		return gyjzh;
	}

	public Double getTzshy() {
		return tzshy;
	}

	public Double getLyqy() {
		return lyqy;
	}

	public Double getYylr() {
		return yylr;
	}

	public Double getYywshr() {
		return yywshr;
	}

	public Double getBtshr() {
		return btshr;
	}

	public Double getYywzhch() {
		return yywzhch;
	}

	public Double getFlqzch() {
		return flqzch;
	}

	public Double getLrze() {
		return lrze;
	}

	public Double getSdshfy() {
		return sdshfy;
	}

	public Double getJlr() {
		return jlr;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setYyshr(Double yyshr) {
		this.yyshr = yyshr;
	}

	public void setYychb(Double yychb) {
		this.yychb = yychb;
	}

	public void setYyshj(Double yyshj) {
		this.yyshj = yyshj;
	}

	public void setXshfy(Double xshfy) {
		this.xshfy = xshfy;
	}

	public void setGlfy(Double glfy) {
		this.glfy = glfy;
	}

	public void setCwfy(Double cwfy) {
		this.cwfy = cwfy;
	}

	public void setZijzhssh(Double zijzhssh) {
		this.zijzhssh = zijzhssh;
	}

	public void setGyjzh(Double gyjzh) {
		this.gyjzh = gyjzh;
	}

	public void setTzshy(Double tzshy) {
		this.tzshy = tzshy;
	}

	public void setLyqy(Double lyqy) {
		this.lyqy = lyqy;
	}

	public void setYylr(Double yylr) {
		this.yylr = yylr;
	}

	public void setYywshr(Double yywshr) {
		this.yywshr = yywshr;
	}

	public void setBtshr(Double btshr) {
		this.btshr = btshr;
	}

	public void setYywzhch(Double yywzhch) {
		this.yywzhch = yywzhch;
	}

	public void setFlqzch(Double flqzch) {
		this.flqzch = flqzch;
	}

	public void setLrze(Double lrze) {
		this.lrze = lrze;
	}

	public void setSdshfy(Double sdshfy) {
		this.sdshfy = sdshfy;
	}

	public void setJlr(Double jlr) {
		this.jlr = jlr;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
