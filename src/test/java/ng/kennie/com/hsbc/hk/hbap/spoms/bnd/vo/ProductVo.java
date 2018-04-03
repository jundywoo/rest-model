/*
 * 		Amendment ID	: 	1
 *		Amendment Date	: 	20091130
 *		CMM/PPCR No.	: 	SPOMS 8.8
 *		Programmer		: 	ACMS
 *		Description		: 	Print log for SQL 
 *
 * 		Amendment ID	: 	2
 *		Amendment Date	: 	20100329
 *		CMM/PPCR No.	: 	SPOMS 9.1
 *		Programmer		: 	ACMS
 *		Description		: 	1H Phase 2B 

**/


package ng.kennie.com.hsbc.hk.hbap.spoms.bnd.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 */
public class ProductVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6708307943197547747L;
	protected int tproductsid;
	protected int producttypeid;
	protected String name;
	protected String isincode;
	protected String bloombergid;
	protected double min_size;
	protected double lot_size;
	protected int created_by;
	protected Timestamp created_date;
	protected int last_modified_by;
	protected Timestamp last_modified_date;

	public String toString() {
		return "tproductid="+tproductsid;
	}
	// ACMS 20091130 @9.1
	
	public ProductVo getProductVo () 
	{
	    ProductVo pVO = new ProductVo();
	    pVO.setTproductsid(tproductsid);
	    pVO.setProducttypeid(producttypeid);
	    pVO.setName(name);
	    pVO.setIsincode(isincode);
	    pVO.setBloombergid(bloombergid);
	    pVO.setMin_size(min_size);
	    pVO.setLot_size(lot_size);
	    pVO.setCreated_by(created_by);
	    pVO.setCreated_date(created_date);
	    pVO.setLast_modified_by(last_modified_by);
	    pVO.setLast_modified_date(last_modified_date);

	    return pVO;
	}
	// ACMS 20091130 @9.1 END
	
	public String toStrings()
	{
	    StringBuffer strBuff = new StringBuffer();
	    Class c = this.getClass();
	    strBuff.append("ClassName=" + c.getName());
	    Field [] f = c.getDeclaredFields();
	    for (int i = 0; i < f.length; i++)
	    {
	        strBuff.append(",");
	        try
	        {
	            strBuff.append(f[i].getName() + "=" + String.valueOf(f[i].get(this)));
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    return strBuff.toString();
	}
	// ACMS 20091130 @8.8 END

	/**
	 * @return Returns the bloombergid.
	 */
	public String getBloombergid() {
		return bloombergid;
	}
	/**
	 * @param bloombergid The bloombergid to set.
	 */
	public void setBloombergid(String bloombergid) {
		this.bloombergid = bloombergid;
	}
	/**
	 * @return Returns the created_by.
	 */
	public int getCreated_by() {
		return created_by;
	}
	/**
	 * @param created_by The created_by to set.
	 */
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	/**
	 * @return Returns the created_date.
	 */
	public Timestamp getCreated_date() {
		return created_date;
	}
	/**
	 * @param created_date The created_date to set.
	 */
	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
	/**
	 * @return Returns the isincode.
	 */
	public String getIsincode() {
		return isincode;
	}
	/**
	 * @param isincode The isincode to set.
	 */
	public void setIsincode(String isincode) {
		this.isincode = isincode;
	}
	/**
	 * @return Returns the last_modified_by.
	 */
	public int getLast_modified_by() {
		return last_modified_by;
	}
	/**
	 * @param last_modified_by The last_modified_by to set.
	 */
	public void setLast_modified_by(int last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	/**
	 * @return Returns the last_modified_date.
	 */
	public Timestamp getLast_modified_date() {
		return last_modified_date;
	}
	/**
	 * @param last_modified_date The last_modified_date to set.
	 */
	public void setLast_modified_date(Timestamp last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	/**
	 * @return Returns the lot_size.
	 */
	public double getLot_size() {
		return lot_size;
	}
	/**
	 * @param lot_size The lot_size to set.
	 */
	public void setLot_size(double lot_size) {
		this.lot_size = lot_size;
	}
	/**
	 * @return Returns the min_size.
	 */
	public double getMin_size() {
		return min_size;
	}
	/**
	 * @param min_size The min_size to set.
	 */
	public void setMin_size(double min_size) {
		this.min_size = min_size;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the producttypeid.
	 */
	public int getProducttypeid() {
		return producttypeid;
	}
	/**
	 * @param producttypeid The producttypeid to set.
	 */
	public void setProducttypeid(int producttypeid) {
		this.producttypeid = producttypeid;
	}
	/**
	 * @return Returns the tproductsid.
	 */
	public int getTproductsid() {
		return tproductsid;
	}
	/**
	 * @param tproductsid The tproductsid to set.
	 */
	public void setTproductsid(int tproductsid) {
		this.tproductsid = tproductsid;
	}
}
