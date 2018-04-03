/*
 * ****************************************************************************
 * COPYRIGHT. HSBC HOLDINGS PLC 2008. ALL RIGHTS RESERVED.
 * 
 * THIS SOFTWARE IS ONLY TO BE USED FOR THE PURPOSE FOR WHICH IT
 * HAS BEEN PROVIDED.  NO PART OF IT IS TO BE REPRODUCED, 
 * DISASSEMBLED, TRANSMITTED, STORED IN A RETRIEVAL SYSTEM NOR
 * TRANSLATED IN ANY HUMAN OR COMPUTER LANGUAGE IN ANY WAY OR 
 * FOR ANY OTHER PURPOSES WHATSOEVER WITHOUT THE PRIOR WRITTEN
 * CONSENT OF HSBC HOLDINGS PLC.
 * ****************************************************************************
 * 
 * Class Name   : ProductBondVo.java
 *
 * Creation Date: Jun 20, 2008
 *
 * Abstract     : 
 *
 * Amendment History :
 *
 *		Amendment ID	:	1
 *		Amendment Date	: 	20090210
 *		CMM/PPCR No.	: 	7.8.8
 *		Programmer		: 	mng
 *		Description		: 	Change default sorting of bonds to availability, tenor, grouped by currency   
 *
 *		Amendment ID	:	2
 *		Amendment Date	: 	20090209
 *		CMM/PPCR No.	: 	8.0
 *		Programmer		: 	tch
 *		Description		: 	support product type description   
 *
 *		Amendment ID	:	3
 *		Amendment Date	:	20090203 
 *		CMM/PPCR No.	:	SPOMS8.0
 *		Programmer		:	wei
 *		Description		:	support multiple entity
 * 
 *		Amendment ID	:	4
 *		Amendment Date	: 	20090213
 *		CMM/PPCR No.	: 	SPOMS8.0
 *		Programmer		: 	mng
 *		Description		: 	Support upload termsheet for bonds   
 *
 *		Amendment ID	:	5
 *		Amendment Date	: 	20090317
 *		CMM/PPCR No.	: 	SPOMS8.1
 *		Programmer		: 	acms
 *		Description		: 	Support Fitch Rating   
 *
 *		Amendment ID	:	6
 *		Amendment Date	: 	20090401
 *		CMM/PPCR No.	: 	SPOMS8.3
 *		Programmer		: 	wei
 *		Description		: 	Bond GSOPS interface
 *   
 *
 * 		Amendment ID	: 	6
 *		Amendment Date	: 	20090414
 *		CMM/PPCR No.	: 	SPOMS 8.1.5
 *		Programmer		: 	lluo
 *		Description		: 	EQ-link enhancement
 *
 *		Amendment ID	:	7
 *		Amendment Date	: 	20090508
 *		CMM/PPCR No.	: 	SPOMS8.3
 *		Programmer		: 	LT
 *		Description		: 	Callable bond supports   
 *
 *		Amendment ID	:	9
 *		Amendment Date	: 	20090722
 *		CMM/PPCR No.	: 	SPOMS8.6
 *		Programmer		: 	acms
 *		Description		: 	Support risk level
 *   
 *		Amendment ID	:	10
 *		Amendment Date	: 	20090807
 *		CMM/PPCR No.	: 	SPOMS8.6
 *		Programmer		: 	LT
 *		Description		: 	FRN Support (Phase 2)   
 *
 * 		Amendment ID	: 	11
 *		Amendment Date	: 	20090820
 *		CMM/PPCR No.	: 	SPOMS 8.6.5
 *		Programmer		: 	LLUO
 *		Description		: 	I&I enhancement
 *
 * 		Amendment ID	: 	12
 *		Amendment Date	: 	20091130
 *		CMM/PPCR No.	: 	SPOMS 8.8
 *		Programmer		: 	ACMS
 *		Description		: 	Print log for SQL 
 *
 * 		Amendment ID	: 	13
 *		Amendment Date	: 	20100112
 *		CMM/PPCR No.	: 	SPOMS 8.9
 *		Programmer		: 	wei
 *		Description		: 	add menudtlid to vo 
 *
 * 		Amendment ID	: 	14
 *		Amendment Date	: 	20110520
 *		CMM/PPCR No.	: 	SPOMS 10.4
 *		Programmer		: 	Louis Luo
 *		Description		: 	IBond
 *
 * 		Amendment ID	: 	15
 *		Amendment Date	: 	20131017
 *		CMM/PPCR No.	: 	SPOMS 11.9 (2013 DEC)
 *		Programmer		: 	jt
 *		Description		: 	(1) Addition of related fields for Note Ratings, Issuer Ratings, Guarantor Ratings
 *							(2) Addition of static method fromString() to ease testing
 *
 * @author 
 * @version 1.0 Jun 20, 2008
 */
