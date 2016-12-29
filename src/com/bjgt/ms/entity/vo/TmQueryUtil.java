package com.bjgt.ms.entity.vo;

public class TmQueryUtil extends BaseObject {
	private static final long serialVersionUID = 2348798321L;
	// 商标名称
	private String querystr;
	// 商标名称类型
	private String queryStrType;
	// 商标类别
	private String tmlb;
	// 是否查拼音
	private boolean isquerypy;
	// 是否查同音字
	private boolean isqueryty;
	// 是否查形似字
	private boolean isquerytx;
	// 是否查英文同义字
	private boolean isqueryywty;
	// 是否查中文同意字
	private boolean isqueryzwty;
	// 是否查同音汉字
	private boolean isquerytyhz;
	// 起始公告期
	private Integer startggq;
	// 结束公告期
	private Integer endggq;
	// 商标状态（全部0，待审中1，已初审2，已注册3，已驳回4，已销亡5）多个用","隔开
	private String tmstatus;
	// 查询类型（相同查询0/近似查询1）
	private Integer querytype;
	// 每页显示数量
	private Integer pagesize;
	// 分页页数
	private Integer pageno;
	// 查询语句
	private String querystatement;
	//查询字段
	private String filed;
	
	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

	@Override
	public String toString() {
		return "TmQueryUtil [querystr=" + querystr + ", queryStrType="
				+ queryStrType + ", tmlb=" + tmlb + ", isquerypy=" + isquerypy
				+ ", isqueryty=" + isqueryty + ", isquerytx=" + isquerytx
				+ ", isqueryywty=" + isqueryywty + ", isqueryzwty="
				+ isqueryzwty + ", isquerytyhz=" + isquerytyhz + ", startggq="
				+ startggq + ", endggq=" + endggq + ", tmstatus=" + tmstatus
				+ ", querytype=" + querytype + ", pagesize=" + pagesize
				+ ", pageno=" + pageno + "]";
	}

	public TmQueryUtil(String querystr, String queryStrType, String tmlb,
			boolean isquerypy, boolean isqueryty, boolean isquerytx,
			boolean isqueryywty, boolean isqueryzwty, boolean isquerytyhz,
			Integer startggq, Integer endggq, String tmstatus,
			Integer querytype, Integer pagesize, Integer pageno) {
		super();
		this.querystr = querystr;
		this.queryStrType = queryStrType;
		this.tmlb = tmlb;
		this.isquerypy = isquerypy;
		this.isqueryty = isqueryty;
		this.isquerytx = isquerytx;
		this.isqueryywty = isqueryywty;
		this.isqueryzwty = isqueryzwty;
		this.isquerytyhz = isquerytyhz;
		this.startggq = startggq;
		this.endggq = endggq;
		this.tmstatus = tmstatus;
		this.querytype = querytype;
		this.pagesize = pagesize;
		this.pageno = pageno;
		refreshQuerystatement();
	}

	public String getQuerystatement() {
		return querystatement;
	}

	public void setQuerystatement(String querystatement) {
		this.querystatement = querystatement;
	}

	/**
	 * 将字符串累加到原字符串后面
	 * 
	 * @param querystatement
	 */
	public void addQuerystatement(String querystatement) {
		if (this.querystatement == null) {
			this.querystatement = querystatement;
		} else {
			this.querystatement += querystatement;
		}
	}

	/**
	 * 将字符串清空
	 * 
	 * @param querystatement
	 */
	public void clearQuerystatement() {
		this.querystatement = "";
	}

	/**
	 * 刷新字符串 添加公告期，法律状态及其他的查询条件字符串
	 * 
	 * @param querystatement
	 */
	public void refreshQuerystatement() {
		clearQuerystatement();
		// 起始公告期和结束公告期都不为空
		// FIXME 如果用到起始公告期和结束公告期则需要查询ttm表，查TTM表速度会下降很多
		// if (startggq != null && startggq > 0 && endggq != null && endggq > 0)
		// {
		// this.querystatement += "  ";
		// }
	}

	public TmQueryUtil() {
		super();
	}

	public String getQuerystr() {
		return querystr;
	}

	public void setQuerystr(String querystr) {
		this.querystr = querystr;
	}

	public String getQueryStrType() {
		return queryStrType;
	}

	public void setQueryStrType(String queryStrType) {
		this.queryStrType = queryStrType;
	}

	public String getTmlb() {
		return tmlb;
	}

	public void setTmlb(String tmlb) {
		this.tmlb = tmlb;
	}

	public boolean isIsquerypy() {
		return isquerypy;
	}

	public void setIsquerypy(boolean isquerypy) {
		this.isquerypy = isquerypy;
	}

	public boolean isIsqueryty() {
		return isqueryty;
	}

	public void setIsqueryty(boolean isqueryty) {
		this.isqueryty = isqueryty;
	}

	public boolean isIsquerytx() {
		return isquerytx;
	}

	public void setIsquerytx(boolean isquerytx) {
		this.isquerytx = isquerytx;
	}

	public boolean isIsqueryywty() {
		return isqueryywty;
	}

	public void setIsqueryywty(boolean isqueryywty) {
		this.isqueryywty = isqueryywty;
	}

	public boolean isIsqueryzwty() {
		return isqueryzwty;
	}

	public void setIsqueryzwty(boolean isqueryzwty) {
		this.isqueryzwty = isqueryzwty;
	}

	public boolean isIsquerytyhz() {
		return isquerytyhz;
	}

	public void setIsquerytyhz(boolean isquerytyhz) {
		this.isquerytyhz = isquerytyhz;
	}

	public Integer getStartggq() {
		return startggq;
	}

	public void setStartggq(Integer startggq) {
		this.startggq = startggq;
	}

	public Integer getEndggq() {
		return endggq;
	}

	public void setEndggq(Integer endggq) {
		this.endggq = endggq;
	}

	public String getTmstatus() {
		return tmstatus;
	}

	public void setTmstatus(String tmstatus) {
		this.tmstatus = tmstatus;
	}

	public Integer getQuerytype() {
		return querytype;
	}

	public void setQuerytype(Integer querytype) {
		this.querytype = querytype;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

}
