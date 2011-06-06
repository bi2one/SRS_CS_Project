package com.cs.srs.control;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.srs.model.Model;
import com.cs.srs.model.MemberModel;
import com.cs.srs.model.data.Member;
import com.cs.srs.model.data.Member.Kind;

import com.cs.srs.model.ItemModel;
import com.cs.srs.model.data.Item;

import com.cs.srs.Fixed;

public abstract class Control_consumer implements com.cs.srs.control.Member {
	int id = 0;
	
	public Control_consumer(int id)
	{
		setId(id);
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public MemberType getMemType() {
		return MemberType.consumer;
	}
	
	public int getAllItems()
	{
		Model m = new Model(Fixed.TN_retailerItems);
		ItemModel im = new ItemModel(); 
		ResultSet m_rs = m.findAll();
		try {
			while (m_rs.next()) 
			{
				ResultSet im_rs = im.findById(m_rs.getInt("items_id"));
				
				if ( im_rs.next() && 
					!showSellItems(im_rs.getInt("id"), im_rs.getString("name"), im_rs.getInt("price")))
					break; 
			}
			return 0;//item count 로 바꿀것
		} catch (SQLException e) {
		    e.printStackTrace();
		    return -1;
		}
		
	}
	
	public int getBuyingItems()
	{
		Model m = new Model(Fixed.TN_buyingItems);
		Model m_retailerItems = new Model(Fixed.TN_retailerItems);
		ItemModel im = new ItemModel();
		ResultSet rs = m.findAll(); //where 절 삽인된 method 가능하면 바꿀것
		try 
		{
			int icount = 0;
			while (rs.next())
			{
				if (rs.getInt("members_id") == this.id )
				{
					ResultSet rs_ri = m_retailerItems.findById(rs.getInt("retailer_items_id"));
					if (rs_ri.next())
					{
						Item item = im.findItemById(rs_ri.getInt("items_id"));
						icount++;
						if ( !showBuyingItems(rs.getInt("id"), item.getName(), item.getPrice()))
							break;
					}
				}
			}
			return icount; 
		} catch (SQLException e) {
		    e.printStackTrace();
		    return -1;
		}
	}
	
	public Item showItemDescription(int id)
	{
		Model m = new Model(Fixed.TN_retailerItems);
		ItemModel im = new ItemModel();
		
		ResultSet rs = m.findById(id);
		try
		{
			if (rs.next())
			{
				return im.findItemById(rs.getInt("items_id"));
			}
		}catch (SQLException e)
		{
		    e.printStackTrace();
		}
		return null;
	}
	
	public boolean Order(int id , int count)
	{
		Model m = new Model(Fixed.TN_buyingItems);
		String[] values = { 
				"null", 
				"" + count , 
				"\"----------\"", 
				"\"" + Fixed.State_Accepting + "\"",
				"" + this.id, 
				"" + id
				};
		return m.insert(values);
	}
	public boolean CancelOrder(int buyingItemId)
	{
		Model m = new Model(Fixed.TN_buyingItems);
		return m.update("delete from " + Fixed.TN_buyingItems + " where id = " + buyingItemId);
	}
	
	protected abstract boolean showSellItems(int retailerItemId, String name, int value);	
	protected abstract boolean showBuyingItems(int buyingItemId, String name, int value);
	//protected abstract void showItemDescription(Item item);
}

//1. 쇼핑몰이 판매중인 제품의 목록(이름, 가격)
	//getAllItems();
//2. 소비자가 현재 주문중인 제품의 목록(이름, 가격)
	//getBuyingItems();
//3. 판매중인 제품의 정보 (이름, 가격, 설명)
	//showItemDescription(int id);
// 
//그리고 필요한 기능들입니다.
//4. 주문하기
//5. 주문취소
