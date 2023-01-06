package soccer.deploy.MyUser;

import java.util.Date;

public class UserMyDto {
	
	private int user_id;
	private String passwd;
	private String email;
	private String name;
	private int age;
	private String address;
	private String img_cont_type;
	private String img_file_name;
	private int back_num;
	private String member_auth;
	private String position;
	private Date regdate;
	
	public UserMyDto() {}

	public UserMyDto(int user_id, String passwd, String email, String name, int age, String address,
			String img_cont_type, String img_file_name, int back_num, String member_auth, String position,
			Date regdate) {
		super();
		this.user_id = user_id;
		this.passwd = passwd;
		this.email = email;
		this.name = name;
		this.age = age;
		this.address = address;
		this.img_cont_type = img_cont_type;
		this.img_file_name = img_file_name;
		this.back_num = back_num;
		this.member_auth = member_auth;
		this.position = position;
		this.regdate = regdate;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg_cont_type() {
		return img_cont_type;
	}

	public void setImg_cont_type(String img_cont_type) {
		this.img_cont_type = img_cont_type;
	}

	public String getImg_file_name() {
		return img_file_name;
	}

	public void setImg_file_name(String img_file_name) {
		this.img_file_name = img_file_name;
	}

	public int getBack_num() {
		return back_num;
	}

	public void setBack_num(int back_num) {
		this.back_num = back_num;
	}

	public String getMember_auth() {
		return member_auth;
	}

	public void setMember_auth(String member_auth) {
		this.member_auth = member_auth;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MyUserDto [user_id=" + user_id + ", passwd=" + passwd + ", email=" + email + ", name=" + name + ", age="
				+ age + ", address=" + address + ", img_cont_type=" + img_cont_type + ", img_file_name=" + img_file_name
				+ ", back_num=" + back_num + ", member_auth=" + member_auth + ", position=" + position + ", regdate="
				+ regdate + "]";
	}
	
	
	
}

//create table users (
//		user_id	number(3)	not null, --PK
//		passwd	varchar2(20)	not null,
//		email	varchar2(30)	not null,
//		name	varchar2(20)	not null,
//		age	number(3)	not null,
//		address	varchar2(200)	not null,
//		img_cont_type	varchar2(20)	,
//		img_file_name	varchar2(100)	,
//		back_num	number(3)	not null,
//		member_auth	varchar2(1),
//		position	varchar2(2),
//        regdate date default sysdate
//	);