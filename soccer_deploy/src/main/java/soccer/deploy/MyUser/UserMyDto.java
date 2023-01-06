package soccer.deploy.MyUser;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserMyDto {


	private String email;
	private String name;
	private int age;
	private int backNum;
	private String position;

	

	
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