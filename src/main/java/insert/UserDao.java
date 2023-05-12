package insert;
import java.sql.*;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

import test.FormBean;
public class UserDao {
public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=latin1","root","password");
	}catch(Exception e){System.out.println(e);}
	return con;
}
public static int save(FormBean u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into validation(firstName,lastName,email,userName,password1,password2,zipcode,tech,notify) values(?,?,?,?,?,?,?,?,?)");
		ps.setString(1,u.getFirstName());
		ps.setString(2,u.getLastName());
		ps.setString(3,u.getEmail());
		ps.setString(4,u.getUserName());
		ps.setString(5,u.getPassword1());
		ps.setString(6,u.getPassword2());
		ps.setString(7,u.getZip());
		String tech=Arrays.toString(u.getFaveTech());
		ps.setString(8,tech);
		ps.setString(9,u.getNotify());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
//public static int update(FormBean u){
//	int status=0;
//	try{
//		Connection con=getConnection();
//		PreparedStatement ps=con.prepareStatement("update register set name=?,password=?,email=?,sex=?,country=? where id=?");
//		ps.setString(1,u.getName());
//		ps.setString(2,u.getPassword());
//		ps.setString(3,u.getEmail());
//		ps.setString(4,u.getSex());
//		ps.setString(5,u.getCountry());
//		ps.setInt(6,u.getId());
//		status=ps.executeUpdate();
//	}catch(Exception e){System.out.println(e);}
//	return status;
//}
//public static int delete(FormBean u){
//	int status=0;
//	try{
//		Connection con=getConnection();
//		PreparedStatement ps=con.prepareStatement("delete from register where id=?");
//		ps.setInt(1,u.getId());
//		status=ps.executeUpdate();
//	}catch(Exception e){System.out.println(e);}
//
//	return status;
//}
//public static List<FormBean> getAllRecords(){
//	List<FormBean> list=new ArrayList<FormBean>();
//	
//	try{
//		Connection con=getConnection();
//		PreparedStatement ps=con.prepareStatement("select * from register");
//		ResultSet rs=ps.executeQuery();
//		while(rs.next()){
//			FormBean u=new FormBean();
//			u.setId(rs.getInt("id"));
//			u.setName(rs.getString("name"));
//			u.setPassword(rs.getString("password"));
//			u.setEmail(rs.getString("email"));
//			u.setSex(rs.getString("sex"));
//			u.setCountry(rs.getString("country"));
//			list.add(u);
//		}
//	}catch(Exception e){System.out.println(e);}
//	return list;
//}
//public static FormBean getRecordById(int id){
//	FormBean u=null;
//	try{
//		Connection con=getConnection();
//		PreparedStatement ps=con.prepareStatement("select * from register where id=?");
//		ps.setInt(1,id);
//		ResultSet rs=ps.executeQuery();
//		while(rs.next()){
//			u=new FormBean();
//			u.setId(rs.getInt("id"));
//			u.setName(rs.getString("name"));
//			u.setPassword(rs.getString("password"));
//			u.setEmail(rs.getString("email"));
//			u.setSex(rs.getString("sex"));
//			u.setCountry(rs.getString("country"));
//		}
//	}catch(Exception e){System.out.println(e);}
//	return u;
//}
}
