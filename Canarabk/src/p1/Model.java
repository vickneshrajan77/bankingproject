package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Model 
{
	String name;
	String custid;
	String accno;
	String pw;
	String balance;
	String email;
	String taccno;
	String tamt;
	private Connection con;
	private String url="jdbc:oracle:thin:@localhost:1521:XE";
	private String user= "SYSTEM";
	private String password= "system";
	private PreparedStatement pstmt;
	private ResultSet res;
	private PreparedStatement pstmt1;
	private ResultSet res1;
	public void setName(String name) {
		this.name = name;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
	 public String getName() {
		return name;
	}

	public String getCustid() {
		return custid;
	}

	public String getAccno() {
		return accno;
	}

	public String getPw() {
		return pw;
	}

	public String getBalance() {
		return balance;
	}

	public String getEmail() {
		return email;
	}

	public String getTaccno() {
		return taccno;
	}

	public void setTaccno(String taccno) {
		this.taccno = taccno;
	}

	public String getTamt() {
		return tamt;
	}

	public void setTamt(String tamt) {
		this.tamt = tamt;
	}

	
	public Model()
	 {
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url, user, password);
		} 
		 catch (Exception e) 
		 {
			System.out.println("problem in connection");
		}
	 }
	 
	 public Boolean login() throws SQLException
	 {
		 pstmt=con.prepareStatement("SELECT * FROM BANKING WHERE CUST_ID=? AND PASSWORD=?");
		 pstmt.setString(1,custid );
		 pstmt.setString(2, pw);
		 res=pstmt.executeQuery();
		 while(res.next()==true)
		 {
			 
			accno= res.getString("ACCNO");
			return true;
		
		 
	     }
		return false;

	

}
	 public Boolean checkBalance()
	 {
		
		 try 
		 {
			pstmt=con.prepareStatement("SELECT * FROM BANKING WHERE ACCNO=?");
			pstmt.setString(1,accno );
			 res=pstmt.executeQuery();
			 System.out.println("appppppppppp");
			 System.out.println(accno);
			 while(res.next()==true)
			 {
				balance= res.getString(5);
				 return true;
			 }
		} 
		 catch (Exception e) 
		 {
			System.out.println("query failed");
		}
		 
		return false;
	 }
	 
	 public Boolean changepwd() throws SQLException
	 {
		 pstmt=con.prepareStatement("UPDATE BANKING SET PASSWORD=? WHERE ACCNO=?");
		 pstmt.setString(1, pw);
		 pstmt.setString(2, accno);
		 System.out.println(pw);
		 System.out.println(accno);
		 System.out.println("chhhh?");
		 int row = pstmt.executeUpdate();
		 System.out.println(row);
		 if(row==0)
		 {
			 return false;
		 }
		return true;
		 
		 
	 }
	 
	 public Boolean Transferamt() throws SQLException
	 {
		 pstmt= con.prepareStatement("UPDATE BANKING SET BALANCE=BALANCE-? WHERE ACCNO=?");
		 pstmt.setString(1, tamt);
		 pstmt.setString(2, accno);
		 int row=pstmt.executeUpdate();
		 System.out.println("hyyyhh");
		 
		 System.out.println(accno);
		 
		 System.out.println(balance);
		 pstmt1=con.prepareStatement("INSERT INTO BSTATEMENT VALUES(?,?,?)");
		 pstmt1.setString(1, accno);
		 pstmt1.setString(2, taccno);
		 pstmt1.setString(3, tamt);
		 System.out.println(accno);
		System.out.println(taccno);
		System.out.println(tamt);
		 int row1=pstmt1.executeUpdate();
		 System.out.println(row1);
		 if(row1==0)
			 
		 {
			 return false;
		 }
		 return true;
		 
	 }
	 
	 
	 
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList getstatement() throws SQLException
	 {
		 @SuppressWarnings("rawtypes")
		ArrayList al=new ArrayList(); 
		pstmt=con.prepareStatement("SELECT * FROM BSTATEMENT WHERE ACCNO=?");
		pstmt.setString(1, accno);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
			String temp=res.getString(1);
			al.add(temp);
			String temp1= res.getString(2);
			al.add(temp1);
			String temp2= res.getString(3);
			al.add(temp2);
		}
		return al;
	 }
}