package ng.kennie.com.hsbc.hk.hbap.spoms.bnd.vo;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ProductBondVo extends ProductVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4510494758339063167L;
	private int tproductbondid;
	private String bond_code;
	private String bond_type;
	private String issuer;
	// private String issue_country_code;
	private String issue_country;
	private Timestamp issue_date;
	private String guarantor;
	private int currency;
	private String coupon_type;
	private double coupon_rate;
	private String coupon_frequency;
	private Timestamp previous_coupon_date;
	private Timestamp next_coupon_date;
	private String moodys_rating;
	private int moodys_rating_value;
	private String sp_rating;
	private int sp_rating_value;

	private Date noteRatingAsOfDateMoodys;
	private boolean noteRatingUpdatedMoodys;
	private Date noteRatingAsOfDateSP;
	private boolean noteRatingUpdatedSP;

	private String issuerRatingMoodys;
	private int issuerRatingValueMoodys;
	private Date issuerRatingAsOfDateMoodys;
	private boolean issuerRatingUpdatedMoodys;

	private String issuerRatingSP;
	private int issuerRatingValueSP;
	private Date issuerRatingAsOfDateSP;
	private boolean issuerRatingUpdatedSP;

	private String guarantorRatingMoodys;
	private int guarantorRatingValueMoodys;
	private Date guarantorRatingAsOfDateMoodys;
	private boolean guarantorRatingUpdatedMoodys;

	private String guarantorRatingSP;
	private int guarantorRatingValueSP;
	private Date guarantorRatingAsOfDateSP;
	private boolean guarantorRatingUpdatedSP;

	private String tsStatus;
	private Timestamp tsGenTime;
	private String tsTemplateStatus;
	private String tsTemplateDesc;

	private Timestamp maturity_date;
	private double tenor;
	private String collateral_type;
	private double day_accrued;
	private double accrual_interest_per_bond;
	private double accrual_interest_per_million;
	private String interest_rate_basis;
	private String issuance_program;
	private String capital_tier;
	private double initial_issue_size;
	private double outstanding_size;
	private String selling_restriction;
	private String remark;
	private String product_risk_level;
	private String extendable;
	private String callable;
	private Timestamp call_date;
	private Timestamp put_date;
	private Timestamp settlement_date;
	private String product_availability;
	private String trader_risk_book;
	private String libor_spread;
	private String discount_margin;
	// mng 20090213 start @amendment 4
	private List tsFilenames;
	private String tsFoldername;
	// mng 20090213 end @amendment 4

	// acms 20090317
	private String fitch_rating;
	private int fitch_rating_value;
	// acms 20090317 END

	// private int iHashCode;

	private int iEntityId;
	private String sState;
	private String sMaturity;
	private String sYield;
	private String sRating;
	private String sRatingCo;
	private String sRatingOp;
	private String sRatingVa;
	private String sCouponRateOp;
	private String sCouponRate;
	private String sBtnSearch;
	private String sSortBy;
	private String sSort;
	private String sGroupBy;
	private String sProductTypeCode;
	private String sEntityCode;
	private String sAssignToTradingDesk;
	private String sProductSuspension;
	private String sCurrency;
	private String sAction;
	// mng 20090210 start @amendment 1
	private String sBidAvailability;
	private String sAskAvailability;
	private String sSortByAvailability; // "Yes" = sort by availability
	// mng 20090210 end @amendment 1

	private double dMinAmountForTrader;

	private String sHashCode;

	private int iStartRow;
	private int iPageSize;

	private int iProductTypeId;

	private double dAskYieldToMaturity;
	private double dTraderAskSize;
	// wei 20090203 start @amendment 3.1
	private String strProductOwner;
	// wei 20090203 end @amendment 3.1

	// tch 20090209 start @amendment 2.1
	private String productTypeDesc;
	// private String entityCode;
	// tch 20090209 end @amendment 2.1
	// lluo 20090414 start @amendment 5
	private String sIndicatorRule;
	// lluo 20090414 end @amendment 5
	// wei 20090401 start @amendment 6.1
	private String isGhssProd;
	// wei 20090401 end @amendment 6.1

	// LT 20090508 start @amendment 7.1
	private String putable;
	private String convertible;
	private String putSchedules;
	private String callSchedules;
	private String convertSchedules;
	private String convertDetails;
	private double maturity_face_value;
	private String remark2;
	// LT 20090508 end @amendment 7.1
	// lluo 20090520 start @amendment 7.1, 7.2, 7.3
	private double dSellMinSize;
	private double dSellLotSize;
	private double dTraderBidSize;
	private String sBusinessStartTime;
	private String sBusinessEndTime;
	// lluo 20090520 end @amendment 7.1, 7.2, 7.3
	// AX 20090602 start @amendment 8
	private String strFreeAgnstFlag;
	// AX 20090602 end @amendment 8

	// acms 20090722
	private String riskLevel;
	// acms 20090722 END

	// LT 20090807 start @amendment 10.1
	private String libor_base;
	private double previous_coupon_rate;
	private Timestamp previous_coupon_date2;
	// LT 20090807 end @amendment 10.1
	// lluo 20090820 start @amendment 11
	private String strXslPageForPSC;
	// lluo 20090820 end @amendment 11
	// wei 20100112 start @amendment 13.1
	private int iMenuDtlID;
	// wei 20100112 start @amendment 13.1

	private String spomsBondType;
	private String iBondIndex;
	private String iBondFloorCoupon;
	private String inflationIndexRatio;
	private String tipsPotentialAdjPrincipleAtMat;

	// Laura 20161107 Bond for PI customers Start
	private String strSellToPIOnly;
	private String strSellToNonPVCOnly;
	private String strCustomerEligibility;
	private String strSalseProcess;
	// Laura 20161107 End

	public ProductBondVo() {
	}

	// do not modify this function, it is used for hashing
	public String toString() {
		// return
		// "name="+name+",isincode="+isincode+",bloombergid="+bloombergid+",min_size="+min_size+",lot_size="+lot_size
		// +
		// ",bond_code="+bond_code+",bond_type="+bond_type+",issuer="+issuer+",issue_country="+issue_country
		// +
		// ",issue_date="+issue_date+",guarantor="+guarantor+",currency="+currency+",coupon_type="+coupon_type
		// +
		// ",coupon_rate="+coupon_rate+",coupon_frequency="+coupon_frequency+",previous_coupon_date="+previous_coupon_date
		// +
		// ",next_coupon_date="+next_coupon_date+",moodys_rating="+moodys_rating+",sp_rating="+sp_rating
		// +
		// ",maturity_date="+maturity_date+",tenor="+tenor+",collateral_type="+collateral_type
		// +
		// ",day_accrued="+day_accrued+",accrual_interest_per_bond="+accrual_interest_per_bond
		// +
		// ",accrual_interest_per_million="+accrual_interest_per_million+",interest_rate_basis="+interest_rate_basis
		// +
		// ",issuance_program="+issuance_program+",capital_tier="+capital_tier+",initial_issue_size="+initial_issue_size
		// +
		// ",outstanding_size="+outstanding_size+",selling_restriction="+selling_restriction
		// +
		// ",remark="+remark+",product_risk_level="+product_risk_level+",call_date="+call_date+",put_date="+put_date
		// +
		// ",settlement_date="+settlement_date+",sState="+sState+",dMinAmountForTrader="+dMinAmountForTrader
		// +
		// ",product_availability="+product_availability+",trader_risk_book="+trader_risk_book+",libor_spread="+libor_spread
		// + ",discount_margin="+discount_margin";
		return "name=" + name + ",isincode=" + isincode + ",bloombergid=" + bloombergid + ",min_size=" + min_size + ",lot_size=" + lot_size
				+ ",bond_code=" + bond_code + ",bond_type=" + bond_type + ",issuer=" + issuer + ",issue_country=" + issue_country
				+ ",issue_date=" + issue_date + ",guarantor=" + guarantor + ",sCurrency=" + sCurrency + ",coupon_type=" + coupon_type
				+ ",coupon_rate=" + coupon_rate + ",coupon_frequency=" + coupon_frequency + ",previous_coupon_date=" + previous_coupon_date
				+ ",next_coupon_date=" + next_coupon_date + ",moodys_rating=" + moodys_rating + ",sp_rating=" + sp_rating
				+ ",issuerRatingMoodys=" + this.issuerRatingMoodys + ",issuerRatingSP=" + this.issuerRatingSP + ",guarantorRatingMoodys="
				+ this.guarantorRatingMoodys + ",guarantorRatingSP=" + this.guarantorRatingSP + ",maturity_date=" + maturity_date
				+ ",tenor=" + tenor + ",collateral_type=" + collateral_type + ",day_accrued=" + day_accrued + ",accrual_interest_per_bond="
				+ accrual_interest_per_bond + ",accrual_interest_per_million=" + accrual_interest_per_million + ",interest_rate_basis="
				+ interest_rate_basis + ",issuance_program=" + issuance_program + ",capital_tier=" + capital_tier + ",initial_issue_size="
				+ initial_issue_size + ",outstanding_size=" + outstanding_size + ",selling_restriction=" + selling_restriction + ",remark="
				+ remark + ",product_risk_level=" + product_risk_level + ",call_date=" + call_date + ",put_date=" + put_date
				+ ",settlement_date=" + settlement_date + ",dMinAmountForTrader=" + dMinAmountForTrader + ",product_availability="
				+ product_availability + ",trader_risk_book=" + trader_risk_book + ",libor_spread=" + libor_spread + ",discount_margin="
				+ discount_margin + ",extendable=" + extendable + ",callable=" + callable + ",assign_to_trading_desk="
				+ sAssignToTradingDesk + ",product_type_code=" + getSProductTypeCode() + ",fitch_rating=" + getFitch_rating()
				+ ",risk_level=" + getRiskLevel() + ",FreeAgnstFlag=" + strFreeAgnstFlag + ",spoms_bond_type=" + getSpomsBondType()
				+ ",ibond_index=" + getIBondIndex() + ",ibond_floor_coupon=" + getIBondFloorCoupon() + ",inflation_index_ratio="
				+ getInflationIndexRatio() + ",potential_adjust_principle_at_maturity=" + getTipsPotentialAdjPrincipleAtMat()
				+ ",strSellToPIOnly=" + strSellToPIOnly + ",strSellToNonPVCOnly=" + strSellToNonPVCOnly + ",strCustomerEligibility="
				+ strCustomerEligibility + ",strSalseProcess=" + strSalseProcess;
	}

	// ACMS 20091130 @8.8
	public String toStrings() {
		StringBuffer strBuff = new StringBuffer();
		/*
		 * if (this.getClass().getSuperclass() != null) { Class superClass =
		 * this.getClass().getSuperclass(); strBuff.append("ClassName=" +
		 * superClass.getName()); Field [] scf = superClass.getDeclaredFields();
		 * for (int i = 0; i < scf.length; i++) { strBuff.append(","); try {
		 * strBuff.append(scf[i].getName() + "=" +
		 * String.valueOf(scf[i].get(this)));
		 * //LogManager.logMessage(String.valueOf(f[i].get(this)),
		 * LogManager.DEBUG); } catch (Exception e) {
		 * LogManager.logMessage(superClass.getName()+": toStrings()  " +
		 * e.toString(), LogManager.ERROR); } } }
		 */
		Class c = this.getClass();
		strBuff.append("ClassName=" + c.getName());
		Field[] f = c.getDeclaredFields();

		for (int i = 0; i < f.length; i++) {
			strBuff.append(",");
			try {
				strBuff.append(f[i].getName() + "=" + String.valueOf(f[i].get(this)));
				// LogManager.logMessage(String.valueOf(f[i].get(this)),
				// LogManager.DEBUG);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return strBuff.toString();
	}

	/**
	 * **************************** ****TESTING PURPOSE ONLY****
	 * ****************************
	 * 
	 * Construction of ProductBondVo with param as VO.toString() value, which
	 * can be captured from spoms_bond.log easily
	 * 
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public static ProductBondVo fromString(String input) throws Exception {

		ProductBondVo vo = new ProductBondVo();
		Field[] pbFields = ProductBondVo.class.getDeclaredFields();
		Field[] pFields = ProductVo.class.getDeclaredFields();

		// TODO : what if value contains char "," ?

		String nameValuePairs[] = input.split(",");

		int fieldsSet = 0;
		for (String nameValuePair : nameValuePairs) {

			String[] nameAndValue = nameValuePair.split("=");
			String fieldName = nameAndValue[0];
			String fieldValue = null;
			for (int i = 1; i < nameAndValue.length; i++) {
				if (fieldValue != null) {
					fieldValue += nameAndValue[i];
				} else {
					fieldValue = nameAndValue[i];
				}
			}
			boolean found = false;
			for (Field field : pbFields) {
				String[] names = (field.getName().split("\\."));
				if (names[(names.length - 1)].equals(fieldName)) {

					if ("null".equals(fieldValue)) {
						field.set(vo, null);
					} else if (field.getType().toString().equals("int")) {
						field.set(vo, Integer.parseInt(fieldValue));
					} else if (field.getType().toString().equals("double")) {
						field.set(vo, Double.parseDouble(fieldValue));
					} else if (field.getType().toString().equals("boolean")) {
						field.set(vo, Boolean.parseBoolean(fieldValue));
					} else if (field.getType().equals(java.sql.Timestamp.class)) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
						field.set(vo, new java.sql.Timestamp(sdf.parse(fieldValue).getTime()));
					} else {
						field.set(vo, fieldValue);
					}
					System.out.println(
							"SET : fieldName [" + fieldName + "] fieldValue [" + fieldValue + "] fieldType [" + field.getType() + "]");
					fieldsSet++;
					found = true;
					break;
				}
			}

			if (!found) {
				for (Field field : pFields) {
					String[] names = (field.getName().split("\\."));
					if (names[(names.length - 1)].equals(fieldName)) {

						if ("null".equals(fieldValue)) {
							field.set(vo, null);
						} else if (field.getType().toString().equals("int")) {
							field.set(vo, Integer.parseInt(fieldValue));
						} else if (field.getType().toString().equals("double")) {
							field.set(vo, Double.parseDouble(fieldValue));
						} else if (field.getType().toString().equals("boolean")) {
							field.set(vo, Boolean.parseBoolean(fieldValue));
						} else if (field.getType().equals(java.sql.Timestamp.class)) {
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
							field.set(vo, new java.sql.Timestamp(sdf.parse(fieldValue).getTime()));
						} else {
							field.set(vo, fieldValue);
						}
						System.out.println(
								"SET : fieldName [" + fieldName + "] fieldValue [" + fieldValue + "] fieldType [" + field.getType() + "]");
						fieldsSet++;
						found = true;
						break;
					}
				}
			}

			if (!found) {
				System.out.println("NOT SET : fieldName [" + fieldName + "] fieldValue [" + fieldValue + "]");
			}

		}

		System.out.println("Set fields " + fieldsSet + "/" + pbFields.length);

		return vo;
	}

	// ACMS 20091130 @8.8 END
	public String getHashCode() {
		String ret = null;
		if (sHashCode != null && !sHashCode.equals("")) {
			ret = sHashCode;
		} else {
			sHashCode = SHA(toString());
			// ACMS 20090114 7.8.8
			// ret = sHashCode;
			// ACMS 20090114 7.8.8 END

		}

		return ret;
	}

	public static String SHA(String text) {
		return SHA(text, "SHA-256");
	}

	public static String SHA(String text, String hashAlgorithm) {
		MessageDigest md;
		byte[] sha1hash = new byte[50];
		try {
			md = MessageDigest.getInstance(hashAlgorithm);
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			sha1hash = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return convertToHex(sha1hash);
	}

	private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String rl) {
		this.riskLevel = rl;
	}

	/* getters and setters */
	/**
	 * @return Returns the accrual_interest_per_bond.
	 */
	public double getAccrual_interest_per_bond() {
		return accrual_interest_per_bond;
	}

	/**
	 * @param accrual_interest_per_bond
	 *            The accrual_interest_per_bond to set.
	 */
	public void setAccrual_interest_per_bond(double accrual_interest_per_bond) {
		this.accrual_interest_per_bond = accrual_interest_per_bond;
	}

	/**
	 * @return Returns the accrual_interest_per_million.
	 */
	public double getAccrual_interest_per_million() {
		return accrual_interest_per_million;
	}

	/**
	 * @param accrual_interest_per_million
	 *            The accrual_interest_per_million to set.
	 */
	public void setAccrual_interest_per_million(double accrual_interest_per_million) {
		this.accrual_interest_per_million = accrual_interest_per_million;
	}

	/**
	 * @return Returns the bond_code.
	 */
	public String getBond_code() {
		return bond_code;
	}

	/**
	 * @param bond_code
	 *            The bond_code to set.
	 */
	public void setBond_code(String bond_code) {
		this.bond_code = bond_code;
	}

	/**
	 * @return Returns the bond_type.
	 */
	public String getBond_type() {
		return bond_type;
	}

	/**
	 * @param bond_type
	 *            The bond_type to set.
	 */
	public void setBond_type(String bond_type) {
		this.bond_type = bond_type;
	}

	/**
	 * @return Returns the call_date.
	 */
	public Timestamp getCall_date() {
		return call_date;
	}

	/**
	 * @param call_date
	 *            The call_date to set.
	 */
	public void setCall_date(Timestamp call_date) {
		this.call_date = call_date;
	}

	/**
	 * @return Returns the callable.
	 */
	public String getCallable() {
		return callable;
	}

	/**
	 * @param callable
	 *            The callable to set.
	 */
	public void setCallable(String callable) {
		this.callable = callable;
	}

	/**
	 * @return Returns the capital_tier.
	 */
	public String getCapital_tier() {
		return capital_tier;
	}

	/**
	 * @param capital_tier
	 *            The capital_tier to set.
	 */
	public void setCapital_tier(String capital_tier) {
		this.capital_tier = capital_tier;
	}

	/**
	 * @return Returns the collateral_type.
	 */
	public String getCollateral_type() {
		return collateral_type;
	}

	/**
	 * @param collateral_type
	 *            The collateral_type to set.
	 */
	public void setCollateral_type(String collateral_type) {
		this.collateral_type = collateral_type;
	}

	/**
	 * @return Returns the coupon_frequency.
	 */
	public String getCoupon_frequency() {
		return coupon_frequency;
	}

	/**
	 * @param coupon_frequency
	 *            The coupon_frequency to set.
	 */
	public void setCoupon_frequency(String coupon_frequency) {
		this.coupon_frequency = coupon_frequency;
	}

	/**
	 * @return Returns the coupon_rate.
	 */
	public double getCoupon_rate() {
		return coupon_rate;
	}

	/**
	 * @param coupon_rate
	 *            The coupon_rate to set.
	 */
	public void setCoupon_rate(double coupon_rate) {
		this.coupon_rate = coupon_rate;
	}

	/**
	 * @return Returns the coupon_type.
	 */
	public String getCoupon_type() {
		return coupon_type;
	}

	/**
	 * @param coupon_type
	 *            The coupon_type to set.
	 */
	public void setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
	}

	/**
	 * @return Returns the currency.
	 */
	public int getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            The currency to set.
	 */
	public void setCurrency(int currency) {
		this.currency = currency;
	}

	/**
	 * @return Returns the dAskYieldToMaturity.
	 */
	public double getDAskYieldToMaturity() {
		return dAskYieldToMaturity;
	}

	/**
	 * @param askYieldToMaturity
	 *            The dAskYieldToMaturity to set.
	 */
	public void setDAskYieldToMaturity(double askYieldToMaturity) {
		dAskYieldToMaturity = askYieldToMaturity;
	}

	/**
	 * @return Returns the day_accrued.
	 */
	public double getDay_accrued() {
		return day_accrued;
	}

	/**
	 * @param day_accrued
	 *            The day_accrued to set.
	 */
	public void setDay_accrued(double day_accrued) {
		this.day_accrued = day_accrued;
	}

	/**
	 * @return Returns the discount_margin.
	 */
	public String getDiscount_margin() {
		return discount_margin;
	}

	/**
	 * @param discount_margin
	 *            The discount_margin to set.
	 */
	public void setDiscount_margin(String discount_margin) {
		this.discount_margin = discount_margin;
	}

	/**
	 * @return Returns the dMinAmountForTrader.
	 */
	public double getDMinAmountForTrader() {
		return dMinAmountForTrader;
	}

	/**
	 * @param minAmountForTrader
	 *            The dMinAmountForTrader to set.
	 */
	public void setDMinAmountForTrader(double minAmountForTrader) {
		dMinAmountForTrader = minAmountForTrader;
	}

	/**
	 * @return Returns the dTraderAskSize.
	 */
	public double getDTraderAskSize() {
		return dTraderAskSize;
	}

	/**
	 * @param traderAskSize
	 *            The dTraderAskSize to set.
	 */
	public void setDTraderAskSize(double traderAskSize) {
		dTraderAskSize = traderAskSize;
	}

	/**
	 * @return Returns the extendable.
	 */
	public String getExtendable() {
		return extendable;
	}

	/**
	 * @param extendable
	 *            The extendable to set.
	 */
	public void setExtendable(String extendable) {
		this.extendable = extendable;
	}

	/**
	 * @return Returns the guarantor.
	 */
	public String getGuarantor() {
		return guarantor;
	}

	/**
	 * @param guarantor
	 *            The guarantor to set.
	 */
	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	/**
	 * @return Returns the iEntityId.
	 */
	public int getIEntityId() {
		return iEntityId;
	}

	/**
	 * @param entityId
	 *            The iEntityId to set.
	 */
	public void setIEntityId(int entityId) {
		iEntityId = entityId;
	}

	/**
	 * @return Returns the initial_issue_size.
	 */
	public double getInitial_issue_size() {
		return initial_issue_size;
	}

	/**
	 * @param initial_issue_size
	 *            The initial_issue_size to set.
	 */
	public void setInitial_issue_size(double initial_issue_size) {
		this.initial_issue_size = initial_issue_size;
	}

	/**
	 * @return Returns the interest_rate_basis.
	 */
	public String getInterest_rate_basis() {
		return interest_rate_basis;
	}

	/**
	 * @param interest_rate_basis
	 *            The interest_rate_basis to set.
	 */
	public void setInterest_rate_basis(String interest_rate_basis) {
		this.interest_rate_basis = interest_rate_basis;
	}

	/**
	 * @return Returns the iPageSize.
	 */
	public int getIPageSize() {
		return iPageSize;
	}

	/**
	 * @param pageSize
	 *            The iPageSize to set.
	 */
	public void setIPageSize(int pageSize) {
		iPageSize = pageSize;
	}

	/**
	 * @return Returns the iProductTypeId.
	 */
	public int getIProductTypeId() {
		return iProductTypeId;
	}

	/**
	 * @param productTypeId
	 *            The iProductTypeId to set.
	 */
	public void setIProductTypeId(int productTypeId) {
		iProductTypeId = productTypeId;
	}

	/**
	 * @return Returns the issuance_program.
	 */
	public String getIssuance_program() {
		return issuance_program;
	}

	/**
	 * @param issuance_program
	 *            The issuance_program to set.
	 */
	public void setIssuance_program(String issuance_program) {
		this.issuance_program = issuance_program;
	}

	/**
	 * @return Returns the issue_country.
	 */
	public String getIssue_country() {
		return issue_country;
	}

	/**
	 * @param issue_country
	 *            The issue_country to set.
	 */
	public void setIssue_country(String issue_country) {
		this.issue_country = issue_country;
	}

	/**
	 * @return Returns the issue_date.
	 */
	public Timestamp getIssue_date() {
		return issue_date;
	}

	/**
	 * @param issue_date
	 *            The issue_date to set.
	 */
	public void setIssue_date(Timestamp issue_date) {
		this.issue_date = issue_date;
	}

	/**
	 * @return Returns the issuer.
	 */
	public String getIssuer() {
		return issuer;
	}

	/**
	 * @param issuer
	 *            The issuer to set.
	 */
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	/**
	 * @return Returns the iStartRow.
	 */
	public int getIStartRow() {
		return iStartRow;
	}

	/**
	 * @param startRow
	 *            The iStartRow to set.
	 */
	public void setIStartRow(int startRow) {
		iStartRow = startRow;
	}

	/**
	 * @return Returns the libor_spread.
	 */
	public String getLibor_spread() {
		return libor_spread;
	}

	/**
	 * @param libor_spread
	 *            The libor_spread to set.
	 */
	public void setLibor_spread(String libor_spread) {
		this.libor_spread = libor_spread;
	}

	/**
	 * @return Returns the maturity_date.
	 */
	public Timestamp getMaturity_date() {
		return maturity_date;
	}

	/**
	 * @param maturity_date
	 *            The maturity_date to set.
	 */
	public void setMaturity_date(Timestamp maturity_date) {
		this.maturity_date = maturity_date;
	}

	/**
	 * @return Returns the moodys_rating.
	 */
	public String getMoodys_rating() {
		return moodys_rating;
	}

	// acms 20090317 8.1
	public String getFitch_rating() {
		return this.fitch_rating;
	}

	public void setFitch_rating(String fitch_rating) {
		this.fitch_rating = fitch_rating;
	}

	public int getFitch_rating_value() {
		return this.fitch_rating_value;
	}

	public void setFitch_rating_value(int fitch_rating_value) {
		this.fitch_rating_value = fitch_rating_value;
	}
	// acms 20090317 END

	/**
	 * @param moodys_rating
	 *            The moodys_rating to set.
	 */
	public void setMoodys_rating(String moodys_rating) {
		this.moodys_rating = moodys_rating;
	}

	/**
	 * @return Returns the moodys_rating_value.
	 */
	public int getMoodys_rating_value() {
		return moodys_rating_value;
	}

	/**
	 * @param moodys_rating_value
	 *            The moodys_rating_value to set.
	 */
	public void setMoodys_rating_value(int moodys_rating_value) {
		this.moodys_rating_value = moodys_rating_value;
	}

	/**
	 * @return Returns the next_coupon_date.
	 */
	public Timestamp getNext_coupon_date() {
		return next_coupon_date;
	}

	/**
	 * @param next_coupon_date
	 *            The next_coupon_date to set.
	 */
	public void setNext_coupon_date(Timestamp next_coupon_date) {
		this.next_coupon_date = next_coupon_date;
	}

	/**
	 * @return Returns the outstanding_size.
	 */
	public double getOutstanding_size() {
		return outstanding_size;
	}

	/**
	 * @param outstanding_size
	 *            The outstanding_size to set.
	 */
	public void setOutstanding_size(double outstanding_size) {
		this.outstanding_size = outstanding_size;
	}

	/**
	 * @return Returns the previous_coupon_date.
	 */
	public Timestamp getPrevious_coupon_date() {
		return previous_coupon_date;
	}

	/**
	 * @param previous_coupon_date
	 *            The previous_coupon_date to set.
	 */
	public void setPrevious_coupon_date(Timestamp previous_coupon_date) {
		this.previous_coupon_date = previous_coupon_date;
	}

	/**
	 * @return Returns the product_availability.
	 */
	public String getProduct_availability() {
		return product_availability;
	}

	/**
	 * @param product_availability
	 *            The product_availability to set.
	 */
	public void setProduct_availability(String product_availability) {
		this.product_availability = product_availability;
	}

	/**
	 * @return Returns the product_risk_level.
	 */
	public String getProduct_risk_level() {
		return product_risk_level;
	}

	/**
	 * @param product_risk_level
	 *            The product_risk_level to set.
	 */
	public void setProduct_risk_level(String product_risk_level) {
		this.product_risk_level = product_risk_level;
	}

	/**
	 * @return Returns the put_date.
	 */
	public Timestamp getPut_date() {
		return put_date;
	}

	/**
	 * @param put_date
	 *            The put_date to set.
	 */
	public void setPut_date(Timestamp put_date) {
		this.put_date = put_date;
	}

	/**
	 * @return Returns the remark.
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            The remark to set.
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	// mng 20090213 start @amendment 4
	public List getTSFilenames() {
		return this.tsFilenames;
	}

	public void setTSFilenames(List filenames) {
		this.tsFilenames = filenames;
	}

	public String getTSFoldername() {
		return this.tsFoldername;
	}

	public void setTSFoldername(String foldername) {
		this.tsFoldername = foldername;
	}

	// mng 20090213 end @amendment 4
	/**
	 * @return Returns the sAction.
	 */
	public String getSAction() {
		return sAction;
	}

	/**
	 * @param action
	 *            The sAction to set.
	 */
	public void setSAction(String action) {
		sAction = action;
	}

	/**
	 * @return Returns the sAssignToTradingDesk.
	 */
	public String getSAssignToTradingDesk() {
		return sAssignToTradingDesk;
	}

	/**
	 * @param assignToTradingDesk
	 *            The sAssignToTradingDesk to set.
	 */
	public void setSAssignToTradingDesk(String assignToTradingDesk) {
		sAssignToTradingDesk = assignToTradingDesk;
	}

	/**
	 * @return Returns the sBtnSearch.
	 */
	public String getSBtnSearch() {
		return sBtnSearch;
	}

	/**
	 * @param btnSearch
	 *            The sBtnSearch to set.
	 */
	public void setSBtnSearch(String btnSearch) {
		sBtnSearch = btnSearch;
	}

	/**
	 * @return Returns the sCouponRate.
	 */
	public String getSCouponRate() {
		return sCouponRate;
	}

	/**
	 * @param couponRate
	 *            The sCouponRate to set.
	 */
	public void setSCouponRate(String couponRate) {
		sCouponRate = couponRate;
	}

	/**
	 * @return Returns the sCouponRateOp.
	 */
	public String getSCouponRateOp() {
		return sCouponRateOp;
	}

	/**
	 * @param couponRateOp
	 *            The sCouponRateOp to set.
	 */
	public void setSCouponRateOp(String couponRateOp) {
		sCouponRateOp = couponRateOp;
	}

	/**
	 * @return Returns the sCurrency.
	 */
	public String getSCurrency() {
		return sCurrency;
	}

	/**
	 * @param currency
	 *            The sCurrency to set.
	 */
	public void setSCurrency(String currency) {
		sCurrency = currency;
	}

	/**
	 * @return Returns the selling_restriction.
	 */
	public String getSelling_restriction() {
		return selling_restriction;
	}

	/**
	 * @param selling_restriction
	 *            The selling_restriction to set.
	 */
	public void setSelling_restriction(String selling_restriction) {
		this.selling_restriction = selling_restriction;
	}

	/**
	 * @return Returns the sEntityCode.
	 */
	public String getSEntityCode() {
		return sEntityCode;
	}

	/**
	 * @param entityCode
	 *            The sEntityCode to set.
	 */
	public void setSEntityCode(String entityCode) {
		sEntityCode = entityCode;
	}

	/**
	 * @return Returns the settlement_date.
	 */
	public Timestamp getSettlement_date() {
		return settlement_date;
	}

	/**
	 * @param settlement_date
	 *            The settlement_date to set.
	 */
	public void setSettlement_date(Timestamp settlement_date) {
		this.settlement_date = settlement_date;
	}

	/**
	 * @return Returns the sGroupBy.
	 */
	public String getSGroupBy() {
		return sGroupBy;
	}

	/**
	 * @param groupBy
	 *            The sGroupBy to set.
	 */
	public void setSGroupBy(String groupBy) {
		sGroupBy = groupBy;
	}

	/**
	 * @return Returns the sHashCode.
	 */
	public String getSHashCode() {
		return sHashCode;
	}

	/**
	 * @param hashCode
	 *            The sHashCode to set.
	 */
	public void setSHashCode(String hashCode) {
		sHashCode = hashCode;
	}

	/**
	 * @return Returns the sMaturity.
	 */
	public String getSMaturity() {
		return sMaturity;
	}

	/**
	 * @param maturity
	 *            The sMaturity to set.
	 */
	public void setSMaturity(String maturity) {
		sMaturity = maturity;
	}

	/**
	 * @return Returns the sp_rating.
	 */
	public String getSp_rating() {
		return sp_rating;
	}

	/**
	 * @param sp_rating
	 *            The sp_rating to set.
	 */
	public void setSp_rating(String sp_rating) {
		this.sp_rating = sp_rating;
	}

	/**
	 * @return Returns the sp_rating_value.
	 */
	public int getSp_rating_value() {
		return sp_rating_value;
	}

	/**
	 * @param sp_rating_value
	 *            The sp_rating_value to set.
	 */
	public void setSp_rating_value(int sp_rating_value) {
		this.sp_rating_value = sp_rating_value;
	}

	/**
	 * @return Returns the sProductSuspension.
	 */
	public String getSProductSuspension() {
		return sProductSuspension;
	}

	/**
	 * @param productSuspension
	 *            The sProductSuspension to set.
	 */
	public void setSProductSuspension(String productSuspension) {
		sProductSuspension = productSuspension;
	}

	/**
	 * @return Returns the sProductTypeCode.
	 */
	public String getSProductTypeCode() {
		return sProductTypeCode;
	}

	/**
	 * @param productTypeCode
	 *            The sProductTypeCode to set.
	 */
	public void setSProductTypeCode(String productTypeCode) {
		sProductTypeCode = productTypeCode;
	}

	/**
	 * @return Returns the sRating.
	 */
	public String getSRating() {
		return sRating;
	}

	/**
	 * @param rating
	 *            The sRating to set.
	 */
	public void setSRating(String rating) {
		sRating = rating;
	}

	/**
	 * @return Returns the sRatingCo.
	 */
	public String getSRatingCo() {
		return sRatingCo;
	}

	/**
	 * @param ratingCo
	 *            The sRatingCo to set.
	 */
	public void setSRatingCo(String ratingCo) {
		sRatingCo = ratingCo;
	}

	/**
	 * @return Returns the sRatingOp.
	 */
	public String getSRatingOp() {
		return sRatingOp;
	}

	/**
	 * @param ratingOp
	 *            The sRatingOp to set.
	 */
	public void setSRatingOp(String ratingOp) {
		sRatingOp = ratingOp;
	}

	/**
	 * @return Returns the sRatingVa.
	 */
	public String getSRatingVa() {
		return sRatingVa;
	}

	/**
	 * @param ratingVa
	 *            The sRatingVa to set.
	 */
	public void setSRatingVa(String ratingVa) {
		sRatingVa = ratingVa;
	}

	/**
	 * @return Returns the sSort.
	 */
	public String getSSort() {
		return sSort;
	}

	/**
	 * @param sort
	 *            The sSort to set.
	 */
	public void setSSort(String sort) {
		sSort = sort;
	}

	/**
	 * @return Returns the sSortBy.
	 */
	public String getSSortBy() {
		return sSortBy;
	}

	/**
	 * @param sortBy
	 *            The sSortBy to set.
	 */
	public void setSSortBy(String sortBy) {
		sSortBy = sortBy;
	}

	/**
	 * @return Returns the sState.
	 */
	public String getSState() {
		return sState;
	}

	/**
	 * @param state
	 *            The sState to set.
	 */
	public void setSState(String state) {
		sState = state;
	}

	/**
	 * @return Returns the sYield.
	 */
	public String getSYield() {
		return sYield;
	}

	/**
	 * @param yield
	 *            The sYield to set.
	 */
	public void setSYield(String yield) {
		sYield = yield;
	}

	/**
	 * @return Returns the tenor.
	 */
	public double getTenor() {
		return tenor;
	}

	/**
	 * @param tenor
	 *            The tenor to set.
	 */
	public void setTenor(double tenor) {
		this.tenor = tenor;
	}

	/**
	 * @return Returns the tproductbondid.
	 */
	public int getTproductbondid() {
		return tproductbondid;
	}

	/**
	 * @param tproductbondid
	 *            The tproductbondid to set.
	 */
	public void setTproductbondid(int tproductbondid) {
		this.tproductbondid = tproductbondid;
	}

	/**
	 * @return Returns the trader_risk_book.
	 */
	public String getTrader_risk_book() {
		return trader_risk_book;
	}

	/**
	 * @param trader_risk_book
	 *            The trader_risk_book to set.
	 */
	public void setTrader_risk_book(String trader_risk_book) {
		this.trader_risk_book = trader_risk_book;
	}

	// mng 20090210 start @amendment 1
	public String getSBidAvailability() {
		return this.sBidAvailability;
	}

	public void setSBidAvailability(String ava) {
		this.sBidAvailability = ava;
	}

	public String getSAskAvailability() {
		return this.sAskAvailability;
	}

	public void setSAskAvailability(String ava) {
		this.sAskAvailability = ava;
	}

	public String getSSortByAvailability() {
		return this.sSortByAvailability;
	}

	public void setSSortByAvailability(String sortByAva) {
		this.sSortByAvailability = sortByAva;
	}

	// mng 20090210 end @amendment 1
	// wei 20090203 start @amendment 2.1
	/**
	 * @return Returns the strProductOwner.
	 */
	public String getProduct_owner() {
		return strProductOwner;
	}

	/**
	 * @param strProductOwner
	 *            The strProductOwner to set.
	 */
	public void setProduct_owner(String strProductOwner) {
		this.strProductOwner = strProductOwner;
	}
	// wei 20090203 end @amendment 2.1

	// tch 20090209 start @amendment 2.1
	/**
	 * @return Returns the productTypeDesc.
	 */
	public String getProductTypeDesc() {
		return productTypeDesc;
	}

	/**
	 * @param productTypeDesc
	 *            The productTypeDesc to set.
	 */
	public void setProductTypeDesc(String productTypeDesc) {
		this.productTypeDesc = productTypeDesc;
	}
	/**
	 * @return Returns the strEntityCode.
	 */
	// public String getEntityCode() {
	// return entityCode;
	// }
	/**
	 * @param strEntityCode
	 *            The strEntityCode to set.
	 */

	// public void setEntityCode(String entityCode) {
	// this.entityCode = entityCode;
	// }
	// tch 20090209 end @amendment 2.1
	// lluo 20090414 start @amendment 6
	/**
	 * @return Returns the sIndicatorRule.
	 */
	public String getSIndicatorRule() {
		return sIndicatorRule;
	}

	/**
	 * @param indicatorRule
	 *            The sIndicatorRule to set.
	 */
	public void setSIndicatorRule(String indicatorRule) {
		sIndicatorRule = indicatorRule;
	}

	// lluo 20090414 end @amendment 6
	// wei 20090401 start @amendment 6.1
	/**
	 * @return Returns the isGHSSProd.
	 */
	public String getIsGhssProd() {
		return isGhssProd;
	}

	/**
	 * @param isGHSSProd
	 *            The isGHSSProd to set.
	 */
	public void setIsGhssProd(String isGhssProd) {
		this.isGhssProd = isGhssProd;
	}
	// wei 20090401 end @amendment 6.1

	// LT 20090508 start @amendment 7.1
	/**
	 * @return Returns the convertible.
	 */
	public String getConvertible() {
		return convertible;
	}

	/**
	 * @param convertible
	 *            The convertible to set.
	 */
	public void setConvertible(String convertible) {
		this.convertible = convertible;
	}

	/**
	 * @return Returns the putable.
	 */
	public String getPutable() {
		return putable;
	}

	/**
	 * @param putable
	 *            The putable to set.
	 */
	public void setPutable(String putable) {
		this.putable = putable;
	}

	/**
	 * @return Returns the callSchedules.
	 */
	public String getCallSchedules() {
		return callSchedules;
	}

	/**
	 * @param callSchedules
	 *            The callSchedules to set.
	 */
	public void setCallSchedules(String callSchedules) {
		this.callSchedules = callSchedules;
	}

	/**
	 * @return Returns the convertSchedules.
	 */
	public String getConvertSchedules() {
		return convertSchedules;
	}

	/**
	 * @param convertSchedules
	 *            The convertSchedules to set.
	 */
	public void setConvertSchedules(String convertSchedules) {
		this.convertSchedules = convertSchedules;
	}

	/**
	 * @return Returns the putSchedules.
	 */
	public String getPutSchedules() {
		return putSchedules;
	}

	/**
	 * @param putSchedules
	 *            The putSchedules to set.
	 */
	public void setPutSchedules(String putSchedules) {
		this.putSchedules = putSchedules;
	}

	/**
	 * @return Returns the convertDetails.
	 */
	public String getConvertDetails() {
		return convertDetails;
	}

	/**
	 * @param convertDetails
	 *            The convertDetails to set.
	 */
	public void setConvertDetails(String convertDetails) {
		this.convertDetails = convertDetails;
	}

	/**
	 * @return Returns the remark2.
	 */
	public String getRemark2() {
		return remark2;
	}

	/**
	 * @param remark2
	 *            The remark2 to set.
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * @return Returns the maturity_face_value.
	 */
	public double getMaturity_face_value() {
		return maturity_face_value;
	}

	/**
	 * @param maturity_face_value
	 *            The maturity_face_value to set.
	 */
	public void setMaturity_face_value(double maturity_face_value) {
		this.maturity_face_value = maturity_face_value;
	}

	// LT 20090508 end @amendment 7.1
	// lluo 20090520 start @amendment 7.1, 7.2, 7.3
	/**
	 * @return Returns the dSellLotSize.
	 */
	public double getDSellLotSize() {
		return dSellLotSize;
	}

	/**
	 * @param sellLotSize
	 *            The dSellLotSize to set.
	 */
	public void setDSellLotSize(double sellLotSize) {
		dSellLotSize = sellLotSize;
	}

	/**
	 * @return Returns the dSellMinSize.
	 */
	public double getDSellMinSize() {
		return dSellMinSize;
	}

	/**
	 * @param sellMinSize
	 *            The dSellMinSize to set.
	 */
	public void setDSellMinSize(double sellMinSize) {
		dSellMinSize = sellMinSize;
	}

	/**
	 * @return Returns the dTraderBidSize.
	 */
	public double getDTraderBidSize() {
		return dTraderBidSize;
	}

	/**
	 * @param traderBidSize
	 *            The dTraderBidSize to set.
	 */
	public void setDTraderBidSize(double traderBidSize) {
		dTraderBidSize = traderBidSize;
	}

	/**
	 * @return Returns the sBusinessEndTime.
	 */
	public String getSBusinessEndTime() {
		return sBusinessEndTime;
	}

	/**
	 * @param businessEndTime
	 *            The sBusinessEndTime to set.
	 */
	public void setSBusinessEndTime(String businessEndTime) {
		sBusinessEndTime = businessEndTime;
	}

	/**
	 * @return Returns the sBusinessStartTime.
	 */
	public String getSBusinessStartTime() {
		return sBusinessStartTime;
	}

	/**
	 * @param businessStartTime
	 *            The sBusinessStartTime to set.
	 */
	public void setSBusinessStartTime(String businessStartTime) {
		sBusinessStartTime = businessStartTime;
	}
	// lluo 20090520 end @amendment 7.1, 7.2, 7.3

	// AX 20090602 start @amendment 8
	/**
	 * @return Returns the bloombergFlag.
	 */
	public String getStrFreeAgnstFlag() {
		return strFreeAgnstFlag;
	}

	/**
	 * @param strFreeAgnstFlag
	 *            The bloombergFlag to set.
	 */
	public void setStrFreeAgnstFlag(String strFreeAgnstFlag) {
		this.strFreeAgnstFlag = strFreeAgnstFlag;
	}
	// AX 20090602 end @amendment 8

	// LT 20090807 start @amendment 10.1
	/**
	 * @return Returns the libor_base.
	 */
	public String getLibor_base() {
		return libor_base;
	}

	/**
	 * @param libor_base
	 *            The libor_base to set.
	 */
	public void setLibor_base(String libor_base) {
		this.libor_base = libor_base;
	}

	/**
	 * @return Returns the previous_coupon_date2.
	 */
	public Timestamp getPrevious_coupon_date2() {
		return previous_coupon_date2;
	}

	/**
	 * @param previous_coupon_date2
	 *            The previous_coupon_date2 to set.
	 */
	public void setPrevious_coupon_date2(Timestamp previous_coupon_date2) {
		this.previous_coupon_date2 = previous_coupon_date2;
	}

	/**
	 * @return Returns the previous_coupon_rate.
	 */
	public double getPrevious_coupon_rate() {
		return previous_coupon_rate;
	}

	/**
	 * @param previous_coupon_rate
	 *            The previous_coupon_rate to set.
	 */
	public void setPrevious_coupon_rate(double previous_coupon_rate) {
		this.previous_coupon_rate = previous_coupon_rate;
	}

	// LT 20090807 end @amendment 10.1
	// lluo 20090820 start @amendment 11
	/**
	 * @return Returns the strXslPageForPSC.
	 */
	public String getStrXslPageForPSC() {
		return strXslPageForPSC;
	}

	/**
	 * @param strXslPageForPSC
	 *            The strXslPageForPSC to set.
	 */
	public void setStrXslPageForPSC(String strXslPageForPSC) {
		this.strXslPageForPSC = strXslPageForPSC;
	}

	// lluo 20090820 end @amendment 11
	// wei 20100112 start @amendment 13
	/**
	 * @return Returns the iMenuDtlID.
	 */
	public int getIMenuDtlID() {
		return iMenuDtlID;
	}

	/**
	 * @param menuDtlID
	 *            The iMenuDtlID to set.
	 */
	public void setIMenuDtlID(int menuDtlID) {
		iMenuDtlID = menuDtlID;
	}
	// wei 20100112 end @amendment 13

	public String getSpomsBondType() {
		return spomsBondType;
	}

	public void setSpomsBondType(String spomsBondType) {
		this.spomsBondType = spomsBondType;
	}

	public String getIBondIndex() {
		return iBondIndex;
	}

	public void setIBondIndex(String bondIndex) {
		iBondIndex = bondIndex;
	}

	public String getIBondFloorCoupon() {
		return iBondFloorCoupon;
	}

	public void setIBondFloorCoupon(String bondFloorCoupon) {
		iBondFloorCoupon = bondFloorCoupon;
	}

	public String getInflationIndexRatio() {
		return inflationIndexRatio;
	}

	public void setInflationIndexRatio(String inflationIndexRatio) {
		this.inflationIndexRatio = inflationIndexRatio;
	}

	public String getTipsPotentialAdjPrincipleAtMat() {
		return tipsPotentialAdjPrincipleAtMat;
	}

	public void setTipsPotentialAdjPrincipleAtMat(String tipsPotentialAdjPrincipleAtMat) {
		this.tipsPotentialAdjPrincipleAtMat = tipsPotentialAdjPrincipleAtMat;
	}

	public Date getNoteRatingAsOfDateMoodys() {
		return noteRatingAsOfDateMoodys;
	}

	public void setNoteRatingAsOfDateMoodys(Date noteRatingAsOfDateMoodys) {
		this.noteRatingAsOfDateMoodys = noteRatingAsOfDateMoodys;
	}

	public Date getNoteRatingAsOfDateSP() {
		return noteRatingAsOfDateSP;
	}

	public void setNoteRatingAsOfDateSP(Date noteRatingAsOfDateSP) {
		this.noteRatingAsOfDateSP = noteRatingAsOfDateSP;
	}

	public String getIssuerRatingMoodys() {
		return issuerRatingMoodys;
	}

	public void setIssuerRatingMoodys(String issuerRatingMoodys) {
		this.issuerRatingMoodys = issuerRatingMoodys;
	}

	public int getIssuerRatingValueMoodys() {
		return issuerRatingValueMoodys;
	}

	public void setIssuerRatingValueMoodys(int issuerRatingValueMoodys) {
		this.issuerRatingValueMoodys = issuerRatingValueMoodys;
	}

	public Date getIssuerRatingAsOfDateMoodys() {
		return issuerRatingAsOfDateMoodys;
	}

	public void setIssuerRatingAsOfDateMoodys(Date issuerRatingAsOfDateMoodys) {
		this.issuerRatingAsOfDateMoodys = issuerRatingAsOfDateMoodys;
	}

	public String getIssuerRatingSP() {
		return issuerRatingSP;
	}

	public void setIssuerRatingSP(String issuerRatingSP) {
		this.issuerRatingSP = issuerRatingSP;
	}

	public int getIssuerRatingValueSP() {
		return issuerRatingValueSP;
	}

	public void setIssuerRatingValueSP(int issuerRatingValueSP) {
		this.issuerRatingValueSP = issuerRatingValueSP;
	}

	public Date getIssuerRatingAsOfDateSP() {
		return issuerRatingAsOfDateSP;
	}

	public void setIssuerRatingAsOfDateSP(Date issuerRatingAsOfDateSP) {
		this.issuerRatingAsOfDateSP = issuerRatingAsOfDateSP;
	}

	public String getGuarantorRatingMoodys() {
		return guarantorRatingMoodys;
	}

	public void setGuarantorRatingMoodys(String guarantorRatingMoodys) {
		this.guarantorRatingMoodys = guarantorRatingMoodys;
	}

	public int getGuarantorRatingValueMoodys() {
		return guarantorRatingValueMoodys;
	}

	public void setGuarantorRatingValueMoodys(int guarantorRatingValueMoodys) {
		this.guarantorRatingValueMoodys = guarantorRatingValueMoodys;
	}

	public Date getGuarantorRatingAsOfDateMoodys() {
		return guarantorRatingAsOfDateMoodys;
	}

	public void setGuarantorRatingAsOfDateMoodys(Date guarantorRatingAsOfDateMoodys) {
		this.guarantorRatingAsOfDateMoodys = guarantorRatingAsOfDateMoodys;
	}

	public String getGuarantorRatingSP() {
		return guarantorRatingSP;
	}

	public void setGuarantorRatingSP(String guarantorRatingSP) {
		this.guarantorRatingSP = guarantorRatingSP;
	}

	public int getGuarantorRatingValueSP() {
		return guarantorRatingValueSP;
	}

	public void setGuarantorRatingValueSP(int guarantorRatingValueSP) {
		this.guarantorRatingValueSP = guarantorRatingValueSP;
	}

	public Date getGuarantorRatingAsOfDateSP() {
		return guarantorRatingAsOfDateSP;
	}

	public void setGuarantorRatingAsOfDateSP(Date guarantorRatingAsOfDateSP) {
		this.guarantorRatingAsOfDateSP = guarantorRatingAsOfDateSP;
	}

	public String getTsStatus() {
		return tsStatus;
	}

	public void setTsStatus(String tsStatus) {
		this.tsStatus = tsStatus;
	}

	public Timestamp getTsGenTime() {
		return tsGenTime;
	}

	public void setTsGenTime(Timestamp tsGenTime) {
		this.tsGenTime = tsGenTime;
	}

	public String getTsTemplateStatus() {
		return tsTemplateStatus;
	}

	public void setTsTemplateStatus(String tsTemplateStatus) {
		this.tsTemplateStatus = tsTemplateStatus;
	}

	public boolean isNoteRatingUpdatedMoodys() {
		return noteRatingUpdatedMoodys;
	}

	public void setNoteRatingUpdatedMoodys(boolean noteRatingUpdatedMoodys) {
		this.noteRatingUpdatedMoodys = noteRatingUpdatedMoodys;
	}

	public boolean isNoteRatingUpdatedSP() {
		return noteRatingUpdatedSP;
	}

	public void setNoteRatingUpdatedSP(boolean noteRatingUpdatedSP) {
		this.noteRatingUpdatedSP = noteRatingUpdatedSP;
	}

	public boolean isIssuerRatingUpdatedMoodys() {
		return issuerRatingUpdatedMoodys;
	}

	public void setIssuerRatingUpdatedMoodys(boolean issuerRatingUpdatedMoodys) {
		this.issuerRatingUpdatedMoodys = issuerRatingUpdatedMoodys;
	}

	public boolean isIssuerRatingUpdatedSP() {
		return issuerRatingUpdatedSP;
	}

	public void setIssuerRatingUpdatedSP(boolean issuerRatingUpdatedSP) {
		this.issuerRatingUpdatedSP = issuerRatingUpdatedSP;
	}

	public boolean isGuarantorRatingUpdatedMoodys() {
		return guarantorRatingUpdatedMoodys;
	}

	public void setGuarantorRatingUpdatedMoodys(boolean guarantorRatingUpdatedMoodys) {
		this.guarantorRatingUpdatedMoodys = guarantorRatingUpdatedMoodys;
	}

	public boolean isGuarantorRatingUpdatedSP() {
		return guarantorRatingUpdatedSP;
	}

	public void setGuarantorRatingUpdatedSP(boolean guarantorRatingUpdatedSP) {
		this.guarantorRatingUpdatedSP = guarantorRatingUpdatedSP;
	}

	public String getTsTemplateDesc() {
		return tsTemplateDesc;
	}

	public void setTsTemplateDesc(String tsTemplateDesc) {
		this.tsTemplateDesc = tsTemplateDesc;
	}

	// Laura 20161107 Bond for PI customers Start
	public void setStrSellToPIOnly(String strSellToPIOnly) {
		this.strSellToPIOnly = strSellToPIOnly;
	}

	public String getStrSellToPIOnly() {
		return strSellToPIOnly;
	}

	public void setStrSellToNonPVCOnly(String strSellToNonPVCOnly) {
		this.strSellToNonPVCOnly = strSellToNonPVCOnly;
	}

	public String getStrSellToNonPVCOnly() {
		return strSellToNonPVCOnly;
	}

	public void setStrCustomerEligibility(String strCustomerEligibility) {
		this.strCustomerEligibility = strCustomerEligibility;
	}

	public String getStrCustomerEligibility() {
		return strCustomerEligibility;
	}

	public void setStrSalseProcess(String strSalseProcess) {
		this.strSalseProcess = strSalseProcess;
	}

	public String getStrSalseProcess() {
		return strSalseProcess;
	}
	// Laura 20161107 End

}
