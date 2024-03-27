package membership;

import common.JDBCConnect;

public class MemberDAO extends JDBCConnect {

	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv,url,id,pw);
	}


	public MemberDTO getMemberDTO(String uid, String upass) {
		System.out.println(uid);
		System.out.println(upass);

		MemberDTO dto = new MemberDTO();
		String query = "SELECT * FROM member WHERE id=? AND pass=?";





		try {

			psmt = con.prepareStatement(query);


			psmt.setString(1,uid);
			psmt.setString(2,upass);
			rs = psmt.executeQuery();



			if(rs.next()) {


				dto.setId(rs.getString(1));
				dto.setPass(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
