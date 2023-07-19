package com.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.CustomerEntity;
import com.entity.addNewTask;
import com.entity.purchaseProduct;
import com.entity.sellerEntity;
import com.entity.soldProduct;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ServicesProvider {
	Connection con;
	public ServicesProvider(Connection con) {
		super();
		this.con=con;
	}
	public boolean checkLogin(String uName, String pass) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="SELECT * FROM login WHERE uName=? AND PASS=? ";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, uName);
		pS.setString(2, pass);
		
		ResultSet rS=pS.executeQuery();
		if(rS.next()) {
			b=true;
		}
		return b;
	}
	public boolean CreateRegistration(String fullName, String uName, String pass) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		 String sql="INSERT INTO login (fullName,uName, pass)VALUES( ?, ?,?)";
		 PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		 pS.setString(1, fullName);
		 pS.setString(2, uName);
		 pS.setString(3, pass);
		 int i=pS.executeUpdate();
		 if(i==1) {
			 b=true;
		 } 
		return b;
	}
	public boolean updatePass(String uName, String pass) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="UPDATE  login SET pass=? WHERE uName=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, pass);
		pS.setString(2, uName);
		int i=pS.executeUpdate();
		if(i==1) {
			b=true;
		}
		return b;
	}
	public boolean addNewProduct(String pName, String pQuantity, String pDate, String pHSN, String pMRP) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="INSERT INTO purchase (pName, pQuantity, HSN ,pDate, pMRP) VALUES(?, ?, ?,?,?)";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, pName);
		pS.setString(2, pQuantity);
		pS.setString(3, pHSN);
		pS.setString(4, pDate);
		pS.setString(5, pMRP);
		
		int i=pS.executeUpdate();
		if(i==1) {
			b=true;
		}
		return b;
	}
	public boolean addNewCustomer(String cName, String cadd, String cGST, String ccontact) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="INSERT INTO customer (cName, cAddress, cGST ,cContact) VALUES (?, ? ,? ,?)";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, cName);
		pS.setString(2, cadd);
		pS.setString(3, cGST);
		pS.setString(4, ccontact);
		int i=pS.executeUpdate();
		if(i==1) {
			System.out.println("add new customer successfully");
			b=true;	
		}
		return b;
	}
	public List<CustomerEntity>totalList(){
		List<CustomerEntity> li=new ArrayList<>();
		CustomerEntity se=null;
		try {
			String sql="SELECT * FROM customer";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new CustomerEntity();
				se.setId(rs.getInt(1));
				se.setcName(rs.getString(2));
				se.setcAdd(rs.getString(3));
				se.setcGST(rs.getString(4));
				se.setcContact(rs.getString(5));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}
	public List<purchaseProduct>purchaseTotalList(){
		List<purchaseProduct> li=new ArrayList<>();
		purchaseProduct se=null;
		try {
			String sql="SELECT * FROM purchase";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new purchaseProduct();
				se.setId(rs.getInt(1));
				se.setpName(rs.getString(2));
				se.setpQuantity(rs.getString(3));
				se.setpHSN(rs.getString(4));
				se.setpDate(rs.getString(5));
				se.setpMRP(rs.getString(6));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}
	public boolean addNewSeller(sellerEntity se) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="INSERT INTO sellerinfo (sName, sAdd, sGST, sContact) VALUES(? ,? ,? ,?)";
		PreparedStatement  ps=(PreparedStatement) con.prepareStatement(sql);
		ps.setString(1, se.getsName());
		ps.setString(2, se.getsAdd());
		ps.setString(3, se.getsGST());
		ps.setString(4, se.getsContact());
		int i=ps.executeUpdate();
		if(i==1) {
			b=true;
		}
		return b;
	}
	public List<purchaseProduct> addPrice(String spName) throws SQLException {
		// TODO Auto-generated method stub
		List<purchaseProduct> li=new ArrayList<>();
		purchaseProduct se=null;
		try {
			String sql="SELECT * FROM purchase WHERE pName=? ";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new purchaseProduct();
				se.setId(rs.getInt(1));
				se.setpName(rs.getString(2));
				se.setpQuantity(rs.getString(3));
				se.setpHSN(rs.getString(4));
				se.setpDate(rs.getString(5));
				se.setpMRP(rs.getString(6));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
	}
	public boolean UpdateProduct(String pName, String pQuantity, String pDate, String pHSN, String pMRP, String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="UPDATE purchase SET pName=?, pQuantity=? , HSN=? ,pDate=?, pMRP=? WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, pName);
		pS.setString(2, pQuantity);
		pS.setString(3, pHSN);
		pS.setString(4, pDate);
		pS.setString(5, pMRP);
		pS.setString(6, id);
		int i=pS.executeUpdate();
		if(i==1) {
			b=true;
		}
		return b;

	}
	public List<purchaseProduct> popupProduct(String j) throws SQLException{
		List<purchaseProduct> li=new ArrayList<purchaseProduct>();
		purchaseProduct obj=null;
		String sql="SELECT * FROM purchase  WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, j);
		ResultSet rS= (ResultSet) pS.executeQuery();
		while(rS.next()){
			obj=new purchaseProduct();
		obj.setId(rS.getInt(1));
			obj.setpName(rS.getString(2));
			obj.setpQuantity(rS.getString(3));
			obj.setpHSN(rS.getString(4));
			obj.setpDate(rS.getString(5));
			obj.setpMRP(rS.getString(6));
			li.add(obj); 		
		}
		return li;
	}
	
	public boolean UpdateCustomer(String cName, String cAddress, String cGST, String cContact, String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="UPDATE customer SET cName=? ,cAddress=? ,cGST=? ,cContact=? WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, cName);
		pS.setString(2, cAddress);
		pS.setString(3, cGST);
		pS.setString(4, cContact);
		pS.setString(5, id);
		int i=pS.executeUpdate();
		if(i==1) {
			b=true;
		}
		return b;

	}
	public List<CustomerEntity> popupCustomer(String j) throws SQLException{
		List<CustomerEntity> li=new ArrayList<>();
		CustomerEntity obj=null;
		String sql="SELECT * FROM customer WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, j);
		ResultSet rS= (ResultSet) pS.executeQuery();
		while(rS.next()){
			obj=new CustomerEntity();
			obj.setId(rS.getInt(1));
			obj.setcName(rS.getString(2));
			obj.setcAdd(rS.getString(3));
			obj.setcGST(rS.getString(4));
			obj.setcContact(rS.getString(5));

			li.add(obj); 		
		}
		return li;
	}
	public boolean UpdateSeller(String sName, String sAddress, String sGST, String sContact, String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="UPDATE sellerinfo SET sName=?, sAdd=?, sGST=?, sContact=? WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, sName);
		pS.setString(2, sAddress);
		pS.setString(3, sGST);
		pS.setString(4, sContact);
		pS.setString(5, id);
		int i=pS.executeUpdate();
		if(i==1) {
			b=true;
		}
		return b;

	}
	public List<sellerEntity> popupSeller(String j) throws SQLException{
		List<sellerEntity> li=new ArrayList<>();
		sellerEntity obj=null;
		String sql="SELECT * FROM sellerinfo WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, j);
		ResultSet rS= (ResultSet) pS.executeQuery();
		while(rS.next()){
			obj=new sellerEntity();
			obj.setId(rS.getInt(1));
			obj.setsName(rS.getString(2));
			obj.setsAdd(rS.getString(3));
			obj.setsGST(rS.getString(4));
			obj.setsContact(rS.getString(5));

			li.add(obj); 		
		}
		return li;
	}
	public List<sellerEntity> sellersTotalList(){
		List<sellerEntity> li=new ArrayList<>();
		sellerEntity se=null;
		try {
			String sql="SELECT * FROM sellerinfo";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new sellerEntity();
				se.setId(rs.getInt(1));
				se.setsName(rs.getString(2));
				se.setsAdd(rs.getString(3));
				se.setsGST(rs.getString(4));
				se.setsContact(rs.getString(5));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}
	public boolean CustomerDeleteFromDB(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="DELETE FROM customer WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, id);
		int d=pS.executeUpdate();
		if(d==1) {
			b=true;
			System.out.println("Delete C ");
		}
		
		return b;
		
	}
	public boolean ProductDeleteFromDB(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="DELETE FROM purchase WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, id);
		int d=pS.executeUpdate();
		if(d==1) {
			b=true;
			System.out.println("Delete  P");
		}
		
		return b;
		
	}
	public boolean VenderDeleteFromDB(String id) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="DELETE FROM sellerinfo WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, id);
		int d=pS.executeUpdate();
		if(d==1) {
			b=true;
			System.out.println("Delete V ");
		}
		
		return b;
		
	}
	public boolean addNewSellBill(String billNo, String pDate, String cName, String pName, String pPrice,
			String pQuantity, String pTotal) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="INSERT INTO sells (GSTNo, pName, price, spQantity, spDate, cName, total) VALUES(?,?,?,?,?, ?, ?)";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, billNo);
		pS.setString(2, pName);
		pS.setString(3, pPrice);
		pS.setString(4, pQuantity);
		pS.setString(5, pDate);
		pS.setString(6, cName);
		pS.setString(7, pTotal);
		int i=pS.executeUpdate();
		if(i==1) {
			System.out.println("add new sell bill successfully");
			b=true;	
		}
		return b;
	}
	
	public List<purchaseProduct>purchaseDetailList(){
		List<purchaseProduct> li=new ArrayList<>();
		purchaseProduct se=null;
		try {
			String sql="SELECT * FROM purchase";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new purchaseProduct();
				se.setId(rs.getInt(1));
				se.setpName(rs.getString(2));
				se.setpQuantity(rs.getString(3));
				se.setpHSN(rs.getString(4));
				se.setpDate(rs.getString(5));
				se.setpMRP(rs.getString(6));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}
	public List<soldProduct>soldDetailList(){
		List<soldProduct> li=new ArrayList<>();
		soldProduct se=null;
		try {
			String sql="SELECT * FROM sells";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new soldProduct();
				se.setId(rs.getInt(1));
				se.setGSTNo(rs.getString(2));
				se.setpName(rs.getString(3));
				se.setpPrice(rs.getString(4));
				se.setpQuantity(rs.getString(5));
				se.setSpDate(rs.getString(6));
				se.setcName(rs.getString(7));
				se.setTotal(rs.getString(8));
				
				
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}

	public List<purchaseProduct> checkPurchase(String pDate){
		List<purchaseProduct> li=new ArrayList<>();
		purchaseProduct se=null;
		try {
			String sql="SELECT * FROM purchase WHERE pDate=?";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pDate);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new purchaseProduct();
				se.setId(rs.getInt(1));
				se.setpName(rs.getString(2));
				se.setpQuantity(rs.getString(3));;
				se.setpHSN(rs.getString(4));
				se.setpDate(rs.getString(5));
				se.setpMRP(rs.getString(6));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}
	public boolean addNewtask(String addTask, String taskType) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="INSERT INTO addnewtask (taskName , TYPE) VALUES (?, ?);";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, addTask);
		pS.setString(2, taskType);
		
		int i=pS.executeUpdate();
		if(i==1) {
			System.out.println("add new task successfully");
			b=true;	
		}
		return b;
	}
	public List<addNewTask>taskTotalList(){
		List<addNewTask> li=new ArrayList<>();
		addNewTask se=null;
		try {
			String sql="SELECT * FROM addnewtask";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new addNewTask();
				se.setId(rs.getInt(1));
				se.setAddtask(rs.getString(2));
				se.setType(rs.getString(3));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
		
	}
	public int showProduct(){
		int id=0;
		try {
			String sql="SELECT COUNT(id) FROM purchase";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			id=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public int showCustomer(){
		int id=0;
		try {
			String sql="SELECT COUNT(id) FROM customer";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			id=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public int showSells(){
		int id=0;
		try {
			String sql="SELECT COUNT(id) FROM sells";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			id=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public int showSupplier(){
		int id=0;
		try {
			String sql="SELECT COUNT(id) FROM sellerinfo";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			id=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public int showAvilable(String pName){
		int id=0;
		try {
			
			String sql="SELECT SUM(spQantity)FROM sells WHERE pName=?";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			id=rs.getInt(1);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public boolean insertcontactUs(String name, String email, String sub, String message) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="INSERT INTO contactus ( NAME, email, sub, message) VALUES(?,?,?,?)";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, name);
		pS.setString(2, email);
		pS.setString(3, sub);
		pS.setString(4, message);
		int i=pS.executeUpdate();
		if(i==1) {
			System.out.println("add new customer successfully");
			b=true;	
		}
		return b;
	}
	public boolean TaskDeleteFromDB(String pid) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="DELETE FROM addnewtask WHERE id=?";
		PreparedStatement pS=(PreparedStatement) con.prepareStatement(sql);
		pS.setString(1, pid);
		int d=pS.executeUpdate();
		if(d==1) {
			b=true;
			System.out.println("Delete V ");
		}
		
		return b;
	}
	public List<soldProduct> checkSell(String pDate) {
		// TODO Auto-generated method stub
		List<soldProduct> li=new ArrayList<>();
		soldProduct se=null;
		try {
			String sql="SELECT * FROM sells WHERE spDate=?";
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, pDate);
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
				se=new soldProduct();
				se.setId(rs.getInt(1));
				se.setpName(rs.getString(2));
				se.setpQuantity(rs.getString(3));;
				se.setpHSN(rs.getString(4));
				se.setpDate(rs.getString(5));
				se.setpPrice(rs.getString(6));
				li.add(se);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
	}
	
}
